package Interface.Panes;

import Interface.GameConstants;
import Interface.SaveElm.SaveList;
import Vue.CollecteurEvenements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileInputStream;

public class Sauvegarde extends JPanel {

    private SaveList listeSave;
    private JLabel titre;
    private JButton valider;
    private JButton retour;
    private CollecteurEvenements collecteur;
    private GridBagLayout layout;
    private Image flecheRetour;
    private Image val;

    public Sauvegarde(CollecteurEvenements c){
        File d = new File("resources/sauvegarde");
        d.mkdir();
        //setBorder(new EmptyBorder(50, 50, 50, 50));
        setBackground(GameConstants.BACKGROUND_COLOR);

        try{
            flecheRetour = (Image) ImageIO.read(new FileInputStream("resources/assets/menu/flecheRetour.png"));
            val = (Image) ImageIO.read(new FileInputStream("resources/assets/menu/boutonValider.png"));
        }catch(Exception e){
            System.err.println("une erreur " + e);
        }
        collecteur = c;
        listeSave = new SaveList();
        titre = new JLabel("Sauvegarde de la partie actuelle");
        valider = new JButton();
        retour = new JButton();
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);

        valider.setBorderPainted(false);
        valider.setContentAreaFilled(false);

        layout = new GridBagLayout();
        setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        add(retour, gbc);


        //
        gbc.gridx = 0;
        gbc.gridy =1;
        gbc.gridwidth =  5;
        gbc.weightx = 5;
        gbc.anchor = GridBagConstraints.NORTH;
        add(titre, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        //gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 3;
        gbc.weighty = 3;
        add(listeSave, gbc);

        gbc.weighty = 0;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        add(valider, gbc);

        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = listeSave.getText();
                if(res == ""){
                    JOptionPane.showInternalMessageDialog(null, "<html>Le nom entré <br>n'est pas correct</html>");
                }else{
                    c.save(res);
                    JOptionPane.showInternalMessageDialog(null, "Sauvegarde terminé");
                    collecteur.togglePause(false);
                }

            }
        });

        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collecteur.togglePause(false);
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 3;
                gbc.weighty = 3;
                gbc.insets = new Insets(0, (int)(getWidth()*0.2), 0 , (int)(getHeight()*0.2 ));
                layout.setConstraints(listeSave, gbc);
                retour.setIcon(new ImageIcon(reScale(0.5f, flecheRetour )));
                valider.setIcon(new ImageIcon(reScale(0.4f, val )));
            }
        });

    }

    public Image reScale(float percent, Image img){
        return img.getScaledInstance((int)(img.getWidth(null)*percent), (int)(img.getHeight(null)*percent), Image.SCALE_FAST  );
    }

}
