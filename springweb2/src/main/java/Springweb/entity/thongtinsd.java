package Springweb.entity;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class thongtinsd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  
    
    @Column(name = "MaTT", nullable = false)
    private Integer MaTT;

    @Column(name = "MaTV", nullable = false)
    private Integer MaTV;
   
//    @Column(name = "MaTB", nullable = true)  
    @Column
  
    private Integer MaTB;
   

    @Temporal(TemporalType.DATE)
    @Column(name = "TGVao", nullable = true)
    private Date TGVao;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGMuon", nullable = true)
    private Date TGMuon;

    @Temporal(TemporalType.DATE)
    @Column(name = "TGTra", nullable = true)
    private Date TGTra;

    @Column(name = "TGDatcho", nullable = true)
    private LocalDateTime TGDatcho;

    private String trangThai;

    
       @ManyToOne
    @JoinColumn(name = "MaTB", insertable = false, updatable = false)
    public thietbi thietbi;

    public thongtinsd() {
    }

    public thongtinsd(Integer MaTT, Integer MaTV, Integer MaTB, Date TGVao, Date TGMuon, Date TGTra, LocalDateTime  TGDatcho) {
        this.MaTT = MaTT;
        this.MaTV = MaTV;
        this.MaTB = MaTB;
        this.TGVao = TGVao;
        this.TGMuon = TGMuon;
        this.TGTra = TGTra;
        this.TGDatcho = TGDatcho;
    }


    public LocalDateTime  getTGDatcho() {
        return TGDatcho;
    }

    public void setTGDatcho(LocalDateTime  TGDatcho) {
        this.TGDatcho = TGDatcho;
    }

    public Integer getMaTT() {
        return MaTT;
    }

    public void setMaTT(Integer MaTT) {
        this.MaTT = MaTT;
    }

    public Integer getMaTV() {
        return MaTV;
    }

    public void setMaTV(Integer MaTV) {
        this.MaTV = MaTV;
    }

    public Integer getMaTB() {
        return MaTB;
    }

    public void setMaTB(Integer MaTB) {
        this.MaTB = MaTB;
    }

    public Date getTGVao() {
        return TGVao;
    }

    public void setTGVao(Date TGVao) {
        this.TGVao = TGVao;
    }

    public Date getTGMuon() {
        return TGMuon;
    }

    public void setTGMuon(Date TGMuon) {
        this.TGMuon = TGMuon;
    }

    public Date getTGTra() {
        return TGTra;
    }

    public void setTGTra(Date TGTra) {
        this.TGTra = TGTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

 
    
    
  
}
