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
  public Vorace(int a, int b) {
    super(a, b, new Point(0,0), new Dimension(0,0), new JCanvas());
    this.name="Vorace"+this.nameId;
  }
  @Override
  public void seDeplacer() {
  }

}