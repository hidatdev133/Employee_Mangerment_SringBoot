package springweb.repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springweb.entity.thanhvien;

@Repository
public interface thanhvienRepository extends CrudRepository<thanhvien, Integer> {

    
    @Query("SELECT t FROM thanhvien t WHERE t.MaTV = ?1 AND t.pass_word = ?2")
    thanhvien findbyMaTV(int matv, String password);
    
    @Query("SELECT t FROM thanhvien t WHERE t.MaTV = ?1 AND t.Email = ?2")
    thanhvien findbyEmail(int matv, String email);
    
    @Query("SELECT t.pass_word FROM thanhvien t WHERE t.Email = ?1")
    String findPasswordbyEmail(String email);
    
    @Query("SELECT t.Email FROM thanhvien t WHERE t.MaTV = ?1")
    String findEmailbyMaTV(int matv);
    
    @Query ("SELECT t.ho_ten FROM thanhvien t WHERE t.MaTV=?1")
    String getusername(int matv);
    @Query ("SELECT t FROM thanhvien t WHERE t.MaTV=?1")
    thanhvien getthanhvien(int matv);
    
    

}

