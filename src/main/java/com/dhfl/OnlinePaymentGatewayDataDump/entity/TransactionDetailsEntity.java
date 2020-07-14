package com.dhfl.OnlinePaymentGatewayDataDump.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@Table(name = "tbl_transaction_details")
@Table(name = "tbl_transaction_details", schema="DHFLLIVE")
public class TransactionDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "txn_status")
	private String txn_status;
	
	@Column(name = "txn_msg")
	private String txn_msg;
	
	@Column(name = "txn_err_msg")
	private String txn_err_msg;
	
	@Column(name = "clnt_txn_ref")
	private String clnt_txn_ref;
	
	@Column(name = "tpsl_bank_cd")
	private String tpsl_bank_cd;
	
	@Column(name = "tpsl_txn_id")
	private String tpsl_txn_id;
	
	@Column(name = "txn_amt")
	private String txn_amt;
	
	@Column(name = "clnt_rqst_meta")
	private String clnt_rqst_meta;
	
	@Column(name = "tpsl_txn_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tpsl_txn_time;
	
	@Column(name = "bal_amt")
	private String bal_amt;
	
	@Column(name = "card_id")
	private String card_id;
	
	@Column(name = "alias_name")
	private String alias_name;
	
	@Column(name = "BankTransactionID")
	private String BankTransactionID;
	
	@Column(name = "mandate_reg_no")
	private String mandate_reg_no;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "hash")
	private String hash;
	
	@Column(name = "app_no")
	private String app_no;
	
	@Column(name = "loan_code")
	private String loan_code;
	
	@Column(name = "customer_name")
	private String customer_name;
	
	@Column(name = "mobile_number")
	private String mobile_number;
	
	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public String getApp_no() {
		return app_no;
	}

	public void setApp_no(String app_no) {
		this.app_no = app_no;
	}

	public String getLoan_code() {
		return loan_code;
	}

	public void setLoan_code(String loan_code) {
		this.loan_code = loan_code;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTxn_status() {
		return txn_status;
	}

	public void setTxn_status(String txn_status) {
		this.txn_status = txn_status;
	}

	public String getTxn_msg() {
		return txn_msg;
	}

	public void setTxn_msg(String txn_msg) {
		this.txn_msg = txn_msg;
	}

	public String getTxn_err_msg() {
		return txn_err_msg;
	}

	public void setTxn_err_msg(String txn_err_msg) {
		this.txn_err_msg = txn_err_msg;
	}

	public String getClnt_txn_ref() {
		return clnt_txn_ref;
	}

	public void setClnt_txn_ref(String clnt_txn_ref) {
		this.clnt_txn_ref = clnt_txn_ref;
	}

	public String getTpsl_bank_cd() {
		return tpsl_bank_cd;
	}

	public void setTpsl_bank_cd(String tpsl_bank_cd) {
		this.tpsl_bank_cd = tpsl_bank_cd;
	}

	public String getTpsl_txn_id() {
		return tpsl_txn_id;
	}

	public void setTpsl_txn_id(String tpsl_txn_id) {
		this.tpsl_txn_id = tpsl_txn_id;
	}

	public String getTxn_amt() {
		return txn_amt;
	}

	public void setTxn_amt(String txn_amt) {
		this.txn_amt = txn_amt;
	}

	public String getClnt_rqst_meta() {
		return clnt_rqst_meta;
	}

	public void setClnt_rqst_meta(String clnt_rqst_meta) {
		this.clnt_rqst_meta = clnt_rqst_meta;
	}

	public Date getTpsl_txn_time() {
		return tpsl_txn_time;
	}

	public void setTpsl_txn_time(Date tpsl_txn_time) {
		this.tpsl_txn_time = tpsl_txn_time;
	}

	public String getBal_amt() {
		return bal_amt;
	}

	public void setBal_amt(String bal_amt) {
		this.bal_amt = bal_amt;
	}

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getAlias_name() {
		return alias_name;
	}

	public void setAlias_name(String alias_name) {
		this.alias_name = alias_name;
	}

	public String getBankTransactionID() {
		return BankTransactionID;
	}

	public void setBankTransactionID(String bankTransactionID) {
		BankTransactionID = bankTransactionID;
	}

	public String getMandate_reg_no() {
		return mandate_reg_no;
	}

	public void setMandate_reg_no(String mandate_reg_no) {
		this.mandate_reg_no = mandate_reg_no;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
	
}
