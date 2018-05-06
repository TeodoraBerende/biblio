package biblioteca.model;


import java.util.ArrayList;
import java.util.List;

public class Carte {
	
	private int id;
	private String titlu;
	private List<String> autori;
	private String anAparitie;
	private String editura;
	private List<String> cuvinteCheie;
	
	public Carte(){
		autori = new ArrayList<String>();
		cuvinteCheie = new ArrayList<String>();
	}

	public Carte(String titlu, List<String> autori, String an, String editura, List<String> cuvinteCheie){
		this.titlu=titlu;
		this.autori=autori;
		anAparitie=an;
		this.editura=editura;
		this.cuvinteCheie=cuvinteCheie;
	}

	public Carte(int id,String titlu, List<String> autori, String an, String editura, List<String> cuvinteCheie){
		this.id=id;
		this.titlu=titlu;
		this.autori=autori;
		anAparitie=an;
		this.editura=editura;
		this.cuvinteCheie=cuvinteCheie;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public List<String> getAutori() {
		return autori;
	}

	public void setAutori(List<String> ref) {
		this.autori = ref;
	}

	public String getAnAparitie() {
		return anAparitie;
	}

	public void setAnAparitie(String anAparitie) {
		this.anAparitie = anAparitie;
	}

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public List<String> getCuvinteCheie() {
		return cuvinteCheie;
	}

	public void setCuvinteCheie(List<String> cuvinteCheie) {
		this.cuvinteCheie = cuvinteCheie;
	}

	/*public void deleteCuvantCheie(String cuvant){
			for(int i=0;i<cuvinteCheie.size();i++){
				if(cuvinteCheie.get(i).equals(cuvant)){
					cuvinteCheie.remove(i);
					return;
				}
			}
	}
	
	public void deleteAutor(String autor){
			for(int i=0;i<autori.size();i++){
				if(autori.get(i).equals(autor)){
					autori.remove(i);
					return;
				}
			}
	}
	
	public void deleteTotiReferentii(){
		autori.clear();
	}
	
	public void adaugaCuvantCheie(String cuvant){
		cuvinteCheie.add(cuvant);
	}
	
	public void adaugaReferent(String ref){
		autori.add(ref);
	}
	
	public boolean cautaDupaCuvinteCheie(List<String> cuvinte){
		for(String c:cuvinteCheie){
			for(String cuv:cuvinte){
				if(c.equals(cuv))
					return true;
			}
		}
		return false;
	}
	 
	public boolean cautaDupaAutor(String autor){
		for(String a:autori){
			if(a.contains(autor))
				return true;
		}
		return false;
	}*/
	
	@Override
	public String toString(){
		String autor = "";
		String cuvCheie = "";
		
		for(int i=0;i<autori.size();i++){
			if(i==autori.size()-1)
				autor+=autori.get(i);
			else
				autor+=autori.get(i)+",";
		}
		
		for(int i=0;i<cuvinteCheie.size();i++){
			if(i==cuvinteCheie.size()-1)
				cuvCheie+=cuvinteCheie.get(i);
			else
				cuvCheie+=cuvinteCheie.get(i)+",";
		}
		
		return id+";"+ titlu+";"+autor+";"+anAparitie+";"+editura+";"+cuvCheie;
	}

    public static Carte getCarteFromString(String carte) throws Exception {
        Carte c = new Carte();
        String []atr = carte.split(";");
        String []autori = atr[2].split(",");
        String []cuvCheie = atr[5].split(",");
        try {
            c.id = Integer.parseInt(atr[0]);
        }catch (Exception e){
            throw new Exception("Id-ul cartii cu titlul "+atr[1]+" nu este numar natural "+atr[0]);
        }
        c.titlu=atr[1];
        for(String s:autori){
            c.autori.add(s);
        }
        c.anAparitie = atr[3];
        c.editura=atr[4];
        for(String s:cuvCheie){
            c.cuvinteCheie.add(s);
        }
        return c;
    }

	@Override
	public boolean equals(Object obj) {
		if(id==((Carte)obj).id){
			return true;
		}
		return false;
	}
}
