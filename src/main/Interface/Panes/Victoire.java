package Interface.Panes;

import Interface.GameConstants;
import Model.Jeu;
import Model.Joueur;
import Vue.CollecteurEvenements;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Victoire extends JPanel{

    JButton relancerPartie;
    JButton retourMenu;
    JPanel panelBoutons;

    Jeu jeu;

    Label messageVictoire;

    CollecteurEvenements controlleur;

    BufferedImage pingouinBleuC,pingouinRougeC, pingouinVertC, pingouinJauneC;
    BufferedImage pingouinBleu,pingouinRouge, pingouinVert, pingouinJaune;
    BufferedImage hexagone,poisson;

    BufferedImage relancerPartieB,retourMenuB;


    ArrayList<Integer> gagnant;

    public Victoire(CollecteurEvenements c){
        jeu = c.getJeu();
        controlleur = c;
        this.setLayout(new BorderLayout());
        this.setBackground(GameConstants.BACKGROUND_COLOR);
        gagnant = jeu.gagnant();

        pingouinBleuC = chargeImage("pingouinBleuWin");
        pingouinRougeC = chargeImage("pingouinRougeWin");
        pingouinVertC = chargeImage("pingouinVertWin");
        pingouinJauneC = chargeImage("pingouinJauneWin");
        pingouinBleu = chargeImage("pingouinBleu");
        pingouinRouge = chargeImage("pingouinRouge");
        pingouinVert = chargeImage("pingouinVert");
        pingouinJaune = chargeImage("pingouinJaune");
        poisson = chargeImage("poisson");
        hexagone = chargeImage("hexagone");
        relancerPartieB = chargeImage("boutonRelancerPartie");
        retourMenuB = chargeImage("boutonRetourMenu");

        setEcranVictoire();
    }


    private void setEcranVictoire(){

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        //-------------message gagnant----------------
        messageVictoire = new Label();
        messageVictoire.setText("Victoire du joueur " + gagnant);
        messageVictoire.setFont(new Font("Serif", Font.PLAIN, 30));

        c.gridy = 0;
        c.gridx = 0;
        c.gridwidth = jeu.getListeJoueur().size();
        c.gridheight = 1;
        c.weighty = 5;
        this.add(messageVictoire, c);



        setScore();



        panelBoutons = new JPanel();
        panelBoutons.setBackground(GameConstants.BACKGROUND_COLOR);
        panelBoutons.setLayout(new BoxLayout(panelBoutons, BoxLayout.X_AXIS));
        relancerPartie = new JButton(new ImageIcon(relancerPartieB));
        retourMenu = new JButton(new ImageIcon(retourMenuB));


        relancerPartie.setBorderPainted(false);
        relancerPartie.setContentAreaFilled(false);
        relancerPartie.setBackground(Color.CYAN);
        //relancerPartie.addActionListener(e -> controlleur.togglePause(true));

        retourMenu.setBorderPainted(false);
        retourMenu.setContentAreaFilled(false);
        retourMenu.setBackground(Color.CYAN);
        retourMenu.addActionListener(e -> controlleur.switchMenu());


        panelBoutons.add(relancerPartie);
        panelBoutons.add(retourMenu);

        c.gridy = 2;
        c.gridx = 0;
        c.gridwidth = jeu.getListeJoueur().size();
        c.gridheight = 2;
        c.weighty = 5;
        this.add(panelBoutons, c);
    }




    private void setScore(){
        ImageIcon iiP = new ImageIcon(poisson);
        Image image = iiP.getImage();
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        iiP = new ImageIcon(newimg);

        ImageIcon iiH = new ImageIcon(hexagone);
        image = iiH.getImage();
        newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        iiH = new ImageIcon(newimg);

        for(int i = 0; i < jeu.getListeJoueur().size();i++) {

            BufferedImage pingouin = getImage(i+1);
            ImageIcon iPingouin = new ImageIcon(pingouin);
//            image = iPingouin.getImage();
//            newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
//            iPingouin = new ImageIcon(newimg);

            JLabel jlP = new JLabel(iiP);
            JLabel jlH = new JLabel(iiH);
            JLabel jlPing = new JLabel(iPingouin);

            //Panel de base pour chaque score
            JPanel mainP = new JPanel();
            mainP.setLayout(new GridBagLayout());
            mainP.setBorder(new LineBorder(Color.BLACK));
            GridBagConstraints c2 = new GridBagConstraints();

            //Panel pour les deux scores
            JPanel imageP = new JPanel();
            imageP.setLayout(new BoxLayout(imageP, BoxLayout.X_AXIS));


            //Panel pour le score poisson
            JPanel poissonP = new JPanel();
            poissonP.setLayout(new BoxLayout(poissonP, BoxLayout.Y_AXIS));

            //Panel pour le score hexagone
            JPanel hexaP = new JPanel();
            hexaP.setLayout(new BoxLayout(hexaP, BoxLayout.Y_AXIS));

            imageP.add(poissonP);
            imageP.add(hexaP);

            //Texte pour le numéro du joueur
            JLabel numJoueur = new JLabel("Joueur " + (i + 1));
            numJoueur.setForeground(Color.BLACK);

            c2.gridx = 0;
            c2.gridy = 0;
            c2.gridwidth = 2;
            c2.weighty = 1;
            mainP.add(numJoueur, c2);

            c2.gridx = 0;
            c2.gridy = 1;
            c2.gridwidth = 2;
            c2.weighty = 3;
            mainP.add(jlPing, c2);

            c2.gridx = 0;
            c2.gridy = 2;
            c2.gridwidth = 2;
            c2.weighty = 5;
            mainP.add(imageP, c2);

            JLabel scoreP = new JLabel(String.valueOf(jeu.getListeJoueur().get(i).getScore()));
            poissonP.add(jlP);
            poissonP.add(scoreP);

            JLabel scoreH = new JLabel(String.valueOf(jeu.getListeJoueur().get(i).getNbCasesMange()));
            hexaP.add(jlH);
            hexaP.add(scoreH);

            GridBagConstraints c = new GridBagConstraints();
            c.gridx = i;
            c.gridy = 1;
            c.fill = GridBagConstraints.BOTH;
            c.anchor = GridBagConstraints.CENTER;
            c.weighty = 10;
            c.weightx = 25;
            this.add(mainP, c);
        }
    }

    private BufferedImage getImage(int i) {
        if(i == 1){
            return (gagnant.contains(1)) ? pingouinBleuC : pingouinBleu;
        }else if(i == 2){
            return (gagnant.contains(2)) ? pingouinRougeC : pingouinRouge;
        }else if(i == 3){
            return (gagnant.contains(3)) ? pingouinVertC : pingouinVert;
        }else{
            return (gagnant.contains(4)) ? pingouinJauneC : pingouinJaune;
        }
    }


    private BufferedImage chargeImage(String nom){
        try {
            InputStream in = new FileInputStream("resources/assets/jeu/victoire/" + nom + ".png");
            return ImageIO.read(in);
        } catch (Exception e) {
            System.out.println("Fichier \"" + nom + "\" introuvable");
        }
        return null;
    }




}
