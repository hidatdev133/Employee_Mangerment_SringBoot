package Springweb.entity;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class thanhvien {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MaTV", nullable = false)
    private Integer MaTV;
    
    @Column(name = "Hoten", nullable = false)
    private String Hoten;
    
    @Column(name = "Khoa", nullable = true)
    private String Khoa;
    
    @Column(name = "Nganh", nullable = true)
    private String Nganh;
    
    @Column(name = "SDT", nullable = true)
    private Integer SDT;
    
    @Column(name = "Password", nullable = false)
    private String PassWord;
    
    @Column(name = "Email", nullable = false)
    private String Email;

    public thanhvien() {
    }

    public thanhvien(Integer MaTV, String Hoten, String Khoa, String Nganh, Integer SDT, String PassWord, String Email) {
        this.MaTV = MaTV;
        this.Hoten = Hoten;
        this.Khoa = Khoa;
        this.Nganh = Nganh;
        this.SDT = SDT;
        this.PassWord = PassWord;
        this.Email = Email;
    }

    public Integer getMaTV() {
        return MaTV;
    }

    public void setMaTV(Integer MaTV) {
        this.MaTV = MaTV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getKhoa() {
        return Khoa;
    }

    public void setKhoa(String Khoa) {
        this.Khoa = Khoa;
    }

    public String getNganh() {
        return Nganh;
    }

    public void setNganh(String Nganh) {
        this.Nganh = Nganh;
    }

    public Integer getSDT() {
        return SDT;
    }

    public void setSDT(Integer SDT) {
        this.SDT = SDT;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
