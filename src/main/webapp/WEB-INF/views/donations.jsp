<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

	<div class="container">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">Add Member Donation</h1>
			<hr />
		</div>
		<c:if test="${not empty successMsg}">
			<div class="alert alert-success mx-auto col-sm-7" role="alert">
  				${successMsg}
			</div>
		</c:if>
		<div class="row mt-3">
			<div class="mx-auto col-sm-7">
				<form action="/donations" method="post">
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputDonorId">Member</label>
						    <select id="inputDonorId" name="donorId" class="form-control" required>
						        <option value="">...</option>
						      	<c:forEach items="${donors}" var="donor">
						      		<option value="${donor.memberID }">${donor.firstname } ${donor.lastname }</option>
						      	</c:forEach>
							</select>
						</div>
					    <div class="form-group col-md-4">
						    <label for="inputDonationType">Type</label>
						    <select id="inputDonationType" name="donationType" class="form-control" required>
						      <option value="">...</option>
						      <option value="Charity">Charity</option>
						      <option value="Offering">Offering</option>
						      <option value="Spec. Offering">Special Offering</option>
						      <option value="Tithes">Tithes</option>
						    </select>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
					      <label for="inputDate">Date</label>
					      <input type="date" class="form-control" id="inputDate" name="donationDate" value="${currDate }" required>
					    </div>
					    <div class="form-group col-md-6">
					    	<label for="inputAmount">Amount</label>
					    	<input type="number" step="1" min="0" class="form-control" id="inputAmount" name="donationAmount" required>
					    </div>
					</div>
					<button type="submit" class="btn btn-primary">Add</button>	
				</form>
			</div>
		</div>
		
		
	</div>

<%@ include file="../common/footer.jspf"%>