/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tpneuneu;

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
        
        Loft loft = new Loft(20,20);
        //TODO reste à initialiser la population des neuneus
        
        /**
         * tour de jeu d'un neuneu
         */
        for (Neuneu joueur : loft.population){
            int a = joueur.getPosX();
            int b = joueur.getPosY();
            //on retire le joueur de sa case
            loft.plateau[a][b].listPresence.remove((Mangeable)joueur);
            joueur.seDeplacer();
            joueur.majPresence(loft.plateau[joueur.getPosX()][joueur.getPosY()]);
        }
    }
}
