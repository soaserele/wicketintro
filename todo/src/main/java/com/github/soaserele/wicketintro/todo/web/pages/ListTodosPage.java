package com.github.soaserele.wicketintro.todo.web.pages;

import com.github.soaserele.wicketintro.todo.model.TodoItem;
import com.github.soaserele.wicketintro.todo.web.TodoSession;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Date;
import java.util.Iterator;

/**
 * User: stanislaw
 * Date: 10/5/13
 * Time: 3:32 PM
 */
public class ListTodosPage extends BasePage {


    private static class EditTodoForm extends Form<TodoItem> {
        private TodoItem todoItem;

        public EditTodoForm(String id, TodoItem todoItem) {
            super(id);
            this.todoItem = todoItem;
            setDefaultModel(new CompoundPropertyModel<>(this.todoItem));
        }

        @Override
        protected void onSubmit() {
            super.onSubmit();
            saveTask();
        }

        private void saveTask() {
            if (todoItem.getIndex() == null) {
                todoItem.setIndex(new Date().getTime());
                TodoSession.get().getItems().add(new TodoItem());
            } else {
                TodoSession.get().removeItem(todoItem.getIndex());
                TodoSession.get().getItems().add(todoItem);
            }
        }
    }

    public ListTodosPage() {
        super();
        final WebMarkupContainer table = new WebMarkupContainer("Table");
        table.setOutputMarkupId(true);

        IDataProvider<TodoItem> todoItemIDataProvider = new IDataProvider<TodoItem>() {
            @Override
            public Iterator<? extends TodoItem> iterator(long first, long count) {
                return TodoSession.get().getItems().subList((int) first, (int) (first + count)).iterator();
            }

            @Override
            public long size() {
                return TodoSession.get().getItems().size();
            }

            @Override
            public IModel<TodoItem> model(TodoItem todoItem) {
                return Model.of(todoItem);
            }

            @Override
            public void detach() {
            }
        };

        DataView<TodoItem> dataView = new DataView<TodoItem>("Row", todoItemIDataProvider) {
            @Override
            protected void populateItem(final Item<TodoItem> item) {
                item.add(
                        new AjaxLink("done") {
                            @Override
                            public void onClick(AjaxRequestTarget target) {
                                item.getModelObject().setDone(!Boolean.TRUE.equals(item.getModelObject().getDone()));
                                target.add(table);
                            }
                        }.add(
                                AttributeModifier.append("class", Boolean.TRUE.equals(item.getModelObject().getDone()) ? "pure-button-success" : "pure-button-error")
                        ),
                        new Label("title", item.getModelObject().getTitle()),
                        new Label("description", item.getModelObject().getDescription()),
                        new Link("edit") {
                            @Override
                            public void onClick() {
                                setResponsePage(new EditTodoPage(item.getModelObject()));
                            }
                        },
                        new AjaxLink("delete") {
                            @Override
                            public void onClick(AjaxRequestTarget target) {
                                TodoSession.get().removeItem(item.getModelObject().getIndex());
                                target.add(table);
                            }
                        }
                );
            }
        };

        table.add(dataView, new AjaxPagingNavigator("Navigator", dataView));
        add(table);
    }

    public ListTodosPage(TodoItem todoItem) {
        super();
        add(new EditTodoForm("Form", todoItem));
    }
}
