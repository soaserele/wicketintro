package com.github.soaserele.wicketintro.hello;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

public class HomePage extends WebPage {
    private String name;

    public HomePage() {
        super();

        Form form = new Form("Form") {
            @Override
            protected void onSubmit() {
                super.onSubmit();
                setResponsePage(new HelloPage(name));
            }
        };
        form.add(new TextField<>("name", new PropertyModel<String>(HomePage.this, "name")));
        add(form);
    }
}
