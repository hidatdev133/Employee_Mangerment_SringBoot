package Springweb.entity;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class xuly {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MaXL", nullable = false)
    private Integer MaXL;

    @Column(name = "MaTV", nullable = false)
    private Integer MaTV;

    @Column(name = "HinhThucXL", nullable = true)
    private String HinhThucXL;

    @Column(name = "SoTien", nullable = true)
    private Integer SoTien;

    @Column(name = "NgayXL", nullable = true)
    private Date NgayXL;

    @Column(name = "TrangThaiXL", nullable = true)
    private Integer TrangThaiXL;

    public xuly() {
    }

    public xuly(Integer MaXL, Integer MaTV, String HinhThucXL, Integer SoTien, Date NgayXL, Integer TrangThaiXL) {
        this.MaXL = MaXL;
        this.MaTV = MaTV;
        this.HinhThucXL = HinhThucXL;
        this.SoTien = SoTien;
        this.NgayXL = NgayXL;
        this.TrangThaiXL = TrangThaiXL;
    }

    public Integer getMaXL() {
        return MaXL;
    }

    public void setMaXL(Integer MaXL) {
        this.MaXL = MaXL;
    }

    public Integer getMaTV() {
        return MaTV;
    }

    public void setMaTV(Integer MaTV) {
        this.MaTV = MaTV;
    }

    public String getHinhThucXL() {
        return HinhThucXL;
    }

    public void setHinhThucXL(String HinhThucXL) {
        this.HinhThucXL = HinhThucXL;
    }

    public Integer getSoTien() {
        return SoTien;
    }

    public void setSoTien(Integer SoTien) {
        this.SoTien = SoTien;
    }

    public Date getNgayXL() {
        return NgayXL;
    }

    public void setNgayXL(Date NgayXL) {
        this.NgayXL = NgayXL;
    }

    public Integer getTrangThaiXL() {
        return TrangThaiXL;
    }

    public void setTrangThaiXL(Integer TrangThaiXL) {
        this.TrangThaiXL = TrangThaiXL;
    }

}
