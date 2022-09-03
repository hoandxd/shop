<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="org.coolstyles.model.*"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="./public/admin/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <%@include file="../inc/navbar.jsp" %>
        <div id="layoutSidenav">
            <%@include file="../inc/navsidebar.jsp" %>            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Orders Details</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">List Order Details</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Quantity</th>
                                            <th>Product Id</th>
                                            <th>Order Id</th>
                                            <th>#</th>
                                            <th>#</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Quantity</th>
                                            <th>Product Id</th>
                                            <th>Order Id</th>
                                            <th>#</th>
                                            <th>#</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                                                                <c:set var="index" value="1"></c:set>

                                        <c:forEach items="${orderDetailList}" var="orderDetail">
                                            <tr>
                                                <td>${index}</td>
                                                <td>
                                                    <% OrderDetail orderDetail = (OrderDetail)pageContext.getAttribute("orderDetail"); %>                                                    
                                                    <%= orderDetail.getOrderId() %>
                                                </td>
                                                <td>
                                                    <a href='ProductDetailServlet?productId=<%= Product.find(orderDetail.getProductId()).getId() %>' target="_blank">
                                                        <%= Product.find(orderDetail.getProductId()).getName() %>
                                                    </a>
                                                </td>
                                                <td>
                                                    ${orderDetail.quantity}
                                                </td>
                                                <td>
                                                    <a href="EditOrderDetailServlet?orderDetailId=${orderDetail.id}">Edit</a>
                                                </td>
                                                <td>
                                                    <a href="DeleteOrderDetailServlet?orderDetailId=${orderDetail.id}">Delete</a>
                                                </td>
                                            </tr>                                            <c:set var="index" value="${index + 1}"></c:set>

                                        </c:forEach>
                                            
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./public/admin/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="./public/admin/assets/demo/chart-area-demo.js"></script>
        <script src="./public/admin/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="./public/admin/js/datatables-simple-demo.js"></script>
    </body>
</html>
