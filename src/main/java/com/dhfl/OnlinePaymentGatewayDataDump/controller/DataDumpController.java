package com.dhfl.OnlinePaymentGatewayDataDump.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dhfl.OnlinePaymentGatewayDataDump.config.ApplicationConfig;
import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;
import com.dhfl.OnlinePaymentGatewayDataDump.repo.DHFLCustomersRepo;
import com.dhfl.OnlinePaymentGatewayDataDump.service.DHFLCustomersInter;
import com.dhfl.OnlinePaymentGatewayDataDump.util.ExcelHelper;
import com.dhfl.OnlinePaymentGatewayDataDump.util.ReadExcelFile;

@Controller
@RequestMapping("/data")
public class DataDumpController {
	Logger logger = LoggerFactory.getLogger(DataDumpController.class);

	@Autowired
	DHFLCustomersRepo respository;
	
	@Autowired
	DHFLCustomersInter dhflCustomersInter;
	
	@Autowired
	ApplicationConfig applicationConfig;

	@GetMapping("/fileupload")
	public String index() {
		return "upload";
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			// Save the uploaded file to this folder
			String UPLOADED_FOLDER = applicationConfig.getDataFileUploadLocation();
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			redirectAttributes.addFlashAttribute("message",
					"Successfully uploaded '" + file.getOriginalFilename() + "'");
			// Get the file and save it somewhere
			System.out.println("File Name==>>"+UPLOADED_FOLDER + file.getOriginalFilename());
			File initialFile = new File(UPLOADED_FOLDER + file.getOriginalFilename());
			FileInputStream targetStream = new FileInputStream(initialFile);
			System.out.println("Input Stream="+targetStream);
			//List<DHFLCustomersEntity> customers = ExcelHelper.excelToTutorials(targetStream);
			List<DHFLCustomersEntity> customers = ReadExcelFile.excelToTutorials(targetStream);
			try {
				if(customers.size()>0) {
					System.out.println("Customers Size===="+customers.size());
					for(DHFLCustomersEntity entity : customers) {
						String applNo = entity.getApplno();
						System.out.println("ApplNumber----->>>>>"+applNo);
						DHFLCustomersEntity row = respository.searchByAppNo(applNo);
						// insert row if data not exists
						if(row==null) {
							respository.save(entity);
						}else {
							// Update row
							System.out.println("Row already exists..Updating record..");
							dhflCustomersInter.updateCustomer(applNo, entity.getMinimumOverdueAmount(), entity.getTotalOverdueEMI(), 
									entity.getTotalChargesAmount(), entity.getMinimumChargeAmount());
						}
					}
				}
			}catch(Exception e) {
				logger.debug("Exception@inserting customer data="+e);
				redirectAttributes.addFlashAttribute("message",
						"File upload is not successful '" + file.getOriginalFilename() + "'");
				return "redirect:/data/uploadStatus";
			}
			//respository.saveAll(customers);

		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message",
					"File upload is not successful '" + file.getOriginalFilename() + "'");
			return "redirect:/data/uploadStatus";
		}
		return "redirect:/data/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}
}
