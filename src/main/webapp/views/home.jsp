<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <style>
        /* Add custom styles for the toast message */
        .toast-container {
            position: fixed;
            top: 1rem;
            right: 1rem;
            z-index: 1000;
        }
    </style>


</head>
<body>

<div class="container text-center">
    <h1>Home Feedbacks</h1>

</div>

<c:if test="${not empty dataStatus}">
    <div class="toast-container">
        <div id="toastMessage" class="toast align-items-center text-white bg-success border-0" role="alert"
             aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body">
                        ${dataStatus}
                </div>
                <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
    </div>
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

<!-- Bootstrap JavaScript and jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<script>
    // Show the toast message
    var toast = new bootstrap.Toast(document.getElementById('toastMessage'));
    toast.show();

    // Hide the toast message after 3 seconds
    setTimeout(function () {
        toast.hide();
    }, 3000); // 3 seconds
</script>


</body>
</html>