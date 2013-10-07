package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Nourriture extends Mangeable {

  protected int type;
  protected Point place;

  public void setPlace(int a, int b){
      this.place.x=a;
      this.place.y=b;
  }   
  
  public Nourriture(int qte, Point pos, Dimension dim, JCanvas jc){
      super(Color.GREEN,pos,dim,jc);
      this.niveau=qte;
      this.type=(int)Math.random()*2;
      this.place=pos;
      jc.addDrawable(this);
  };

 
    @Override
     	public void draw(Graphics g) {

		Color c = g.getColor();
		g.setColor(color);
		g.drawRect((place.x)*20+10,(place.y)*20+10,5,5);
                  g.setColor(c);
	}    
  


}