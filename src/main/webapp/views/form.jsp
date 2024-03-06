<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Feedback</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container text-center">
    <h1>${headingText}</h1>
</div>


<div class="container center-pill">

    <form action="/addFeedback" method="post" enctype="multipart/form-data">

        <div class="mb-3">
            <label for="fullName" class="form-label">fullName</label>
            <input type="text" class="form-control" id="fullName" required name="fullName" minlength="3">
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">email</label>
            <input type="email" class="form-control" id="email" required name="email" minlength="2">
        </div>

        <div class="mb-3">
            <label for="phoneNumber" class="form-label">phoneNumber</label>
            <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" required maxlength="10">
        </div>
        <div class="mb-3">
        <label for="gender" class="form-label">Gender</label>
        <select class="form-select" id="gender" aria-label="Default select example" name="gender" required>
            <option selected>Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="others">Others</option>
        </select>
        </div>

        <div class="mb-3">
            <label for="state" class="form-label">state</label>
            <input type="text" class="form-control" id="state" name="state" required>
        </div>

        <div class="mb-3">
            <label for="city" class="form-label">city</label>
            <input type="text" class="form-control" id="city" name="city" required>
        </div>

        <div class="mb-3">
            <label for="pinCode" class="form-label">pinCode</label>
            <input type="number" class="form-control" id="pinCode" name="pinCode" required maxlength="6">
        </div>

        <div class="mb-3">
            <label for="message" class="form-label">Feedback message</label>
            <textarea class="form-control" id="message" rows="3" name="message" required></textarea>
        </div>

        <div class="mb-3">
            <label for="file" class="form-label">Select file</label>
            <input class="form-control" type="file" id="file" name="file" accept=".pdf,.jpeg,.jpg,.png">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>