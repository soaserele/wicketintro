package com.github.soaserele.wicketintro.hello;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class HelloPage extends WebPage {
    public HelloPage(String name) {
        super();
        add(
                new Label("Name", name),
                new Link("Back") {
                    @Override
                    public void onClick() {
                        setResponsePage(HomePage.class);
                    }
                }
        );
    }
}
