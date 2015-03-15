<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Vue Banque</title>
</head>
<body>
<form action="ServletBanque"  method="post">
Code : <input type="text" name="code">
Montant : <input type="text" name="mnt"><br/>
<input type="submit" name="action" value="Verser">
<input type="submit" name="action" value="Retirer">
<table border="1">
<tr>
<th>CODE</th><th>DATE CREATION</th><th>SOLDE</th>
</tr>
<c:forEach items="${comptes}" var="c">
<tr>
<td>${c.code}</td><td>${c.dateCreation}</td><td>${c.solde}</td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>