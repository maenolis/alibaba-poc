package com.baeldung;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.baeldung.dto.EmployeeDto;

@Service
public class CompanyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);

    private static final String EMPLOYEE_MGMT = "employee-mgmt";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancerClient;

    public void updateManager(Long managerId, boolean exception) {

        Map<String, Object> params = new HashMap<>();
        params.put("managerId", managerId);
//        ServiceInstance serviceInstance = loadBalancerClient.choose(EMPLOYEE_MGMT);
//        String endpointPath = String.format("http://%s:%s/new-manager/{managerId}", serviceInstance.getHost(), serviceInstance.getPort());
        String endpointPath = "http://127.0.0.1:18084/new-manager/{managerId}";
        LOGGER.info("Endpoint: {}", endpointPath);
        ResponseEntity<EmployeeDto> response = restTemplate.postForEntity(endpointPath, null, EmployeeDto.class, params);

        if (exception) {
            throw new RuntimeException("foo");
        }

        jdbcTemplate.update("update manager set first_name = ?, last_name = ?", response.getBody().getFirstName(), response.getBody().getLastName());

    }

}
