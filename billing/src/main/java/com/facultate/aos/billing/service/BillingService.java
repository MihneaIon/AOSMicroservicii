package com.facultate.aos.billing.service;

import com.facultate.aos.billing.model.Billing;

public interface BillingService {

    Billing addBill(Billing bill);

    Billing updateBill(long billId, Billing billing);

    Billing getBill(long id);

    void deleteBill(long id);
}
