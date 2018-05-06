package biblioteca.repository;


import biblioteca.model.Carte;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartiRepository implements IRepository{
	
	private String file = "src/main/resources/cartiBD.txt";
	private List<Carte> carti=new ArrayList<Carte>();
	private int maxim=1;
	
	public CartiRepository(){
		//URL location = CartiRepository.class.getProtectionDomain().getCodeSource().getLocation();
        //System.out.println(location.getFile());
		readCartifromFile();
        for (Carte c:carti){
            if(c.getId()>maxim){
                maxim=c.getId();
            }
        }
    }
	
	public void adaugaCarte(Carte c) {
		BufferedWriter bw = null;
        maxim++;
		c.setId(maxim);
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(c.toString());
			bw.newLine();
			
			bw.close();
			carti.add(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Rescrie toata lista de carti in fisier
	private void scrieCartiFisier(){
        BufferedWriter bw = null;
        for(Carte c: carti){
            System.out.println(c);
        }
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for(Carte c: carti) {
                bw.write(c.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private void readCartifromFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=br.readLine())!=null){
				carti.add(Carte.getCarteFromString(line));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
            e.printStackTrace();
        }
	}

	public List<Carte> getAllCarti() {
		return carti;
	}

	public List<Carte> cautaCarteDupaTitlu(String titlu){
        List<Carte> cartiGasite = new ArrayList<Carte>();
        int i=0;
        for(Carte c:carti){
            if(c.getTitlu().toLowerCase().equals(titlu.toLowerCase())){
                cartiGasite.add(c);
            }
        }
        return cartiGasite;
    }

    public void stergeCarte(Carte c){
	    carti.remove(c);

	    scrieCartiFisier();
    }

	public List<Carte> cautaCarteDupaAutor(String autor) {
		List<Carte> cartiGasite = new ArrayList<Carte>();
		int i=0;
		while (i<carti.size()) {
            boolean flag = false;
            List<String> autori = carti.get(i).getAutori();
            int j = 0;
            while (j < autori.size() && !flag) {
                String[] nume = autori.get(j).split(" ");
                for (String numeAutor : nume) {
                    if (numeAutor.length() >= autor.length()) {
                        if (numeAutor.toLowerCase().substring(0, autor.length()).equals(autor.toLowerCase())) {
                            flag = true;
                        }
                    }
                }
                j++;
            }
            if (flag == true) {
                cartiGasite.add(carti.get(i));
            }
            i++;
        }
		return cartiGasite;
	}

    /***
     * Returneaza toata cartile dintr-un an, ordonate alfabetic dupa titlu si dupa autor
     * @param an - anul din care se doresc cartile
     * @return - o lista cu cartile din acel an ordonate alfabetic dupa titlu; daca au acelasi titlu se compara
     * autorii ambelor carti pana cand se gaseste o diferenta intre 2 autori saupana cand lista de autori a unei
     * carti se termina, moment in care cartea cu mai putini autori se alege sa fie in fata celelailte
     */

	public List<Carte> getCartiOrdonateDinAnul(String an) {
        List<Carte> cartiGasite = new ArrayList<Carte>();
        for (Carte c : carti) {
            if (c.getAnAparitie().equals(an)) {
                cartiGasite.add(c);
            }
        }
        Collections.sort(cartiGasite, new Comparator<Carte>() {

            @Override
            public int compare(Carte a, Carte b) {
                if (a.getTitlu().compareTo(b.getTitlu()) == 0) {
                    int i = 0, j = 0;
                    while (i < a.getAutori().size() && j < b.getAutori().size()) {
                        if (a.getAutori().get(i).compareTo(b.getAutori().get(j)) == 0) {
                            i++;
                            j++;
                        } else {
                            return a.getAutori().get(i).compareTo(b.getAutori().get(j));
                        }
                    }
                    if (i + 1 == a.getAutori().size() && j + 1 == b.getAutori().size()) {
                        return 0;
                    }
                    if (i + 1 == a.getAutori().size()) {
                        return 1;
                    }
                    if (j + 1 == b.getAutori().size()) {
                        return -1;
                    }
                }

                return a.getTitlu().compareTo(b.getTitlu());
            }

        });

        return cartiGasite;
    }
}
