<%--
  Created by IntelliJ IDEA.
  User: wangzhijun
  Date: 2020/3/30
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css"/>
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/easyui/jquery.datagrid.js"></script>
</head>
<body>
<table class="dv-table" border="0" style="width: 100%">
    <tr>
        <td rowspan="3" style="width: 60px">
            <img src="${book.cover}"/>
        </td>
        <td class="dv-label">ID:</td>
        <td>${book.id}</td>
        <td class="dv-label">书名:</td>
        <td>${book.name}</td>
    </tr>
    <tr>
        <td class="dv-label">价格</td>
        <td>${book.price}</td>
        <td class="dv-label">作者</td>
        <td>${book.author}</td>
    </tr>
    <tr>
        <td class="dv-label">简介</td>
        <td colspan="3">${book.summary}</td>
    </tr>
</table>
</body>
</html>
