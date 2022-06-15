package io.capstone.website_service.controller;

import io.capstone.website_service.entity.User;
import io.capstone.website_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class BzzChatWebController {
    @Autowired
    private UserService userService;

    /**
     * Home page access
     * @return index HTML page
     */
    @GetMapping("/")
    public String homePage() {
        //TODO-> only admin access?
//        Authentication authetication = SecurityContextHolder.getContext().getAuthentication();
//        if(authetication != null && authetication.getPrincipal()
//                instanceof UserDetails && ((UserDetails)authetication.getPrincipal()).getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))){
//            return "redirect:/admin";
//        }
        return "index";
    }

    /**
     * Registration page access
     * @param model Model attribute
     * @return registration HTML page
     */
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());

        return "register_page";
    }

    /**
     * Registration success page access
     * @param user user entity instance
     * @return registration success HTML page
     */
    @PostMapping("/register_process")
    public String registerProcess(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //! Password encryption
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        if (!Objects.equals(user.getRole(), "ADMIN")) {
            user.setEnabled(true); //? If user is not admin, make it enabled
        }

        userService.save(user);

        return "register_success";
    }

    /**
     * Admin page
     * @return admin HTML page
     */
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    /**
     * List of users registered page access
     * @param model Model attribute
     * @return list of users HTML page
     */
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute(userList);

        return "users";
    }

    /**
     * @return dashboard page
     */
    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";
    }
}
