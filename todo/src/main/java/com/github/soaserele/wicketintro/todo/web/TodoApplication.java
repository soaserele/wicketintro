package com.github.soaserele.wicketintro.todo.web;

import com.github.soaserele.wicketintro.todo.web.pages.HomePage;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

public class TodoApplication extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

    @Override
    public Session newSession(Request request, Response response) {
        return new TodoSession(request);
    }
}
