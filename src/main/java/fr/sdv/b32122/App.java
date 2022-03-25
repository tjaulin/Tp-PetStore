package fr.sdv.b32122;

import fr.sdv.b32122.bo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "petstore" );
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Product product1 = new Product("17895", "Steak", ProdType.FOOD, 2.0);
        Product product2 = new Product("45893", "unTruc", ProdType.CLEANING, 2.0);
        Product product3 = new Product("00561", "unAccessoire", ProdType.ACCESSORY, 6.0);

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);

        Address adresse1 = new Address("5", "rue du bois", "35000", "Rennes");
        Address adresse2 = new Address("2", "rue de la forêt", "35135", "Chantepie");
        Address adresse3 = new Address("45", "route du moulin", "44000", "Nantes");

        em.persist(adresse1);
        em.persist(adresse2);
        em.persist(adresse3);

        PetStore petstore1 = new PetStore("CatStore", "Romain");
        petstore1.addProducts(product1);
        product1.addPetStore(petstore1);
        adresse1.setPetStore(petstore1);
        petstore1.setAddress(adresse1);

        PetStore petstore2 = new PetStore("AnimalsStore", "Jennifer");
        petstore2.addProducts(product2);
        product2.addPetStore(petstore2);
        adresse2.setPetStore(petstore2);
        petstore2.setAddress(adresse2);

        PetStore petstore3 = new PetStore("DogStore", "Antoine");
        petstore3.addProducts(product3);
        product3.addPetStore(petstore3);
        petstore3.setAddress(adresse3);
        adresse3.setPetStore(petstore3);


        em.persist(petstore1);
        em.persist(petstore2);
        em.persist(petstore3);

        Date birthFish1 = new Date(2021,5,6);
        Date birthFish2 = new Date(2018,12,15);
        Date birthFish3 = new Date(2014,6,24);
        Fish poisson1 = new Fish(birthFish1, "Orange", FishLivEnv.SEA_WATER);
        poisson1.setPetStore(petstore1);
        Fish poisson2 = new Fish(birthFish2, "Vert", FishLivEnv.SEA_WATER);
        poisson2.setPetStore(petstore2);
        Fish poisson3 = new Fish(birthFish3, "Jaune", FishLivEnv.FRESH_WATER);
        poisson3.setPetStore(petstore2);

        em.persist(poisson1);
        em.persist(poisson2);
        em.persist(poisson3);

        Date birthCat1 = new Date(2014, 2, 1);
        Date birthCat2 = new Date(2017, 4, 27);
        Date birthCat3 = new Date(2010, 7, 22);
        Cat chat1 = new Cat(birthCat1, "Gris", "5");
        chat1.setPetStore(petstore1);
        Cat chat2 = new Cat(birthCat2, "Blanc", "2");
        chat2.setPetStore(petstore3);
        Cat chat3 = new Cat(birthCat3, "Noir", "3");
        chat3.setPetStore(petstore1);

        em.persist(chat1);
        em.persist(chat2);
        em.persist(chat3);

        //NE FONCTIONNE PAS
        /*
        System.out.println("###DEBUT###");
        PetStore p = em.find(PetStore.class, 1l);
        for (Animal animals : p.getAnimals()) {
            System.out.println(animals);
        }
        System.out.println("###FIN###");*/

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
