package tpneuneu;

import graphisme.Fenetre;
import java.awt.Color;
import java.util.LinkedList;

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
         * compt countains the number of turn
         */
        int compt=0;
        /**
         * comptMort and comptNourriture allow to display a graveyard of what is removed from the loft
         */
        int comptMort=0;
        int comptNourriture=0;
        while(!loft.population.isEmpty()){
            /**
             * each Neuneu plays one time
             */
            compt++;
            LinkedList<Mangeable> aSupp;
            LinkedList<Neuneu> neuneuSupp = new LinkedList<>();
            
            
            System.out.println("Tour numero "+ compt+ " : le loft contient " + loft.population.size()+ " neuneus");
           
            
            for (Neuneu joueur : loft.population){
                aSupp = new LinkedList<>();
                //timer
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                
                //position before moving
                int a = joueur.getPosX();
                int b = joueur.getPosY();
                //remove Neuneu from ListPresence as he is going to move
                loft.plateau[a][b].listPresence.remove((Mangeable)joueur);
                //the neuneu moves
                joueur.seDeplacer();
                //the neuneu is added to ListPresence of his new position
                int c = joueur.getPosX();
                int d = joueur.getPosY();
                joueur.majPresence(loft.plateau[c][d]);

                //we decided what is going to eat for the neuneu
               int bouffeInt = loft.plateau[c][d].listPresence.size();
               if (bouffeInt > 1){
                   joueur.manger((Mangeable) loft.plateau[c][d].listPresence.get(0));
               }
               
                //we populate a list of Nourriture and Neuneu which are dead in the new case
                for(Mangeable element : loft.plateau[c][d].listPresence){
                    if ((int)element.niveau == 0){
                       aSupp.add((Mangeable)element);
                       System.out.println(element.getClass()+" killed");
                       if (element instanceof Neuneu){
                            neuneuSupp.add((Neuneu)joueur);
                            comptMort++;
                            joueur.setPosX(25+comptMort);
                            joueur.setPosY(0);
                            fen.repaint();
                       }
                       else if (element instanceof Nourriture){
                            comptNourriture++;
                            fen.repaint();
                            //((Nourriture)element).setPosX(25+comptNourriture);
                            //((Nourriture)element).setPosY(2);
                    }
                    }
                }
                //we remove those elements from the new case
                for(Mangeable element : aSupp){
                    loft.plateau[c][d].listPresence.remove(element);
                }             
               
                //display is refreshed
                fen.repaint();
                }
            for (Neuneu element : neuneuSupp){
                loft.population.remove(element);
            }
        }
        System.out.println("fini");
    }
}
