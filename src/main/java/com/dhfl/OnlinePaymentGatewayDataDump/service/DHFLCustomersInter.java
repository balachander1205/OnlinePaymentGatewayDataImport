package com.dhfl.OnlinePaymentGatewayDataDump.service;

import org.springframework.data.repository.query.Param;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;

public interface DHFLCustomersInter {
	public DHFLCustomersEntity searchByBrLoanCode(String brLoanCode);
	public DHFLCustomersEntity searchByAppNo(String appNo);
	public DHFLCustomersEntity searchByMobileNo(String mobileNo);
	public int updateCustomer(String appNo, Long MinimumOverdueAmount,
			Long TotalOverdueEMI, Long TotalChargesAmount,
			Long MinimumChargeAmount, String mobileno, String customerName);
}
