package biblioteca.repository;

import biblioteca.model.Carte;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartiRepositoryTest3 {
    static CartiRepositoryMock repositoryMock;

    @BeforeAll
    static void init() {
        repositoryMock=new CartiRepositoryMock();
    }
    @Test
    void getCartiOrdonateDinAnul1() {
        List<Carte> cartiTest=new ArrayList<Carte>();
        cartiTest.add(new Carte(1,"Povesti", Arrays.asList("Mihai Eminescu","Ion Caragiale","Ion Creanga"),"1973","Corint",Arrays.asList("povesti","povestiri")));
        cartiTest.add(new Carte(2,"Poezii", Arrays.asList("Sadoveanu"),"1973","Corint",Arrays.asList("poezii")));
        List<Carte> cartiGasite=repositoryMock.getCartiOrdonateDinAnul("1973");

        if(cartiGasite.equals(cartiTest)){
            assert (false);
        }
        else{
            assert (true);
        }

    }

    @Test
    void getCartiOrdonateDinAnul2() {
        List<Carte> cartiTest=new ArrayList<Carte>();
        cartiTest.add(new Carte(2,"Poezii", Arrays.asList("Sadoveanu"),"1973","Corint",Arrays.asList("poezii")));
        cartiTest.add(new Carte(1,"Povesti", Arrays.asList("Mihai Eminescu","Ion Caragiale","Ion Creanga"),"1973","Corint",Arrays.asList("povesti","povestiri")));

        List<Carte> cartiGasite=repositoryMock.getCartiOrdonateDinAnul("1973");

        if(cartiGasite.equals(cartiTest)){
            assert true;
        }
        else{
            assert (false);
        }

    }
}