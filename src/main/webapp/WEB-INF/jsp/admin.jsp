<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html xmlns:th="https://www.thymeleaf.org">
<head>
	<link href="/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="/js/jquery-1.11.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<title>DHFL Transactions</title>	
</head>
<style>
table.table>thead {
    background-color: #c1c1c15e;
    border-bottom: 3px solid #c1c1c1;
}
form.form-group.details_frm {
    padding: 15px 15px 15px 15px;
    border: 1px #00000014 solid;
    margin: 20px;
    border-top-color: #00a65a;
    background-color: #ecf0f5;
    border-radius: 3px;
    background: #ffffff;
    border-top: 3px solid #ed1c24;
    box-shadow: 0 10px 10px rgba(0,0,0,.05);
}
.div_amt_details {
    color: black !important;
    width: 16px;
    height: 16px;
    text-align: center;
    border-radius: 16px;
    font-size: 12px;
    border: #00000045 solid 1px;
    font-weight: bolder;
    margin-top: 10px;
}
button.glyphicon.glyphicon-search.btn.btn-primary.mb-2 {
    background-color: #ed1c24;
    border: #ed1c24;
    padding: 10px 10px 10px 10px;
}
.table>tbody>tr>td {
    font-size: 12px;
    border-bottom: 2px solid #ddd;
}
.table>thead>tr>th {
    font-size: 12px;
}
.row {
    margin-right: 0;
    margin-left: 0;
}
body {
    background-color: #ecf0f5;
    background-image: url(/images/background1.jpg);
    background-position: top;
    background-repeat: no-repeat;
}
</style>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-sm bg-light navbar-light static-top">
			<img src="/images/logo.png" alt="Logo" style="margin:25px;">
	</nav>
	<!-- <h2>Search Form</h2> -->
	<!-- <script type="text/javascript" src="https://www.tecprocesssolution.com/proto/P2M/server/lib/checkout.js"></script> -->
	<div class="row ">
		<form method="post" action="/searchform" class="form-group details_frm">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="col-md-3">
							<div class="form-group">
								<label for="contain">Transaction Number</label> 
								<input required class="form-control"	type="text" name="loancode"/>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="contain">Application Number</label> 
								<input required class="form-control"	type="text" name="appno"/>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="contain">Customer ID</label> 
								<input required class="form-control"	type="text" name="customerid"/>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label for="contain">Mobile Number</label> 
								<input required class="form-control" type="text" name="mobileno" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-3">
						<div class="form-group">
							<button type="submit" class="glyphicon glyphicon-search btn btn-primary mb-2">
								<span class="" aria-hidden="true">Search</span>
							</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- Displaying error message -->
	<c:if test="${errormsg !=null}">
		<div style="text-align: center">${errormsg}</div>
	</c:if>
	<!-- Data table -->
	<div class="row">
		<c:if test="${data != null}">
		<form action class="form-group details_frm table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">AppNo</th>
						<th scope="col">BRLoanCode</th>
						<th scope="col">TxnTime</th>
						<th scope="col">Customer Name</th>
						<th scope="col">TxnStatus</th>
						<th scope="col">Message</th>
						<th scope="col">Error Message</th>
						<th scope="col">TxnRef</th>
						<th scope="col">BankID</th>
						<th scope="col">TPSLTxnID</th>
						<th scope="col">TxnAmount</th>
						<th scope="col">Client Meta</th>						
						<!-- <th scope="col">TPSLRefundID</th> -->
						<th scope="col">Balance Amount</th>
						<!-- <th scope="col">Token</th>
						<th scope="col">Hash</th> -->						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="data" items="${data}">
						<tr>
							<td scope="row">${data.app_no}</td>
							<td scope="row">${data.loan_code}</td>
							<td scope="row">${data.tpsl_txn_time}</td>
							<td scope="row">${data.customer_name}</td>
							<td scope="row">${data.txn_status}</td>
							<td scope="row">${data.txn_msg}</td>
							<td scope="row">${data.txn_err_msg}</td>
							<td scope="row">${data.clnt_txn_ref}</td>
							<td scope="row">${data.tpsl_bank_cd}</td>
							<td scope="row">${data.tpsl_txn_id}</td>
							<td scope="row">${data.txn_amt}</td>
							<td scope="row">${data.clnt_rqst_meta}</td>							
							<%-- <td scope="row">${data.tpsl_rfnd_id}</td> --%>
							<td scope="row">${data.bal_amt}</td>
							<%-- <td scope="row">${data.token}</td>
							<td scope="row">${data.hash}</td> --%>							
						</tr>
					</c:forEach>											
				</tbody>
			</table>
		</form>
		</c:if>
	</div>
	<!-- Response Text -->
	<div class="row">
		<div class="col-md-12">
			<div class="col-md-3">
				<%-- <div class="form-group">${btnSubmit}</div> --%>
			</div>
		</div>
	</div>
	<!-- status message -->
	<c:if test="${status_msg !=null}">
		<div style="text-align: center">${status_msg}</div>
	</c:if>
</body>
<script type='text/javascript'>
    // Tool tip logic
    $(document).ready(function(){
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
</html>