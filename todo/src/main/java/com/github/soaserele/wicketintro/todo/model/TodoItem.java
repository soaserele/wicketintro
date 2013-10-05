package com.github.soaserele.wicketintro.todo.model;

import java.io.Serializable;

public class TodoItem implements Serializable {

    private Long index;
    private String title;
    private String description;
    private Boolean done;

    public Long getIndex() {
        return index;
    }

    public void setIndex(Long index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (description != null ? !description.equals(todoItem.description) : todoItem.description != null)
            return false;
        if (done != null ? !done.equals(todoItem.done) : todoItem.done != null) return false;
        if (index != null ? !index.equals(todoItem.index) : todoItem.index != null) return false;
        if (title != null ? !title.equals(todoItem.title) : todoItem.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = index != null ? index.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (done != null ? done.hashCode() : 0);
        return result;
    }
}
