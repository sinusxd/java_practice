package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Main {
    public static void main(String[] args) {

        String beanName1 = "consolePrinter";
        String beanName2 = "filePrinter";
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Printer printer = (Printer) context.getBean(beanName1);

        if (printer != null) {
            printer.doPrint();
        } else {
            System.out.println("Bean with name " + beanName1 + " not found");
        }

        printer = (Printer) context.getBean(beanName2);

        if (printer != null) {
            printer.doPrint();
        } else {
            System.out.println("Bean with name " + beanName2 + " not found");
        }
    }
}
