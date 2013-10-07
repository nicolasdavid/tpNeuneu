package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Lapin extends Neuneu {
    
  public Lapin(int a, int b, Point pos, Dimension dim, JCanvas jc){
      super(Color.RED,pos,dim,jc);
      
      this.nameId++;
      this.name="Lapin"+this.nameId;
      this.posX=a;
      this.posY=b;
      this.niveau=100;
      this.sexe=(int)Math.random()*2;
      jc.addDrawable(this);
  }
  
  @Override
  public void seDeplacer(Loft loft) {
  }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}