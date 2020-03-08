package de.leuphana.apigateway.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface CustomerServiceConnector {

    @RequestMapping(method = RequestMethod.GET, value = "/customer")
    public Object getCustomerByUsername(@RequestParam("username") String username);
}
