package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam("userToRemoveId") int id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String getNewUserTemplate(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "createUser";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("userToEditId") int id, Model model) {
        User editedUser = userService.getUserById(id);
        model.addAttribute("editedUser", editedUser);
        return "editUser";
    }
}
