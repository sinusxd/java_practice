package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinter implements Printer {
    @Override
    public void doPrint() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("./output.txt"));
            writer.println("Printing to file");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}