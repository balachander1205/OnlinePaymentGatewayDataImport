package com.dhfl.OnlinePaymentGatewayDataDump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;
import com.dhfl.OnlinePaymentGatewayDataDump.repo.DHFLCustomersRepo;

@Service
public class DHFLCustomersInterImpl implements DHFLCustomersInter{
	@Autowired
	DHFLCustomersRepo dhflCustomersRepo;

	@Override
	public DHFLCustomersEntity searchByBrLoanCode(String brLoanCode) {
		return dhflCustomersRepo.searchByBrLoanCode(brLoanCode);
	}

	@Override
	public DHFLCustomersEntity searchByAppNo(String appNo) {
		return dhflCustomersRepo.searchByAppNo(appNo);
	}

	@Override
	public DHFLCustomersEntity searchByMobileNo(String mobileNo) {
		return dhflCustomersRepo.searchByMobileNo(mobileNo);
	}

	@Override
	public int updateCustomer(String appNo, Long MinimumOverdueAmount, Long TotalOverdueEMI, Long TotalChargesAmount,
			Long MinimumChargeAmount) {
		int count = dhflCustomersRepo.updateCustomer(appNo, MinimumOverdueAmount, TotalOverdueEMI, TotalChargesAmount,
				MinimumChargeAmount);
		return count;
	}
}
