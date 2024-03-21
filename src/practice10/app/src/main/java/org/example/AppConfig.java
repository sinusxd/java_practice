package org.example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
    @Bean(name = "consolePrinter")
    public Printer consolePrinter(){
        return new ConsolePrinter();
    }
    @Bean(name = "filePrinter")
    public Printer filePrinter(){
        return new FilePrinter();
    }

}
