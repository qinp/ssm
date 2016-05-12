package sy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.model.User;
import sy.service.UserServiceI;

@Controller
@RequestMapping("userController")
public class UserController {

	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}
	
	@RequestMapping("showUser/{id}")
	public String showUser(@PathVariable int id, HttpServletRequest request){
		User user = userService.getUserById(id);
		request.setAttribute("user", user);
		return "showUser";
	}
}
