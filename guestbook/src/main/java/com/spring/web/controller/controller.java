package com.spring.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.web.dao.SpringDao;
import com.spring.web.vo.page;

@Controller
public class controller {
	@Autowired
	private SpringDao dao;
	
	@RequestMapping("list")
	public String list(Model model){
		try {
			ArrayList<page> pages = (ArrayList<page>) dao.selectList();
			model.addAttribute("pages", pages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "list";
	}
	@RequestMapping("write")
	public String write() {
		
		return "write";
	}
	@RequestMapping("write_done")
	public String write_done(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String content = request.getParameter("content");
		if((email.indexOf("@")>-1)&&(email.lastIndexOf(".")>email.indexOf("@"))){
			page P = new page()
					.setEmail(email)
					.setPassword(pw)
					.setContent(content);
			try {
				dao.insertPage(P);
				model.addAttribute("text", "등록되었습니다.");
				return "write_done";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			model.addAttribute("text", "이메일이 올바르지 않습니다.");
		}
		
		return "write_done";
	}
	
	@RequestMapping("modify")
	public String modify(HttpServletRequest request, Model model) {
		String no = request.getParameter("no");
		try {
			model.addAttribute("page", dao.selectPage(no));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "modify";
	}
	
	@RequestMapping(value = "modify_done", method = RequestMethod.POST)
	public String modify_done(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String num = request.getParameter("no");
		String pw = request.getParameter("pw");
		String content = request.getParameter("content");
		page P;
		if((email.indexOf("@")>-1)&&(email.lastIndexOf(".")>email.indexOf("@"))){
			try {
				P = dao.selectPage(num);
				String prePassword = P.getPassword();
				if(prePassword.equals(pw)){
					P.setEmail(email).setContent(content);
					dao.updatePage(P);
					model.addAttribute("text", "수정 되었습니다.");
					return "write_done";
				}
				else{
					model.addAttribute("text", "비밀번호가 맞지 않습니다.");
					return "write_done";
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			model.addAttribute("text", "이메일이 올바르지 않습니다.");
		}
		return "write_done";
	}
}
