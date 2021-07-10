package com.codeplanet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletClass extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
          
            String s=req.getParameter("psw");
		   //PrintWriter out=res.getWriter();
           //out.print("<h1>HelloWelcomeToPlanet get request</h1>");
           //out.close();
		  // req.setAttribute("psw", s);

			String val = req.getParameter("psw-repeat");
			String val1 = req.getParameter("email");
			String val2 = req.getParameter("psw");
			System.out.print(val1 + "  "+ val2);
			req.setAttribute("email", val1);
			Connection con = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");//Load Driver class(communicate b/w java and databse)
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project1?characterEncoding=latin1","root","norapuu12");//Coonection b/w java and database
				Statement st = con.createStatement();//Vehical(transport query)
	            String query="insert into user values('abc@gmail.com','abc')";
			    int x=st.executeUpdate(query);
	            System.out.print("   "+x);
				//String query1 = "Select * from user where email =" + val1;
				//ResultSet rs = st.executeQuery(query1);
			}
			catch (ClassNotFoundException |SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
           RequestDispatcher dispatcher=req.getRequestDispatcher("First.jsp");
           dispatcher.forward(req, res);
    }
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
        out.print("<h1>HelloWelcomeToPlanet post request</h1>");
        out.close();
	}
}
		 
