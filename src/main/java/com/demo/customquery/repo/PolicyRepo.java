package com.demo.customquery.repo;

import com.demo.customquery.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Integer> {
    //naming over convertion

    Policy findPolicyById(Integer id);

    //SELECT * FROM Policy where holderName = 'HTET'
    //Policy findPolicyByHolderName(String name);

    //JPQL vs Native Query
    @Query("SELECT p FROM Policy p WHERE p.holderName = :name")
    Policy findPolicyByHolderName(@Param("name") String names);

    //@Query("SELECT p.holderName as holderName, p.policyNo as policyNo FROM Policy p WHERE p.policyNo = ?1 AND p.holderName = ?2")
    //PolicyProjection findPolicyByPolicyNo(String policyNo, String holderName);

    @Query("SELECT p.holderName as holderName, p.policyNo as policyNo FROM Policy p WHERE p.policyNo = ?1 AND p.holderName = ?2")
    PolicyProjection findPolicyByPolicyNo(String policyNo, String holderName);
}
