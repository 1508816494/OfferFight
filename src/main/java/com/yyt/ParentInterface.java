package com.yyt;

public interface ParentInterface {

    static void print() {
        System.out.println(111);
    }

    default void pp() {
        System.out.println(2222);
    }
}
