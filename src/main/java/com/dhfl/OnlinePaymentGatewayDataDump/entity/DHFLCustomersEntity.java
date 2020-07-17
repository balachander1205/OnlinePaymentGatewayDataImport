package com.dhfl.OnlinePaymentGatewayDataDump.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "tbl_dhfl_customers")
@Table(name = "tbl_dhfl_customers", schema="dhfllive")
//@Table(name = "tbl_dhfl_customers", schema="custport")
public class DHFLCustomersEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brloancode")
	private String brloancode;
	
	@Column(name = "applno")
	private String applno;
	
	@Column(name = "customername")
	private String customername;
	
	@Column(name = "mobileno")
	private String mobileno;
	
	@Column(name = "TotalOverdueEMI")
	private Long TotalOverdueEMI;
	
	@Column(name = "MinimumOverdueAmount")
	private Long MinimumOverdueAmount;
	
	@Column(name = "OverdueBlankField")
	private Long OverdueBlankField;
	
	@Column(name = "TotalChargesAmount")
	private Long TotalChargesAmount;
	
	@Column(name = "MinimumChargeAmount")
	private Long MinimumChargeAmount;
	
	@Column(name = "ChargeBlankField")
	private Long ChargeBlankField;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrloancode() {
		return brloancode;
	}

	public void setBrloancode(String brloancode) {
		this.brloancode = brloancode;
	}

	public String getApplno() {
		return applno;
	}

	public void setApplno(String applno) {
		this.applno = applno;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Long getTotalOverdueEMI() {
		return TotalOverdueEMI;
	}

	public void setTotalOverdueEMI(Long totalOverdueEMI) {
		TotalOverdueEMI = totalOverdueEMI;
	}

	public Long getMinimumOverdueAmount() {
		return MinimumOverdueAmount;
	}

	public void setMinimumOverdueAmount(Long minimumOverdueAmount) {
		MinimumOverdueAmount = minimumOverdueAmount;
	}

	public Long getOverdueBlankField() {
		return OverdueBlankField;
	}

	public void setOverdueBlankField(Long overdueBlankField) {
		OverdueBlankField = overdueBlankField;
	}

	public Long getTotalChargesAmount() {
		return TotalChargesAmount;
	}

	public void setTotalChargesAmount(Long totalChargesAmount) {
		TotalChargesAmount = totalChargesAmount;
	}

	public Long getMinimumChargeAmount() {
		return MinimumChargeAmount;
	}

	public void setMinimumChargeAmount(Long minimumChargeAmount) {
		MinimumChargeAmount = minimumChargeAmount;
	}

	public Long getChargeBlankField() {
		return ChargeBlankField;
	}

	public void setChargeBlankField(Long chargeBlankField) {
		ChargeBlankField = chargeBlankField;
	}
}
