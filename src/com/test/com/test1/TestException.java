package com.test.com.test1;

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

public class TestException {
    public static void f() throws MyException{
        System.out.println("My");
        throw new MyException("MyException()");
    }
    public static void main(String[] args) {
        try {
            f();

        }catch (MyException e){
            System.out.println(e);
        }finally {
            System.out.println("MyException");
        }
    }
}
