package com.baeldung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.dto.EmployeeDto;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private static final String SUCCESS = "SUCCESS";

    private static final String FAIL = "FAIL";

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/account", produces = "application/json")
    public ResponseEntity<String> account(String userId, int money) {
        LOGGER.info("Account Service - userId: {}, money: {}", userId, money);

        return ResponseEntity.ok(SUCCESS);
    }

    @PostMapping("/new-manager/{managerId}")
    public ResponseEntity<EmployeeDto> account(@PathVariable("managerId") Long managerId) {
        EmployeeEntity newManager = employeeService.newManager(managerId);
        EmployeeDto response = new EmployeeDto(
            newManager.getId(),
            newManager.getFirstName(),
            newManager.getLastName(),
            newManager.isManager()
        );
        return ResponseEntity.ok(response);
    }
}