package ru.alexander.cbr;

import java.util.EnumSet;
import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import org.mybatis.spring.annotation.MapperScan;
import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.alexander.cbr.repository.BNKSEEKRepository;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"ru.alexander.cbr"})
@MapperScan("ru.alexander.cbr.repository")
public class Application implements CommandLineRunner{
    
    @Autowired
    private BNKSEEKRepository bNKSEEKRepository;

    public static void main(String[] args) {        
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Приложение стартовало");
//        System.out.println("111111111111" + this.bNKSEEKRepository.findAll().toString());
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.jsf");
    }

    @Bean
    public FilterRegistrationBean rewriteFilter() {
        FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }
    
}
