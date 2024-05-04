package Springweb.entity;

import com.sun.istack.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "thietbi")
public class thietbi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MaTB", nullable = false)
    private Integer MaTB;

    @Column(name = "TenTB", nullable = false)
    private String TenTB;

    @Column(name = "MoTaTB", nullable = true)
    private String MoTaTB;

    public thietbi() {
    }

    public thietbi(Integer MaTB, String TenTB, String MoTaTB) {
        this.MaTB = MaTB;
        this.TenTB = TenTB;
        this.MoTaTB = MoTaTB;
    }

    public Integer getMaTB() {
        return MaTB;
    }

    public void setMaTB(Integer MaTB) {
        this.MaTB = MaTB;
    }

    public String getTenTB() {
        return TenTB;
    }

    public void setTenTB(String TenTB) {
        this.TenTB = TenTB;
    }

    public String getMoTaTB() {
        return MoTaTB;
    }

    public void setMoTaTB(String MoTaTB) {
        this.MoTaTB = MoTaTB;
    }

}
