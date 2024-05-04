package Springweb.controller;

import Springweb.entity.thietbi;
import Springweb.entity.thongtinsd;
import Springweb.repository.thanhvienRepository;
import Springweb.repository.thietbiRepository;
import Springweb.repository.thongtinsdRepository;
import Springweb.repository.xulyRepository;
import Springweb.service.thietbiService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private thanhvienRepository tvReposity;

    @Autowired
    private thietbiRepository tbReposity;

    @Autowired
    private thongtinsdRepository ttsdReposity;

    @Autowired
    private xulyRepository xlReposity;

    @GetMapping("/home")
    public String viewHomePage(Model model) {
        Iterable<thietbi> listThietbi = tbReposity.findAll();
        Iterable<thongtinsd> listTtsd = ttsdReposity.findAll();

        for (thietbi tb : listThietbi) {
            if (tb.getMoTaTB() == null || tb.getMoTaTB().trim().isEmpty()) {
                tb.setMoTaTB("Description not available");
            }

            model.addAttribute("listThietbi", listThietbi);
        }

        for (thongtinsd ttsd : listTtsd) {
            if (ttsd.getTGMuon() != null && ttsd.getTGTra() == null) {
                ttsd.setTrangThai("Đang được mượn");
            } else {
                ttsd.setTrangThai("Có sẵn");
            }
            model.addAttribute("listThongtinsd", listTtsd);
        }
        return "home";
    }
}
