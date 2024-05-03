package Springweb.controller;

import Springweb.entity.thietbi;
import Springweb.repository.thanhvienRepository;
import Springweb.repository.thietbiRepository;
import Springweb.repository.thongtinsdRepository;
import Springweb.repository.xulyRepository;
import Springweb.service.thietbiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    
    @Autowired
    private thietbiService tbService;
    
    @GetMapping("/home")
    public String viewHomePage(Model model) {
        model.addAttribute("listThietbi", tbService.getAllThietbi());
        return "home";
    }

}
