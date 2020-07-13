package com.dhfl.OnlinePaymentGatewayDataDump.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
	@Value("${pg.data.upload.location}")
	private String dataFileUploadLocation;

	public String getDataFileUploadLocation() {
		return dataFileUploadLocation;
	}

	public void setDataFileUploadLocation(String dataFileUploadLocation) {
		this.dataFileUploadLocation = dataFileUploadLocation;
	}	
}
