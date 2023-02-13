package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute("newUser") User newUser) {
        userService.saveUser(newUser);
        return "redirect:/";
    }

    @DeleteMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "userToRemoveId", required = false) Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @PutMapping ("/")
    public String editUser(@ModelAttribute("editedUser") User editedUser) {
        userService.editUser(editedUser);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String getNewUserTemplate(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "createUser";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(value = "userToEditId", required = false) Long id,
                           Model model) {
        User editedUser = userService.getUserById(id);
        model.addAttribute("editedUser", editedUser);
        return "editUser";
    }
}
