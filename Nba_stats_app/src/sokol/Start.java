package sokol;

// domaća zadaća:


import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;
import javax.swing.UIManager;
import sokol.pomocno.PocetniInsert;
import sokol.view.Loading;

//upogoniti Hibernate prateći https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-maven-example/
public class Start {

    public static void main(String[] args) {
       
//PocetniInsert.izvedi();
//new Loading().setVisible(true);
try {
            UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
                    new Loading().setVisible(true);

        } catch (Exception e) {
}

        
    }
    
}
