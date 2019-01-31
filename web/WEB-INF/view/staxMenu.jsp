<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Меню</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.servletContext.contextPath}/css/boot.css">

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="locale" var="loc"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>
    <fmt:message bundle="${loc}" key="local.locfoto" var="tabphoto"/>
    <fmt:message bundle="${loc}" key="local.locname" var="tabname"/>
    <fmt:message bundle="${loc}" key="local.locdecription" var="tabdescr"/>
    <fmt:message bundle="${loc}" key="local.locportion" var="tabportion"/>
    <fmt:message bundle="${loc}" key="local.locprice" var="tabprice"/>
    <fmt:message bundle="${loc}" key="local.locweight" var="tabweight"/>
    <fmt:message bundle="${loc}" key="local.loccurrency" var="tabcurrency"/>
</head>
<body>
<div style="width: 1000px; margin: 0 auto;">
    <div>
        <h1 align="center">Меню.</h1>
        <h3>Холодные закуски</h3>
    </div>
    <hr>
    <div style="width: 20%; float: left; text-align: center">
        <c:if test="${category=='coldsnack'}">
            <h4 class="text-muted">ХОЛОДНЫЕ ЗАКУСКИ</h4>
        </c:if>
        <c:if test="${category!='coldsnack'}">
            <h4><strong>
                <form action="/EpamThirdTask/Stax" method="post">
                    <input type="hidden" name="command" value="STAXLIST"/>
                    <input type="hidden" name="category" value="coldsnack"/>
                    <button style="
    background: white;
    font-size: 100%;
    font-family: inherit;
    border: 0;
    padding: 0;">
                        ХОЛОДНЫЕ ЗАКУСКИ
                    </button>
                </form>
            </strong>
            </h4>
        </c:if>
        <c:if test="${category=='warmsnack'}">
            <h4 class="text-muted">ГОРЯЧИЕ ЗАКУСКИ</h4>
        </c:if>
        <c:if test="${category!='warmsnack'}">
            <h4><strong>
                <form action="/EpamThirdTask/Stax" method="post">
                    <input type="hidden" name="command" value="STAXLIST"/>
                    <input type="hidden" name="category" value="warmsnack"/>
                    <button style="
    background: white;
    font-size: 100%;
    font-family: inherit;
    border: 0;
    padding: 0;">
                        ГОРЯЧИЕ ЗАКУСКИ
                    </button>
                </form>
            </strong></h4>
        </c:if>
        <c:if test="${category=='breakfast'}">
            <h4 class="text-muted">ЗАВТРАКИ</h4>
        </c:if>
        <c:if test="${category!='breakfast'}">
            <h4><strong>
                <form action="/EpamThirdTask/Stax" method="post">
                    <input type="hidden" name="command" value="STAXLIST"/>
                    <input type="hidden" name="category" value="breakfast"/>
                    <button style="
    background: white;
    font-size: 100%;
    font-family: inherit;
    border: 0;
    padding: 0;">
                        ЗАВТРАКИ
                    </button>
                </form>
            </strong></h4>
        </c:if>
        <h4><strong>САЛАТЫ</strong></h4>
        <h4><strong>СУПЫ</strong></h4>
        <h4><strong>РЫБНЫЕ БЛЮДА</strong></h4>
        <h4><strong>МЯСНЫЕ БЛЮДА</strong></h4>
        <h4><strong>ГАРНИРЫ</strong></h4>
        <h4><strong>БЛЮДА НА МАНГАЛЕ</strong></h4>
        <h4><strong>ОТ ШЕФ-ПОВАРА</strong></h4>
        <h4><strong>ПРИЛОЖЕНИЕ</strong></h4>
        <h4><strong>ДЕСЕРТ</strong></h4>
        <hr>
    </div>
    <div style="width: 75%; float: right; ">
        <div class="wrapper" style="padding-top: 5px;">
            <div class="table">
                <table>
                    <thead>
                    <tr>
                        <th style="width: 60px"><c:out value="${tabphoto}"/></th>
                        <th style="width: 80px"><c:out value="${tabname}"/></th>
                        <th style="width: 300px"><c:out value="${tabdescr}"/></th>
                        <th style="width: 80px"><c:out value="${tabportion}"/><br>(<c:out value="${tabweight}"/>)</th>
                        <th style="width: 60px"><c:out value="${tabprice}"/><br>(<c:out value="${tabcurrency}"/>)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="food" items="${Foods}">
                        <tr>
                            <td><i class="glyphicon-search icon-camera"></i></td>
                            <td><c:out value="${food.name}"/></td>
                            <td>
                                <small>
                                    <c:forEach var="ingredient" items="${food.mainIngredients}">
                                        <c:out value="${ingredient}"/>,
                                    </c:forEach>
                                    <c:set value="${food.choosingIngrName}" var="select"/>
                                    <c:if test="${select!=null}">
                                        (на выбор:
                                        <c:forEach var="choosing" items="${food.choosingIngrName}">
                                            <c:out value="${choosing}"/>,

                                        </c:forEach>
                                        )
                                    </c:if>
                                    <ol>
                                        <c:forEach var="additonl" items="${food.addIngrName}">
                                            <li>
                                                <c:out value="${additonl}"/>
                                            </li>
                                        </c:forEach>
                                    </ol>
                                </small>
                            </td>
                            <td><c:out value="${food.portion}"/></td>
                            <td style="text-align: center">
                                <c:if test="${food.price!=0.0}">
                                    <c:out value="${food.price}"/>
                                </c:if>
                                <ol>
                                    <c:forEach var="addIngrPrice" items="${food.addIngrValue}">
                                        <li>
                                            <c:if test="${addIngrPrice!=0.0}">
                                                <c:out value="${addIngrPrice}"/>
                                            </c:if>
                                        </li>
                                    </c:forEach>
                                </ol>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <form method="post">
                <input type="hidden" name="command" value="NEXTSTAXLIST"/>
                <input type="hidden" name="category" value="${requestScope.category}"/>
                <button class="btn btn-inverse" onclick="location.href='/EpamThirdTask/Stax'">Далее</button>
            </form>
            <div style="float: right">
                <button class="btn btn-inverse" onclick="location.href='/EpamThirdTask'">
                    На главную
                </button>
            </div>
            <div style=" position: absolute; right: 0;top: 0;">
                <form method="post">
                    <input type="hidden" name="command" value="CHANGELOCALE"/>
                    <input type="hidden" name="local" value="en"/>
                    <input type="hidden" name="category" value="${requestScope.category}"/>
                    <button class="btn btn-inverse" onclick="location.href='/EpamThirdTask/Stax'">
                        <c:out value="${en_button}"/>
                    </button>
                </form>
                <form method="post">
                    <input type="hidden" name="command" value="CHANGELOCALE"/>
                    <input type="hidden" name="local" value="ru"/>
                    <input type="hidden" name="category" value="${requestScope.category}"/>
                    <button class="btn btn-inverse" onclick="location.href='/EpamThirdTask/Stax'">
                        <c:out value="${ru_button}"/>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
