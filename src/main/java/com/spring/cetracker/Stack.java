package com.spring.cetracker;

public class Stack {
    private List list;

    public Stack() {
    }

    public void push(Object data) {
        this.list.add(data);
    }

    public Object pop() {
        return this.list.delete();
    }

    public Object peek() {
        return this.list.getHead();
    }
}
