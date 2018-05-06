package biblioteca.repository;

import biblioteca.model.Carte;
import biblioteca.util.Validator;
import org.junit.jupiter.api.BeforeAll;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CartiRepositoryTest {

    static CartiRepositoryMock repositoryMock;

    @BeforeAll
    static void init() {
        repositoryMock=new CartiRepositoryMock();
    }

    @org.junit.jupiter.api.Test
    void TC1_ECP() {
        Carte c=new Carte("1984", Arrays.asList("George Orwell"),"1949","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            int maximBefore=repositoryMock.getMaxim();
            repositoryMock.adaugaCarte(c);
            int maximAfter=repositoryMock.getMaxim();
            System.out.println(maximBefore);
            System.out.println(maximAfter);
            assert ((maximBefore==maximAfter-1));
            System.out.println("TC1_ECP -> Carte adaugata");
        }catch (Exception ex){
            System.out.println("TC1_ECP -> " + ex.getMessage());
            assert (false);
        }
    }

    @org.junit.jupiter.api.Test
    void TC3_ECP() {
        Carte c=new Carte("", Arrays.asList("George Orwell"),"1949","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            repositoryMock.adaugaCarte(c);
            System.out.println("TC3_ECP -> Carte adaugata");
            assert(false);
        }catch (Exception ex){
            System.out.println("TC3_ECP -> " + ex.getMessage());
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC5_ECP() {
        Carte c=new Carte("1984", Arrays.asList("1"),"1949","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            repositoryMock.adaugaCarte(c);
            System.out.println("TC5_ECP -> Carte adaugata");
            assert(false);
        }catch (Exception ex){
            System.out.println("TC5_ECP -> " + ex.getMessage());
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC6_ECP() {
        Carte c=new Carte("1984", Arrays.asList("George Orwell"),"asdf","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            repositoryMock.adaugaCarte(c);
            System.out.println("TC6_ECP -> Carte adaugata");
            assert(false);
        }catch (Exception ex){
            System.out.println("TC6_ECP -> " + ex.getMessage());
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC8_ECP() {
        Carte c=new Carte("1984", Arrays.asList("George Orwell"),"1949","198",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            repositoryMock.adaugaCarte(c);
            System.out.println("TC8_ECP -> Carte adaugata");
            assert(false);
        }catch (Exception ex){
            System.out.println("TC8_ECP -> " + ex.getMessage());
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC31_BVA() {
        Carte c=new Carte("1984", Arrays.asList("1"),"1949","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            repositoryMock.adaugaCarte(c);
            System.out.println("TC31_BVA -> Carte adaugata");
            assert(false);
        }catch (Exception ex){
            System.out.println("TC31_BVA -> " + ex.getMessage());
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC7_BVA() {
        Carte c=new Carte("1984", new ArrayList<String>(),"1949","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            repositoryMock.adaugaCarte(c);
            System.out.println("TC7_BVA -> Carte adaugata");
            assert(false);
        }catch (Exception ex){
            System.out.println("TC7_BVA -> " + ex.getMessage());
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC25_BVA() {
        Carte c=new Carte("1984", Arrays.asList("George Orwell"),"1949","Penguin Books",new ArrayList<String>());
        try {
            Validator.validateCarte(c);
            repositoryMock.adaugaCarte(c);
            System.out.println("TC25_BVA -> Carte adaugata");
            assert(false);
        }catch (Exception ex){
            System.out.println("TC25_BVA -> " + ex.getMessage());
            assert (true);
        }
    }

    @org.junit.jupiter.api.Test
    void TC27_BVA() {
        Carte c=new Carte("1984", Arrays.asList("George Orwell"),"1949","Penguin Books",Arrays.asList("politic"));
        try {
            Validator.validateCarte(c);
            int maximBefore=repositoryMock.getMaxim();
            repositoryMock.adaugaCarte(c);
            int maximAfter=repositoryMock.getMaxim();
            assert ((maximBefore==maximAfter-1));
            System.out.println("TC27_BVA -> Carte adaugata");
            assert(true);
        }catch (Exception ex){
            System.out.println("TC27_BVA -> " + ex.getMessage());
            assert (false);
        }
    }

    @org.junit.jupiter.api.Test
    void TC13_BVA() {
        Carte c=new Carte("1984", Arrays.asList("George Orwell"),"1949","Penguin Books",Arrays.asList("politic","totalitarism"));
        try {
            Validator.validateCarte(c);
            int maximBefore=repositoryMock.getMaxim();
            repositoryMock.adaugaCarte(c);
            int maximAfter=repositoryMock.getMaxim();
            assert ((maximBefore==maximAfter-1));
            System.out.println("TC13_BVA -> Carte adaugata");
            assert(true);
        }catch (Exception ex){
            System.out.println("TC13_BVA -> " + ex.getMessage());
            assert (false);
        }
    }


}