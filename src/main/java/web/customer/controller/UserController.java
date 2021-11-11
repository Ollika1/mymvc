package web.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.customer.model.User;
import web.customer.service.UserService;

@Controller
@RequestMapping("/people")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String home(Model model){
        model.addAttribute("list",userService.getAllUsers());
        return "home";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", userService.getById(id));
        return "show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new User());
    return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") User user){
        userService.save(user);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person",userService.getById(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user, @PathVariable("id") int id){
        userService.edit(id, user);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/people";
    }

}
