package biblioteca.view;


import biblioteca.control.BibliotecaController;
import biblioteca.model.Carte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UI {

	private BufferedReader console;
	BibliotecaController bibliotecaController;
	
	public UI(BibliotecaController bibliotecaController){
		this.bibliotecaController = bibliotecaController;
	}
	
	public void executa() throws IOException {
		
		console = new BufferedReader(new InputStreamReader(System.in));
		
		int opt = -1;
		while(opt!=0){
			
			switch(opt){
				case 1:
					adauga();
					break;
				case 2:
					cautaCartiDupaAutor();
					break;
				case 3:
					afiseazaCartiOrdonateDinAnul();
					break;
				case 4:
					afiseazaToateCartile();
					break;
				case 5:
					stergeCarte();
					break;
			}
		
			printMenu();
			String line;
			do{
				System.out.println("Introduceti un nr:");
				line=console.readLine();
			}while(!line.matches("[0-5]"));
			opt=Integer.parseInt(line);
		}
	}
	
	public void printMenu(){
		System.out.println("\n");
		System.out.println("Evidenta cartilor dintr-o biblioteca");
		System.out.println("     1. Adaugarea unei noi carti");
		System.out.println("     2. Cautarea cartilor scrise de un anumit autor");
		System.out.println("     3. Afisarea cartilor din biblioteca care au aparut intr-un anumit an, ordonate alfabetic dupa titlu si autori");
		System.out.println("     4. Afisarea tuturor cartilor");
		System.out.println("     5. Stergerea unei carti dupa titlul acesteia");
		System.out.println("     0. Exit");
	}
	
	public void adauga(){
		Carte c = new Carte();
		try{
            System.out.println();
			System.out.println("Titlu: ");
			c.setTitlu(console.readLine());
			String line;
            do{
                System.out.println("Nr. de autori:");
                line=console.readLine();
            }while(!line.matches("[1-9]+"));
            int nrAutori= Integer.parseInt(line);
            for(int i=1;i<=nrAutori;i++){
                System.out.println("Autor "+i+": ");
                c.getAutori().add(console.readLine());
            }

			do{
				System.out.println("An aparitie:");
				line=console.readLine();
			}while(!line.matches("[0-9]+"));
			c.setAnAparitie(line);

            System.out.println("Editura: ");
            c.setEditura(console.readLine());
			
			do{
				System.out.println("Nr. de cuvinte cheie:");
				line=console.readLine();
			}while(!line.matches("[1-9]+"));
			int nrCuv= Integer.parseInt(line);
			for(int i=1;i<=nrCuv;i++){
				System.out.println("Cuvant "+i+": ");
				c.getCuvinteCheie().add(console.readLine());
			}
			bibliotecaController.adaugaCarte(c);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void stergeCarte(){
        try{
            System.out.println();
            System.out.println("Titlul cartii ce se doreste a fi stearsa: ");
            String titlu =console.readLine();
            List<Carte> cartiGasite=bibliotecaController.cautaCarteDupaTitlu(titlu);
            if(cartiGasite.size()==0){
                System.out.println("Nu exista carti in biblioteca cu acest titlu "+titlu+"!");
                return;
            }
            afiseazaCartile(cartiGasite);

            System.out.println("Alegeti id-ul cartii pe care doriti sa o stergeti");
            String line;
            do{
                System.out.println("Id:");
                line=console.readLine();
            }while(!line.matches("[0-9]+"));
            int id= Integer.parseInt(line);
            Carte deSters=null;
            for(Carte c: cartiGasite){
                if(c.getId()==id){
                    deSters=c;
                    break;
                }
            }
            if(deSters==null){
                System.out.println("Id-ul introdus "+id+"nu se regaseste in cartile gasite dupa titlu de mai sus!");
                return;
            }

            bibliotecaController.stergeCarte(deSters);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


	
	public void afiseazaToateCartile(){
		System.out.println();
		List<Carte> carti=bibliotecaController.getAllCarti();
        if(carti.size()==0){
            System.out.println("Nu exista carti in biblioteca!");
            return;
        }
		afiseazaCartile(carti);
	}

    private void afiseazaCartile(List<Carte> carti){
        System.out.println();
        for(Carte c: carti) {
            System.out.println(c);
        }
    }



	public void cautaCartiDupaAutor(){
		System.out.println();
		System.out.println("Autor:");
		try {
			List<Carte> carti=bibliotecaController.cautaCarteDupaAutor(console.readLine());
            if(carti.size()==0){
                System.out.println("Nu exista carti scrise de acest autor in biblioteca!");
                return;
            }
			afiseazaCartile(carti);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void afiseazaCartiOrdonateDinAnul(){
		System.out.println();
		try{
			String line;
			do{
				System.out.println("An aparitie:");
				line=console.readLine();
			}while(!line.matches("[0-9]+"));
			List<Carte> carti= bibliotecaController.getCartiOrdonateDinAnul(line);
			if(carti.size()==0){
                System.out.println("Nu exita in biblioteca carti aparute in acest an "+line+"!");
                return;
            }
			afiseazaCartile(carti);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
