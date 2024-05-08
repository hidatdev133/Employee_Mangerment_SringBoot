package springweb.controller;

import Springweb.entity.thietbi;
import Springweb.entity.thongtinsd;
import Springweb.repository.thietbiRepository;
import Springweb.repository.thongtinsdRepository;
import Springweb.repository.xulyRepository;
import Springweb.service.thietbiService;
import Springweb.service.thietbiServiceImpl;
import Springweb.service.thongtinsdServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springweb.repository.thanhvienRepository;

@Controller
public class HomeController {

    @Autowired
    private thanhvienRepository tvReposity;

    @Autowired
    private thietbiRepository tbReposity;
    
    @Autowired
    private thietbiServiceImpl tbServiceImpl;

    @Autowired
    private thongtinsdRepository ttsdReposity;
    
    @Autowired
    private thongtinsdServiceImpl ttsdServiceImpl;

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
    
    @GetMapping("/detail")
    public String viewDetail(@RequestParam("id") int id, Model model) {
        System.out.println("details");
        Optional<thietbi> thietbiop = tbServiceImpl.findById(id);
        Iterable<thongtinsd> listTtsd = ttsdReposity.findAll();
        Optional<thongtinsd> ttsdop = null;

        if (thietbiop.isPresent()) {
            thietbi tb = thietbiop.get();
            if (tb.getMoTaTB() == null || tb.getMoTaTB().trim().isEmpty()) {
                tb.setMoTaTB("Description not available");
            }
            ttsdop = ttsdServiceImpl.findById(tb.getMaTB());
            model.addAttribute("thietbiop", tb);
        } else {
            System.out.println("Không có thiết bị này");
            // Handle the case where the device ID is not found
        }

        for (thongtinsd ttsd : listTtsd) {
            System.out.println("thoi gian" + ttsd.getTGMuon());
            if (ttsd.getTGMuon() != null && ttsd.getTGTra() == null) {
                ttsd.setTrangThai("Đang được mượn");
            } else {
                ttsd.setTrangThai("Có sẵn");
            }
            model.addAttribute("listThongtinsd", listTtsd);
        }
        return "detail";
    }

}
