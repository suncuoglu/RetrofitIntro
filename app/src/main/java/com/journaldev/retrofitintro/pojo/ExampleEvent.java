package com.journaldev.retrofitintro.pojo;

public class ExampleEvent {
    UserList.Datum user;

    public ExampleEvent(UserList.Datum user) {
        this.user = user;
    }

    public UserList.Datum getUser() {
        return user;
    }

    public void setUser(UserList.Datum user) {
        this.user = user;
    }

    public ExampleEvent() {
    }
}
