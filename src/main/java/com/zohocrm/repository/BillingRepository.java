package com.zohocrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm.entities.Billing;

                                          // give Billing and wrapper class name Long
public interface BillingRepository extends JpaRepository<Billing, Long> { 

}
