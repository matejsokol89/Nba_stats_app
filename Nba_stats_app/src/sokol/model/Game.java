package sokol.model;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePicker;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Game extends Entitet implements Serializable {

   private Date dateofgame;
       private CalendarPanel calendarPanel;

   private String homeTeamPoints;
   private String awayTeamPoints;
    @ManyToOne
    private NbaTeam hometeam;
    @ManyToOne
    private NbaTeam awayteam;
    

    public String getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(String homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }

    public String getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(String awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }
    
    

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
    public String toString() {
        return this.hometeam.getName() + " - " + this.awayteam.getName() + " (" + this.homeTeamPoints + " / " + this.awayTeamPoints + ")";
    }

    @Override
    public String getCSV() {
        return getAwayteam() + "\t" + getHometeam() + "\t"  + getDateofgame();
    }


    

}
