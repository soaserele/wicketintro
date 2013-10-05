package com.github.soaserele.wicketintro.hello;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class HelloApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }
}
