<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.cms.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/inc.js"></script>
<script type="text/javascript">
	$(function(){
		$(".isNewPic").click(function(){
			//dwrService.updateIndexPic($(this).val());
			var url = $("#ctx").val() + "/admin/pic/updateIndexPic";
			$.post(url, {'pid':$(this).val()}, function(data){
				if(data.result == 1)
					console.log('success');
			});
		});
	});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<input type="hidden" id="ctx" value=<%=request.getContextPath()%>/>
	<table width="800" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td width="180">缩略图</td>
			<td width="500">文章标题</td>
			<td>首页新闻</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${datas.datas }" var="pic">
			<tr>
				<td><img src='<%=request.getContextPath()%>/resources/upload/thumbnail/${pic.newName}'/></td>
				<td>${pic.topic.title }</td>
				<td>
					<input type="checkbox" class="isNewPic" value="${pic.id }" <c:if test="${pic.isIndexPic eq 1 }">checked="checked"</c:if>/>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="3" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${datas.total }" name="totalRecord"/>
				<jsp:param value="newPics" name="url"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
</div>
</body>
</html>