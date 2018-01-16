<%@ page import="java.io.*"
%><%@ page import="java.util.Arrays"
%><%@ page import="java.io.File"
%><%@ page import="org.alfresco.repo.*;"
%><%@ page contentType="application/json;charset=UTF-8"
%><% File jsp = new File(request.getSession().getServletContext().getRealPath(request.getServletPath()));
File dir = jsp.getParentFile();
String requestPath = request.getRequestURL().substring(0,request.getRequestURL().lastIndexOf("api-selector.jsp"));

File[] list = dir.listFiles(new FilenameFilter() {
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".yaml");
    }
});
%>

[

<% for(int i = 0; i < list.length; i++) { %>
	"<% RestApiProcessor.getApiInfo(list[i]); %>
	"
	<% } %>

]