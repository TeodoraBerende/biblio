package biblioteca.repository;

import biblioteca.model.Carte;

import java.util.List;

public interface IRepository {
    void adaugaCarte(Carte c);
    List<Carte> getAllCarti();
    List<Carte> cautaCarteDupaAutor(String autor);
    List<Carte> getCartiOrdonateDinAnul(String an);
    List<Carte> cautaCarteDupaTitlu(String titlu);
    void stergeCarte(Carte c);
}
