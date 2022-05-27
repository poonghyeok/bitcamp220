package com.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	urlPatterns={"*.do"},
	initParams = {
	@WebInitParam(name="propertiesConfig", value="command.properties")
	}
)
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String propertiesConfig = config.getInitParameter("propertiesConfig"); //serlvet이니깐 지정해놓은 properties를 읽어온다. properties를 읽어온다기 보다는 properties file이 존재하는 path를 return 받는다.
		//ServletConfig라는 class의 getInitParameter를 사용해서 web.xml에서 tagging 해놓은 propertiesConfig 라는 param-name의 param-value 즉 절대경로를 String type으로 return받게 된다 .
		System.out.println("propertiesConfig : " + propertiesConfig); //Properties라는 datatype있으니깐 propertyConfig라고 하는 편이 낫겠다. 
		

		  String realFolder = config.getServletContext().getRealPath("/WEB-INF/");
		  //WEB.INF가 있는 폴더를 받아낸다. 
		  String realPath = realFolder + propertiesConfig;
		  System.out.println("realPath = " + realPath);
		 
		
		FileInputStream fin = null; //FileInputStream 객체를 생성시켜둔다. properties는 file type이기 때문에 file의 내용을 입력받기 위해서
		Properties properties = new Properties(); //Properties 객체를 생성시켜둔다. 
		try {
			fin = new FileInputStream(realPath); //일단 FileInputStream 객체에 properties의 절대경로를 꽂는다.
			properties.load(fin); //properties 객쳉 file의 절대경로를 꽂은 fileInputStream의 객체를 꽂는다.
			System.out.println("loaded properties = "+properties);
		
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		
		Iterator it = properties.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			System.out.println("key = "+key);
			
			String className = properties.getProperty(key);
			System.out.println("className = "+className);
			
			try {
				Class<?> classType = Class.forName(className);
				Object ob = classType.newInstance();
				
				System.out.println("ob = "+ob);
				
				map.put(key, ob);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} 
			
			System.out.println();
		}//while
	}//init
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("UTF-8");	
		}//if
		
		String category = request.getServletPath();
		
		CommandProcess com = (CommandProcess)map.get(category); //member.service.WriteFormService
		
		String view = null;
	
		try {
			view = com.requestPro(request, response); //"/member/writeForm.jsp"
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);//상대번지
		dispatcher.forward(request, response);//제어권 넘기기
	
	}

}
