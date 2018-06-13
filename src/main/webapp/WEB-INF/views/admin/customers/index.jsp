<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Customers</h1>
</div>

<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/customers/add" class="btn btn-default btn-xs">
            <span class="glyphicon glyphicon-plus"></span>
        </a>
    </p>
</div>

<table class="table table-hover table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Added Date</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${course.createdDate}</td>
            <td>
                <c:choose>
                    <c:when test="${course.status}">
                        <label class="label label-success">Active</label>
                    </c:when>
                    <c:otherwise>
                        <label class="label label-danger">Inctive</label>
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${SITE_URL}/admin/customers/edit/${customer.id}" class="btn btn-default btn-xs">
                    <span class="glyphicon glyphicon-pencil"></span>
                </a>
                <a href="${SITE_URL}/admin/customers/delete/${customer.id}" class="btn btn-default btn-xs">
                    <span class="glyphicon glyphicon-trash"></span>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="../shared/footer.jsp" %>