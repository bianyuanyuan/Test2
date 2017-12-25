package com.test.com.test1;

import javax.swing.plaf.synth.SynthOptionPaneUI;

class SimpleException extends Exception {
    public SimpleException() {
    }

    public SimpleException(String message) {
        super(message);
    }
}

public class InheritinhException {
    public static void f() throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }
    public static void g() throws SimpleException{
        System.out.print("Throw SimpleException from g()");
        throw new SimpleException("Originated in g()_");
    }

    public static void main(String[] args) {
        InheritinhException sed=new InheritinhException();
        try{
            f();

        }catch (SimpleException e){
            e.printStackTrace(System.out);
        }
        try {
            g();
            }catch (SimpleException e){
            e.printStackTrace(System.out);
        }
    }
}
