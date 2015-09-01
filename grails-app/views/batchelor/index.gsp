<%--
  Created by IntelliJ IDEA.
  Author: Konstantin Bork
  Date: 08/28/2015
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Batchelor Controller</title>
</head>

<body>
    <p>
        <g:link action="launchSampleJobOnce">Launch 1 job</g:link>
        <g:link action="launchSampleJobTenTimes">Launch 10 jobs</g:link>
        <g:link action="launchSampleJob100">Launch 100 jobs</g:link>
        <g:link action="produceTask">Produce 1 task</g:link>
        <g:link action="produce10Tasks">Produce 10 tasks</g:link>
        <g:link action="testConsumer">Test consumer</g:link>
        <g:link action="testWorker">Test worker</g:link>
    </p>
</body>
</html>