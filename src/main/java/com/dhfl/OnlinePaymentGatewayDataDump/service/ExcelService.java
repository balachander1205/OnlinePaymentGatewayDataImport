package com.dhfl.OnlinePaymentGatewayDataDump.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;
import com.dhfl.OnlinePaymentGatewayDataDump.repo.DHFLCustomersRepo;
import com.dhfl.OnlinePaymentGatewayDataDump.util.ExcelHelper;

@Service
public class ExcelService {
	@Autowired
	DHFLCustomersRepo repository;

	public void save(MultipartFile file) {
		try {
			List<DHFLCustomersEntity> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
			repository.saveAll(tutorials);
		} catch (IOException e) {
			throw new RuntimeException("fail to store excel data: " + e.getMessage());
		}
	}
}
