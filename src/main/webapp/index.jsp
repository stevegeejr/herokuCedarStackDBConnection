<html>

<head>
<meta http-equiv="Content-Language" content="en-us">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<title>PostgreSQL  Connectivity Test</title>

<link type="text/css" rel="stylesheet" href="postgres.css">

</head>

<body>


<form method="POST" action="/testconn.jsp">
	<p>&nbsp;</p>
	<div align="center">
		<table border="0" class="border" width="800">
			<tr>
				<td class="headerBold">PostgreSQL Connection Test Harness</td>
			</tr>
			<tr>
				<td class="rowA">This test harness will simply allow a user to 
				test their Cedar Stack Heroku instance. There is nothing to 
				configure, the system will automatically pull the &quot;SHARED_DATABASE_URL&quot; environment 
				variable, parse the connection string and connect to the 
				database.<p>The Connection code can be fetched from [<a target="_source" href="PostGresDBManager.java">HERE</a>]<p>
				Full Source:
				<a href="https://stevegeejr@github.com/stevegeejr/herokuCedarStackDBConnection.git">
				https://stevegeejr@github.com/stevegeejr/herokuCedarStackDBConnection.git</a></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="Test Connection" name="B1" style="float: right"></td>
			</tr>
		</table>
	</div>
	<p>&nbsp;</p>
</form>


</body>

</html>