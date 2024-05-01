package Springweb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity (name = "thanhvien")
public class thanhvien {
    @Id
    private Integer MaTV;
    private String Hoten;
    private String Khoa;
    private String NganhString;
    private Integer SDT;
    private String PassWord;
    private String Email;

    public thanhvien() {
    }

    public thanhvien(Integer MaTV, String Hoten, String Khoa, String NganhString, Integer SDT, String PassWord, String Email) {
        this.MaTV = MaTV;
        this.Hoten = Hoten;
        this.Khoa = Khoa;
        this.NganhString = NganhString;
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

    public String getNganhString() {
        return NganhString;
    }

    public void setNganhString(String NganhString) {
        this.NganhString = NganhString;
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
