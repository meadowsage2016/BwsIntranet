<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<c:import url="include-headtag.jsp" />

<body>

<%@ include file="include-navigation.jsp" %>

<div class="jumbotron">
    <div class="container text-center">
        <h1>My Portfolio</h1>
        <p>Some text that represents "Me"...</p>
    </div>
</div>

<div class="container-fluid bg-3 text-center">
    <h3>Some of my Work</h3><br>
    <div class="row">
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
    </div>
</div>
<br>

<div class="container-fluid bg-3 text-center">
    <div class="row">
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-3">
            <p>Some text..</p>
            <img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
        </div>
    </div>
</div>
<br><br>

<%@ include file="include-footer.jsp" %>

</body>
</html>
