package com.dhfl.OnlinePaymentGatewayDataDump.service;

import java.util.List;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.TransactionDetailsEntity;


public interface TransactionDetailsInter {
	public List<TransactionDetailsEntity> getAllTransactions();
}
