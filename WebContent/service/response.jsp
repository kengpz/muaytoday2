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
	RestTemplateService restTemplateService = (RestTemplateService) ApplicationContextFactory.getInstance().getBean("restTemplateService");
	Number result = restTemplateService.getForNumber("/service/manage.jsp?action=" + String.valueOf(params.get("action")) , params);
%><%=result %>