<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.herokuapp.muaytoday.service.RestTemplateService"%>
<%@page import="com.herokuapp.muaytoday.factory.ApplicationContextFactory"%>
<%
	Map params = new HashMap();
	Enumeration enumeration = request.getParameterNames();
	while (enumeration.hasMoreElements()) {
		String key = (String) enumeration.nextElement();
		params.put(key.toLowerCase(), (String)request.getParameter(key));
	}

	if (params.isEmpty() == false && params.get("action").equals(null) == false) {
		RestTemplateService restTemplateService = (RestTemplateService) ApplicationContextFactory.getInstance().getBean("restTemplateService");
		Number result = restTemplateService.getForNumber("/service/management.jsp?action="+String.valueOf(params.get("action")) , params);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Management data page</title>
</head>
<body>
<h1>Manage data here</h1>
</body>
</html>