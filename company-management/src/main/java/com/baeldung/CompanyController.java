package com.baeldung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.seata.spring.annotation.GlobalTransactional;

@RestController
@RefreshScope
public class CompanyController {

    @Value(value = "${ceo:takis}")
    String ceoValue;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    CompanyService companyService;

    @GetMapping("/config/ceo")
    public ResponseEntity<String> getFooValue() {
        String ceoApplicationContext = applicationContext.getEnvironment().getProperty("ceo");
        String response = String.format("CEO: %s - CEO(env): %s", ceoValue, ceoApplicationContext);
        return ResponseEntity.ok(response);
    }

    @GlobalTransactional(timeoutMills = 300000, name = "company-mgmt-tx-group")
    @PostMapping("/manager/{managerId}")
    public ResponseEntity<Void> changeManager(@PathVariable("managerId") Long managerId, boolean exception) {
        companyService.updateManager(managerId, exception);
        return ResponseEntity.noContent().build();
    }
}
