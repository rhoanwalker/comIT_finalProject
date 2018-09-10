<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

	<div class="container">
		
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">Update Member Registration Form</h1>
		</div>
		<div class="row mt-3">
			<div class="mx-auto col-sm-7">
				<form action="/updateregistration.do" method="post">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="firstname">Firstname</label>
					    <input type="text" class="form-control" id="inputFirstname" name="firstname" value="${member.firstname }" required autofocus>
						</div>
						<div class="form-group col-md-6">
							<label for="inputlastname">Lastname</label>
					    <input type="text" class="form-control" id="inpputLastname" name="lastname" value="${member.lastname }" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
						    <label for="inputDOB">Date of Birth</label>
						    <input type="date" class="form-control" id="inputDOB" name="dob" value="${member.dob }" required>
						</div>
					  <div class="form-group col-md-4">
					    <label for="inputGender">Gender</label>
					    <select id="inputGender" name="gender" class="form-control" required>
					      <option value="${member.gender }">${member.gender }</option>
					      <option value="Male">Male</option>
					      <option value="Female">Female</option>
					    </select>
					  </div>
					</div>
					<div class="form-group">
					    <label for="inputEmail">Email</label>
					    <input type="email" class="form-control" id="inputEmail" name="email" value="${member.memberEmail }" required>
					</div>
					<div class="form-row">
					  <div class="form-group col-md-6">
					    <label for="inputPhoneNo">Telephone</label>
					    <input type="text" class="form-control" id="inputPhoneNo" name="phoneNo" value="${member.memberPhoneNo }">
					  </div>
					  <div class="form-group col-md-6">
					    <label for="inputStartDate">Start Date</label>
					    <input type="date" class="form-control" id="inputStartDate" name="startDate" value="${member.memberStartDate }">
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
					  <div class="form-group col-md-6">
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
					  <div class="form-group col-md-2">
					    <label for="postalCode">Postal Code</label>
					    <input type="text" class="form-control" id="postalCode">
					  </div>
					</div>
					<input id="memberid" name="memberid" type="hidden" value="${member.memberID }">
					<button type="submit" class="btn btn-primary">Update</button>
				</form>
			</div>
		</div>



	</div>

<%@ include file="../common/footer.jspf"%>