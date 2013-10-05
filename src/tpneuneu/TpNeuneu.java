package tpneuneu;

import graphisme.Fenetre;
import graphisme.GUI;
import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author Nicolas
 */
public class TpNeuneu {

    /**
     * @param args the command line arguments
     */
    
    //CLASSE PRINCIPALE
    public static void main(String[] args) {
        
        
        
        /**
         * initilisation de la liste de population faite dans la construction du loft
         */
        
        /**
         * tour de jeu d'un neuneu
         */
        
        Fenetre fen = new Fenetre();
        fen.getJCanvas().setBackground(Color.WHITE);
        /**
         * The size of the plateau need to be set to (20,20)
         */
        Loft loft = new Loft(20,20,fen.getJCanvas());
        
        
        for (Neuneu joueur : loft.population){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            int a = joueur.getPosX();
            int b = joueur.getPosY();
            //on retire le joueur de sa case
            loft.plateau[a][b].listPresence.remove((Mangeable)joueur);
            loft.plateau[joueur.getPosX()][joueur.getPosY()].listPresence.remove((Mangeable)joueur);
            joueur.seDeplacer();
            joueur.majPresence(loft.plateau[joueur.getPosX()][joueur.getPosY()]);
            fen.repaint();
        }
    }
}
