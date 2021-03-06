package spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

@Controller
public class HelloSpring {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "index";

	}

	@RequestMapping(value = "/my.css", method = RequestMethod.GET)
	public String myCss(ModelMap model) {

//		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "css";

	}

	@RequestMapping(value = "/scripts.js", method = RequestMethod.GET)
	public String myJs(ModelMap model) {

//		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "js";

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}

	@RequestMapping("/helloDue")
	public String hello(Model model) {
		Jedis jedis = new Jedis();

		Long resp = jedis.incr("java.ee");
		
		jedis.close();
		
		model.addAttribute("msg", "CIAO " + resp);

		return "helloworld";

	}

}