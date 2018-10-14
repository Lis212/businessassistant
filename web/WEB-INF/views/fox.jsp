<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fox Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>

<script>
    var service = 'http://localhost:8080/fox';
    var RestGet = function (id) {
        $.ajax({
            type: 'GET',
            url: service + '/get/' + id,
            dataType: 'json',
            accept: 'json',
            contentType: 'application/json;utf-8',
            async: false,
            success: function (result) {
                $('#response').html(JSON.stringify(result.name)),
                $('#description').html(JSON.stringify(result.description))
            },
            error: function (jqXHR, testStatus, errorThrown) {
                $('#response').html(JSON.stringify(jqXHR))
            }
        });
    };
</script>

<body>

<h1>Fox's info</h1>

<table class="table">
    <tr>
        <th>Request type</th>
        <th>URL</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Get fox by id <code><strong>GET</strong></code></td>
        <td>/fox/get/{id}</td>
        <td>
            id: <input id="getCatID" value="">
            <button type="button" onclick="RestGet($('#getCatID').val())">Get fox info</button>
        </td>
    </tr>
</table>

<div class="panel panel-default">
    <div class="panel-heading">Fox INFO</div>
    <div class="panel-body">
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
            </tr>
            <tr>
                <td>
                    <div class="panel panel-default">
                        <div class="panel-body" id="response"></div>
                    </div>
                </td>
                <td>
                    <div class="panel panel-default">
                        <div class="panel-body" id="description"></div>
                    </div>
                </td>
            </tr>
        </table>
    </div>
</div>
<%--Default mapping from the lesson--%>
<%--<div class="panel panel-default">--%>
<%--<div class="page-heading">--%>
<%--<strong>RESPONSE</strong>--%>
<%--</div>--%>
<%--<div class="panel-body" id="response"></div>--%>
<%--<div class="panel-body" id="description"></div>--%>
<%--</div>--%>

</body>
</html>