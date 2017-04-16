<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.Map"%>
<html>
<head>
<title>Order Items</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/demos.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300,600,400'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/jsgrid.css" />
<link rel="stylesheet" type="text/css" href="css/theme.css" />
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.2/themes/cupertino/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>


<script src="src/jsgrid.core.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="css/sweetalert.css">
<script src="js/sweetalert.min.js"></script>
<script src="js/scripts.js" type="text/javascript"></script>
<script src="src/jsgrid.load-indicator.js" type="text/javascript"></script>
<script src="src/jsgrid.load-strategies.js" type="text/javascript"></script>
<script src="src/jsgrid.sort-strategies.js" type="text/javascript"></script>
<script src="src/jsgrid.field.js" type="text/javascript"></script>
<script src="src/fields/jsgrid.field.text.js" type="text/javascript"></script>
<script src="src/fields/jsgrid.field.number.js" type="text/javascript"></script>
<script src="src/fields/jsgrid.field.control.js" type="text/javascript"></script>
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900|Quicksand:400,700|Questrial"
	rel="stylesheet" />
<link href="css/default.css" rel="stylesheet" type="text/css"
	media="all" />
<meta name="viewport" content="width=1200, maximum-scale=10" />
</head>

<body>

	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<!-- 				<span class="icon icon-cog"></span> -->

			</div>
			<div id="menu">
				<ul>


					<li><a class="tab" href="Orders.jsp">Orders</a></li>

					<li class="active"><a class="tab" href="#">&nbsp; &nbsp;&nbsp;&nbsp;
							Order Items &nbsp;&nbsp; &nbsp;</a></li>
					<li><a class="tab" href="Product.jsp">&nbsp;
							&nbsp;&nbsp;&nbsp; Products &nbsp;&nbsp; &nbsp;</a></li>
					<li><a class="tab" href="Customers.jsp">&nbsp;
							&nbsp;&nbsp;&nbsp; Customers &nbsp;&nbsp; &nbsp;</a></li>


				</ul>
				<ul>

				</ul>
			</div>
		</div>
	</div>
	<div class="wrapper" style="width:100%;">
		<!-- 		<button onclick="addLocation()" id="save">Save</button> -->
		<div id="banner" class="containe
				le="width:80%;">

			<div id="jsGrid"></div>
			<div id="detailsDialog">
				<div class="details-form-field">
					<table>


						<tr>
							<td><label><b style="font-size:1.1em;">Item ID :</b></label></td>
							<td><input id="id" name="id" type="text" disabled="disabled"
								style="background-color:white; height:33px; font-size:1em; font-weight: bold; border-radius:5px;" /></td>
						</tr>
						<tr>
							<td><label><b style="font-size:1.1em;">Status :</b></label></td>
							<td><select id="status" name="status"
								style="background-color:white;  height:33px; font-size:1em; font-weight: bold; border-radius:5px;"><option
										value="0">Canceled</option>
									<option value="active">Active</option></select></td>
						</tr>
						<tr>
							<td><label><b style="font-size:1.1em;">Price :</b></label></td>
							<td><input id="price" name="price" type="text"
								style="background-color:white; height:33px; font-size:1em; font-weight: bold; border-radius:5px;" /></td>
						</tr>
						<tr>
							<td><label><b style="font-size:1.1em;">Quantity
										:</b></label></td>
							<td><input id="quantity" name="quantity" type="text"
								style="background-color:white; height:33px; font-size:1em; font-weight: bold; border-radius:5px;" /></td>
						</tr>
						<tr>
							<td align="center" colspan="2">
								<button style="width: 60px; height:30px; margin-top:8px;"
									onclick="updateOrderItem()" id="save">Update</button>
							</td>
						</tr>
					</table>
				</div>
				<div class="details-form-field"></div>
			</div>
			<div style="position: absolute; right: 26%;">
				<br>
				<!-- 					<button class="newEventButt">Add New Event</button> -->
				<input type="image" class="butt" src="img/addOrderItem.png"
					alt="Add Order" onclick="addOrderItem()"
					style="widht:50px; height: 50px; " />

			</div>
		</div>
	</div>



	<div id="copyright">
		<p>&copy; All rights reserved.</p>

	</div>
</body>
<script src="./js/OrdersItem.js"></script>
</html>



