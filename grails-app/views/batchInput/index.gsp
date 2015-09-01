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
        <select name="taskName">
            <option value="sampleJob">Sample Job</option>
            <option value="longJob">Long Job</option>
        </select>
        <input value="Submit" type="submit"/>
    </g:form>
</div>

<div id="running">
    <h2>Currently running</h2>
    <!-- TODO add a link for each running job to get the status or stop it -->
    <g:form action="registerTask">
        <select name="taskName">
            <option value="sampleJob">Sample Job</option>
            <option value="longJob">Long Job</option>
        </select>
        <input value="Submit" type="submit"/>
    </g:form>
</div>

</body>
</html>