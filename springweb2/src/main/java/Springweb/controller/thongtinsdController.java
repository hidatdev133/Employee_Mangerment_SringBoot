package Springweb.controller;

import Springweb.entity.thongtinsd;
import Springweb.service.thongtinsdServiceImpl;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/thongtinsd")
public class thongtinsdController {

    
    @Autowired
    private thongtinsdServiceImpl thongTinSDServiceimp;
    

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Timestamp reserveTime
    @PostMapping("/save")
    public String saveThongTinSuDung(String thanhVienId, String thietBiId, String reserveTime) {
        if (reserveTime == null || reserveTime.isEmpty()) {
            return "redirect:/detail?id=" + thietBiId + "&missingDate";
        }

        int newId = thongTinSDServiceimp.findNextId();
        int parsedThanhVienId = Integer.parseInt(thanhVienId);
        int parsedThietBiId = Integer.parseInt(thietBiId);

//        thanhvien thanhVien = thanhVienServiceimp.findById(parsedThanhVienId);
//        thietbi thietBi = thietBiService.findByMaTB(parsedThietBiId);
        Timestamp new_reserveTime;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date = inputFormat.parse(reserveTime);

            String formattedDate = outputFormat.format(date);
            new_reserveTime = Timestamp.valueOf(formattedDate);
            if (new_reserveTime.before(new Date())) {
                return "redirect:/detail?id=" + thietBiId + "&invalidDate"; // Chuyển hướng với thông báo lỗi
            }else if (!thongTinSDServiceimp.checkValidReserveTime(parsedThietBiId ,new_reserveTime)){
                return "redirect:/detail?id=" + thietBiId + "&deviceReserved";
            }
        } catch (ParseException e) {
            return "redirect:/detail?id=" + thietBiId + "&errorDate";
        }

        thongtinsd ttsd = new thongtinsd();
        ttsd.setMaTT(newId);
        ttsd.setMaTV(parsedThanhVienId);
        ttsd.setMaTB(parsedThietBiId);
        ttsd.setTGDatcho(new_reserveTime);
        

        System.out.println("ttsd" + ttsd.toString()
        
        );
        thongtinsd savedEntity = thongTinSDServiceimp.save(ttsd);
        if (savedEntity != null) {
            System.out.println("Them thanh cong \n");
        } else {
            System.out.println("Them that bai \n");
        }
        return "redirect:/home";
    }
    
    @ResponseBody
    @PostMapping("/checkValidReserveTime")
    public ResponseEntity<Map<String, String>> checkValidReserveTime(String thietBiId, String reserveTime) {
        Map<String, String> response = new HashMap<>();
        System.out.println("hhhhhhhh");

        // Kiểm tra nếu reserveTime không hợp lệ
        if (reserveTime == null || reserveTime.isEmpty()) {
            response.put("result", "error");
            response.put("redirect", "/detail?id=" + thietBiId + "&missingDate");
            return ResponseEntity.ok().body(response);
        }

        // Parse thietBiId sang kiểu int
        int parsedThietBiId = Integer.parseInt(thietBiId);
        Timestamp new_reserveTime;
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            // Parse reserveTime về kiểu Timestamp
            Date date = inputFormat.parse(reserveTime);
            String formattedDate = outputFormat.format(date);
            new_reserveTime = Timestamp.valueOf(formattedDate);

            // Kiểm tra thời gian đặt chỗ
            if (new_reserveTime.before(new Date())) {
                // Thời gian đặt chỗ nhỏ hơn thời gian hiện tại
                response.put("result", "error");
                response.put("redirect", "/detail?id=" + thietBiId + "&invalidDate");
            } else if (thongTinSDServiceimp.checkValidReserveTime(parsedThietBiId, new_reserveTime)) {
                // Thời gian đặt chỗ hợp lệ
                response.put("result", "success");
                response.put("redirect", "/detail?id=" + thietBiId + "&canReserved");
            } else {
                // Thiết bị đã được đặt chỗ bởi người khác
                response.put("result", "error");
                response.put("redirect", "/detail?id=" + thietBiId + "&deviceReserved");
            }
        } catch (ParseException e) {
            // Xử lý nếu có lỗi xảy ra khi parse thời gian
            response.put("result", "error");
            response.put("redirect", "/detail?id=" + thietBiId + "&errorDate");
        }

        // Trả về ResponseEntity chứa thông tin response
        return ResponseEntity.ok().body(response);
    }
}
