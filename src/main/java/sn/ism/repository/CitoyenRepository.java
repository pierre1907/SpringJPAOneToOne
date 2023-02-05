package sn.ism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.domaine.Citoyen;

public interface CitoyenRepository extends JpaRepository <Citoyen, String >{
    public Citoyen findByNumci(String numeroCi);
}
