package Interface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

public class GameConstants {


    //---------------------------Couleur------------------------------
    public static final Color BACKGROUND_COLOR = new Color(0x88C9D1);
    public static final Color BACKGROUND_GRISEE = new Color(150, 150, 150, 192);
    public static final Color SELECTION = new Color(0x7292A4);
    public static final Color ROUGE = new Color(0xEC1C24);
    public static final Color VERT = new Color(0x0ED145);
    public static final Color BLEU = new Color(0x3F48CC);
    public static final Color JAUNE = new Color(0xFFF200);
    public static final Color ROUGE_CLAIR = new Color(0xeab3b4);
    public static final Color VERT_CLAIR = new Color(0xb3deb7);
    public static final Color BLEU_CLAIR = new Color(0xb6b7dc);
    public static final Color JAUNE_CLAIR = new Color(0xf3edb2);


    //----------------------------Dossier-----------------------------------
    public static final String DOSSIER_SAVE = "resources/sauvegarde/";


    //--------------------------Images plateau-------------------------------
    public static final BufferedImage hPoisson1 = chargeImagePlateau("casePoissons1");
    public static final BufferedImage hPoisson2 = chargeImagePlateau("casePoissons2");
    public static final BufferedImage hPoisson3 = chargeImagePlateau("casePoissons3");

    public static final BufferedImage hVide = chargeImagePlateau("caseVide");

    public static final BufferedImage hPingouinR1 = chargeImagePlateau("caseRouge1");
    public static final BufferedImage hPingouinR2 = chargeImagePlateau("caseRouge2");
    public static final BufferedImage hPingouinR3 = chargeImagePlateau("caseRouge3");

    public static final BufferedImage hPingouinB1 = chargeImagePlateau("caseBleu1");
    public static final BufferedImage hPingouinB2 = chargeImagePlateau("caseBleu2");
    public static final BufferedImage hPingouinB3 = chargeImagePlateau("caseBleu3");


    public static final BufferedImage hPingouinV1 = chargeImagePlateau("caseVert1");
    public static final BufferedImage hPingouinV2 = chargeImagePlateau("caseVert2");
    public static final BufferedImage hPingouinV3 = chargeImagePlateau("caseVert3");

    public static final BufferedImage hPingouinJ1 = chargeImagePlateau("caseJaune1");
    public static final BufferedImage hPingouinJ2 = chargeImagePlateau("caseJaune2");
    public static final BufferedImage hPingouinJ3 = chargeImagePlateau("caseJaune3");


    public static final BufferedImage hPoisson1hR = chargeImagePlateau("brilleRouge1");
    public static final BufferedImage hPoisson2hR = chargeImagePlateau("brilleRouge2");
    public static final BufferedImage hPoisson3hR = chargeImagePlateau("brilleRouge3-2");

    public static final BufferedImage hPoisson1hB = chargeImagePlateau("brilleBleu1");
    public static final BufferedImage hPoisson2hB = chargeImagePlateau("brilleBleu2");
    public static final BufferedImage hPoisson3hB = chargeImagePlateau("brilleBleu3-2");

    public static final BufferedImage hPoisson1hV = chargeImagePlateau("brilleVert1");
    public static final BufferedImage hPoisson2hV = chargeImagePlateau("brilleVert2");
    public static final BufferedImage hPoisson3hV = chargeImagePlateau("brilleVert3-2");

    public static final BufferedImage hPoisson1hJ = chargeImagePlateau("brilleJaune2");
    public static final BufferedImage hPoisson2hJ = chargeImagePlateau("brilleJaune2");
    public static final BufferedImage hPoisson3hJ = chargeImagePlateau("brilleJaune3-2");



    public static final BufferedImage hPingouinR1h = chargeImagePlateau("contourBrilleRouge1");
    public static final BufferedImage hPingouinR2h = chargeImagePlateau("contourBrilleRouge2");
    public static final BufferedImage hPingouinR3h = chargeImagePlateau("contourBrilleRouge3");

    public static final BufferedImage hPingouinB1h = chargeImagePlateau("contourBrilleBleu1");
    public static final BufferedImage hPingouinB2h = chargeImagePlateau("contourBrilleBleu2");
    public static final BufferedImage hPingouinB3h = chargeImagePlateau("contourBrilleBleu3");

    public static final BufferedImage hPingouinV1h = chargeImagePlateau("contourBrilleVert1");
    public static final BufferedImage hPingouinV2h = chargeImagePlateau("contourBrilleVert2");
    public static final BufferedImage hPingouinV3h = chargeImagePlateau("contourBrilleVert3");

    public static final BufferedImage hPingouinJ1h = chargeImagePlateau("contourBrilleJaune1");
    public static final BufferedImage hPingouinJ2h = chargeImagePlateau("contourBrilleJaune2");
    public static final BufferedImage hPingouinJ3h = chargeImagePlateau("contourBrilleJaune3");


