package com.github.soaserele.wicketintro.todo.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 * User: stanislaw
 * Date: 10/5/13
 * Time: 3:03 PM
 */
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
