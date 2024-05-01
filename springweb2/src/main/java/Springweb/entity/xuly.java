package Springweb.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "xyly")
public class xuly {

    @Id
    private Integer MaXL;
    private Integer MaTV;
    private String HinhThucXL;
    private Integer SoTien;
    private Date NgayXL;
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
