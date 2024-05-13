/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Springweb.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springweb.entity.thanhvien;
import springweb.service.thanhvienService;
import springweb.repository.thanhvienRepository;

@Service
public class thanhvienServicelmpl implements thanhvienService{
    @Autowired
    private thanhvienRepository membersRepository;
    
    
    @Override
    public boolean checkLogin(int matv, String password) {
        thanhvien member = membersRepository.findbyMaTV(matv,password);
        if (member == null)
            return false;
        return true;
    } 

    @Override
    public boolean checkRegister(thanhvien tv) {
        thanhvien member = membersRepository.findbyEmail(tv.getMaTV(),tv.getEmail());
        if(member == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkEmail(int matv, String email) {
        thanhvien member = membersRepository.findbyEmail(matv , email);
        if(member == null)
            return false;
        return true;
    }

    @Override
    public String getEmail(String email) {
        String password = membersRepository.findPasswordbyEmail(email);
        return password;
    }

    @Override
    public void updatePassword(int matv, String newPassword) {
        Optional<thanhvien> optionalThanhVien = membersRepository.findById(matv);
        if (optionalThanhVien.isPresent()) {
            thanhvien thanhVien = optionalThanhVien.get();
            thanhVien.setPass_word(newPassword);
            membersRepository.save(thanhVien);
        } else {
            // Xử lý trường hợp không tìm thấy thành viên
        }
    }

    @Override
    public String getEmail2(int matv) {
        String email = membersRepository.findEmailbyMaTV(matv);
        return email;
    }

    
      @Override
    public String getusername(int matv){
        String username=membersRepository.getusername(matv);
        return username;
    }
    @Override 
    public thanhvien getthanhvien(int matv){
        thanhvien tv=membersRepository.getthanhvien(matv);
        return tv;
    }

    @Override
    public thanhvien getMember(int matv, String password) {
        thanhvien member = membersRepository.findbyMaTV(matv,password);
        return member;

    }
}
