package sokol.pomocno;

public class Kontrola {

   public static void stringNijePrazan(String s,String poruka) throws NbaException{
        if(s==null || s.isEmpty()){
            throw new NbaException("Name required");
            
        }
        
    }
}