package ru.alexander.cbr;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.alexander.cbr.repository.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    DataSource dataSource;
    
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {        
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("111111111111" + this.customerRepository.findAll().toString());
    }
}
