<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/1/17
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<c:import url="include-headtag.jsp" />
</head>

<h3><c:out value="${noRecordsFoundMessage}" /></h3>
<div>

    <div role="navigation">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#CNN" aria-controls="CNN" role="tab" data-toggle="tab">CNN</a></li>
        <li role="presentation"><a href="#WallStreetJournal" aria-controls="WallStreetJournal" role="tab" data-toggle="tab">Wall Street Journal</a></li>
        <li role="presentation"><a href="#FoxSports" aria-controls="FoxSports" role="tab" data-toggle="tab">Fox Sports</a></li>
    </ul>

    <!-- Tab panes -->
        <div class="tab-content">

            <div role="tabpanel" class="tab-pane active" id="CNN">
                <h3>Cnn Headlines</h3>
                <c:forEach items="${CNNNewsResult}" var="CNNnews">
                    <p>
                        <img class="newsImage" src="${CNNnews.getUrlToImage()}" style="height:10%;width:10%;"/>
                        <a href="${CNNnews.getUrl()}" target="_blank">${CNNnews.getTitle()}</a>
                        <br />
                        ${CNNnews.getDescription()}
                        <hr />
                    </p>
                </c:forEach>
            </div>

            <div role="tabpanel" class="tab-pane" id="WallStreetJournal">
                <h3>Wall Street Journal</h3>
                <c:forEach items="${WSJNewsResult}" var="WSJnews">
                    <p>
                        <img class="newsImage" src="${WSJnews.getUrlToImage()}" style="height:10%;width:10%;"/>
                        <a href="${WSJnews.getUrl()}" target="_blank">${WSJnews.getTitle()}</a>
                        <br />
                        ${WSJnews.getDescription()}
                        <hr />
                    </p>
                </c:forEach>
            </div>

            <div role="tabpanel" class="tab-pane" id="FoxSports">
                <h3>Fox Sports Headlines</h3>
                <c:forEach items="${SportsNewsResult}" var="SportsNews">
                    <p>
                        <img class="newsImage" src="${SportsNews.getUrlToImage()}" style="height:10%;width:10%;"/>
                        <a href="${SportsNews.getUrl()}" target="_blank">${SportsNews.getTitle()}</a>
                        <br />
                        ${SportsNews.getDescription()}
                        <hr />
                    </p>
                </c:forEach>
            </div>

        </div>
    </div>
</div>