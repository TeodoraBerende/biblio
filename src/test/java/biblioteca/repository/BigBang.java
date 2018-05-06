package biblioteca.repository;

import biblioteca.model.Carte;
import biblioteca.util.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BigBang {
    static CartiRepositoryMock repositoryMock;

    @BeforeAll
    static void init() {
        repositoryMock=new CartiRepositoryMock();
    }

    @Test
    void cerinta1_adaugaCarte() {
        Carte c=new Carte("1984", Arrays.asList("George Orwell"),"1949","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            int maximBefore=repositoryMock.getMaxim();
            repositoryMock.adaugaCarte(c);
            int maximAfter=repositoryMock.getMaxim();
            System.out.println(maximBefore);
            System.out.println(maximAfter);
            assert ((maximBefore==maximAfter-1));
        }catch (Exception ex){
            assert (false);
        }
    }



    @Test
    void cerinta2_cautaAutor() {
        List<Carte> cartiTest=new ArrayList<Carte>();
        cartiTest.add(new Carte(1,"Povesti", Arrays.asList("Mihai Eminescu","Ion Caragiale","Ion Creanga"),"1973","Corint",Arrays.asList("povesti","povestiri")));
        cartiTest.add(new Carte(4,"Povesti", Arrays.asList("Mihai Eminescu","Ion Creanga","Tudor"),"1990","Corint",Arrays.asList("povesti","povestiri")));

        List<Carte> cartiGasite=repositoryMock.cautaCarteDupaAutor("ion");

        if(cartiGasite.equals(cartiTest)){
            assert true;
        }
        else{
            assert (false);
        }

    }



    @Test
    void cerinta3_cautaAn() {
        List<Carte> cartiTest = new ArrayList<Carte>();
        cartiTest.add(new Carte(2, "Poezii", Arrays.asList("Sadoveanu"), "1973", "Corint", Arrays.asList("poezii")));
        cartiTest.add(new Carte(1, "Povesti", Arrays.asList("Mihai Eminescu", "Ion Caragiale", "Ion Creanga"), "1973", "Corint", Arrays.asList("povesti", "povestiri")));

        List<Carte> cartiGasite = repositoryMock.getCartiOrdonateDinAnul("1973");

        if (cartiGasite.equals(cartiTest)) {
            assert true;
        } else {
            assert (false);
        }
    }

    @Test
    void integrare(){
        cerinta1_adaugaCarte();
        cerinta2_cautaAutor();
        cerinta3_cautaAn();
    }



}