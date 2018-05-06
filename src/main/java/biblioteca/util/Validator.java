package biblioteca.util;

import biblioteca.model.Carte;

import java.util.Arrays;

public class Validator {
	public static void validateCarte(Carte c)throws Exception{
		if(c.getTitlu().length()<3) {
			throw new Exception("Titlu invalid! " + c.getTitlu());
		}
		if(c.getAutori().isEmpty()){
			throw new Exception("Lista autori vida!");
		}
		for(String s:c.getAutori()){
			if(!isOKString(s))
				throw new Exception("Autor invalid! "+s);
		}
		if(!isNumber(c.getAnAparitie()))
			throw new Exception("Anul aparitiei invalid! "+c.getAnAparitie());
		if(Integer.parseInt(c.getAnAparitie())<1800)
			throw new Exception("Anul aparitiei invalid! Trebuie sa fie mai mare de 1800! "+c.getAnAparitie());
		if(c.getEditura().length()<3){
			throw new Exception("Editura invalida! "+c.getEditura());
		}
		if(!isOKString(c.getEditura())){
			throw new Exception("Editura invalida! "+c.getEditura());
		}
		if(c.getCuvinteCheie().isEmpty()){
			throw new Exception("Lista cuvinte cheie vida!");
		}
		for(String s:c.getCuvinteCheie()){
			if(!isOKString(s))
				throw new Exception("Cuvant cheie invalid! "+s);
		}
	}
	
	public static boolean isNumber(String s){
		return s.matches("[0-9]+");
	}

    /***
     * Verifica ca numele unui autor sa nu contina cifre si sa nu fie vid
     * @param s-numele verificat
     * @return - true daca este corect, false altfel
     */
	public static boolean isOKString(String s){
		String []strings = s.split(" ");
		if(strings.length>1){
		    for(String string:strings){
		        boolean ok=string.matches("[a-zA-Z]+");
		        if(!ok) {
                    return false;
                }
            }
            return true;
		}
		else {
            return s.matches("[a-zA-Z]+");
        }
	}
	
}
