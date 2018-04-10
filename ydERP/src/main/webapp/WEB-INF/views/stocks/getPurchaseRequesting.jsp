<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>구매전체조회</title>
<link rel="stylesheet" type="text/css" media="screen" 
	href="${pageContext.request.contextPath}/resources/jqgrid5/ui.jqgrid-bootstrap.css" />
<script src="./scripts/jquery-3.3.1.min.js"></script>
<script src="./scripts/json.min.js"></script>

<script type="text/javascript">
	
	$(function() {
		requestPurchaseList();
		insertRequestPurchase();
	});

	function insertRequestPurchase() {
		$("#btn1").click(function() {
			var params = [];

			$.ajax({
				url : "./insertPurchaseRequest",
				type : "PUT",
				dataType : "json",
				data : JSON.stringify(params),
				contentType : "application/json;charset=utf-8",
				success : function() {
					console.log("complete")
					//requestTempList;
					requestPurchaseList();
				}
			});
		})
	}

	function requestPurchaseList() {
		$.ajax({
			url : "getPurchaseRequestTempListData",
			type : "GET",
			dataType : "json",
			contentType : "application/json;charset=utf-8",
			success : requestPurchaseListResult
		})
	}
	function requestPurchaseListResult(datas) {
		$("tbody").empty();
		$.each(datas.data, function(idx, item) {
			$("<tr>").append($("<td>").html(item.tmpDetailCode))
					 .append($("<td>").html(item.tmpMasterCode))
					 .append($("<td>").html(item.tmpPurchaseQty))
					 .append($("<td>").html(item.tmpPurchasePrice))
					 .append($("<td>").html(item.tmpItemTax))
					 .append($("<td>").html(item.itemCode))
					 .append($("<td>").html(item.itemName))
					 //.append($("<td>").html("<button id=\'btnSelect\' >조회</button>"))
					 //.append($("<td>").html("<button id=\'btnDelete\' >삭제</button>"))
					 //.append($("<input type=\"hidden\" id=\'hidden_id\' />").val(item.seq))
					 .appendTo("tbody");
		});
	}

</script>
</head>
<body>
	<form name="frm" action="createPurchaseRequest">
		<input type="button" value="주문요청승인" id="btn1" />
		<div class="col-lg-12">
			<table id="list" border="1">
				<thead><tr>
					<th>주문상세코드</th>
					<th>주문코드</th>
					<th>주문수량</th>
					<th>주문단가</th>
					<th>부가세</th>
					<th>품목코드</th>
					<th>폼목명</th>
				</tr></thead>
				<tbody></tbody>
			</table>
			<div id="pager"></div>
		</div>
	</form>
</body>
</html>