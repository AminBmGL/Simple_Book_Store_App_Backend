package livre.applivre.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import livre.applivre.domain.Categorie;
import livre.applivre.domain.Livre;
import livre.applivre.repository.CategorieRepository;
import livre.applivre.repository.LivreRepository;

@Component
public class Bootstrap implements CommandLineRunner{

    private final CategorieRepository categoryRespository;
    private final LivreRepository livreRepository;


	public Bootstrap(CategorieRepository categoryRespository, LivreRepository livreRepository) {
		super();
		this.categoryRespository = categoryRespository;
		this.livreRepository = livreRepository;
	}


	@Override
    public void run(String... args) throws Exception {
        
        loadBooks();
       
    }
	
	private void loadBooks() {
		
		if(categoryRespository.count()==0) {
			Categorie categorie1=new Categorie("IpMan","Action",10,15);
			categorie1=categoryRespository.save(categorie1);
			
			Categorie categorie2=new Categorie("Jackie Chan","Action",10,20);
			categorie2=categoryRespository.save(categorie2);
			
			Categorie categorie3=new Categorie("Angular","Computer Science",10,50);
			categorie3=categoryRespository.save(categorie3);
			
			Livre livre=new Livre(false,categorie1);
			livreRepository.save(livre);
			
			Livre livre2=new Livre(false,categorie2);
			
			livreRepository.save(livre2);

			Livre livre3=new Livre(false,categorie3);
			livreRepository.save(livre3);
			
			Livre livre4=new Livre(false,categorie1);
			livreRepository.save(livre4);

			Livre livre5=new Livre(false,categorie1);
			livreRepository.save(livre5);


		}
	
	}
}
