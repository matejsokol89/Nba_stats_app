/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.view;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import sokol.model.Operater;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import org.hibernate.Query;
import org.hibernate.Session;
import sokol.controller.ObradaNbaTeam;
import sokol.controller.ObradaPlayer;
import sokol.json.team.Standard;
import sokol.json.team.Teams;
import sokol.model.Entitet;
import sokol.model.Player;
import sokol.model.NbaTeam;
import sokol.pomocno.HibernateUtil;
import sokol.pomocno.NbaException;

public class Prozor extends javax.swing.JFrame {

    private JPanel pnlPocetna;
    private JPanel pnlNbaTeams;
    private JPanel pnlPlayers;
    private JPanel pnlPlayerStats;
    private JPanel pnlGame;
    private JPanel pnlOperators;

    private Operater operater;
    private Date pocetakRada;
    Image inImage;
    static Image image = Toolkit.getDefaultToolkit().getImage("slike/nbasmall.png");
    static TrayIcon trayIcon = new TrayIcon(image, "Nba app");

    /**
     * Creates new form Prozor
     */
    public Prozor(Operater operater) {
        initComponents();
        this.operater = operater;
        setTitle("NBA STATS APP " + operater.getIme() + " " + operater.getPrezime());
        pnlPocetna = new IzbornikPanel();
        pnlNbaTeams = new NbaTeamWithPlayers();
        pnlPlayers = new PlayerPanel();
        pnlPlayerStats = new PlayerStatPanel();
        pnlGame = new GamePanel();
        pnlOperators = new OperateriPanel();

        postaviPanel(pnlPocetna);

        pocetakRada = new Date();

        definirajTimer();
        definirajTray();

    }

    private void definirajTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                long diffInSeconds = (new Date().getTime() - pocetakRada.getTime()) / 1000;

                long diff[] = new long[]{0, 0, 0, 0};
                /* sec */
                diff[3] = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
                /* min */
                diff[2] = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds;
                /* hours */
                diff[1] = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds;
                /* days */
                diff[0] = (diffInSeconds = (diffInSeconds / 24));

