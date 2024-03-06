<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <!-- Include jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <!-- Include Toastr.js -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</head>

<body>

<div class="container text-center">
    <h1>Home Feedbacks</h1>
</div>
<div class="container text-center">
    <a href="http://localhost:8080/form" > <button class="btn btn-primary">New Form</button> </a>
</div>

<c:if test ="${not empty dataStatus}">
    <script>
        toastr.info("${dataStatus}");
    </script>
</c:if>


<div class="container text-center">

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th scope="col">Email</th>
            <th scope="col">PhoneNO</th>
            <th scope="col">Gender</th>
            <th scope="col">State</th>
            <th scope="col">City</th>
            <th scope="col">PinCode</th>
            <th scope="col">message</th>
            <th scope="col">File</th>
            <th scope="col">Action</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.id}</td>
                <td>${item.fullName}</td>
                <td>${item.email}</td>
                <td>${item.phoneNumber}</td>
                <td>${item.gender}</td>
                <td>${item.state}</td>
                <td>${item.city}</td>
                <td>${item.pinCode}</td>
                <td>${item.message}</td>
                <td>
                    <a href="/download/${item.filePath}" >
                        <button type="button" class="btn btn-primary">Download</button>
                    </a>
                </td>
                <td>
                    <form method="post" action="/delete/${item.id}" >
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
                <td>
                    <form method="get" action="/update/${item.id}" >
                        <button type="submit" class="btn btn-warning">Update</button>
                    </form>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>