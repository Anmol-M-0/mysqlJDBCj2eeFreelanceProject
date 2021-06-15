<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<style type="text/css">
html { background:radial-gradient(#238dbb, #114476); height:100%; text-align:center; font-family:Helvetica; font-size:3em; color:#134c7e; }

input.set { display:none; }

#slide1:checked ~ .mask .overflow { margin-left:0; }
#slide2:checked ~ .mask .overflow { margin-left:-100%; }
#slide3:checked ~ .mask .overflow { margin-left:-200%; }
#slide4:checked ~ .mask .overflow { margin-left:-300%; }

#slides { margin:50px auto; width:80%; position:relative; }

#slides .mask { width:90%; overflow:hidden; margin:auto; }

#slides .overflow { width:400%; -webkit-transform:translateZ(0); -webkit-transition:all 0.5s ease-out; -moz-transition:all 0.5s ease-out; -o-transition:all 0.5s ease-out; transition:all 0.5s ease-out; }

#slides .slide { width:25%; height:200px; line-height:200px; float:left; background:#fff; }

#controls { width:100%; }

#controls label { display:none; width:5%; height:60px; opacity:0.3; position:absolute; top:50%; margin-top:-30px; cursor:pointer; background:#000; }

#controls label:hover { opacity:0.8; }

#slide1:checked ~ #controls label:nth-child(2), #slide2:checked ~ #controls label:nth-child(3), #slide3:checked ~ #controls label:nth-child(4) { right:0; display:block; }

#slide2:checked ~ #controls label:nth-child(1), #slide3:checked ~ #controls label:nth-child(2), #slide4:checked ~ #controls label:nth-child(3) { left:0; display:block; }
</style>

</head>
<body>



<div id="slides">
  <input checked type="radio" name="slider" id="slide1" class="set" />
  <input type="radio" name="slider" id="slide2" class="set" />
  <input type="radio" name="slider" id="slide3" class="set" />
  <input type="radio" name="slider" id="slide4" class="set" />  
		  
  <div class="mask">    
    <div class="overflow">
      
      <div class="slide">1</div>
      <div class="slide">2</div>
      <div class="slide">3</div>
      <div class="slide">4</div>
      
    </div>    
  </div>

  <div id="controls" onclick="">  
    <label for="slide1"></label>
    <label for="slide2"></label>
    <label for="slide3"></label>
    <label for="slide4"></label>    
  </div>
</div>


		
			<c:forEach var="student" items="${students}">
					<h2>
						<c:out value="${student.id}" />
					</h2>
					<h3>
						<c:out value="${student.name}" />
					</h3>
					<input class='hide' type="radio" id="uno" name="tractor" /> <img
						src="data:image/jpg;base64,${student.base64Image}" width="240"
						height="300" />
			</c:forEach>
	
</body>
</html>