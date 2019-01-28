<%--
  Created by IntelliJ IDEA.
  User: Ehor Halavin
  Date: 18.01.2019
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EpamThirdTask</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<h1 class="w3-container w3-blue-grey w3-opacity w3-right-align">
    EPAM Third Task
</h1>

<div class="w3-container w3-center">

    <div class="w3-bar w3-padding-large w3-padding-24">
        <form method="post" action="/EpamThirdTask/Sax">
            <input type="hidden" name="category" value="coldsnack"/>
            <input type="hidden" name="command" value="SAXLIST">
            <button class="w3-btn w3-hover-light-blue w3-round-large">
                SAX
            </button>
        </form>
        <form method="post" action="/EpamThirdTask/Stax">
            <input type="hidden" name="category" value="coldsnack"/>
            <input type="hidden" name="command" value="STAXLIST">
            <button class="w3-btn w3-hover-light-blue w3-round-large">
                STAX
            </button>
        </form>
        <form method="post" action="/EpamThirdTask/Dom">
            <input type="hidden" name="category" value="coldsnack"/>
            <input type="hidden" name="command" value="DOMLIST">
            <button class="w3-btn w3-hover-light-blue w3-round-large">
                DOM
            </button>
        </form>
    </div>
</div>

</body>
</html>
