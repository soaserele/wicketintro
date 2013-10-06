package com.github.soaserele.wicketintro.phonebook.web;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class PhonebookSession extends WebSession {

    public PhonebookSession(Request request) {
        super(request);
    }

    public static PhonebookSession get() {
        return (PhonebookSession) WebSession.get();
    }
}
