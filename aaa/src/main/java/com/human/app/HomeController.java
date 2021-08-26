package com.human.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String home1(Locale locale, Model m) {		
		m.addAttribute("m_name", "jenny,jisoo");		
		return "members";
	}
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("myName", "Choi");
		model.addAttribute("myHome", "pyeongtaek");
		model.addAttribute("myMobile", "01055554444");
		
		return "home";
	}
	@RequestMapping(value = "/getinfo")
	public String getInfo() {
		return "getinfo";
	}
	
	@RequestMapping(value = "/info")
	public String doInfo(HttpServletRequest hsr, Model model) {		
		String uid=hsr.getParameter("userid");	
		String addr=hsr.getParameter("address");
		System.out.println("uid="+uid);
		System.out.println("addr="+addr);
		model.addAttribute("loginid",uid);
		model.addAttribute("region",addr);
		// userid -> uid -> loginid, address->addr->region
		return "viewinfo";
	}
	
	@RequestMapping(value = "/choose")
	public String doChoose() {
		return "choose";
	}
	@RequestMapping(value = "/selected")
	public String doJob(HttpServletRequest hsr, Model model) {
		String strPath=hsr.getParameter("path");
		if(strPath.equals("login")) {
			return "getinfo";
		} else if(strPath.equals("newbie")) {
			return "newbie";
		} else {
			return "choose";
		}
	}
	@RequestMapping(value = "/today/{address}/{userid}")
	public String showNumber() {
		return null;
	}
}
