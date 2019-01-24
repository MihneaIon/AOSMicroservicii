package com.facultate.aos.billing.repository;

import com.facultate.aos.billing.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}
