package biblioteca.control;


import biblioteca.model.Carte;
import biblioteca.repository.CartiRepository;
import biblioteca.repository.IRepository;
import biblioteca.util.Validator;

import java.util.List;

public class BibliotecaController {

	private IRepository repositoryCarti;
	
	public BibliotecaController(IRepository cr){
		this.repositoryCarti = cr;
	}
	
	public void adaugaCarte(Carte c) throws Exception{
		Validator.validateCarte(c);
		repositoryCarti.adaugaCarte(c);
	}

	public List<Carte> cautaCarteDupaTitlu(String titlu){
		return repositoryCarti.cautaCarteDupaTitlu(titlu);
	}
	
	/*public void modificaCarte(Carte nou, Carte vechi) throws Exception{
		repositoryCarti.modificaCarte(nou, vechi);
	}*/
	
	public void stergeCarte(Carte c){
		repositoryCarti.stergeCarte(c);
	}

	public List<Carte> cautaCarteDupaAutor(String autor) throws Exception{
		if(!Validator.isOKString(autor)){
		    throw new Exception("Numele autorului este invalid "+autor+"!");
        }
		return repositoryCarti.cautaCarteDupaAutor(autor);
	}
	
	public List<Carte> getAllCarti(){
		return repositoryCarti.getAllCarti();
	}
	
	public List<Carte> getCartiOrdonateDinAnul(String an) throws Exception{
		if(!Validator.isNumber(an))
			throw new Exception("Anul nu e numar!");
		return repositoryCarti.getCartiOrdonateDinAnul(an);
	}
	
}
