package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="mytest",
urlPatterns={"/myurl"})
public class MyServlet  extends HttpServlet{
	@Override
	protected  void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException ,IOException{
		System.out.println("premier servlet");
	}
	
	
		@Override
		protected  void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException ,IOException{
			super.doPost(req,resp);
		}
	
}
   
