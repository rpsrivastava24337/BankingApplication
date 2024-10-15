<%@page import="newAccount.AccountBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RPS Bank</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">RPS Bank</a>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="newaccount.html">New Account</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="balance.html">Balance</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="deposit.html">Deposit</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="withdraw.html">Withdraw</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="transfer.html">Transfer</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="closeacc.html">Close Account</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="aboutus.html">About Us</a></li>

					</ul>
				</div>
			</div>
		</nav>
	</div>

	<%
	AccountBean ab = (AccountBean) application.getAttribute("abean");

	%>
	<div class="result">
		<h4>Account close Successfully !!!</h4>
		<table>
			<tr>
				<th>Your Acc.No</th>
				<th>Your Balance</th>
				<th>Account Status</th>
				



			</tr>
			<tr>
				<td><%=ab.getAccNo()%></td>
				<td><%=ab.getAmt()%></td>
				<td><%="Closed"%></td>
				
			</tr>

		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>