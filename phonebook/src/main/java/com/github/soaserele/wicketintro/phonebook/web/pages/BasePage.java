package com.github.soaserele.wicketintro.phonebook.web.pages;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;

abstract public class BasePage extends WebPage {
    public BasePage() {
        super();
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(JavaScriptHeaderItem.forReference(getApplication().getJavaScriptLibrarySettings().getJQueryReference()));
    }

    public boolean isAuthenticated() {
        return false;
    }
}
