<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<style>
	 
	    .error {
	        color: #ff0000;
	    }
	    
        tr:second-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }	    
	</style>	
</head>
<body>
	<form:form method="post" action="add" commandName="usuario">
		<table>
		
			<tr>
				<td><form:label path="username">
						<spring:message code="label.username" />
					</form:label></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message code="label.password" />
					</form:label></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" />
					</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"/></td>
			</tr>
					
			<tr>
				<td><form:label path="firstname">
						<spring:message code="label.firstname" />
					</form:label></td>
				<td><form:input path="firstname" /></td>
				<td><form:errors path="firstname" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="lastname">
						<spring:message code="label.lastname" />
					</form:label></td>
				<td><form:input path="lastname" /></td>
				<td><form:errors path="lastname" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="lab">
						<spring:message code="label.lab" />
					</form:label></td>
				<td><form:input path="lab" /></td>
				<td><form:errors path="lab" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td><form:label path="division">
						<spring:message code="label.division" />
					</form:label></td>
				<td><form:input path="division" /></td>
				<td><form:errors path="division" cssClass="error"/></td>
			</tr>
						
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.add"/>" /></td>
			</tr>
		</table>
	</form:form>

	<h3>List of Users</h3>
	<c:if test="${!empty usuarioList}">
		<table class="data">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Lab</th>
				<th>Division</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${usuarioList}" var="usr">
				<tr>
					<td>${usr.lastname},${usr.firstname}</td>
					<td>${usr.email}</td>
					<td>${usr.lab}</td>
					<td>${usr.division}</td>
					<td><a href="<c:url value='/delete/${usr.ID}-user' />">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>