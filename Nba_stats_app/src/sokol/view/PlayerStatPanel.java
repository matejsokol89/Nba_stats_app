/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.view;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import sokol.controller.ObradaNbaTeam;
import sokol.controller.ObradaPlayer;
import sokol.controller.ObradaPlayerStats;
import sokol.model.NbaTeam;
import sokol.model.Player;
import sokol.model.PlayerStats;
import sokol.pomocno.NbaException;

/**
 *
 * @author Admin
 */
public class PlayerStatPanel extends javax.swing.JPanel {

    private ObradaPlayerStats obrada;
    private ObradaPlayer obrada1;
    // final private DecimalFormat df;
    private PlayerStats playerStats;
    private Player player;

    public PlayerStatPanel() {
        initComponents();
        setName("Player stats");
        obrada = new ObradaPlayerStats();
        obrada1 = new ObradaPlayer();
        //ucitajStatistiku();
        ucitajStatistiku1();

        // String pattern = "###,###.###";
        // df = new DecimalFormat(pattern);
        //NumberFormat nf = NumberFormat.getNumberInstance(new Locale("hr", "HR"));
        // df = (DecimalFormat) nf;
        //df.applyPattern("###.#");
    }

    private void ucitajStatistiku() {

        Player igrac = lstPlayer.getSelectedValue();

        DefaultListModel<PlayerStats> m = new DefaultListModel<>();

        if (igrac != null) {
            int idNba_igrac_selected = lstPlayer.getSelectedValue().getIdNba();
            obrada.getEntiteti().forEach((s) -> {
                if (s.getPlayers() != null && s.getPlayers().getIdNba() == idNba_igrac_selected) {
                    m.addElement(s);
                }
            });
        }
        lstPlayerStats.setModel(m);
    }

    private void ucitajStatistiku1() {

        DefaultListModel<Player> m = new DefaultListModel<>();
        obrada1.getEntiteti(txtUvjet.getText()).forEach((s) -> {
            m.addElement(s);
        });
        lstPlayer.setModel(m);

    }

