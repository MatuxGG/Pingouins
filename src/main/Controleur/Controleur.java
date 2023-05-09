package Controleur;

import Interface.Fenetre;
import Interface.GameBoard;
import Model.*;
import Vue.AdaptateurSourisPlateau;
import Vue.BanquiseGraphique;
import Vue.CollecteurEvenements;

import java.awt.*;

public class Controleur implements CollecteurEvenements {

    private Fenetre window;
    private GameBoard plateauJeu;

    private JeuAvance jeu;

    int info;


    public Controleur(){
        jeu = null;
        window = null;
        plateauJeu = null;
        info = 0;

    }

    public void toggleHelp(){
        this.window.workingPane.toggleBackingPane();

    }

    public void switchSel(){window.switchPanel(2);}

    public void switchMenu(){
        window.switchPanel(1);
    }

    public void switchGameBoard(){
        window.switchPanel(3);
    }



    @Override
    public void clicSourisPlateau(int coupX, int coupY) {
        for(int i = 0; i < plateauJeu.getBq().getPlateauJeu().size();i++) {
            Shape cell = plateauJeu.getBq().getPlateauJeu().get(i);

            if (cell.contains(coupX, coupY)) {
                if (jeu.getEtat() == JeuAvance.ETAT_PLACEMENTP) {
                    joueCoupPhase1(plateauJeu.getBq().getCoordFromNumber(i));
                } else if(jeu.getEtat() == JeuAvance.ETAT_SELECTIONP || jeu.getEtat() == JeuAvance.ETAT_CHOIXC){
                    joueCoupPhase2(plateauJeu.getBq().getCoordFromNumber(i));
                    if(jeu.getSelection())
                        info = i;
                    else
                        info = jeu.getJoueur();

                }else if (jeu.getEtat() == JeuAvance.ETAT_FINAL){
                    System.out.println("Test etat final");
                }

                plateauJeu.misAJour(jeu, info);
                break;
            }
        }

    }


    public void setPlateauJeu(GameBoard gb){
        plateauJeu = gb;
        plateauJeu.getBq().addMouseListener(new AdaptateurSourisPlateau(plateauJeu.getBq(), this));
    }

    public void setJeu(JeuAvance j){
        jeu = j;
        jeu.startGame();
    }

    public void setInterface(Fenetre window){
        this.window = window;
    }

    private void joueCoupPhase1(Position p){
        if(jeu.peutPlacer(p.x, p.y))
            jeu.placePingouin(p.x, p.y);
        else
            System.out.println("Peut pas placer ici");
    }


    private void joueCoupPhase2(Position p) {
        if(!jeu.getSelection()){
            if(jeu.pingouinPresent(p.x, p.y) && jeu.getCase(p.x, p.y).pingouinPresent() == jeu.getJoueur()){
                jeu.setSelectionP(p);
            }
        }else{
            Pingouin pingouin = new Pingouin(jeu.getSelectionP().x, jeu.getSelectionP().y);
            Coup c = new Coup(p.x, p.y,pingouin,false);
            if(jeu.peutJouer(c)){
                jeu.joue(c);
            }else{
                //Remplacer par pp
                System.out.println("Coup impossible");
            }
            jeu.unsetSelectionP();
        }

    }

}
