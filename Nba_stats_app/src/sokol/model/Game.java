package sokol.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Game extends Entitet implements Serializable {

   private Date dateofgame;
    @ManyToOne
    private NbaTeam hometeam;
    @ManyToOne
    private NbaTeam awayteam;

    public Date getDateofgame() {
        return dateofgame;
    }

    public void setDateofgame(Date dateofgame) {
        this.dateofgame = dateofgame;
    }

    public NbaTeam getHometeam() {
        return hometeam;
    }

    public void setHometeam(NbaTeam hometeam) {
        this.hometeam = hometeam;
    }

    public NbaTeam getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(NbaTeam awayteam) {
        this.awayteam = awayteam;
    }

    @Override
    public String getCSV() {
        return getAwayteam() + "\t" + getHometeam() + "\t"  + getDateofgame();
    }
    

}
