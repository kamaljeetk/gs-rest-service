<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page session="true"%>

<html> 
<head> <title>Spittr</title>
 <!-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" > -->
 </head> <body> <h1>Register</h1>
 
 
 
 <c:forEach items="${greetingList}" var="greeting" >
 <table>
 <tr>
 <td> <div class="ID"> <c:out value="${greeting.id}" /> </div></td>
  <td> <div class="CONTENT"> <c:out value="${greeting.content}" /> </div></td>
   <td> <div class="PRIORITY"> <c:out value="${greeting.priority}" /></div></td>
     <td> <div class="TYPE"> <c:out value="${greeting.type}" /></div></td>
     
     <c:forEach items="${greeting.address}" var="address" >
      <td> <div class="ADDRESS"> <c:out value="${address.address_id}" /></div></td>
      <td> <div class="ADDRESS"> <c:out value="${address.houseNo}" /></div></td>
    
    </c:forEach>
   
    
    <tr>
    </table>
    </c:forEach>
 