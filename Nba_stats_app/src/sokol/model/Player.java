package sokol.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Sokol
 */
@Entity

public class Player extends Entitet implements Serializable {

    private String firstname;
    private String lastname;
    private String jerseynumber;
    private String position;

    @ManyToOne
    private NbaTeam nbaTeam;
    @OneToMany
    private List<PlayerStats> playerStats;

    public List<PlayerStats> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<PlayerStats> playerStats) {
        this.playerStats = playerStats;
    }



    public NbaTeam getNbaTeam() {
        return nbaTeam;
    }

    public void setNbaTeam(NbaTeam nbaTeam) {
        this.nbaTeam = nbaTeam;
    }

    

 

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJerseynumber() {
        return jerseynumber;
    }

    public void setJerseynumber(String jerseynumber) {
        this.jerseynumber = jerseynumber;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return getFirstname() + " " + getLastname();
    }

    @Override
    public String getCSV() {
        return getFirstname()+ "\t" + getLastname()+ "\t" + getJerseynumber()+ "\t" + getPosition();
    }

}
