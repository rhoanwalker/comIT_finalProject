<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

	<div class="container">
	
	<!-- Table list of users -->
	<div>
		
		<table class="table table-sm table-hover">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">Firstname</th>
		      <th scope="col">Lastname</th>
		      <th scope="col">Gender</th>
		      <th scope="col">Start Date</th>
		      <th scope="col">Email</th>
		      <th scope="col">Telephone</th>
		      <th scope="col"></th>
		    </tr>
		  </thead>
		  <c:forEach items="${members}" var="member">
		  <tbody>
		    <tr>
		      	<td><c:out value="${member.firstname}"/></td>
		      	<td><c:out value="${member.lastname}"/></td>
		      	<td><c:out value="${member.gender}"/></td>
		      	<td><c:out value="${member.memberStartDate}"/></td>
		      	<td><c:out value="${member.memberEmail}"/></td>
		      	<td><c:out value="${member.memberPhoneNo}"/></td>
		      	<td>
		      		<form action="/updateregistration.do" method="get">
		      			<input id="memberid" name="memberid" type="hidden" value="${member.memberID}">
		      			<button type="submit" class="btn btn-link">Update</button>
		      		</form>
		      	</td>
		    </tr>		    
		  </tbody>
		  </c:forEach>
		</table>
	</div>
	
	<!-- button link to add/register a member -->
	<div>
		<button type="button" class="btn btn-link" data-toggle="modal" data-target="#registrationModal">Register Member</button>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="registrationModalTitle">Complete Member Registration Form</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
			<!-- Registration Form -->	       
			<form action="/registration.do" method="post">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="firstname">Firstname</label>
				    <input type="text" class="form-control" id="inputFirstname" name="firstname" required autofocus>
					</div>
					<div class="form-group col-md-6">
						<label for="inputlastname">Lastname</label>
				    <input type="text" class="form-control" id="inpputLastname" name="lastname" required>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
					    <label for="inputDOB">Date of Birth</label>
					    <input type="date" class="form-control" id="inputDOB" name="dob" required>
					</div>
				  <div class="form-group col-md-4">
				    <label for="inputGender">Gender</label>
				    <select id="inputGender" name="gender" class="form-control" required>
				      <option value="">...</option>
				      <option value="Male">Male</option>
				      <option value="Female">Female</option>
				    </select>
				  </div>
				</div>
				<div class="form-group">
				    <label for="inputEmail">Email</label>
				    <input type="email" class="form-control" id="inputEmail" name="email" required>
				</div>
				<div class="form-row">
				  <div class="form-group col-md-6">
				    <label for="inputPhoneNo">Telephone</label>
				    <input type="text" class="form-control" id="inputPhoneNo" name="phoneNo">
				  </div>
				  <div class="form-group col-md-6">
				    <label for="inputStartDate">Start Date</label>
				    <input type="date" class="form-control" id="inputStartDate" name="startDate" value="${currDate }">
				  </div>
				</div>
				<div class="form-group">
				  <label for="inputAddress1">Address</label>
				  <input type="text" class="form-control" id="inputAddress1" name="address1">
				</div>
				<div class="form-group">
				  <label for="inputAddress2">Address 2</label>
				  <input type="text" class="form-control" id="inputAddress2" name="address2">
				</div>
				<div class="form-row">
				  <div class="form-group col-md-5">
				    <label for="inputProvince">Province</label>
				    <select id="inputProvince" name="province" class="form-control">
				      <option value="">...</option>
				      <option value="Ontario">Ontario</option>
				      <option value="Manitoba">Manitoba</option>
				      <option value="Montreal">Montreal</option>
				    </select>
				  </div>
				  <div class="form-group col-md-4">
				    <label for="inputCity">City</label>
				    <select id="inputCity" name="city" class="form-control">
				      <option value="">...</option>
				      <option value="Selkirk">Selkirk</option>
				      <option value="Thompson">Thompson</option>
				      <option value="Winnipeg">Winnipeg</option>
				    </select>
				  </div>
				  <div class="form-group col-md-3">
				    <label for="postalCode">Postal Code</label>
				    <input type="text" class="form-control" id="postalCode">
				  </div>
				</div>
				<button type="submit" class="btn btn-primary float-right">Register</button>
			</form>

	      </div>
	    </div>
	  </div>
	</div>		
		
	</div>

<%@ include file="../common/footer.jspf"%>