package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Nourriture extends Mangeable {

  protected int type;
  protected Point place;
  protected int posX;
  protected int posY;

    public void setPosX(int i){
     posX=i;
  }  
    
  public void setPosY(int j){
     posY=j;
  }
  
  public Nourriture(int qte,int a, int b, Point pos, Dimension dim, JCanvas jc){
      super(Color.GREEN,pos,dim,jc);
      this.niveau=qte;
      this.posX=a;
      this.posY=b;
      this.type=(int)Math.random()*2;
      jc.addDrawable(this);
  };

 
    @Override
     	public void draw(Graphics g) {
                if(niveau==0){
		Color c = g.getColor();
		g.setColor(color);
		g.drawRect((posX)*20+10,(posY)*20+10,5,5);
                  g.setColor(c);
                }
                else if(niveau>0){
                    		Color c = g.getColor();
		g.setColor(color);
		g.fillRect((posX)*20+10,(posY)*20+10,5,5);
                  g.setColor(c);
                }
	}    
  


}