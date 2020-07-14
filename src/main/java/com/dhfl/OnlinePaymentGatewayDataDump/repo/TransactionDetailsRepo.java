package com.dhfl.OnlinePaymentGatewayDataDump.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.TransactionDetailsEntity;

@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetailsEntity, Long>{
	//@Query(value = "select loanData from TransactionDetailsEntity loanData", nativeQuery = true)
	//@Query(value = "select * from dhfllive.tbl_transaction_details", nativeQuery = true)
	@Query(value = "select * from tbl_transaction_details", nativeQuery = true)
	List<TransactionDetailsEntity> getAllTransactions();
}
