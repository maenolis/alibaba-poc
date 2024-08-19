package com.baeldung;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    private static final String EMPLOYEE_MGMT = "employee-mgmt";

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscoveryController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/employees")
    public ResponseEntity<Void> employees() {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", "takis");
        params.put("money", 10);
        ServiceInstance serviceInstance = loadBalancerClient.choose(EMPLOYEE_MGMT);
        String endpointPath = String.format("http://%s:%s/account?userId={userId}&money={money}", serviceInstance.getHost(), serviceInstance.getPort());
        LOGGER.info("Endpoint: {}", endpointPath);
        ResponseEntity<String> response = restTemplate.postForEntity(endpointPath, null, String.class, params);
        LOGGER.info("Got Response: {}", response.getBody());
        return ResponseEntity.noContent().build();
    }

}
