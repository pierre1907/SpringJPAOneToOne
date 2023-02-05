package sn.ism.domaine;

import jakarta.persistence.*;

import java.io.Serializable;
//Entite Père
@Entity
@Table(name="citoyens")
public class Citoyen implements Serializable
{
    @Id
    @Column(length = 50)
    private String numci;
    @Column(length = 25)

    private String nom;
    @Column(length = 50)

    private String prenom;
    @OneToOne(mappedBy="citoyen" ,cascade=CascadeType.ALL)
    private Passport passport;


    public Citoyen(String nom)
    {

    }

    public Citoyen() {
        
    }

    public String getNumci() {
        return numci;
    }

    public void setNumci(String numci) {
        this.numci = numci;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
