/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.view;

import sokol.controller.ObradaNbaTeam;
import sokol.controller.ObradaPlayer;
import sokol.model.Entitet;
import sokol.model.NbaTeam;
import sokol.model.Player;
import sokol.pomocno.NbaException;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author Sokol
 */
public class NbaTeamWithPlayers extends javax.swing.JPanel {

    private NbaTeam entitet;
    private ObradaNbaTeam obrada;
    private List<Player> playeriUBazi;
    private int oznacenaSifra;


    public NbaTeamWithPlayers() {
        initComponents();
        tblEntiteti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setName("Nba teams");
        obrada = new ObradaNbaTeam();

        definirajDogadajNaTablici();
        ucitajPlayera();
        ucitaj();
        lstPlayeriNaTimu.setModel(new DefaultListModel<>());

    }

    private void ucitaj() {

        List<NbaTeam> lista = obrada.getEntiteti(txtUvjet.getText());

        //sortirati po prezimenu
        Collections.sort(lista, new Comparator<NbaTeam>() {
            public int compare(NbaTeam o1, NbaTeam o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // tblEntiteti.removeAll();
        DefaultTableModel m = (DefaultTableModel) tblEntiteti.getModel();

        m.setRowCount(0);

        lista.forEach((s) -> {
            Object[] niz = {s.getName()};
            m.addRow(niz);
            m.setValueAt(s, m.getRowCount() - 1, 0);
        });
        ocistiPolja();

        if (oznacenaSifra > 0) {
            NbaTeam trenutnaGrupa;
            for (int i = 0; i < tblEntiteti.getModel().getRowCount(); i++) {
                trenutnaGrupa = (NbaTeam) tblEntiteti.getModel().getValueAt(i, 0);
                if (oznacenaSifra == trenutnaGrupa.getIdNba()) {
                    tblEntiteti.setRowSelectionInterval(i, i);
                    break;
                }
            }

        }

    }

    private void ocistiPolja() {
        for (Component c : pnlPodaci.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            }
        }
    }

    private boolean popuniSvojstva() {
        entitet.setName(txtName.getText());
        entitet.setCity(txtCity.getText());
        
        //entitet.setCity((String) cmbCity.getSelectedItem().toString());
        //entitet.setName((String) cmbClubs.getSelectedItem());

        List<Player> playeri = new ArrayList<>();
        DefaultListModel<Player> m = (DefaultListModel<Player>) lstPlayeriNaTimu.getModel();
        for (int i = 0; i < m.getSize(); i++) {
            playeri.add(m.getElementAt(i));
        }
        entitet.setPlayeri(playeri);
        return true;
    }
        

    private void definirajDogadajNaTablici() {
        tblEntiteti.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    return;
                }
                if(tblEntiteti.getSelectedRow()==-1){
                 return;            
            }
                entitet = (NbaTeam) tblEntiteti.getValueAt(tblEntiteti.getSelectedRow(), 0);
                txtName.setText(entitet.getName());
                txtCity.setText(entitet.getCity());
                //ovo radi kada su vrijednost hashcode iste
                cmbCity.setSelectedItem(entitet.getName());
                System.out.println("Selected 1 " + entitet);

                if (entitet.getPlayeri() != null) {

                    DefaultListModel<Player> m2 = new DefaultListModel<>();
                    entitet.getPlayeri().forEach((s) -> {
                        // System.out.println( s + " - " + s.hashCode());
                        m2.addElement(s);
                    });
                    lstPlayeriNaTimu.setModel(m2);
                }

            }
        });
    }

    public void ucitajPlayera() {

        ObradaNbaTeam nt = new ObradaNbaTeam();
        DefaultComboBoxModel<NbaTeam> m = new DefaultComboBoxModel<>();
        nt.getEntiteti().forEach((s) -> {
            // System.out.println( s + " - " + s.hashCode());
            m.addElement(s);
        });
        cmbCity.setModel(m);

        ObradaPlayer op = new ObradaPlayer();
        DefaultListModel<Player> m2 = new DefaultListModel<>();
        playeriUBazi = op.getEntiteti();
        playeriUBazi.forEach((s) -> {
            // System.out.println( s + " - " + s.hashCode());
            m2.addElement(s);
        });
        lstPlayersiUBazi.setModel(m2);

    }
    

    private void lstNbaTeamsValueChanged(javax.swing.event.ListSelectionEvent evt) {
        if (evt.getValueIsAdjusting()) {
            return;
        }

        entitet = (NbaTeam) tblEntiteti.getSelectionModel();
        if (entitet==null) {
            return;
        }
        ocistiPolja();
        txtName.setText(entitet.getName());
        txtCity.setText(entitet.getCity());
        
        System.out.println("Selected 2 " + entitet);

        DefaultListModel<Player> m = new DefaultListModel<>();
        entitet.getPlayeri().forEach((p) -> {
            m.addElement(p);
        });
        lstPlayeriNaTimu.setModel(m);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUvjet = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntiteti = new javax.swing.JTable();
        pnlPodaci = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCity = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPlayersiUBazi = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPlayeriNaTimu = new javax.swing.JList<>();
        btnMakni = new javax.swing.JButton();
        txtUvjetPlayer = new javax.swing.JTextField();
        btnDodajNovi = new javax.swing.JButton();
        btnPromjena = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Uvjet"));

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

        tblEntiteti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblEntiteti);
        if (tblEntiteti.getColumnModel().getColumnCount() > 0) {
            tblEntiteti.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnTrazi)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, 360));

        pnlPodaci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 204), 3));

        jLabel1.setText("Name");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel2.setText("City");

        lstPlayersiUBazi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPlayersiUBazi.setToolTipText("");
        lstPlayersiUBazi.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane1.setViewportView(lstPlayersiUBazi);

        lstPlayeriNaTimu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPlayeriNaTimu.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jScrollPane3.setViewportView(lstPlayeriNaTimu);

        btnMakni.setText("-");
        btnMakni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakniActionPerformed(evt);
            }
        });

        txtUvjetPlayer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUvjetPlayerKeyReleased(evt);
            }
        });

        btnDodajNovi.setText("Add new");
        btnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNoviActionPerformed(evt);
            }
        });

        btnPromjena.setText("Change");
        btnPromjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjenaActionPerformed(evt);
            }
        });

        btnObrisi.setText("Delete");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnDodaj.setText("+");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel4.setText("City");

        javax.swing.GroupLayout pnlPodaciLayout = new javax.swing.GroupLayout(pnlPodaci);
        pnlPodaci.setLayout(pnlPodaciLayout);
        pnlPodaciLayout.setHorizontalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(btnDodajNovi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPromjena)
                        .addGap(14, 14, 14)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(txtName)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPodaciLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(85, 85, 85))
                            .addGroup(pnlPodaciLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))))
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addComponent(txtUvjetPlayer)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnMakni)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlPodaciLayout.setVerticalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUvjetPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnMakni))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnObrisi)
                            .addComponent(btnPromjena)
                            .addComponent(btnDodajNovi))
                        .addGap(45, 45, 45))))
        );

        add(pnlPodaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 11, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == 10) {
            ucitaj();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitaj();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
//ovdje nesto ne valja
        if (lstPlayersiUBazi.getSelectedValues() == null) {
            return;
        }

        Player p = lstPlayersiUBazi.getSelectedValue();
        if (!((DefaultListModel<Player>) lstPlayeriNaTimu.getModel()).contains(p)) {
            ((DefaultListModel<Player>) lstPlayeriNaTimu.getModel()).addElement(p);
            lstPlayeriNaTimu.repaint();
            lstPlayeriNaTimu.revalidate();
        }

    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnMakniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakniActionPerformed
        if (lstPlayeriNaTimu.getSelectedValue() == null) {
            return;
        }

        DefaultListModel<Player> m2 = (DefaultListModel<Player>) lstPlayeriNaTimu.getModel();

        m2.removeElement(lstPlayeriNaTimu.getSelectedValue());

        lstPlayeriNaTimu.repaint();
        lstPlayeriNaTimu.revalidate();

    }//GEN-LAST:event_btnMakniActionPerformed

    private void txtUvjetPlayerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetPlayerKeyReleased

        DefaultListModel<Player> m2 = new DefaultListModel<>();

        playeriUBazi.forEach((s) -> {
            if (s.getFirstname().toLowerCase().contains(txtUvjetPlayer.getText().toLowerCase())) {
                m2.addElement(s);
            }
        });
        lstPlayersiUBazi.setModel(m2);

    }//GEN-LAST:event_txtUvjetPlayerKeyReleased

    private void btnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNoviActionPerformed

        entitet = new NbaTeam();

        if (!popuniSvojstva()) {
            return;
        }
        try {
            obrada.dodaj(entitet);
            oznacenaSifra = entitet.getIdNba();

            ucitaj();
        } catch (NbaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajNoviActionPerformed

    private void btnPromjenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjenaActionPerformed

        if (entitet == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberi City");
            return;
        }

        if (!popuniSvojstva()) {
            return;
        }

        try {
            obrada.promjena(entitet);
            oznacenaSifra = entitet.getIdNba();

            ucitaj();
        } catch (NbaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjenaActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if (entitet == null) {
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberi City");
            return;
        }

        obrada.obrisi(entitet);
        oznacenaSifra = 0;

        ucitaj();
    }//GEN-LAST:event_btnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajNovi;
    private javax.swing.JButton btnMakni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JComboBox<NbaTeam> cmbCity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Player> lstPlayeriNaTimu;
    private javax.swing.JList<Player> lstPlayersiUBazi;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JTable tblEntiteti;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUvjet;
    private javax.swing.JTextField txtUvjetPlayer;
    // End of variables declaration//GEN-END:variables
}
