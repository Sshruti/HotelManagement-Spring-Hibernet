package com.mikadosolutions.training.springmvc.controllers;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import javax.servlet.http.HttpSession;
import org.springframework.validation.ObjectError;
import org.springframework.validation.FieldError;
import com.mikadosolutions.training.springmvc.bean.User;

@Controller
@RequestMapping("/")
public class HomeController
{
@RequestMapping("/")
	public String welcome()
	{
	return "welcome";
	}
@RequestMapping(value="/login", method= RequestMethod.GET)
	public ModelAndView login()// When we have pass data as long as with view
	{
ModelAndView mv = new ModelAndView("login");
User user = new User();
user.setUsername("someone@somewhere.com");
mv.addObject("user",user);
return mv;
	}
@RequestMapping("/authUser")
	public String authenticate(@Valid User user, BindingResult result, HttpSession session)
	{
if (result.hasErrors())
{
	return "login";
	}
	else if (user.getUsername().equals("salunkhe8@gmail.com") && user.getPassword().equals("shruti"))
	{
		session.setAttribute("user",user);
		return "userhome";
	}
	else
		{
		if(!user.getUsername().equals("salunkhe8@gmail.com"))
			result.addError(new FieldError ("user","username","username is incorrect"));
		if(!user.getPassword().equals("shruti"))
			result.addError(new FieldError ("user","password","password is incorrect"));
		return "login";
		}
	}
@RequestMapping("secure/home")
	public String Home()
	{
return "userhome";
	}
@RequestMapping("/back")
	public String back(HttpSession session)
	{
User user =(User)session.getAttribute("user");
if(user== null)
		{
	return "welcome";
		}
		else
		{
			return "userhome";
		}
	}
@RequestMapping("secure/logout")
public String logout(HttpSession session)
	{
session.removeAttribute("user");
return "welcome";
	}
};
