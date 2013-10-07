package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Vorace extends Erratique {

    /**
     * 
     * @param a X
     * @param b Y
     */
    public Vorace(int a, int b,Color color, Point pos, Dimension dim, JCanvas jc){
      super(a, b,color, pos,dim, jc);
      this.name="Vorace"+this.nameId;
    }
    
  @Override
  public void seDeplacer() {
  }

}