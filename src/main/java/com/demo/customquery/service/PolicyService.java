package com.demo.customquery.service;

import com.demo.customquery.model.Policy;
import com.demo.customquery.repo.PolicyProjection;
import com.demo.customquery.repo.PolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PolicyService {
    @Autowired
    private PolicyRepo policyRepo;

    public void save(Policy policy) {
        policyRepo.save(policy);
    }

    public void test() {
        Policy policy1 = new Policy("POL001", "Peter John", 2000, 2000);
        Policy policy2 = new Policy()
                .builder()
                .policyNo("POL002")
                .holderName("HTET")
                .premium(2300)
                .sumInsured(45000)
                .build();
        save(policy1);
        save(policy2);

        Policy result1 = policyRepo.findById(1).orElseThrow(() -> new IllegalArgumentException("Invalid Id " + 1));
        Policy result2 = policyRepo.findPolicyById(2);
        // Policy result2 = findPolicyById(2);

        Policy result3 = policyRepo.findPolicyByHolderName("HTET");
        PolicyProjection result4 = policyRepo.findPolicyByPolicyNo("POL002", "HTET");


        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4.getPolicyNo() + " " + result4.getHolderName());

    }
}
