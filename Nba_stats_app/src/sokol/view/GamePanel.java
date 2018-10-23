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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.hibernate.Query;
import org.hibernate.Session;
import sokol.controller.ObradaGame;
import sokol.controller.ObradaNbaTeam;
import sokol.model.Game;
import sokol.model.NbaTeam;
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
        pnlKalendar1.setSize(d);
        calendarPanel.setSize(pnlKalendar1.getSize());
        pnlKalendar1.add(calendarPanel);
    }

    private void ucitajHomeTeam() {
        teamObrada.getEntiteti().forEach((s) -> {
            cmbHomeTeam.addItem(s.getName());
            cmbAwayTeam.addItem(s.getName());

        });
    }

    private void ucitajKalendar() {

        Date d = Date.from(datePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        game.setDateofgame(d);
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
        pnlKalendar1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstGames = new javax.swing.JList<>();
        btnObrisi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDatumUtakmice = new javax.swing.JTextField();

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

        javax.swing.GroupLayout pnlKalendar1Layout = new javax.swing.GroupLayout(pnlKalendar1);
        pnlKalendar1.setLayout(pnlKalendar1Layout);
        pnlKalendar1Layout.setHorizontalGroup(
            pnlKalendar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        pnlKalendar1Layout.setVerticalGroup(
            pnlKalendar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPodaciLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlKalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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
                .addGap(18, 18, 18)
                .addComponent(pnlKalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4))
                    .addComponent(txtDatumUtakmice))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
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
                        .addGap(8, 8, 8)
                        .addComponent(txtDatumUtakmice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi))
                    .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 30, Short.MAX_VALUE))
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

        Date d = Date.from(datePicker.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("Chosen date is: " + d);
        gaming.setDateofgame(d);
        System.out.println("Game for save: " + gaming);
        if (away.equals(home)) {
            JOptionPane.showMessageDialog(getRootPane(), "The same team can't play the same game ");
            return;
        }
        
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
        Game selectedGame = lstGames.getSelectedValue();

        System.out.println("Selected game " + selectedGame);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formatDatuma = df.format(selectedGame.getDateofgame());
        txtDatumUtakmice.setText(formatDatuma);

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
    protected javax.swing.JPanel pnlKalendar1;
    protected javax.swing.JPanel pnlPodaci;
    protected javax.swing.JTextField txtAwayScore;
    protected javax.swing.JTextField txtAwayTeam;
    protected javax.swing.JTextField txtDatumUtakmice;
    protected javax.swing.JTextField txtHomeScore;
    protected javax.swing.JTextField txtHomeTeam;
    // End of variables declaration//GEN-END:variables
}
