package springweb.controller;

import Springweb.util.ForgotPassWordEmail;
import Springweb.util.UpdatePassWordEmail;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springweb.entity.thanhvien;
import springweb.repository.thanhvienRepository;
import springweb.service.thanhvienService;


@Controller
public class thanhvienController {
    @Autowired
    private thanhvienService memberService;
    
    @Autowired
    private thanhvienRepository memberRopository;
    
    @Autowired
    private ForgotPassWordEmail sendemail;
    
    @Autowired
    private UpdatePassWordEmail sendemail2;
    

    @GetMapping("/login")
    public String loginForm(HttpSession session) {
        if (session.getAttribute("matv") != null) {
            return "home";
        }
        return "login";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("matv");
        return "redirect:/home";
    }
    
    @PostMapping("/member/checklogin")
    public String checklogin(Model model, @RequestParam("matv") int matv, 
@RequestParam("password") String password, HttpSession session) {
         boolean check = memberService.checkLogin(matv, password);
         if (check == false) {
             model.addAttribute("ERROR", "MaTV or Password is incorrect");
             return "login";
         }else{
         session.setAttribute("matv", matv);
         thanhvien tv = memberService.getMember(matv, password);
         session.setAttribute("hovaten", tv.getHo_ten());
         return "redirect:/home";
         }
     }
    

    @GetMapping("/register")
    public String registerForm(HttpSession session) {
        return "register";
    }
    
    @PostMapping("/member/checkregister")
    public String checkregister(Model model, @ModelAttribute("tv") thanhvien tv, HttpSession session) {
        boolean check = memberService.checkRegister(tv);
        if (!check) {
            model.addAttribute("ERROR", "MaTV or Email already exists");
            return "register"; 
        } else {
            session.setAttribute("matv", tv.getMaTV());
            memberRopository.save(tv);
            return "redirect:/login"; 
        }
    }
    
    @GetMapping("/changepassword")
    public String changepasswordForm(HttpSession session,Model model){
        return "changepassword";
    }
    
    @PostMapping("/member/checkmatv")
    public String checkMatvAndOldPassword(Model model, 
                                       @RequestParam("matv") int matv,
                                       @RequestParam("oldpassword") String oldPassword,
                                       @RequestParam("newpassword") String newPassword,
                                       HttpSession session) {
        boolean isAuthenticated = memberService.checkLogin(matv, oldPassword);
        if (!isAuthenticated) {
            model.addAttribute("ERROR", "MaTV or Old Password is incorrect");
            return "changePassword";
        } else {
            session.setAttribute("matv", matv);
            memberService.updatePassword(matv, newPassword);
            String email = memberService.getEmail2(matv);
            sendemail2.sendPasswordByEmail(email);
            model.addAttribute("successMessage", "Password updated successfully!");
            return "redirect:/login"; 
        }
    }
    
    @GetMapping("/forgotpassword")
    public String forgotpasswordForm(HttpSession session,Model model){
        return "forgotpassword";
    }
    
    @PostMapping("/member/checkmatvandemail")
    public String checkmatvandemail(Model model, @RequestParam("matv") int matv,@RequestParam("email") String email, HttpSession session) {
        boolean check = memberService.checkEmail(matv, email);
        if (!check) {
            model.addAttribute("ERROR", "MaTV or Email is incorrect");
            return "forgotpassword"; 
        } else {
            session.setAttribute("matv", matv);
            sendemail.sendPasswordByEmail(email);
            model.addAttribute("successMessage", "Check email to see password");
            return "redirect:/login"; 
        }
    }   
}