    private void ocistiPolja() {

        for (Component c : pnlPodaci.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }

    private boolean popuniSvojstva() {

        try {
            playerStats.setFg2ptatt(new BigDecimal(txtFg2patt.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Has to be a number");
            return false;
        }

        try {
            playerStats.setFg2ptmade(new BigDecimal(txtFg2ptmade.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Has to be a number");
            return false;
        }

        try {
            playerStats.setFg3ptatt(new BigDecimal(txtFg3ptatt.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Has to be a number");
            return false;
        }
        try {
            playerStats.setFg3ptmade(new BigDecimal(txtFg3ptmade.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Has to be a number");
            return false;
        }
        try {
            playerStats.setFtatt(new BigDecimal(txtFtatt.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Has to be a number");
            return false;
        }
        try {
            playerStats.setFtmade(new BigDecimal(txtFtmade.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Has to be a number");
            return false;
        }
        try {
            playerStats.setGamesplayed(new BigDecimal(txtGamesPlayed.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "Has to be a number");
            return false;
        }

        return true;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPodaci = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtGamesPlayed = new javax.swing.JTextField();
        labela1 = new javax.swing.JLabel();
        txtFg2patt = new javax.swing.JTextField();
        labela2 = new javax.swing.JLabel();
        txtFg2ptmade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFg3ptatt = new javax.swing.JTextField();
        btnObrisi = new javax.swing.JButton();
        btnPromjena = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtFg3ptmade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFtatt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFtmade = new javax.swing.JTextField();
        btnDodajNovi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUvjet = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPlayer = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPlayerStats = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Games played");

        labela1.setText("fg2ptatt");

        labela2.setText("fg2ptmade");

        jLabel4.setText("fg3ptatt");

        btnObrisi.setText("Delete");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnPromjena.setText("Change");
        btnPromjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjenaActionPerformed(evt);
            }
        });

        jLabel5.setText("fg3ptmade");

        jLabel7.setText("ftatt");

        jLabel8.setText("ftmade");

        btnDodajNovi.setText("Add new");
        btnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNoviActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPodaciLayout = new javax.swing.GroupLayout(pnlPodaci);
        pnlPodaci.setLayout(pnlPodaciLayout);
        pnlPodaciLayout.setHorizontalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFtatt)
                            .addComponent(txtGamesPlayed)
                            .addComponent(txtFg2patt)
                            .addComponent(txtFg2ptmade)
                            .addComponent(txtFg3ptatt)
                            .addComponent(txtFg3ptmade)
                            .addComponent(txtFtmade)
                            .addGroup(pnlPodaciLayout.createSequentialGroup()
                                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(labela2)
                                    .addComponent(labela1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(btnDodajNovi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPromjena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );
        pnlPodaciLayout.setVerticalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txtGamesPlayed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labela1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFg2patt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labela2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFg2ptmade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFg3ptatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFg3ptmade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(8, 8, 8)
                .addComponent(txtFtatt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(8, 8, 8)
                .addComponent(txtFtmade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPromjena)
                    .addComponent(btnObrisi)
                    .addComponent(btnDodajNovi))
                .addGap(45, 45, 45))
        );

        jLabel3.setText("Condition");

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        btnTrazi.setText("Search");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        lstPlayer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPlayer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlayerValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstPlayer);

        lstPlayerStats.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPlayerStats.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlayerStatsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPlayerStats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnTrazi))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(502, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPodaci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrazi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(236, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNoviActionPerformed

        playerStats = new PlayerStats();
        player = lstPlayer.getSelectedValue();
        // player = izvlaci player iz lst-Players....
        if (player == null) {
            JOptionPane.showMessageDialog(getRootPane(), "There is no player selected");
            return;
        }

        // player = izvlaci player iz lst-Players....
        // if player is null -> reject: 1. poruka, 2. return
        playerStats.setPlayers(player);

        if (!popuniSvojstva()) {
            return;
        }
        try {
            obrada.dodaj(playerStats);
            ucitajStatistiku();
        } catch (NbaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajNoviActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        playerStats = lstPlayerStats.getSelectedValue();
        if (playerStats == null) {
            JOptionPane.showMessageDialog(getRootPane(), "First choose field");
            return;
        }

        obrada.obrisi(playerStats);
        ucitajStatistiku();

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromjenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjenaActionPerformed
        playerStats = lstPlayerStats.getSelectedValue();
        if (player == null) {
            JOptionPane.showMessageDialog(getRootPane(), "First choose field");
            return;
        }

        if (!popuniSvojstva()) {
            return;
        }

        try {
            obrada.promjena(playerStats);
            ucitajStatistiku();
        } catch (NbaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }

    }//GEN-LAST:event_btnPromjenaActionPerformed

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == 10) {
            ucitajStatistiku1();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void lstPlayerStatsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPlayerStatsValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }

        playerStats = lstPlayerStats.getSelectedValue();
        if (playerStats == null) {
            return;
        }
        ocistiPolja();

        txtFg2ptmade.setText(playerStats.getFg2ptatt().toString());
        txtFg2patt.setText(playerStats.getFg2ptatt().toString());
        txtFg3ptatt.setText(playerStats.getFg3ptatt().toString());
        txtFg3ptmade.setText(playerStats.getFg3ptmade().toString());
        txtFtatt.setText(playerStats.getFtatt().toString());
        txtFtmade.setText(playerStats.getFtmade().toString());
        txtGamesPlayed.setText(playerStats.getGamesplayed().toString());


    }//GEN-LAST:event_lstPlayerStatsValueChanged

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitajStatistiku1();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void lstPlayerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPlayerValueChanged
        // TODO add your handling code here:
        ucitajStatistiku();
    }//GEN-LAST:event_lstPlayerValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnDodajNovi;
    protected javax.swing.JButton btnObrisi;
    protected javax.swing.JButton btnPromjena;
    protected javax.swing.JButton btnTrazi;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jLabel4;
    protected javax.swing.JLabel jLabel5;
    protected javax.swing.JLabel jLabel7;
    protected javax.swing.JLabel jLabel8;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JLabel labela1;
    protected javax.swing.JLabel labela2;
    protected javax.swing.JList<Player> lstPlayer;
    protected javax.swing.JList<PlayerStats> lstPlayerStats;
    protected javax.swing.JPanel pnlPodaci;
    protected javax.swing.JTextField txtFg2patt;
    protected javax.swing.JTextField txtFg2ptmade;
    protected javax.swing.JTextField txtFg3ptatt;
    protected javax.swing.JTextField txtFg3ptmade;
    protected javax.swing.JTextField txtFtatt;
    protected javax.swing.JTextField txtFtmade;
    protected javax.swing.JTextField txtGamesPlayed;
    protected javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables
}
