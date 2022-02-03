package com.ecommerce.cartservice.controllers;

import com.ecommerce.models.product.Product;
import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerConfig;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
import org.springframework.cloud.netflix.eureka.http.EurekaApplications;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class ProductInfoController {
    /**
     * using api-gateway and eureka server and eureka client
     */

    @Autowired
    private RestTemplate restTemplate;

    private EurekaClient eurekaClient;

    @Value("${spring.cloud.client.hostname}")
    private String applicationURL;

    @GetMapping("/my-get-products")
    String getCartProduct() {
        System.out.println("URL" + applicationURL);
        return applicationURL;
    }
}
