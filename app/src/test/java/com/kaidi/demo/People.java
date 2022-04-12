package com.kaidi.demo;

public class People {

    private String name;
    @Deprecated
    public int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void eat(String food) {
        System.out.println("eat food " + food);
    }

    public void eat(String... foods) {
        StringBuilder s = new StringBuilder();
        for (String food : foods) {
            s.append(food);
            s.append(" ");
        }
        System.out.println("eat food " + s.toString());
    }

    public void sleep() {
        System.out.println("sleep");
    }

    @Override
    public String toString() {
        return "name = " + name + " age = " + age;
    }
}
