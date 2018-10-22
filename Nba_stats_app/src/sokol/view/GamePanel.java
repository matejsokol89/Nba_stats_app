/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.view;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Component;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.hibernate.Query;
import org.hibernate.Session;
import sokol.controller.ObradaGame;
import sokol.controller.ObradaNbaTeam;
import sokol.model.Game;
import sokol.model.NbaTeam;
import sokol.model.Player;
import sokol.model.PlayerStats;
import sokol.pomocno.HibernateUtil;
import sokol.pomocno.NbaException;

/**
 *
 * @author Admin
 */
public class GamePanel extends javax.swing.JPanel {

    private ObradaNbaTeam teamObrada;
    private ObradaGame gameObrada;
    private NbaTeam nbaTeam;
    private Game game;
    private DatePicker datePicker;
    private CalendarPanel calendarPanel;

    public GamePanel() {
        initComponents();
        setName("Games");
        teamObrada = new ObradaNbaTeam();
        gameObrada = new ObradaGame();
        ucitajHomeTeam();
        ucitajListuGamesa();

        datePicker = new DatePicker();
        datePicker.setLocale(new Locale("hr"));
        datePicker.setDateToToday();
        calendarPanel = new CalendarPanel(datePicker);

        Dimension d = calendarPanel.getPreferredSize();
        pnlKalendar.setSize(d);
        calendarPanel.setSize(pnlKalendar.getSize());
        pnlKalendar.add(calendarPanel);
    }

    private void ucitajHomeTeam() {
        teamObrada.getEntiteti().forEach((s) -> {
            cmbHomeTeam.addItem(s.getName());
            cmbAwayTeam.addItem(s.getName());

        });
    }

    private void ucitajKalendar() {
    

        if (game.getDateofgame() == null) {
            datePicker.setDateToToday();
            calendarPanel.setSelectedDate(datePicker.getDate());
        } else {
            LocalDate date = new Date(game.getDateofgame().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            calendarPanel.setSelectedDate(date);
            datePicker.setDate(date);
        }
      
    }

    private void ucitajListuGamesa() {
        DefaultListModel<Game> m = new DefaultListModel<>();
        gameObrada.getEntiteti().forEach((s) -> {               
            m.addElement(s);
        });
        lstGames.setModel(m);


    }

    private void ocistiPolja() {

        for (Component c : pnlPodaci.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }

    private boolean popuniSvojstva() {

        nbaTeam.setName(txtHomeTeam.getText());
        nbaTeam.setCity(txtHomeTeam.getText());
        Date d = Date.from(datePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        game.setDateofgame(d);
        ucitajKalendar();

        return true;
    }

    private NbaTeam findTeamByName(String name) {
        Session session = HibernateUtil.getSession();
        //NbaTeam team = (NbaTeam) session.get(NbaTeam.class, teamId);
        String hql = "FROM NbaTeam N WHERE N.name = '" + name + "'";
        Query query = session.createQuery(hql);
        List results = query.list();
        System.out.println("found team " + results);
        return (NbaTeam) results.get(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPodaci = new javax.swing.JPanel();
        btnDodajNovi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtHomeTeam = new javax.swing.JTextField();
        txtHomeScore = new javax.swing.JTextField();
        txtAwayTeam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAwayScore = new javax.swing.JTextField();
        cmbHomeTeam = new javax.swing.JComboBox<>();
        cmbAwayTeam = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstGames = new javax.swing.JList<>();
        btnObrisi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pnlKalendar = new javax.swing.JPanel();

        pnlPodaci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255), 3));

        btnDodajNovi.setText("Add new");
        btnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNoviActionPerformed(evt);
            }
        });

        jLabel1.setText("Home team");

        txtHomeScore.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtHomeScore.setForeground(new java.awt.Color(51, 51, 255));

        jLabel2.setText("Away team");

        txtAwayScore.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtAwayScore.setForeground(new java.awt.Color(0, 51, 255));

        cmbHomeTeam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose team" }));
        cmbHomeTeam.setToolTipText("");
        cmbHomeTeam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbHomeTeamItemStateChanged(evt);
            }
        });

        cmbAwayTeam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose team" }));
        cmbAwayTeam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAwayTeamItemStateChanged(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 51, 255));
        jTextField1.setText(":");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPodaciLayout = new javax.swing.GroupLayout(pnlPodaci);
        pnlPodaci.setLayout(pnlPodaciLayout);
        pnlPodaciLayout.setHorizontalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPodaciLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDodajNovi, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPodaciLayout.createSequentialGroup()
                        .addComponent(txtHomeTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHomeScore, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAwayScore, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cmbHomeTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txtAwayTeam)
                    .addComponent(cmbAwayTeam, 0, 114, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPodaciLayout.setVerticalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHomeTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHomeScore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAwayTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAwayScore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbHomeTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAwayTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDodajNovi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lstGames.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 2, true));
        lstGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstGames.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstGamesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstGames);

        btnObrisi.setText("Delete");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sokol/view/final-score resize.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sokol/view/juego.png"))); // NOI18N

        javax.swing.GroupLayout pnlKalendarLayout = new javax.swing.GroupLayout(pnlKalendar);
        pnlKalendar.setLayout(pnlKalendarLayout);
        pnlKalendarLayout.setHorizontalGroup(
            pnlKalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );
        pnlKalendarLayout.setVerticalGroup(
            pnlKalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlKalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlKalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNoviActionPerformed

        Game gaming = new Game();

        gaming.setHomeTeamPoints(txtHomeScore.getText());
        gaming.setAwayTeamPoints(txtAwayScore.getText());

        NbaTeam away = findTeamByName(txtAwayTeam.getText());
        NbaTeam home = findTeamByName(txtHomeTeam.getText());

        gaming.setHometeam(home);
        gaming.setAwayteam(away);
        try {
            gameObrada.dodaj(gaming);
            ucitajListuGamesa();

        } catch (NbaException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnDodajNoviActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        game = lstGames.getSelectedValue();
        if (game == null) {
            JOptionPane.showMessageDialog(getRootPane(), "First select Game");
            return;
        }

        gameObrada.obrisi(game);
        ucitajListuGamesa();


    }//GEN-LAST:event_btnObrisiActionPerformed

    private void lstGamesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstGamesValueChanged
        ucitajKalendar();

    }//GEN-LAST:event_lstGamesValueChanged

    private void cmbHomeTeamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbHomeTeamItemStateChanged
        // TODO add your handling code here:
        String homeTeam = (String) evt.getItem();
        txtHomeTeam.setText(homeTeam);
    }//GEN-LAST:event_cmbHomeTeamItemStateChanged

    private void cmbAwayTeamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAwayTeamItemStateChanged
        // TODO add your handling code here:
        String awayTeam = (String) evt.getItem();
        txtAwayTeam.setText(awayTeam);
    }//GEN-LAST:event_cmbAwayTeamItemStateChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnDodajNovi;
    protected javax.swing.JButton btnObrisi;
    protected javax.swing.JComboBox<String> cmbAwayTeam;
    protected javax.swing.JComboBox<String> cmbHomeTeam;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JScrollPane jScrollPane3;
    protected javax.swing.JTextField jTextField1;
    protected javax.swing.JList<Game> lstGames;
    protected javax.swing.JPanel pnlKalendar;
    protected javax.swing.JPanel pnlPodaci;
    protected javax.swing.JTextField txtAwayScore;
    protected javax.swing.JTextField txtAwayTeam;
    protected javax.swing.JTextField txtHomeScore;
    protected javax.swing.JTextField txtHomeTeam;
    // End of variables declaration//GEN-END:variables
}
