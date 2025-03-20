package com.spingpractice;

import java.util.Arrays;
import java.util.List;
import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.spingpractice.model.Alien;
import com.spingpractice.repository.AlienRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	
	@Autowired
	AlienRepo repo;
	
	@ModelAttribute
	public void modelData(Model m)
	{
		m.addAttribute("name","aliens");
	}
	
	@RequestMapping("/")
	public String display() {
		//return "index.jsp";
		return "index";
	}
	
	
	//Approach-1
//	@RequestMapping("add")
//	public String add(HttpServletRequest req){
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		
//		int num3 = i+j;
//		
//		HttpSession session  = req.getSession();
//		
//		session.setAttribute("num3",num3);
//		return "result.jsp";
//	}
	
	//Approach-2
//	@RequestMapping("add")
//	public String add(@RequestParam("num1") int  i,@RequestParam("num2") int j, HttpSession session){
//		
//		int num3 = i+j;
//		session.setAttribute("num3",num3);
//		return "result.jsp";
//	}
	
	//Approach-3
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1") int  i,@RequestParam("num2") int j){
//		
//		int num3 = i+j;
//		
//	//ModelAndView mv = new ModelAndView("result");
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		
//		mv.addObject("num3",num3);
//		return mv;
//	}
	
	//Approach-4
	@RequestMapping("add")
	public String add(@RequestParam("num1") int  i,@RequestParam("num2") int j,ModelMap m){
		
		int num3 = i+j;
		m.addAttribute("num3",num3);
		return "result";
	}
	
	//Approach -1
//	@RequestMapping("addAlien")
//	public String addAlien(@RequestParam("aid") int  aid,@RequestParam("aname") String aname,Model m ){
//		
//		Alien a = new Alien();
//		a.setAid(aid);
//		a.setAname(aname);
//		
//		m.addAttribute("alien",a);
//		
//		return "result";
//	}
	
//	@RequestMapping("addAlien")
//	public String addAlien(@ModelAttribute("a1") Alien a ){  //public String addAlien(Alien a,Model m )
//				
//		return "result";
//	}
	
	
//	@GetMapping("/getAliens")
//	public String getAliens(Model m) {
//		
//		List<Alien> aliens = Arrays.asList(new Alien(101,"Anchal"),new Alien(102,"Anuj"));
//		
//		m.addAttribute("result",aliens);
//		return "showAliens";
//	}
	
	
	//Using ORM fetch the data from the database
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		
		m.addAttribute("result",repo.findAll());
		return "showAliens";
	}
	
	//Using ORM fetch the data from the database
		@GetMapping("getAlien")
		public String getAlienById(@RequestParam("aid") int id,Model m ) {
			
			m.addAttribute("result",repo.findById(id));
			return "showAliens";
		}
	
	@PostMapping("/addAlien")
	public String addAliendata(@ModelAttribute Alien a ){  //public String addAlien(Alien a,Model m )
				
		repo.save(a);
		return "result";
	}
	
	//Using ORM fetch the data from the database
			@GetMapping("/getAlienByName")
			public String getAlienByName(@RequestParam String aname,Model m ) {
			
				m.addAttribute("result",repo.find(aname));
				return "showAliens";
			}
}
