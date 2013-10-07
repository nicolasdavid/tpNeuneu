package tpneuneu;

import graphisme.IDrawable;
import graphisme.JCanvas;
import graphisme.ObjetGraphique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Erratique extends Neuneu {

    /**
     * 
     * @param a position in X
     * @param b position in Y
     */
    	

    protected JCanvas jcanvas;
    
  public Erratique(int a, int b, Color color, Point pos, Dimension dim, JCanvas jc){
      super(color,pos,dim,jc);
      
      this.nameId++;
      this.name="Erratique"+this.nameId;
      this.posX=a;
      this.posY=b;
      this.niveau=100;
      this.sexe=(int)Math.random()*2;
      jc.addDrawable(this);
  }
  
  @Override
  public int seDeplacer(Loft loft) {
 
      this.posX+=(int)(Math.random()*6)-3;      
      this.posY+=(int)(Math.random()*6)-3;
     
      //check no border exception !
      this.checkBords(20,20);
      
      this.niveau-=10;
      return 1; //need the return statement for the Mangeable
  }
  
  	public void draw(Graphics g) {
                if(niveau==0){
		Color c = g.getColor();
		g.setColor(color);
		g.drawRect((this.posX)*20,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                if(niveau>0){
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect((this.posX)*20,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                
	}       
}
