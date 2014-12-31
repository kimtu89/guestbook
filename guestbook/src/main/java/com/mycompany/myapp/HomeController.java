package com.mycompany.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	Dao dao;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Locale locale, Model model) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			
			String url = "jdbc:cubrid:localhost:33000:guestbook:::?charset=utf-8";
			String userid = "dba";
			String password = "1111";
			conn = DriverManager.getConnection(url,userid,password);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM LETTERS ORDER BY [INDEX] DESC");
			ArrayList<page> pages = new ArrayList<page>();
			while(rs.next()){
				pages.add(new page()
				.setIndex(rs.getInt("INDEX"))
				.setEmail(rs.getString("EMAIL"))
				.setContent(rs.getString("CONTENT"))
				.setCreatedDate(rs.getTimestamp("WRITETIME"))
				.setModifiedDate(rs.getTimestamp("MODIFYTIME")));
			}
			model.addAttribute("pages", pages);
		} catch(Exception e){}
		
		return "list";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(Locale locale, Model model) {
		
		return "write";
	}
	
	@RequestMapping(value = "write_done", method = RequestMethod.POST)
	public String write_done(@RequestParam(value="email") String email,
			@RequestParam(value="pw") String pw, @RequestParam(value="content") String content, Model model) {
		Connection conn = null;
		PreparedStatement stmt = null;
		if((email.indexOf("@")>-1)&&(email.lastIndexOf(".")>email.indexOf("@"))){
			try{
				Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
				
				String url = "jdbc:cubrid:localhost:33000:guestbook:::?charset=utf-8";
				String userid = "dba";
				String password = "1111";
				conn = DriverManager.getConnection(url,userid,password);
				
				stmt = conn.prepareStatement("INSERT INTO LETTERS(EMAIL,PASSWORD,CONTENT,WRITETIME,MODIFYTIME)"
						+ "VALUES (?,?,?,NOW(),NOW())");
				stmt.setString(1, email);
				stmt.setString(2, pw);
				stmt.setString(3, content);
				stmt.executeUpdate();
				model.addAttribute("text", "등록되었습니다.");
			} catch(Exception e){}
		}
		else{
			model.addAttribute("text", "이메일이 올바르지 않습니다.");
		}
		return "write_done";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(@RequestParam(value="no") String no, Model model) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			
			String url = "jdbc:cubrid:localhost:33000:guestbook:::?charset=utf-8";
			String userid = "dba";
			String password = "1111";
			conn = DriverManager.getConnection(url,userid,password);
			
			stmt = conn.prepareStatement("SELECT * FROM LETTERS WHERE [INDEX]=?");
			stmt.setString(1, no);
			rs = stmt.executeQuery();
			page P = new page();
			if(rs.next()){
				P.setIndex(rs.getInt("INDEX"))
				.setEmail(rs.getString("EMAIL"))
				.setPassword(rs.getString("PASSWORD"))
				.setContent(rs.getString("CONTENT"))
				.setCreatedDate(rs.getTimestamp("WRITETIME"))
				.setModifiedDate(rs.getTimestamp("MODIFYTIME"));
			}
			model.addAttribute("page", P);
		} catch(Exception e){}
		
		return "modify";
	}
	
	@RequestMapping(value = "modify_done", method = RequestMethod.POST)
	public String modify_done(@RequestParam(value="email") String email, @RequestParam(value="no") String num,
			@RequestParam(value="pw") String pw, @RequestParam(value="content") String content, Model model) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String prePassword = null;
		if((email.indexOf("@")>-1)&&(email.lastIndexOf(".")>email.indexOf("@"))){
			try{
				Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
				
				String url = "jdbc:cubrid:localhost:33000:guestbook:::?charset=utf-8";
				String userid = "dba";
				String password = "1111";
				conn = DriverManager.getConnection(url,userid,password);
				
				stmt = conn.prepareStatement("SELECT [PASSWORD] FROM LETTERS WHERE [INDEX]=?");
				stmt.setString(1, num);
				rs = stmt.executeQuery();
				
				rs.next();
				prePassword = rs.getString("PASSWORD");
				
				if(prePassword.equals(pw)){
					stmt = conn.prepareStatement("UPDATE LETTERS SET EMAIL=?,CONTENT=?,MODIFYTIME=NOW() WHERE [INDEX]=?");
					stmt.setString(1, email);
					stmt.setString(2, content);
					stmt.setString(3, num);
					stmt.executeUpdate();
					model.addAttribute("text", "수정 되었습니다.");
					return "modify_done";
				}
				else{
					model.addAttribute("text", "비밀번호가 맞지 않습니다.");
				}
			} catch(Exception e){}
		}
		else{
			model.addAttribute("text", "이메일이 올바르지 않습니다.");
		}
		return "modify_done";
	}
}
