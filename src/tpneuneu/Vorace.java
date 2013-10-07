package tpneuneu;

import graphisme.JCanvas;
import java.awt.Dimension;
import java.awt.Point;

public class Vorace extends Erratique {

    /**
     * 
     * @param a X
     * @param b Y
     */
    public Vorace(int a, int b, Point pos, Dimension dim, JCanvas jc){
      super(a, b, pos,dim, jc);
      this.name="Vorace"+this.nameId;
    }
    
  @Override
  public void seDeplacer(Loft loft) {
     // Nourriture plusProche = this.plusProcheNourriture(loft);
      
      //check no border exeption !
      this.checkBords(20,20);
      
      this.niveau-=10;
  }

}