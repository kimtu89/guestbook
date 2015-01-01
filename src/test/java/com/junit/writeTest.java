package com.junit;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;

import com.spring.web.controller.controller;
import com.spring.web.vo.page;

public class writeTest {
	private static controller write;
	@BeforeClass
	public static void beforeSetup() {
		write = new controller();
	}
	@SuppressWarnings({ "null", "deprecation" })
	@Test
	public void testWrite_done() {
		/*HttpServletRequest success = null;
		Model model = null;
		model.addAttribute("text", "a");
		success.setAttribute("email", "테스트@이메.일");
		success.setAttribute("pw", "1111");
		success.setAttribute("content", "본문\n테스트");
		HttpServletRequest fail = null;
		fail.setAttribute("email", "이메일에러");
		fail.setAttribute("pw", "1111");
		fail.setAttribute("content", "에러\n테스트");
		write.write_done(success,model);
		Assert.assertEquals("수정 되었습니다.", success.getAttribute("text"));
		//write.write_done(fail,model);
		//Assert.assertEquals("수정 되었습니다.", fail.getAttribute("text"));
	*/
	}

}
