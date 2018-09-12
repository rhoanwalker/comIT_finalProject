<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

	<div class="container">
	
		<c:if test="${empty taxReceipt.memberFName }">
			<div class="alert alert-warning mt-3" role="alert">
	 			You currently have no record of donation for the tax year selected!
			</div>
		</c:if>
		<div>
		<h2>OFFICIAL RECEIPT FOR INCOME TAX PURPOSES </h2>
		</div><hr />
		<div>
			<p>
				<b>Date Issued:</b> ${currDate } <br />
				<b>Serial No. A:</b> 
			</p>
		</div><hr />
		<form>
			<div class="form-row">
				<h4>THIS IS TO CERTIFY THAT WE HAVE RECEIVED FROM:</h4>
				<div class="form-group col-md-6">
					<label for="inputName" class="col-sm-2 col-form-label">NAME</label>
			    	<input type="text" class="form-control" id="inputName" value="${taxReceipt.memberFName } ${ taxReceipt.memberLName}" readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="inputAmount" class="col-sm-2 col-form-label">AMOUNT</label>
			    	<input type="text" class="form-control" id="inputAmount" value="${taxReceipt.amount }" readonly>
				</div>
				<div class="form-group col-md-2">
					<label for="inputYear" class="col-form-label">DURING THE YEAR</label>
			    	<input type="text" class="form-control" id="inputYear" value="${taxReceipt.taxYear }" readonly>
				</div>
			</div>
		</form>
		<hr />
		<div>
			<p>
				<b>ISSUED BY:</b> <i>Church of God in Christ Jesus (Apostolic), Winnipeg.</i>
			</p>
			<p>
				<b>REGISTRATION NO.</b>
			</p>
		</div>
		
	</div>

<%@ include file="../common/footer.jspf"%>