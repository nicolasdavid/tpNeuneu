package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Lapin extends Neuneu {
    
  public Lapin(int a, int b){
      super(Color.BLACK, new Point(0,0), new Dimension(0,0), new JCanvas());
      this.nameId++;
      this.name="Lapin"+this.nameId;
      this.posX=a;
      this.posY=b;
      this.niveau=100;
      this.sexe=(int)Math.random()*2;
  }
  
  @Override
  public void seDeplacer() {
  }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}