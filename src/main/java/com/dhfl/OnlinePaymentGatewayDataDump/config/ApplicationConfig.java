package com.dhfl.OnlinePaymentGatewayDataDump.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	@Value("${pg.data.upload.location}")
	private String dataFileUploadLocation;
	
	@Value("${pg.data.upload.invalid.file}")
	private String invalidFileUploaded;
	
	@Value("${pg.data.upload.blank.file}")
	private String blankFileUploaded;
	
	public String getBlankFileUploaded() {
		return blankFileUploaded;
	}

	public void setBlankFileUploaded(String blankFileUploaded) {
		this.blankFileUploaded = blankFileUploaded;
	}

	public String getInvalidFileUploaded() {
		return invalidFileUploaded;
	}

	public void setInvalidFileUploaded(String invalidFileUploaded) {
		this.invalidFileUploaded = invalidFileUploaded;
	}

	public String getDataFileUploadLocation() {
		return dataFileUploadLocation;
	}

	public void setDataFileUploadLocation(String dataFileUploadLocation) {
		this.dataFileUploadLocation = dataFileUploadLocation;
	}	
}
