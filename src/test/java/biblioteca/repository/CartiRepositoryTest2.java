package biblioteca.repository;

import biblioteca.model.Carte;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartiRepositoryTest2 {
    static CartiRepositoryMock repositoryMock;

    @BeforeAll
    static void init() {
        repositoryMock=new CartiRepositoryMock();
    }

    @Test
    void cautaCarteDupaAutor1() {
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
    void cautaCarteDupaAutor2() {
        List<Carte> cartiTest=new ArrayList<Carte>();
        List<Carte> cartiGasite=repositoryMock.cautaCarteDupaAutor("lalalalalala");

        if(cartiGasite.equals(cartiTest)){
            assert true;
        }
        else{
            assert (false);
        }

    }

    @Test
    void cautaCarteDupaAutor3() {
        repositoryMock.removeAll();
        List<Carte> cartiGasite=repositoryMock.cautaCarteDupaAutor("ion");

        if(cartiGasite.isEmpty()){
            assert true;
        }
        else{
            assert (false);
        }

    }


}