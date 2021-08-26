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
		model.addAttribute("myName", "Lim Eunbi");
		model.addAttribute("address", "봉서산샛길 64");
		model.addAttribute("mobile", "01080753708");
		return "members";
	}
	@RequestMapping("/getinfo")
	public String getInfo() {
		return "getinfo";
	}
	
	@RequestMapping("/info")
	public String doInfo(@RequestParam("userid") String id,@RequestParam("address") String addr, Model model) {
//		String id=hsr.getParameter("userid");
//		String addr=hsr.getParameter("address");
//		
		model.addAttribute("loginid", id);
		model.addAttribute("region", addr);
		
		return "viewinfo";
	}
	@RequestMapping("/choose")
	public String doChoose() {
		return "choose";
	}
	
	@RequestMapping("/selected")
//	public String doJob(HttpServletRequest hsr, Model model) {
	public String doJob(@RequestParam("path") String strPath, Model model) {
//		String strPath=hsr.getParameter("path");
		if(strPath.equals("login")) {
			return "getinfo";
		}else if(strPath.equals("newbie")) {
			return "newbie";
		}
		return "choose";
	}
	
	//Command 객체
//	public String doJob(ParamList pl, Model model) {
//		model.addAttribute("userid", pl.userid);
//		model.addAttribute("addr", pl.address);
//		return "";
//	}
	//PathVariable
	@RequestMapping("/today/{year}/{month}/{day}")
	public String showToday(@PathVariable int year, @PathVariable int month, @PathVariable int day, Model model) {
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		return "today";
	}
	
}