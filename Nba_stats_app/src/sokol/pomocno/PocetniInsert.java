/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.pomocno;

import sokol.model.NbaTeam;
import sokol.model.Operater;
import sokol.model.Player;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Profesor
 */
public class PocetniInsert {

    public static void izvedi() {

        Session session = HibernateUtil.getSession();

        session.beginTransaction();

        kreirajOperatera(session);
       // NbaTeam nbaTeam = kreirajNbaTeam(session);
       // Player player = kreirajPlayera(session, nbaTeam);
        session.getTransaction().commit();
    }

    private static void kreirajOperatera(Session session) {
        Operater o = new Operater();
        o.setIme("Matej");
        o.setPrezime("Sokol");
        o.setEmail("sokolvm@gmail.com");
        o.setLozinka(Autorizacija.getHash("t"));
        session.save(o);
    }

   /* private static NbaTeam kreirajNbaTeam(Session session) {
        NbaTeam newTeam = new NbaTeam();
        newTeam.setName("Thunders");
        newTeam.setCity("Oklahoma");
        session.save(newTeam);
        return newTeam;
    }

    private static Player kreirajPlayera(Session session, NbaTeam nbaTeam) {
        Player newPlayer = new Player();
        newPlayer.setFirstname("Russel");
        newPlayer.setLastname("Westbrook");
        newPlayer.setNbaTeam(nbaTeam);
        newPlayer.setJerseynumber("0");
        newPlayer.setPosition("PG");
        session.save(newPlayer);
        return newPlayer;

    }*/

}
