package Interface;

import Interface.Panes.*;
import Vue.CollecteurEvenements;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BackingPane extends JPanel {
    private CollecteurEvenements collecteur;
    private JPanel context;
    private int etat;
    private int previousState;
    private EmptyBorder wide;
    private EmptyBorder small;

    public BackingPane(CollecteurEvenements c) {
        this.collecteur = c;
        setLayout(new BorderLayout());
        setOpaque(false);
        setBorder(new EmptyBorder(120, 300, 120, 300));
        context = new Aide(collecteur);
        add(context, BorderLayout.CENTER);
        etat = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(GameConstants.BACKGROUND_GRISEE);
        g.fillRect(0, 0, getWidth(), getHeight());
        wide = new EmptyBorder((int)(getHeight()*0.15), (int)(getWidth()*0.15), (int)(getHeight()*0.15), (int)(getWidth()*0.15));
        small = new EmptyBorder((int)(getHeight()*0.15), (int)(getWidth()*0.40), (int)(getHeight()*0.15), (int)(getWidth()*0.40));
        if(etat == 1 || etat == 3){
            setBorder(wide);
        }else{
            setBorder(small);
        }


    }

    public void setPanelLayer(int j){
        this.remove(context);
        if(j == 1){
            this.context = new Aide(collecteur);
            previousState = etat;
            this.etat = 1;
        }else if(j == 2){
            this.context = new Pause(this.collecteur);
            previousState = etat;
            this.etat = 2;
        }else if(j == 3){
            this.context = new Sauvegarde(collecteur);
            previousState = etat;
            this.etat = 3;
        }else if(j == 4){
            this.context = new Chargement(collecteur);
            previousState = etat;
            this.etat = 4;
        }else if(j == 5){
            this.context = new Victoire(collecteur);
            previousState = etat;
            this.etat = 5;
        }
        this.add(context);
        this.revalidate();
        this.repaint();

    }

    public int getPreviousState(){
        return previousState;
    }

    public void reset(){
        etat = 0;
        previousState = 0;
    }



}
