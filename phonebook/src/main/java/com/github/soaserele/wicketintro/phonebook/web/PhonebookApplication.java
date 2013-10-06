package com.github.soaserele.wicketintro.phonebook.web;

import com.github.soaserele.wicketintro.phonebook.web.pages.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

public class PhonebookApplication extends WebApplication {

    @Override
    protected void init() {
        super.init();
        getComponentInstantiationListeners().add(new SpringComponentInjector(this));
        mountPage("index", HomePage.class);
        new AnnotatedMountScanner().scanPackage("com.github.soaserele.wicketintro.phonebook.web").mount(this);
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new PhonebookSession(request);
    }
}
