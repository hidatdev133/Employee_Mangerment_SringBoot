package Springweb.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "thongtinsd")
public class thongtinsd {

    @Id
    private Integer MaTT;
    private Integer MaTV;
    private Integer MaTB;
    private Date TGVao;
    private Date TGMuon;
    private Date TGTra;

    public thongtinsd() {
    }

    public thongtinsd(Integer MaTT, Integer MaTV, Integer MaTB, Date TGVao, Date TGMuon, Date TGTra) {
        this.MaTT = MaTT;
        this.MaTV = MaTV;
        this.MaTB = MaTB;
        this.TGVao = TGVao;
        this.TGMuon = TGMuon;
        this.TGTra = TGTra;
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
    
    

}
