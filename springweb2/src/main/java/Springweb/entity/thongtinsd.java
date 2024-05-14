package Springweb.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class thongtinsd {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MaTT", nullable = false)
    private Integer MaTT;

    @Column(name = "MaTV", nullable = false)
    private Integer MaTV;

    @Column(name = "MaTB", nullable = true)
    private Integer MaTB;

    @Column(name = "TGVao", nullable = true)
    private Timestamp TGVao;

    @Column(name = "TGMuon", nullable = true)
    private Timestamp TGMuon;

    @Column(name = "TGTra", nullable = true)
    private Timestamp TGTra;

    @Column(name = "TGDatcho", nullable = true)
    private Timestamp TGDatcho;

    private String trangThai;

    public thongtinsd() {
    }

    public thongtinsd(Integer MaTT, Integer MaTV, Integer MaTB, Timestamp TGVao, Timestamp TGMuon, Timestamp TGTra, Timestamp  TGDatcho) {
        this.MaTT = MaTT;
        this.MaTV = MaTV;
        this.MaTB = MaTB;
        this.TGVao = TGVao;
        this.TGMuon = TGMuon;
        this.TGTra = TGTra;
        this.TGDatcho = TGDatcho;
    }

    public Timestamp  getTGDatcho() {
        return TGDatcho;
    }

    public void setTGDatcho(Timestamp  TGDatcho) {
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

    public Timestamp getTGVao() {
        return TGVao;
    }

    public void setTGVao(Timestamp TGVao) {
        this.TGVao = TGVao;
    }

    public Timestamp getTGMuon() {
        return TGMuon;
    }

    public void setTGMuon(Timestamp TGMuon) {
        this.TGMuon = TGMuon;
    }

    public Timestamp getTGTra() {
        return TGTra;
    }

    public void setTGTra(Timestamp TGTra) {
        this.TGTra = TGTra;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
