package com.facultate.aos.billing.proxy;

import com.facultate.aos.billing.model.Billing;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "warehouse", url = "localhost:2002")
public interface WarehouseProxy {
    @GetMapping("/item/{itemId}")
    public Billing retriveWarehouse(@PathVariable("itemId") Long itemId);

    @PutMapping("/item/up/{itemId}")
    public Billing buyAndUpdateStore(@PathVariable("itemId") Long itemId);
}
