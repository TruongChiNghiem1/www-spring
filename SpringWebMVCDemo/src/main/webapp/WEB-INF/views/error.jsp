<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<h2>Application Error, please contact support.</h2>
<h3>${message}</h3>
<a href="<c:url value="/employees" /> " class="btn btn-secondary"> Back</a>
</body>
</html>