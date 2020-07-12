package com.dhfl.OnlinePaymentGatewayDataDump.service;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;

public interface DHFLCustomersInter {
	public DHFLCustomersEntity searchByBrLoanCode(String brLoanCode);
	public DHFLCustomersEntity searchByAppNo(String appNo);
	public DHFLCustomersEntity searchByMobileNo(String mobileNo);
}
