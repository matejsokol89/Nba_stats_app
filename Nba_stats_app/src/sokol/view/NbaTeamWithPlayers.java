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

        ObradaPlayer op = new ObradaPlayer();
        DefaultListModel<Player> m2 = new DefaultListModel<>();
        playeriUBazi = op.getEntiteti();
        playeriUBazi.forEach((s) -> {
            // System.out.println( s + " - " + s.hashCode());
            m2.addElement(s);
        });

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
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPlayeriNaTimu = new javax.swing.JList<>();
        btnDodajNovi = new javax.swing.JButton();
        btnPromjena = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 50, 106));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204), 2));

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

        tblEntiteti.setBackground(new java.awt.Color(0, 153, 204));
        tblEntiteti.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblEntiteti.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        tblEntiteti.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTrazi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 340));

        pnlPodaci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3));

        jLabel1.setText("Name");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        lstPlayeriNaTimu.setBackground(new java.awt.Color(0, 153, 204));
        lstPlayeriNaTimu.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        lstPlayeriNaTimu.setForeground(new java.awt.Color(255, 255, 255));
        lstPlayeriNaTimu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPlayeriNaTimu.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jScrollPane3.setViewportView(lstPlayeriNaTimu);

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

        jLabel4.setText("City");

        jLabel3.setText("Team roster");

        javax.swing.GroupLayout pnlPodaciLayout = new javax.swing.GroupLayout(pnlPodaci);
        pnlPodaci.setLayout(pnlPodaciLayout);
        pnlPodaciLayout.setHorizontalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(txtName)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnDodajNovi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                .addComponent(btnPromjena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlPodaciLayout.setVerticalGroup(
            pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPodaciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPodaciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPodaciLayout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(btnDodajNovi)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjena)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi))
                    .addComponent(jScrollPane3))
                .addGap(86, 86, 86))
        );

        add(pnlPodaci, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 420, 350));

        jLabel2.setText("Condition");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sokol/view/2-nba-logos-with-balls-106555.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 460, 170));
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
            JOptionPane.showMessageDialog(getRootPane(), "First choose a filed");
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
    private javax.swing.JButton btnDodajNovi;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Player> lstPlayeriNaTimu;
    private javax.swing.JPanel pnlPodaci;
    private javax.swing.JTable tblEntiteti;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables
}
