<html ng-app="techpedia">
<body ng-controller="TestController" ng-init="InitLoad()">
	<input type="file" ng-file="file" base-sixty-four-input> Data:
	{{file}} {{file.fileName}} {{file.fileType}} {{file.base64}}

	<%@ page session="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<form action="<c:url value="/signin/facebook" />" method="POST">
		<button type="submit">Sign in with Facebook</button>
	</form>
</body>
<jsp:include page="template/footer.jsp" />