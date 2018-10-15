package sokol.pomocno;

public class NbaException extends Exception{

    private String poruka;
    
    public NbaException(String poruka){
        super();
        this.poruka=poruka;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
}