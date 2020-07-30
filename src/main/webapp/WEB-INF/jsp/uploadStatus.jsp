<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns:th="https://www.thymeleaf.org">
<head>
<link href="/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="/css/font-awesome.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<title>DHFL Online Payment</title>
</head>
<style>
table#tbl_data_status {
    margin-left: 25%;
    width: 50%;
    text-align: center;
    border: 1px solid #8080805e;
}
#report_status {
    color: green;
    width: 100%;
    font-size: 16px;
    margin-top: 5%;
    margin-bottom: 5%;
    text-transform: uppercase;
    text-align: center;
    font-weight: 900;
}
label#lbl_disclaimer {
	color: red;
	font-size: 14px;
	font-weight: 100;
}

table.trans_tbl>tbody>tr>td {
	width: 50%;
	padding-left: 5%;
}

table.trans_tbl {
	border: 1px solid #999999a1;
}
/*Transaction animation CSS*/
.ame_paystep {
	display: block;
	clear: both;
	margin: 20px auto;
	width: 445px;
}

.ame_paystepbg {
	display: block;
	margin: 0px;
	padding: 0px;
}

.ame_paystepinfo {
	display: block;
	margin-bottom: 15%;
	margin: 0px;
	padding: 0px;
	font-size: 11px;
	color: #444444;
	text-align: center;
}

.step1.active {
	float: left;
	margin: 0;
	padding: 0;
	width: 90px;
}

.step2 {
	float: left;
	margin: 0;
	padding: 0;
	text-align: center;
	width: 59%;
}

.step3 {
	float: right;
	margin: 0;
	padding: 0;
	width: 90px;
}

.ame_paystepbg>img {
	width: 100%;
}
/* End of Transaction animation CSS*/
img#img_captcha_refresh {
	width: 100px;
	padding: 2px 0px 2px 0px;
}

img#img_captcha {
	width: 70%;
	height: 5%;
	margin-top: 1px;
	border-radius: 3px;
}

thead>tr {
	background-color: #8080800f;
}

thead>tr {
	background-color: #8080800f;
}

label.lbl_captcha {
	font-size: 18px;
	background-color: #ed1c2480;
	color: #fff;
	padding: 5px 10px 5px 10px;
	border-radius: 5px;
	font-family: cursive;
	font-weight: 100;
}

h1 {
	color: #fff;
	font-size: 4.6rem;
	font-weight: 600;
	text-align: center;
	padding-bottom: 1rem;
	text-transform: none;
}

.rightNav {
	display: inline-block;
	float: right;
	padding-top: 1rem;
}

span.call {
	float: left;
	display: inline-block;
}

span.call>a {
	color: #fff;
	font-weight: bold;
	font-size: 2.4rem;
	padding-left: 3rem;
	padding-right: 4rem;
	display: inline-block;
	position: relative;
	pointer-events: none;
}

p {
	font-size: 1.6rem;
	padding: 0;
	color: #3e3e3e;
	opacity: .5;
	padding: 2rem 0;
	line-height: 2rem;
	font-weight: 400;
	text-align: center;
}

footer .lastFooter {
	background-color: #ecf0f5;
	/* border-top: 1px solid #d6d6d6;
    padding-bottom: 6.5rem; */
	text-align: center;
}

.col-md-8.form-group.details_frm {
	padding: 15px 15px 15px 15px;
	border: 1px #00000014 solid;
	/* margin-top: 20px; */
	border-top-color: #00a65a;
	background-color: #ecf0f5;
	border-radius: 3px;
	background: #ffffff;
	border-top: 3px solid #ed1c24;
	box-shadow: 0 10px 10px rgba(0, 0, 0, .05);
}

body {
	background-attachment: fixed;
	background-color: #ecf0f5;
	background-image: url('/images/background1.jpg');
	background-position: top;
	background-repeat: no-repeat;
}

.qrcode_img {
	width: 50%;
}

.form-control {
	display: inherit;
}

th, td {
	font-size: 13px;
	font-family: inherit;
}

.box-title {
	display: inline-block;
	font-size: 18px;
	margin: 0;
	line-height: 1;
	padding-bottom: 5px;
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
	background-color: #428bca;
	border: #428bca;
	padding: 10px 10px 10px 10px;
}

button.glyphicon.btn.btn-primary.mb-2 {
	background-color: #ed1c24;
	border: #ed1c24;
	padding: 10px 10px 10px 10px;
}

form.form-group.details_frm {
	padding: 15px 15px 15px 15px;
	border: 1px #00000014 solid;
	/* margin: 20px; */
	border-top-color: #00a65a;
	background-color: #ecf0f5;
	border-radius: 3px;
	background: #ffffff;
	border-top: 3px solid #ed1c24;
	box-shadow: 0 10px 10px rgba(0, 0, 0, .05);
}

body {
	background-color: #ecf0f5;
}

.row {
	margin-right: 0;
	margin-left: 0;
}
</style>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-sm bg-light navbar-light static-top">
		<img style="margin: 25px;" src="/images/logo.png" alt="Logo"
			style="width:40px;">
		<div class="rightNav">
			<span class="call"> <a href="tel:1800223435">1800 22 3435</a>
			</span>
		</div>
	</nav>

	<!--  Loan Details Row -->
	<div class="row">
		<div class="col-md-12">
			<div class="col-md-4"></div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<c:if test="${message !=null}">
				<form class="form-group details_frm">
					<div class="row">
						<div class="">
							<div class="form-group">
								<label id="report_status" style="color: green">${message}</label>
								<c:if test="${uploadStatus!=null }">
									<table class="table" id="tbl_data_status">
										<thead>
											<tr>
												<th scope="col">Total Records</th>
												<th scope="col">Updated Records</th>
												<th scope="col">Insetred Rows</th>
												<!-- <th scope="col">Mobile</th> -->
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>${totalRows} <input type="hidden" name="totalRows"
													value="${totalRows}" />
												</td>
												<td>${updatedRows} <input type="hidden" name="updatedRows"
													value="${updatedRows}" />
												</td>
												<td>${insertedRows} <input type="hidden" name="insertedRows"
													value="${insertedRows}" />
												</td>
												<%-- <td>
									${mobileno}
									<input type="hidden" name="mobile_no" value="${mobileno}"/>
								</td> --%>
											</tr>
										</tbody>
									</table>
								</c:if>
								<button onclick="window.location='/data/fileupload';" type="button" id="btn_upload_new" class="btn btn-primary mb-2">
									<span class="" aria-hidden="true">UPLOAD ANOTHER FILE</span>
								</button>
							</div>
						</div>
					</div>
				</form>
			</c:if>
		</div>
	</div>
	<footer>
		<div class="lastFooter">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<p>
							<strong>Disclaimer </strong>- "The Company is having a valid Certificate of
							Registration dated 31/07/2001 issued by the National Housing Bank
							under Section 29A of the National Housing Bank Act, 1987.
							However, the National Housing Bank does not accept any
							responsibility or guarantee about the present position as to the
							financial soundness of the company or for the correctness of any
							of the statements or representations made or opinions expressed
							by the company and for repayment of deposits / discharge of the
							liabilities by the company."

						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>