package co;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.hibernate.*;

import co.logic.DatabaseManager;
import co.logic.dao.Dietary;

import co.utilities.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.build.AllowSysOut;


public class Main {
    public static void main(String[] args) {

        /*Session s = HibernateUtil.getSessionFactory().openSession();
        Dietary d = new Dietary();
        d.setName("vegan");
        s.persist(d);
        s.close();*/

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("culinary-organizer");
        EntityManager em = emf.createEntityManager();

        System.out.println("Program started");

        DatabaseManager dm = new DatabaseManager();
        List<Dietary> dList = new ArrayList<Dietary>(dm.getAllDietaryTypes());

        for(Iterator<Dietary> i = dList.listIterator(); i.hasNext();) {
            Dietary d = i.next();
            System.out.println("Dietary id: " + d.getId() + ", name: " + d.getName());
        }

        /*em.getTransaction().begin();
        Dietary d = new Dietary();
        d.setName("vegan");
        em.persist(d);
        em.getTransaction().commit();
        //em.close();
        System.out.println("Created: id: " + String.valueOf(d.getId()) + ", name: " + d.getName());

        //em = emf.createEntityManager();
        Dietary retrieved = em.find(Dietary.class, 1);
        if(retrieved != null)
            System.out.println("Retrieved: id: " + String.valueOf(retrieved.getId()) + ", name: " + retrieved.getName());
        else
            System.out.println("Retrieved: null");*/


        em.close();
        System.out.println("Program finished");



		/*Ingredient i = new Ingredient.Builder("a", null).decription("desc").build();
		System.out.println("Create: id: " + String.valueOf(i.getId()) + ", decription: " + i.getDescription());
		Ingredient i2 = new Ingredient.Builder("a", null).decription("desc").build();
		System.out.println("Create2: id: " + String.valueOf(i2.getId()) + ", decription: " + i2.getDescription());
		i2.setDecrption("dec_new");
		System.out.println("Update: id: " + String.valueOf(i2.getId()) + ", decription: " + i2.getDescription());*/

        String str;
        List<String> l = new ArrayList();


        ////////////////emf.close();
    }
}