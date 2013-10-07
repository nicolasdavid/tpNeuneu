package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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

    	public void draw(Graphics g) {
                if(niveau==0){
		Color c = g.getColor();
		g.setColor(color);
		g.drawRect((this.posX)*20+5,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                if(niveau>0){
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect((this.posX)*20+5,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                
	}      
}