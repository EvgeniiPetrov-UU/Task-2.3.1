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

//    @PostMapping("/new")
//    public String saveUser(@ModelAttribute("newUser") User user) {
//        userService.saveUser(user);
//        return "users";
//    }

//    @DeleteMapping(value = "/delete")
//    public String deleteUser(@RequestParam(value = "userId") Long id) {
//        userService.deleteUserById(id);
//        return "redirect:/users";
//    }

//    @PatchMapping(value = "/edit")
//    public String editUser((@RequestParam(value = "userId") Long id, @ModelAttribute(value = "editedUser") User editedUser) {
//        userService.editUserById(editedUser);
//        return "editUser";
//    }
}
