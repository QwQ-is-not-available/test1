package org.example.springboot_aop;

public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("msg from threadlocal");
        System.out.println(Thread.currentThread().getName()+":"+local.get());
    }
}
