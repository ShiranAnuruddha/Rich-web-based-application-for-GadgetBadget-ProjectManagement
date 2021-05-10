package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class projectAPI extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6056671524773503122L;
	project projectObj = new project();
	
	public projectAPI() {
		
		super();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
			{
			 String output = projectObj.insertProject(request.getParameter("authorName"),
			request.getParameter("projectCategory"),
			 request.getParameter("projectName"),
			request.getParameter("projectPrice"),
			request.getParameter("authorEmail"),
			request.getParameter("projectDesc"));
			response.getWriter().write(output);
			}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
			{
			 Map paras = getParasMap(request);
			 String output = projectObj.updateProject(paras.get("hidItemIDSave").toString(),
			 paras.get("authorName").toString(),
			 paras.get("projectCategory").toString(),
			paras.get("projectName").toString(),
			paras.get("projectPrice").toString(),
			paras.get("authorEmail").toString(),
			paras.get("projectDesc").toString());
			response.getWriter().write(output);
			}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException
			{
			 Map paras = getParasMap(request);
			 String output = projectObj.deleteProject(paras.get("projectID").toString());
			response.getWriter().write(output);
			}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 { 
	
	String[] p = param.split("=");
	 map.put(p[0], p[1]);
	 }
	 }
	catch (Exception e)
	 {
	 }
	return map;
	}
	
	
}
