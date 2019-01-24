package com.facultate.aos.billing.service;

import com.facultate.aos.billing.model.Billing;
import com.facultate.aos.billing.repository.BillingRepository;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImpl  implements BillingService{

    public BillingRepository billingRepository;

    public BillingServiceImpl(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @Override
    public Billing addBill(Billing bill) {
        return billingRepository.saveAndFlush(bill);
    }

    @Override
    public Billing updateBill(long billId, Billing billing) {
        Billing updateBill=getBill(billId);
        updateBill.setNameOfPerson(billing.getNameOfPerson());
        updateBill.setPlaceForDeleavery(billing.getPlaceForDeleavery());
        updateBill.setDate(billing.getDate());

        return billingRepository.saveAndFlush(updateBill);
    }

    @Override
    public Billing getBill(long id) {
        return billingRepository.findById(id).get();
    }

    @Override
    public void deleteBill(long id) {
        billingRepository.deleteById(id);
    }
}
