<%@ include file="../common/header.jspf" %>

	<div class="container">	
		<div class="mx-auto col-sm-6">
	<form class="form-signin" action="/login.do" method="post">
		<div class="text-center mb-4">
			<img class="mb-4" src="../../images/church_logo.jpg" width="80" height="80">
			<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		</div>
		<div class="form-label-group">
       		<input type="email" id="inputEmail" class="form-control" placeholder="Email address" 
       			name="username" required autofocus>
     		</div>
     		<div class="form-label-group">
	        <input type="password" id="inputPassword" class="form-control" placeholder="Password"
	        	name="password" required>
	    </div>
	    <div class="checkbox mb-3">
	        <label>
	          <input type="checkbox" value="remember-me"> Remember me
	        </label>
	    </div>
	    <button class="btn btn-lg btn-primary btn-link" type="submit">Sign in</button>
	    <a class="btn btn-primary" href="/home" role="button">Cancel</a>
		<c:if test="${not empty errMsg}">
			<div class="alert alert-danger mt-3" role="alert">
	 				${errMsg}
			</div>
		</c:if>
	</form>
	</div>
	</div>
		
<%@ include file="../common/footer.jspf" %>