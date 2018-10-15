package sokol.controller;

import sokol.model.Player;
import sokol.pomocno.NbaException;
import java.util.List;

public class ObradaPlayer extends Obrada implements ObradaInterface<Player> {

    public List<Player> getEntiteti() {
        return session.createQuery(" from Player").list();
    }

    public List<Player> getEntiteti(String uvjet) {
        return session.createQuery(" from Player e where "
                + " concat(e.firstname, ' ', e.lastname) like :uvjet")
                .setString("uvjet", "%" + uvjet + "%")
                .list();
    }

    @Override
    public Player dodaj(Player e) throws NbaException {
        
        kontrola(e);
        spremi(e);
        return e;
    }

    @Override
    public Player promjena(Player e) throws NbaException {
        
        kontrola(e);
        spremi(e);
        return e;
    }

    private void kontrola(Player e) throws NbaException {

        if (e.getFirstname().trim().isEmpty()) {
            throw new NbaException("First name required");
        }

        if (e.getLastname().trim().isEmpty()) {
            throw new NbaException("Last name required");
        }

    }

}
