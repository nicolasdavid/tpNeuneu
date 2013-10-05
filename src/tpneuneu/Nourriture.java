package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Nourriture extends Mangeable {

  protected int type;

  protected int niveau;
  
  public Nourriture(int qte){
      super(Color.BLACK, new Point(0,0), new Dimension(0,0), new JCanvas());
      this.niveau=qte;
      this.type=(int)Math.random()*2;
     
  }

  @Override
  public void setNiveau(int i) {
  }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  


}