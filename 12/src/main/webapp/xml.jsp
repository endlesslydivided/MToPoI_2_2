<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<root xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:x="http://java.sun.com/jsp/jstl/xml"
      version="2.0">
    <jsp:directive.page contentType="text/html; charset=UTF-8"/>
    <html>
    <head>
        <title>XML</title>
    </head>
    <body>
    <x:parse var="info">
        <c:import url="exams.xml" />
    </x:parse>
    </body>
    </html>
</root>

