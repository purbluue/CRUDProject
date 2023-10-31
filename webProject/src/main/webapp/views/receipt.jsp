<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Bootstrap Example</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>

	<div class="container mt-3">
		<h2>공황장애 극복 프로젝트</h2>
		<p>불만 사항을 입력해 주세요.</p>
		<form action="receipt.do" method="post">
			<div class="mb-3 mt-3">
				<label for="comment">Comments:</label>
				<textarea class="form-control" rows="5" id="comment" name="receipt"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">접수하기</button>
		</form>
	</div>

<script>
 var message = "${receiptResult}";
 if(message!="") alert(message);
</script>
</body>

</html>