package sy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sy.model.User;

@Controller
@RequestMapping("json")
public class JsonController {
	
	@RequestMapping("result")
	public void json(User user, HttpServletRequest request, HttpServletResponse response) throws IOException{
		String result = "{\"username\":\" "+ user.getUsername() +" \",\"userage\":\" "+ user.getUserage()+" \"}";
		PrintWriter pw = null;
		response.setContentType("application/json");
		pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}

	@RequestMapping("toJson")
	public String toJson(){
		return "form";
	}
}
