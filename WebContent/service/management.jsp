<%@page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.herokuapp.muaytoday.service.MatchService"%>
<%@page import="com.herokuapp.muaytoday.json.JsonObjectMapper"%>
<%@page import="com.herokuapp.muaytoday.request.BufferedReaderRequest"%>
<%@page import="com.herokuapp.muaytoday.factory.ApplicationContextFactory"%>
<%
	//request.setCharacterEncoding("UTF-8)");
	MatchService matchService = (MatchService) ApplicationContextFactory.getInstance().getBean("matchService");
	String action = request.getParameter("action");
	Map params = BufferedReaderRequest.getRequestMap(request);

	System.out.println("Params = " + params);
	String json = null;
	List list = new ArrayList();
	if (action.equals("add")) {
		Number result = matchService.add(params);

		json = JsonObjectMapper.getInstance().writeValueAsString(result);
	} else if (action.equals("edit")) {
		Number result = matchService.update(params);

		json = JsonObjectMapper.getInstance().writeValueAsString(result);
	} else if (action.equals("update")) {
		Number result = matchService.update(params);

		json = JsonObjectMapper.getInstance().writeValueAsString(result);
	} else if (action.equals("getmatchtoday")) {
		list = matchService.getMatchToday();

		json = JsonObjectMapper.getInstance().writeValueAsString(list);
	}
%><%out.clear();%><%=json%>