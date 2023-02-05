package sn.ism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.ism.domaine.Citoyen;
import sn.ism.domaine.Passport;
import sn.ism.repository.CitoyenRepository;
import sn.ism.repository.PassportRepository;

@SpringBootApplication
public class SpringDataJpaOneToOneApplication implements CommandLineRunner
{
	@Autowired
	private CitoyenRepository crepo;
	@Autowired
	private PassportRepository prepo;


	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaOneToOneApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		sauver();
		//searchNumci();
		//searchNumpass();
		//deleteCitoyen();
		deletePassport();
	}
	
	public void sauver()
	{
		//saving pair entities instance
		Citoyen c1 = new Citoyen();
		c1.setNumci("CI1907");
		c1.setNom("Kassi");
		c1.setPrenom("Dos Santos-Pereira");
		crepo.save(c1);

		Citoyen c2 = new Citoyen();
		c2.setNumci("TG0924");
		c2.setNom("Etudiany 2");
		c2.setPrenom("Prenom etu 2");
		crepo.save(c2);

		Passport p1 = new Passport();
		p1.setNumpass("09RR12323");
		p1.setTp("PD");

		Passport p2 = new Passport();
		p2.setNumpass("22AI34161");
		p2.setTp("PP");

		//asso bi-directionnel entre pass et citoyen
		c1.setPassport(p1);
		p1.setCitoyen(c1);

		c2.setPassport(p2);
		p2.setCitoyen(c2);

		//save children entities instances
		prepo.save(p1);
		prepo.save(p2);
	}


	public void searchNumci()
	{
		Citoyen ct = crepo.findByNumci("TG0904");
		if (ct==null){
			System.out.println("Ce numéro de citoyen n'existe pas ");
		}
		else{
			System.out.println("__________________________");
			System.out.println("Numéro de CI: " + ct.getNumci());
			System.out.println("Nom du citoyen: " + ct.getNom());
			System.out.println("Prenom du citoyen: " + ct.getPrenom());
			System.out.println("Numero du passeport: " + ct.getPassport().getNumpass());
			System.out.println("Type de passeport: " + ct.getPassport().getTp());
		}
		System.out.println("__________________________");

	}

	public void searchNumpass()
	{
		Passport ps = prepo.findByNumpass("09RR12323");
		System.out.println("__________________________");
		if (ps==null){
			System.out.println("Ce passeport n'existe pas ");
		}
		else{
			System.out.println("Numero du passeport: " + ps.getNumpass());
			System.out.println("Type de passeport: " + ps.getTp());
			System.out.println("Numéro du citoyen: " + ps.getCitoyen().getNumci());
			System.out.println("Nom du citoyen: " + ps.getCitoyen().getNom());
			System.out.println("Prenom du citoyen: " + ps.getCitoyen().getPrenom());
		}
		System.out.println("__________________________");

	}

	public void deleteCitoyen()
	{
		Citoyen ct = crepo.findByNumci("TG0904");
		System.out.println("__________________________");
		if (ct==null){
			System.out.println("Ce numéro de citoyen n'existe pas ");
		}else {
			crepo.delete(ct);
			System.out.println("Citoyen supprimé avec succès");
		}
		System.out.println("__________________________");
	}

	public void deletePassport()
	{
		Passport ps = prepo.findByNumpass("09RR12323");
		System.out.println("__________________________");
		if (ps==null){
			System.out.println("The passport doesn't exist");
		}else {
			//supprimer le lien entre le citoyen et le passport
			Citoyen cit = ps.getCitoyen();
			ps.setCitoyen(null);
			crepo.save(cit);
			prepo.delete(ps);
			System.out.println("Delete done !!");
		}
		System.out.println("__________________________");
	}

}
