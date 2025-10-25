package org.gherkin.background;

public class Blog {

    final String name;
    final User owner; // nullable for ownerless blogs

    public Blog(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }
}
