package com.mycompany.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
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
		try{
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			
			String url = "jdbc:cubrid:localhost:33000:guestbook:::";
			String userid = "dba";
			String password = "1111";
			conn = DriverManager.getConnection(url,userid,password);
			
			stmt = conn.prepareStatement("INSERT INTO LETTERS(EMAIL,PASSWORD,CONTENT,WRITETIME,MODIFYTIME)"
					+ "VALUES (?,?,?,NOW(),NOW())");
			stmt.setString(1, email);
			stmt.setString(2, pw);
			stmt.setString(3, content);
			stmt.executeUpdate();
		} catch(Exception e){
		}
		
		return "write_done";
	}
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Locale locale, Model model, HttpServletRequest request) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			
			String url = "jdbc:cubrid:localhost:33000:guestbook:::";
			String userid = "dba";
			String password = "1111";
			conn = DriverManager.getConnection(url,userid,password);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT *"
					+ "FROM LETTERS"
					+ "ORDER BY INDEX DESC");
			ArrayList<page> pages = new ArrayList<page>();
			while(rs.next()){
				pages.add(new page()
				.setIndex(rs.getInt("INDEX"))
				.setEmail(rs.getString("EMAIL"))
				.setPassword(rs.getString("PASSWORD"))
				.setContent(rs.getString("CONTENT"))
				.setCreatedDate(rs.getDate("WRITETIME"))
				.setModifiedDate(rs.getDate("MODIFYTIME")));
			}
			model.addAttribute("pages", pages);
		} catch(Exception e){
		}
		
		return "list";
	}
}
