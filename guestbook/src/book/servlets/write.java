package book.servlets;

import cubrid.jdbc.driver.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class write extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ "<head><title>글쓰기</title></head>"
				+ "<body>"
				+ "<form action='book' method='post'>"
				+ "email : <input type='text' name='email'><br>"
				+ "pw : <input type='password' name='pw'><br>"
				+ "content : <input type='text' name='content' style='height:100px'><br>"
				+ "<input type='submit' value='쓰기'>"
				+ "</form>"
				+ "</body></html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			String url = "jdbc:cubrid:localhost:33000:guestbook:::";
			String userid = "dba";
			String password = "1111";
			conn = DriverManager.getConnection(url,userid,password);
			
			stmt = conn.prepareStatement("INSERT INTO LETTERS(EMAIL,PASSWORD,CONTENT)"
					+ "VALUES (?,?,?)");
			stmt.setString(1, request.getParameter("email"));
			stmt.setString(2, request.getParameter("pw"));
			stmt.setString(3, request.getParameter("content"));
			stmt.executeUpdate();
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html>"
					+ "<head><title>등록</title></head>"
					+ "<body>등록"
					+ "</body></html>");
			//response.sendRedirect("write");
		} catch(Exception e){
			
		}
	}
}
