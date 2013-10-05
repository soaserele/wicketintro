package com.github.soaserele.wicketintro.todo.web;

import com.github.soaserele.wicketintro.todo.model.TodoItem;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoSession extends WebSession {
    private List<TodoItem> items = Collections.synchronizedList(new ArrayList<TodoItem>());

    public TodoSession(Request request) {
        super(request);
    }

    public List<TodoItem> getItems() {
        return items;
    }

    public static TodoSession get() {
        return (TodoSession) WebSession.get();
    }

    public synchronized void removeItem(Long index) {
        TodoItem item = null;
        for (TodoItem it : items) {
            if (it.getIndex().equals(index)) {
                item = it;
                break;
            }
        }

        if (item != null) {
            items.remove(item);
        }
    }
}
