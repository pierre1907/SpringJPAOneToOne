package sn.ism.domaine;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="passports")
public class Passport implements Serializable {

    @Id
    @Column(length = 50)
    private String numpass;
    @Column(length = 25)

    private String tp; //P, PS, PD
    @OneToOne
    @JoinColumn(name = "numci")
    private Citoyen citoyen;

    public Passport() {

    }

    public String getNumpass() {
        return numpass;
    }

    public void setNumpass(String numpass) {
        this.numpass = numpass;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public Citoyen getCitoyen() {
        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {
        this.citoyen = citoyen;
    }
}
