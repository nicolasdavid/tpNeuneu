/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpneuneu;

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
        
        JCanvas jc = new JCanvas();
        jc.setBackground(Color.WHITE);
        jc.setPreferredSize(new Dimension(400,400));
        GUI.showOnFrame(jc,"loft");
        Loft loft = new Loft(20,20,jc);
        
        /*
        for (Neuneu joueur : loft.population){
            int a = joueur.getPosX();
            int b = joueur.getPosY();
            //on retire le joueur de sa case
            loft.plateau[a][b].listPresence.remove((Mangeable)joueur);
            joueur.seDeplacer();
            joueur.majPresence(loft.plateau[joueur.getPosX()][joueur.getPosY()]);
        }*/
    }
}
