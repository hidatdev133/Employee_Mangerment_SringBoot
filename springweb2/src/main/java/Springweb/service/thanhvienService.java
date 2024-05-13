/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springweb.service;

import org.springframework.stereotype.Service;
import springweb.entity.thanhvien;

/**
 *
 * @author Dat dep trai
 */
@Service
public interface thanhvienService {
    
   boolean checkLogin(int matv, String password);
   
   thanhvien getMember(int matv, String password);
   
   boolean checkRegister(thanhvien tv);
   
   boolean checkEmail(int matv, String email);
   
   String getEmail(String email);
   
   String getEmail2(int matv);
   
   void updatePassword(int matv, String newPassword);
   
   String getusername(int matv);
   
   thanhvien getthanhvien(int matv);
}
