<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>경고창</title>
</head>
<body>
	<script type="text/javascript">
		var msg = "${msg}";
		var url = "${url}";
		alert(msg);
		location.href=url;
	</script>
</body>
</html>