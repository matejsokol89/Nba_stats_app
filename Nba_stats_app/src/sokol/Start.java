package sokol;

// domaća zadaća:


import com.birosoft.liquid.LiquidLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;
import sokol.view.Loading;


//upogoniti Hibernate prateći https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-maven-example/
public class Start {

    public static void main(String[] args) {
       
//PocetniInsert.izvedi();
//new Loading().setVisible(true);
try {
            UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());
       EventQueue.invokeLater(() -> new Loading().setVisible(true));

        } catch (Exception e) {
}

        
    }
    
}
