package com.dhfl.OnlinePaymentGatewayDataDump.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.TransactionDetailsEntity;
import com.dhfl.OnlinePaymentGatewayDataDump.service.TransactionDetailsInter;


@Controller
@RequestMapping("/data")
public class AdminController {
Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	TransactionDetailsInter transDetails;
	
	@GetMapping("/admin")
	public String payment(ModelMap map) {
		try {
			System.out.println("it is runing on" + (env.getProperty("local.server.port")));
			List<TransactionDetailsEntity> data = transDetails.getAllTransactions();
			map.put("data", data);
			for(TransactionDetailsEntity row : data) {
				System.out.println("Row :: "+row);
			}
		}catch(Exception e) {
			logger.debug("Exception@/data/admin="+e);
		}
		return "admin";
	}
}
