
package Springweb.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author caothanh
 */
@Controller
public class MembersController {

    @GetMapping("/login")
    public String loginForm(HttpSession session) {
        if (session.getAttribute("USERNAME") != null) {
            return "home";
        }
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(HttpSession session) {
        if (session.getAttribute("USERNAME") != null) {
            return "home";
        }
        return "register";
    }
}
