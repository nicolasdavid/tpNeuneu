package tpneuneu;

import graphisme.JCanvas;
import java.awt.Dimension;
import java.awt.Point;

public class Cannibale extends Vorace {

    /**
     * 
     * @param a X
     * @param b Y
     */
    public Cannibale(int a, int b, Point pos, Dimension dim, JCanvas jc) {
     super(a, b, pos,dim, jc);
     this.name="Cannibale"+this.nameId;
    }
    /*
  @Override
  public void manger(Mangeable repas) {
  }*/

  @Override
  public void seDeplacer() {
  }

}