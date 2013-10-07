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
         * Creation of the display
         */
        
        Fenetre fen = new Fenetre();
        fen.getJCanvas().setBackground(Color.WHITE);
        /**
         * Initialisation of the Loft (includes its inhabitants) 
         * /!\ The size of the plateau need to be set to (20,20)
         */
        Loft loft = new Loft(20,20,fen.getJCanvas());
        
        
        /**
         * each Neuneu plays one time
         */
        for (Neuneu joueur : loft.population){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            int a = joueur.getPosX();
            int b = joueur.getPosY();
            //remove Neuneu from ListPresence as he is going to move
            loft.plateau[a][b].listPresence.remove((Mangeable)joueur);
            //the neuneu moves
            joueur.seDeplacer();
            //the neuneu is added to ListPresence of his new position
            joueur.majPresence(loft.plateau[joueur.getPosX()][joueur.getPosY()]);
            //display is refreshed
            fen.repaint();
        }
    }
}