    public static final BufferedImage hPoissonG1 = chargeImagePlateau("gris1-2");
    public static final BufferedImage hPoissonG2 = chargeImagePlateau("gris2-2");
    public static final BufferedImage hPoissonG3 = chargeImagePlateau("gris3-2");


    public static final BufferedImage hPingouinRC1 = chargeImagePlateau("brillePingRouge1");
    public static final BufferedImage hPingouinRC2 = chargeImagePlateau("brillePingRouge2");
    public static final BufferedImage hPingouinRC3 = chargeImagePlateau("brillePingRouge3");


    public static final BufferedImage hPingouinBC1 = chargeImagePlateau("brillePingBleu1");
    public static final BufferedImage hPingouinBC2 = chargeImagePlateau("brillePingBleu2");
    public static final BufferedImage hPingouinBC3 = chargeImagePlateau("brillePingBleu3");

    public static final BufferedImage hPingouinVC1 = chargeImagePlateau("brillePingVert1");
    public static final BufferedImage hPingouinVC2 = chargeImagePlateau("brillePingVert2");
    public static final BufferedImage hPingouinVC3 = chargeImagePlateau("brillePingVert3");

    public static final BufferedImage hPingouinJC1 = chargeImagePlateau("brillePingJaune1");
    public static final BufferedImage hPingouinJC2 = chargeImagePlateau("brillePingJaune2");
    public static final BufferedImage hPingouinJC3 = chargeImagePlateau("brillePingJaune3");

    public static final BufferedImage hVideR = chargeImagePlateau("caseRougeTransparent");
    public static final BufferedImage hVideB = chargeImagePlateau("caseBleuTransparent");
    public static final BufferedImage hVideV = chargeImagePlateau("caseVertTransparent");
    public static final BufferedImage hVideJ = chargeImagePlateau("caseJauneTransparent");

    public static final BufferedImage fondMer = chargeImagePlateau("fondMer");

    public static final BufferedImage banquise = chargeImagePlateau("banquiseLarge");


    //--------------------------Images Victoire-------------------------------

    public static final BufferedImage pingouinBleuC = chargeImageVictoire("pingouinBleuWin");
    public static final BufferedImage pingouinRougeC = chargeImageVictoire("pingouinRougeWin");
    public static final BufferedImage pingouinVertC = chargeImageVictoire("pingouinVertWin");
    public static final BufferedImage pingouinJauneC = chargeImageVictoire("pingouinJauneWin");
    public static final BufferedImage relancerPartieB = chargeImageVictoire("boutonRelancerPartie");
    public static final BufferedImage retourMenuB = chargeImageVictoire("boutonRetourMenu");


    //--------------------------Images jeu-------------------------------
    public static final BufferedImage pingouinBleu = chargeImageJeu("pingouinBleu");
    public static final BufferedImage pingouinRouge = chargeImageJeu("pingouinRouge");
    public static final BufferedImage pingouinVert = chargeImageJeu("pingouinVert");
    public static final BufferedImage pingouinJaune = chargeImageJeu("pingouinJaune");
    public static final BufferedImage poisson = chargeImageJeu("poisson");
    public static final BufferedImage hexagone = chargeImageJeu("hexagone");


    //--------------------------Images boutons-------------------------------

    public static final BufferedImage suggestion = chargeImageJeu("boutonAstuce");
    public static final BufferedImage pause = chargeImageJeu("boutonPause");
    public static final BufferedImage annuler = chargeImageJeu("boutonAnnuler");
    public static final BufferedImage refaire = chargeImageJeu("boutonRefaire");
    public static final BufferedImage regenerePlateau = chargeImageJeu("boutonRegen");
    public static final BufferedImage boutonOk = chargeImageJeu("boutonOk");





    private static BufferedImage chargeImagePlateau(String nom) {
        try {
            InputStream in = new FileInputStream("resources/assets/jeu/plateau/" + nom + ".png");
            return ImageIO.read(in);
        } catch (Exception e) {
            System.out.println("Fichier \"" + nom + "\" introuvable");
        }
        return null;
    }


    private static BufferedImage chargeImageJeu(String nom) {
        try {
            InputStream in = new FileInputStream("resources/assets/jeu/menu/" + nom + ".png");
            return ImageIO.read(in);
        } catch (Exception e) {
            System.out.println("Fichier \"" + nom + "\" introuvable");
        }
        return null;
    }


    private static BufferedImage chargeImageVictoire(String nom){
        try {
            InputStream in = new FileInputStream("resources/assets/jeu/victoire/" + nom + ".png");
            return ImageIO.read(in);
        } catch (Exception e) {
            System.out.println("Fichier \"" + nom + "\" introuvable");
        }
        return null;
    }


}
