package ir.kimiya.bandaremam.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import ir.kimiya.bandaremam.model.User;
import ir.kimiya.bandaremam.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String getUsers(){
		return "User";
	}

	@PostMapping(value = "users/addNew")
	public RedirectView addNew(User user,RedirectAttributes redir){
		userService.save(user);
		RedirectView redirectView = new RedirectView("/index",true);
		redir.addFlashAttribute("message","Successfully Registered! login now!");
		return redirectView;
	}
	/*@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getUsers(Model model) {
		List<User> userList = userService.getUsers();
		model.addAttribute("users",userList);
		return "user";
	}
	
	
	//Modified method to Add a new user User
	@PostMapping(value="users/addNew")
	public String addNew(User user) {
		userService.save(user);
	    return "redirect:/users";
	}

	@RequestMapping(value="users/findById")
	@ResponseBody
	public Optional<User> findById(int id) {
	return userService.findById(id);
	}
*/


}
