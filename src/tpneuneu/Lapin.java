package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Lapin extends Neuneu {
    
  public Lapin(int a, int b,Color color, Point pos, Dimension dim, JCanvas jc){
      super(color,pos,dim,jc);
      
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



      	public void draw(Graphics g) {
                if(niveau==0){
		Color c = g.getColor();
		g.setColor(color);
		g.drawRect((this.posX)*20+15,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                if(niveau>0){
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect((this.posX)*20+15,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                
	}      
}
