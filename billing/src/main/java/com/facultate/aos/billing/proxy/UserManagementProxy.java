package com.facultate.aos.billing.proxy;

import com.facultate.aos.billing.model.Billing;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "userManagement" ,url="localhost:2001")
public interface UserManagementProxy {
    @GetMapping("/user/getUser/{id}")
    public Billing retriveUserName(@PathVariable("id") Long id);
}
