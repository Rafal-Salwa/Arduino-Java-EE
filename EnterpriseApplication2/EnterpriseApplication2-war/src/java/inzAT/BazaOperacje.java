/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inzAT;

import baza.Uzytkownik;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Salwa2
 */
public class BazaOperacje {

    public EntityManager emq = javax.persistence.Persistence.createEntityManagerFactory("EnterpriseApplication2-warPU").createEntityManager();

    public String zaloguj(String id) {
        try {
            emq.getTransaction().begin();
            Query jpqlQuery = emq.createNamedQuery("Uzytkownik.findByLogin");
            Uzytkownik uz = (Uzytkownik) jpqlQuery.setParameter("login", id).getSingleResult();
            emq.getTransaction().commit();

            int upr = uz.getUprawnienia();
            return "user id= " + uz.getId() + " login= " + uz.getLogin() + " haslo= " + uz.getHaslo() + " upr= " + uz.getUprawnienia();
        } catch (NoResultException ex) {
            return "nie poprawne dane";
        }

    }

}
