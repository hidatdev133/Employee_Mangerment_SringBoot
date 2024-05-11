package springweb.controller;

import Springweb.entity.thietbi;
import Springweb.entity.thongtinsd;
import Springweb.repository.thietbiRepository;
import Springweb.repository.thongtinsdRepository;
import Springweb.repository.xulyRepository;
import Springweb.service.thietbiService;
import Springweb.service.thietbiServiceImpl;
import Springweb.service.thongtinsdService;
import Springweb.service.thongtinsdServiceImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private thongtinsdService ttsdService;

    @Autowired
    private xulyRepository xlReposity;
    
    @Autowired
    private thietbiService thietbiService ;

//    @GetMapping("/home")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        Iterable<thietbi> listThietbi = tbReposity.findAll();
//        Date date = new Date();
//        Iterable<thietbi> thietBiList = tbReposity.findAll();
//        Map<Integer, String[]> trangThaiMap = new HashMap<>();
//        
//        if(keyword != null){
//            listThietbi = this.thietbiService.searchTB(keyword);
//            model.addAttribute("listThietbi", listThietbi);
//        }
//        
//        for (thietbi thietBi : thietBiList) {
//            boolean daMuon = false;
//            boolean daDatCho = false;
//            for(thongtinsd x: ttsdReposity.findAll()){
//                if(x.getTGDatcho()!= null){
//                    daDatCho = true;
//                }
//                if (x.getTGMuon()!= null && x.getTGTra() == null){
//                    daMuon = true;
//                }
//            }
//            // Lưu trạng thái của thiết bị vào Map
//            String[] trangThai = new String[2];
//            trangThai[0] = daMuon ? "Đã mượn" : "Chưa mượn";
//            trangThai[1] = daDatCho ? "Đã đặt chỗ" : "Chưa đặt chỗ";
//            trangThaiMap.put(thietBi.getMaTB(), trangThai);
//        }
//        // Đưa dữ liệu vào model
//        model.addAttribute("dataThietBi", thietBiList);
//        model.addAttribute("trangThaiMap", trangThaiMap);
//        return "home";
//    }
    
    
    @GetMapping("/home")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        Iterable<thietbi> listThietbi = tbReposity.findAll();
        Iterable<thongtinsd> listTtsd = ttsdReposity.findAll();
        if(keyword != null){
            listThietbi = this.thietbiService.searchTB(keyword);
            model.addAttribute("listThietbi", listThietbi);
        }
       
        for (thietbi tb : listThietbi) {
            if (tb.getMo_tatb() == null || tb.getMo_tatb().trim().isEmpty()) {
                tb.setMo_tatb("Description not available");
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
//        Iterable<thietbi> listThietbi = ttsdReposity.findAll();

        if(id != 0){
            listTtsd = this.ttsdService.searchTTSD(id);
            
            model.addAttribute("listThongtinsd", listTtsd);
        }
        
//        for (thongtinsd ttsd : listTtsd) {
//            System.out.println("thoi gian" + ttsd.getTGMuon());
//            if (ttsd.getTGMuon() != null && ttsd.getTGTra() == null) {
//                ttsd.setTrangThai("Đang được mượn");
//            } else {
//                ttsd.setTrangThai("Có sẵn");
//            }
//            model.addAttribute("listThongtinsd", listTtsd);
//        }
        
        
        if (thietbiop.isPresent()) {
            thietbi tb = thietbiop.get();
            if (tb.getMo_tatb() == null || tb.getMo_tatb().trim().isEmpty()) {
                tb.setMo_tatb("Description not available");
            }
            model.addAttribute("thietbiop", tb);
        } else {
            System.out.println("Không có thiết bị này");
            // Handle the case where the device ID is not found
        }

//        for (thongtinsd ttsd : listTtsd) {
//            System.out.println("thoi gian" + ttsd.getTGMuon());
//            if (ttsd.getTGMuon() != null && ttsd.getTGTra() == null) {
//                ttsd.setTrangThai("Đang được mượn");
//            } else {
//                ttsd.setTrangThai("Có sẵn");
//            }
//            model.addAttribute("listThongtinsd", listTtsd);
//        }
        return "detail";
    }

}
