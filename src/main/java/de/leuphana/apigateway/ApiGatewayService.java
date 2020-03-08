package de.leuphana.apigateway;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"de.leuphana.apigateway"})
@RestController
public class ApiGatewayService {

    @Autowired
    private EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayService.class, args);
    }


    @GetMapping(value = "/hello", produces = "application/json")
    public List<Application> greeting() {
        Applications instance = eurekaClient.getApplications();
        System.out.println(instance.getRegisteredApplications());
        return instance.getRegisteredApplications();
    }
}
