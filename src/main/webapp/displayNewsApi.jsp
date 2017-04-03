<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 4/1/17
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h3><c:out value="${noRecordsFoundMessage}" /></h3>

<div>
    <h2>Cnn Headlines</h2>
    <ul>
    <c:forEach items="${CNNNewsResult}" var="CNNnews">
        <li>
        ${CNNnews.getPublishedAt()}
        ${CNNnews.getAuthor()}
        ${CNNnews.getUrlToImage()}
        ${CNNnews.getDescription()}
        ${CNNnews.getTitle()}
        ${CNNnews.getUrl()}
        </li>
    </c:forEach>
    </ul>
</div>

<div>
    <h2>WSJ Headlines</h2>
    <ul>
    <c:forEach items="${WSJNewsResult}" var="WSJnews">
    <li>
        ${WSJnews.getPublishedAt()}
        ${WSJnews.getAuthor()}
        ${WSJnews.getUrlToImage()}
        ${WSJnews.getDescription()}
        ${WSJnews.getTitle()}
        ${WSJnews.getUrl()}
    </li>
    </c:forEach>
    </ul>
</div>

<div>
    <h2>Fox Sports Headlines</h2>
    <ul>
        <c:forEach items="${SportsNewsResult}" var="SportsNews">
            <li>
                    ${SportsNews.getPublishedAt()}
                    ${SportsNews.getAuthor()}
                    ${SportsNews.getUrlToImage()}
                    ${SportsNews.getDescription()}
                    ${SportsNews.getTitle()}
                    ${SportsNews.getUrl()}
            </li>
        </c:forEach>
    </ul>
</div>

