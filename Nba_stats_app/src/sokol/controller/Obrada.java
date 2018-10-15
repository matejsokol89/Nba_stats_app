package sokol.controller;

import java.util.ArrayList;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import sokol.model.Entitet;
import sokol.pomocno.HibernateUtil;
import org.hibernate.Session;

public abstract class Obrada<T extends Entitet> {

   protected Session session;
      public abstract List<T> getEntiteti();

    
    public  Obrada(){
        session=HibernateUtil.getSession();
    }
    
     public List<Entitet> getListEntitet(){
        List<T> lista = getEntiteti();
        List<Entitet> vrati = new ArrayList<>();
        lista.forEach((l)->{vrati.add((l));});
       return vrati;
    }
   
    
    protected void spremi(Entitet e){
        //System.out.println(e.getClass().toString());
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();
    }
   
    public void obrisi(Entitet e){
        session.beginTransaction();
        session.delete(e);
        session.getTransaction().commit();
    }
    
}