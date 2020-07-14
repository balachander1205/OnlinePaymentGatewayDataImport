package com.dhfl.OnlinePaymentGatewayDataDump.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.TransactionDetailsEntity;
import com.dhfl.OnlinePaymentGatewayDataDump.repo.TransactionDetailsRepo;

@Service
public class TransactionDetailsInterImpl implements TransactionDetailsInter{
	
	@Autowired
	TransactionDetailsRepo transDetailsRepo;

	@Override
	public List<TransactionDetailsEntity> getAllTransactions() {
		return transDetailsRepo.getAllTransactions();
	}

	

}
