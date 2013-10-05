package com.github.soaserele.wicketintro.todo.web.pages;

import com.github.soaserele.wicketintro.todo.model.TodoItem;
import com.github.soaserele.wicketintro.todo.web.TodoSession;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import java.util.Date;

/**
 * User: stanislaw
 * Date: 10/5/13
 * Time: 3:32 PM
 */
public class EditTodoPage extends BasePage {


    private static class EditTodoForm extends Form<TodoItem> {
        public EditTodoForm(String id, TodoItem todoItem) {
            super(id);
            setDefaultModel(new CompoundPropertyModel<>(todoItem));
            add(
                    new TextField<String>("title"),
                    new TextArea<String>("description"),
                    new CheckBox("done")
            );
        }

        @Override
        protected void onSubmit() {
            super.onSubmit();
            saveTask();
            setResponsePage(ListTodosPage.class);
        }

        private void saveTask() {
            TodoItem todoItem = getModelObject();

            if (todoItem.getIndex() == null) {
                todoItem.setIndex(new Date().getTime());
            } else {
                TodoSession.get().removeItem(todoItem.getIndex());
            }
            TodoSession.get().getItems().add(todoItem);
        }
    }

    public EditTodoPage() {
        super();
        add(new EditTodoForm("Form", new TodoItem()));
    }

    public EditTodoPage(TodoItem todoItem) {
        super();
        add(new EditTodoForm("Form", todoItem));
    }
}
