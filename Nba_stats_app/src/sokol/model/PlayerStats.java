package sokol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PlayerStats extends Entitet implements Serializable {

    private BigDecimal gamesplayed;
    private BigDecimal minutes;
    private BigDecimal pts;
    private BigDecimal reb;
    private BigDecimal ast;
    private BigDecimal stl;
    private BigDecimal blk;
    private BigDecimal player;
//game int not null
    @OneToOne 
   private Player players;
        
    //@OneToMany(mappedBy = "playerStats",  cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE })
    //private List<Player> playeri;

    public Player getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players = players;
    }


    @ManyToOne
    private Game game;

   // public Player getPlayers() {
       /// return players;
    //}

    //public void setPlayers(Player players) {
      //  this.players = players;
    //}

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public BigDecimal getGamesplayed() {
        return gamesplayed;
    }

    public void setGamesplayed(BigDecimal gamesplayed) {
        this.gamesplayed = gamesplayed;
    }

    public BigDecimal getMinutes() {
        return minutes;
    }

    public void setMinutes(BigDecimal minutes) {
        this.minutes = minutes;
    }

    public BigDecimal getPts() {
        return pts;
    }

    public void setPts(BigDecimal pts) {
        this.pts = pts;
    }

    public BigDecimal getReb() {
        return reb;
    }

    public void setReb(BigDecimal reb) {
        this.reb = reb;
    }

    public BigDecimal getAst() {
        return ast;
    }

    public void setAst(BigDecimal ast) {
        this.ast = ast;
    }

    public BigDecimal getStl() {
        return stl;
    }

    public void setStl(BigDecimal stl) {
        this.stl = stl;
    }

    public BigDecimal getBlk() {
        return blk;
    }

    public void setBlk(BigDecimal blk) {
        this.blk = blk;
    }
    

   

    public BigDecimal getPlayer() {
        return player;
    }

    public void setPlayer(BigDecimal player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return getPts()+ " points " + " ," + getReb()+ " rebounds " + getAst() + " assists" ;
    }
    
    @Override
    public String getCSV() {
        return getAst()+ "\t" + getBlk()+ "\t" + getMinutes()+ "\t" + getPts()
                + getReb()+ "\t" + getStl()+ "\t" + getGame()+ "\t" + getGamesplayed();
    }


}
