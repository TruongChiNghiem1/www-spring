<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<link href="<c:url value="/styles/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/styles/main.css" />" rel="stylesheet">

</head>
<body>

	<div class="container" style="max-width: 600px">
		<span>${error}</span>
		<form:form role="form" action="${pageContext.request.contextPath}/employees/save" method="post" modelAttribute="employee" class="needs-validation">
			
			<h2>
			<c:if>
				Registration Employee
			</c:if>
			<c:if test="${employee != null}">
				Update Employee
			</c:if>
			
			
			</h2>
			<div class="mb-3 row align-items-center">
				<form:label path="firstName" cssClass="col-sm-3 control-label">First Name</form:label>
				<div class="col-sm-9">
					<form:input path="firstName" placeholder="First Name" cssClass="form-control" />
					<form:errors path="firstName" cssClass="error"/>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="lastName" cssClass="col-sm-3 control-label">Last Name</form:label>
				<div class="col-sm-9">
					<form:input path="lastName" placeholder="Last Name" cssClass="form-control" />
					<form:errors path="lastName" cssClass="error"/>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="emailAddress" cssClass="col-sm-3 control-label">Email</form:label>
				<div class="col-sm-9">
					<form:input type="email" path="emailAddress" placeholder="Email" cssClass="form-control" />
					<form:errors path="emailAddress" cssClass="error"/>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="dob" class="col-sm-3 control-label">Date of Birth</form:label>
				<div class="col-sm-9">
					<form:input type="date" path="dob" cssClass="form-control" />
					<form:errors path="dob" cssClass="error"/>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="phoneNumber" cssClass="col-sm-3 control-label">Phone number </form:label>
				<div class="col-sm-9">
					<form:input path="phoneNumber" placeholder="Phone number" cssClass="form-control" />
					<form:errors path="phoneNumber" cssClass="error"/>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="gender" class="control-label col-sm-3">Gender</form:label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-check form-check-inline">
								<form:radiobutton cssClass="form-check-input" path="gender" id="male" value="male" label="Male"/> 
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-check form-check-inline">
								<form:radiobutton cssClass="form-check-input" path="gender" id="female" value="female" label="Female" /> 
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="mb-3 row align-items-center">
				<form:label path="address.address" cssClass="col-sm-3 control-label">Address</form:label>
				<div class="col-sm-9">
					<form:input path="address.address" placeholder="Address" class="form-control" />
					<form:errors path="address.address" cssClass="error"/>
				</div>
			</div>
			<div class="mb-3 row">
			<div class="col-sm-3"></div>
			<div class="col-sm-9">
			<a href="<c:url value="/employees" /> " class="btn btn-secondary"> Back</a>
			<button type="submit" class="btn btn-primary">Register</button>
			</div>
			</div>
		</form:form>
		<!-- /form -->
	</div>
	<!-- ./container -->

</body>
</html>