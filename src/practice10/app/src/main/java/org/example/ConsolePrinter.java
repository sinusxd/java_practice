package org.example;

public class ConsolePrinter implements Printer{
    @Override
    public void doPrint() {
        System.out.println("Printing to console");
    }
}
