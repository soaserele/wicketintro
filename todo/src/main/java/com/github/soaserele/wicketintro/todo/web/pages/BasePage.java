package com.github.soaserele.wicketintro.todo.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public class BasePage extends WebPage {
    public BasePage() {
        super();

        add(
                new Link("View") {
                    @Override
                    public void onClick() {
                        setResponsePage(ListTodosPage.class);
                    }
                },
                new Link("Add") {
                    @Override
                    public void onClick() {
                        setResponsePage(EditTodoPage.class);
                    }
                }
        );
    }
}
