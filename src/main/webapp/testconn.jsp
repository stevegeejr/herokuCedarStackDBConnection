<%@ 
	page import="org.geefive.heroku.postgres.*,java.util.*" 
	language="java"
%>
<%! 
	String result = "N/A";
%>
<%
	PostGresDBManager dbManager = new PostGresDBManager(session);
	try{
		result = dbManager.openConnection();
	}catch(Exception ex){
		out.println(ex.getMessage());
	}
%>

<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>PostgreSQL Connectivity Test</title>

<link type="text/css" rel="stylesheet" href="postgres.css">

</head>
<body>
<form method="POST" action="/testconn.jsp">
	<p>&nbsp;</p>
	<div align="center">
		<table border="0" class="border" width="800">
			<tr>
				<td class="headerBold" width="395">PostgreSQL Connection Test Harness</td>
				<td class="headerBold" width="393">
				<p align="right">[<a href="index.jsp">Return Home</a>]</td>
			</tr>
			<tr>
				<td class="header" colspan="2">Connectivity Results ...</td>
			</tr>
			<tr>
				<td class="rowA" colspan="2"><%= result  %></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="Re-Test Connection" name="B1" style="float: right"></td>
			</tr>
		</table>
	</div>
	<p>&nbsp;</p>
</form>


</body>

</html>