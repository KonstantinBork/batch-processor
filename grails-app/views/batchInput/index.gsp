<%--
  Created by IntelliJ IDEA.
  User: konstantin
  Date: 01.09.15
  Time: 14:26
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<head>
    <title>Batch Input</title>
</head>
<body>

<div id="register">
    <h2>Register a new task</h2>
    <!-- TODO make the selection dynamic -->
    <g:form action="registerTask">
        <g:select name="taskName" from="${jobNames}"/>
        <input value="Submit" type="submit"/>
    </g:form>
</div>

<div id="running">
    <h2>Currently running</h2>
    <!-- TODO add a link for each running job to get the status or stop it -->
    <g:each var="taskName" in="${executions}">
        <g:if test="${taskName.value}">
            <div name="${taskName}">
                <strong>${taskName.key}</strong></br>
                <g:each var="id" in="${taskName.value}">
                    ${id} </br>
                </g:each>
            </div>
        </g:if>
    </g:each>
</div>

</body>
</html>