package Springweb.entity;

import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "thietbi")
public class thietbi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MaTB", nullable = false)
    private Integer MaTB;

    @Column(name = "TenTB", nullable = false)
    private String TenTB;

    @Column(name = "mo_tatb", nullable = true)
    private String mo_tatb;
    
     @OneToMany(mappedBy = "thietbi", cascade = CascadeType.ALL)
    private List<thongtinsd> listTtsd;

    public thietbi() {
    }

    public thietbi(Integer MaTB, String TenTB, String mo_tatb) {
        this.MaTB = MaTB;
        this.TenTB = TenTB;
        this.mo_tatb = mo_tatb;
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

    public String getMo_tatb() {
        return mo_tatb;
    }

    public void setMo_tatb(String mo_tatb) {
        this.mo_tatb = mo_tatb;
    }
    

}
