package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;

public class Cannibale extends Vorace {

    /**
     * 
     * @param a X
     * @param b Y
     */
    public Cannibale(int a, int b,Color color, Point pos, Dimension dim, JCanvas jc) {
     super(a, b,color, pos,dim, jc);
     this.name="Cannibale"+this.nameId;
    }
    /*
  @Override
  public void manger(Mangeable repas) {
  }*/

  @Override
  public void seDeplacer(Loft loft) {
  }
  
   public void manger(LinkedList<Mangeable> repas) {
        int bouffeInt = repas.size();
        
        if (bouffeInt > 0){
            int intABouffer=0, pasManger=0;
            //Case of none cannibale so we search the first not neuneu in ListePresence
                while (intABouffer<bouffeInt && repas.get(intABouffer) instanceof Neuneu){
                    intABouffer++;
                }
                if (intABouffer >= bouffeInt){ //no Nourriture, only Neuneu on the case so skip the manger function
                    pasManger = 1;
                }
              
            if (pasManger==0){
                
                if (repas.get(intABouffer) instanceof Neuneu) { //if eat a Neuneu
                    repas.get(intABouffer).setNiveau(0);
                    this.setNiveau(100); //set energie of neuneu eaten to 0 (as dead) and to 100 for the eater
                }
                else if(repas.get(intABouffer).niveau+this.niveau>100){ //if eat a nourriture
                      repas.get(intABouffer).setNiveau(100-repas.get(intABouffer).niveau+this.niveau); //set new niveau
                      this.setNiveau(100); //Neuneu has full energy
                }
                else{
                    this.setNiveau(this.niveau+repas.get(intABouffer).niveau);  
                    repas.get(intABouffer).setNiveau(0); //no more food           
                }
            }   
        }
  }
   
}
