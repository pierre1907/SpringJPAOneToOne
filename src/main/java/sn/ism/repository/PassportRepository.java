package sn.ism.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ism.domaine.Passport;

public interface PassportRepository  extends JpaRepository<Passport,String >{

    public Passport findByNumpass(String numero);
}