                lblVrijeme.setText(String.format(
                        "%s%d:%s%d:%s%d",
                        diff[1] < 10 ? "0" : "",
                        diff[1],
                        diff[2] < 10 ? "0" : "",
                        diff[2],
                        diff[3] < 10 ? "0" : "",
                        diff[3]));
            }
        }, 0, 1000);
    }

    private void definirajTray() {

        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            trayIcon.setImageAutoSize(true);
            trayIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                }
            });

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("TrayIcon could not be added.");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlIzbornik = new javax.swing.JPanel();
        btnPocetna = new javax.swing.JButton();
        btnNbaTeams = new javax.swing.JButton();
        btnPlayerStats = new javax.swing.JButton();
        btnPlayers = new javax.swing.JButton();
        btnGames = new javax.swing.JButton();
        btnOperators = new javax.swing.JButton();
        pnlSadrzaj = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblVrijeme = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        menuNbaJson = new javax.swing.JMenuItem();
        menuApiNbaTeams = new javax.swing.JMenuItem();
        menuPlayer = new javax.swing.JMenu();
        menuApiPlayer = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuNbaTeams = new javax.swing.JMenu();
        menuTeamCSV = new javax.swing.JMenuItem();
        menuTeamJSON = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        btnPocetna.setText("Izbornik");
        btnPocetna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPocetnaActionPerformed(evt);
            }
        });

        btnNbaTeams.setText("Nba teams");
        btnNbaTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNbaTeamsActionPerformed(evt);
            }
        });

        btnPlayerStats.setText("Player stats");
        btnPlayerStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerStatsActionPerformed(evt);
            }
        });

        btnPlayers.setText("Players");
        btnPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayersActionPerformed(evt);
            }
        });

        btnGames.setText("Games");
        btnGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGamesActionPerformed(evt);
            }
        });

        btnOperators.setText("Operators");
        btnOperators.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperatorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlIzbornikLayout = new javax.swing.GroupLayout(pnlIzbornik);
        pnlIzbornik.setLayout(pnlIzbornikLayout);
        pnlIzbornikLayout.setHorizontalGroup(
            pnlIzbornikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIzbornikLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIzbornikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPocetna, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnOperators, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnGames, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnPlayerStats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(btnNbaTeams, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlIzbornikLayout.setVerticalGroup(
            pnlIzbornikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIzbornikLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnPocetna, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNbaTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnPlayerStats, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnGames, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnOperators, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pnlSadrzaj.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout pnlSadrzajLayout = new javax.swing.GroupLayout(pnlSadrzaj);
        pnlSadrzaj.setLayout(pnlSadrzajLayout);
        pnlSadrzajLayout.setHorizontalGroup(
            pnlSadrzajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        pnlSadrzajLayout.setVerticalGroup(
            pnlSadrzajLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("Nba stats");

        jMenuItem2.setText("Izlaz");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Import");

        jMenu5.setText("Nba team");

        menuNbaJson.setText("JSON");
        menuNbaJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNbaJsonActionPerformed(evt);
            }
        });
        jMenu5.add(menuNbaJson);

        menuApiNbaTeams.setText("API");
        menuApiNbaTeams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuApiNbaTeamsActionPerformed(evt);
            }
        });
        jMenu5.add(menuApiNbaTeams);

        jMenu2.add(jMenu5);

        menuPlayer.setText("Player");

        menuApiPlayer.setText("Api");
        menuApiPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuApiPlayerActionPerformed(evt);
            }
        });
        menuPlayer.add(menuApiPlayer);

        jMenu2.add(menuPlayer);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Export");

        mnuNbaTeams.setText("Nba teams");

        menuTeamCSV.setText("CSV");
        menuTeamCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTeamCSVActionPerformed(evt);
            }
        });
        mnuNbaTeams.add(menuTeamCSV);

        menuTeamJSON.setText("JSON");
        menuTeamJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTeamJSONActionPerformed(evt);
            }
        });
        mnuNbaTeams.add(menuTeamJSON);

        jMenu3.add(mnuNbaTeams);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Help");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlIzbornik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVrijeme, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSadrzaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIzbornik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlSadrzaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVrijeme, javax.swing.GroupLayout.DEFAULT_SIZE, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPocetnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPocetnaActionPerformed
        postaviPanel(pnlPocetna);
    }//GEN-LAST:event_btnPocetnaActionPerformed

    private void btnNbaTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNbaTeamsActionPerformed
        postaviPanel(pnlNbaTeams);
    }//GEN-LAST:event_btnNbaTeamsActionPerformed

    private void btnPlayerStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerStatsActionPerformed
        postaviPanel(pnlPlayerStats);
    }//GEN-LAST:event_btnPlayerStatsActionPerformed

    private void btnPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayersActionPerformed
        postaviPanel(pnlPlayers);
    }//GEN-LAST:event_btnPlayersActionPerformed

    private void btnGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGamesActionPerformed
        postaviPanel(pnlGame);
    }//GEN-LAST:event_btnGamesActionPerformed

    private void btnOperatorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperatorsActionPerformed
        postaviPanel(pnlOperators);
    }//GEN-LAST:event_btnOperatorsActionPerformed

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        setVisible(false);

    }//GEN-LAST:event_formWindowIconified

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (JOptionPane.showConfirmDialog(getRootPane(), "Sigurno izaći", "Izlaz iz aplikacije",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            dispose();
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new OAplikaciji().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void menuApiNbaTeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuApiNbaTeamsActionPerformed
        String sJsonContent = "";

        try {//trebam api dovuc a da radi
            URL url = new URL("http://data.nba.net/prod/v2/2018/teams.json");
            URLConnection request = url.openConnection();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))) {
                sJsonContent = reader.lines().collect(Collectors.joining("\n"));
                //System.out.println(sJsonContent);
                Gson gson = new Gson();
                Teams teams = gson.fromJson(sJsonContent, Teams.class);

                List<Standard> clubs = teams.getLeague().getStandard();
                for (Standard club : clubs) {
                    System.out.println(club);
                    ObradaNbaTeam obrada = new ObradaNbaTeam();
                    NbaTeam team = new NbaTeam();
                    team.setCity(club.getCity());
                    team.setName(club.getNickname());
                    // TODO: add nbaApiTeamId Integer
                    team.setTeamId(club.getTeamId());

                    obrada.dodaj(team);
                }

            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_menuApiNbaTeamsActionPerformed

    private void menuNbaJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNbaJsonActionPerformed
        Gson gson = new Gson();
        List<NbaTeam> timovi = gson.fromJson(ucitajTekst("JSON DATOTEKA", "json"), new TypeToken<List<NbaTeam>>() {
        }.getType());
        ObradaNbaTeam on = new ObradaNbaTeam();
        ObradaPlayer op = new ObradaPlayer();
        for (NbaTeam nt : timovi) {
            try {
                on.dodaj(nt);

            } catch (NbaException ex) {
                printStackTrace(ex);
            }

        }
    }//GEN-LAST:event_menuNbaJsonActionPerformed

    private void menuTeamCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTeamCSVActionPerformed
        ObradaNbaTeam o = new ObradaNbaTeam();
        spremiCSV(o.getListEntitet());
    }//GEN-LAST:event_menuTeamCSVActionPerformed

    private void menuTeamJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTeamJSONActionPerformed
        ObradaNbaTeam o = new ObradaNbaTeam();
        spremiJSON(o.getListEntitet());
    }//GEN-LAST:event_menuTeamJSONActionPerformed

    private void menuApiPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuApiPlayerActionPerformed
        String sJsonContent = "";

        try {//trebam api dovuc a da radi
            URL url = new URL("http://data.nba.net/prod/v1/2018/players.json");
            URLConnection request = url.openConnection();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))) {
                sJsonContent = reader.lines().collect(Collectors.joining("\n"));
                //System.out.println(sJsonContent);
                Gson gson = new Gson();
                sokol.json.player.Player playerClass = gson.fromJson(sJsonContent, sokol.json.player.Player.class);

                List<sokol.json.player.Standard> players = playerClass.getLeague().getStandard();
                for (sokol.json.player.Standard player : players) {
                    System.out.println(player);
                    ObradaPlayer obradaPlayer = new ObradaPlayer();
                    Player firstPlayer = new Player();
                    firstPlayer.setFirstname(player.getFirstName());
                    firstPlayer.setLastname(player.getLastName());
                    firstPlayer.setJerseynumber(player.getJersey());
                    firstPlayer.setPosition(player.getPos());

                    firstPlayer = obradaPlayer.dodaj(firstPlayer);

                    // TODO: Poveži tim sa playerTEamId
                    String teamId = player.getTeamId();

                    try {
                        ObradaNbaTeam obrada = new ObradaNbaTeam();
                        System.out.println("looking for team in db by teamid " + teamId);
                        Session session = HibernateUtil.getSession();

                        //NbaTeam team = (NbaTeam) session.get(NbaTeam.class, teamId);
                        String hql = "FROM NbaTeam N WHERE N.teamId = '" + teamId + "'";
                        Query query = session.createQuery(hql);
                        List results = query.list();
                        System.out.println("team query:" + results);
                        NbaTeam team = (NbaTeam) results.get(0);
                        System.out.println("team found:" + team);
                        firstPlayer.setNbaTeam(team);
                        team.getPlayeri().add(firstPlayer);
                        team = obrada.dodaj(team);
                        System.out.println("team updated:" + team);
                        
                        //session.close();
                    } catch (Exception e) {
                        System.out.println("team update error:" + e.getLocalizedMessage());
                    }
                }

            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_menuApiPlayerActionPerformed

    private void spremiCSV(List<Entitet> lista) {
        String naziv = "podaci";
        if (lista.size() > 0) {
            Entitet e = lista.get(0);
            naziv = e.getClass().getSimpleName().toLowerCase();
            StringBuilder s = new StringBuilder();
            lista.forEach((en) -> {
                s.append(en.getCSV());
                s.append("\n");
            });
            spremiTekst(s.toString(), "CSV DATOTEKA", "csv", naziv, true);

        }
    }

    /**/
    private void spremiTekst(String s, String nazivEkstenzije, String ekstenzija, String nazivDatoteke, boolean otvoriNakonSpremanja) {
        JFileChooser spremiKao = new JFileChooser();
        spremiKao.setSelectedFile(new File(System.getProperty("user.home") + File.separator + nazivDatoteke));
        spremiKao.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(nazivEkstenzije, ekstenzija);

        spremiKao.setFileFilter(filter);
        if (spremiKao.showSaveDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
            String putanja = spremiKao.getSelectedFile().getAbsolutePath();
            if (!putanja.endsWith("." + ekstenzija)) {
                putanja += "." + ekstenzija;
            }
            File dat = new File(putanja);
            if (!(!dat.exists()
                    || JOptionPane.showConfirmDialog(getRootPane(), "Datoteka postoji, zamjeniti?", "Datoteka postoji", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)) {
                return;
            }
            try {
                FileWriter fw = new FileWriter(putanja);
                fw.write(s);
                fw.close();
                if (otvoriNakonSpremanja) {
                    Desktop d = Desktop.getDesktop();
                    d.open(dat);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(getRootPane(), "Problem kod pisanja u datoteku");
            }

        }
    }

    private class IzbjegniPovratnoNbaTeamove implements ExclusionStrategy {

        public boolean shouldSkipClass(Class<?> arg0) {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes f) {

            return (f.getDeclaringClass() == NbaTeam.class && f.getName().equals("player")
                    || f.getDeclaringClass() == Player.class && f.getName().equals("nbaTeam"));
        }

    }

    private void spremiJSON(List<Entitet> lista) {
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new IzbjegniPovratnoNbaTeamove())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        String json = gson.toJson(lista);

        String naziv = "podaci";
        if (lista.size() > 0) {
            Entitet e = lista.get(0);
            naziv = e.getClass().getSimpleName().toLowerCase();
            spremiTekst(json, "JSON DATOTEKA", "json", naziv, false);
        }

    }

    private String ucitajTekst(String nazivEkstenzije, String ekstenzija) {
        JFileChooser ucitaj = new JFileChooser();
        ucitaj.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(nazivEkstenzije, ekstenzija);

        ucitaj.setFileFilter(filter);
        if (ucitaj.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(ucitaj.getSelectedFile()));

                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                br.close();
                return sb.toString();
            } catch (IOException e) {

            }

        }

        return "";
    }

    private void postaviPanel(JPanel panel) {
        pnlSadrzaj.removeAll();
        pnlSadrzaj.add(panel);
        panel.setSize(pnlSadrzaj.getSize());
        pnlSadrzaj.revalidate();
        pnlSadrzaj.repaint();

        resetPozadinaButton();

        switch (panel.getName()) {
            case "Menu":
                btnPocetna.setBackground(Color.GREEN);
                break;
            case "Nba teams":
                btnNbaTeams.setBackground(Color.GREEN);
                break;
            case "Players":
                btnPlayers.setBackground(Color.GREEN);
                break;
            case "Player stats":
                btnPlayerStats.setBackground(Color.GREEN);
                break;
            case "Games":
                btnGames.setBackground(Color.GREEN);
                break;
            case "Operators":
                btnOperators.setBackground(Color.GREEN);
                break;

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGames;
    private javax.swing.JButton btnNbaTeams;
    private javax.swing.JButton btnOperators;
    private javax.swing.JButton btnPlayerStats;
    private javax.swing.JButton btnPlayers;
    private javax.swing.JButton btnPocetna;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblVrijeme;
    private javax.swing.JMenuItem menuApiNbaTeams;
    private javax.swing.JMenuItem menuApiPlayer;
    private javax.swing.JMenuItem menuNbaJson;
    private javax.swing.JMenu menuPlayer;
    private javax.swing.JMenuItem menuTeamCSV;
    private javax.swing.JMenuItem menuTeamJSON;
    private javax.swing.JMenu mnuNbaTeams;
    private javax.swing.JPanel pnlIzbornik;
    private javax.swing.JPanel pnlSadrzaj;
    // End of variables declaration//GEN-END:variables

    private void resetPozadinaButton() {
        for (Component c : pnlIzbornik.getComponents()) {
            c.setBackground(Color.gray);
        }
    }

}
