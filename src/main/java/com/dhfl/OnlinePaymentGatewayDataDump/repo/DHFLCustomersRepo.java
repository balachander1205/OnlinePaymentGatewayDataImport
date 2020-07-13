package com.dhfl.OnlinePaymentGatewayDataDump.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;

@Repository
public interface DHFLCustomersRepo extends CrudRepository<DHFLCustomersEntity, Long>{
	@Query("select loandata from DHFLCustomersEntity loandata where loandata.brloancode = :brLoanCode")
	DHFLCustomersEntity searchByBrLoanCode(@Param("brLoanCode") String brLoanCode);
	
	@Query("select loandata from DHFLCustomersEntity loandata where loandata.applno = :appNo")
	DHFLCustomersEntity searchByAppNo(@Param("appNo") String appNo);
	
	@Query("select loandata from DHFLCustomersEntity loandata where loandata.mobileno = :mobileNo")
	DHFLCustomersEntity searchByMobileNo(@Param("mobileNo") String mobileNo);
	
	@Query("update DHFLCustomersEntity loandata set TotalOverdueEMI=:TotalOverdueEMI,"
			+ "MinimumOverdueAmount=:MinimumOverdueAmount, TotalChargesAmount=:TotalChargesAmount,"
			+ "MinimumChargeAmount=:MinimumChargeAmount where loandata.applno = :appNo")
	int updateCustomer(@Param("appNo") String appNo, @Param("MinimumOverdueAmount") Long MinimumOverdueAmount,
			@Param("TotalOverdueEMI") Long TotalOverdueEMI, @Param("TotalChargesAmount") Long TotalChargesAmount,
			@Param("MinimumChargeAmount") Long MinimumChargeAmount);
}
