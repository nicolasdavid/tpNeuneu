package tpneuneu;

import graphisme.JCanvas;
import graphisme.ObjetGraphique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class Case extends ObjetGraphique {

  protected LinkedList<Mangeable> listPresence;
  protected JCanvas jcanvas;
  protected int x;
  protected int y;
  
  //constructeur
  public Case(Mangeable n, Point pos, Dimension dim, JCanvas jc){
      super(Color.BLACK, pos, dim);
      this.x=pos.x;
      this.y=pos.y;
      this.jcanvas = jc;
      this.listPresence = new LinkedList<>();
      this.listPresence.add(n);
      jc.addDrawable(this);
  }

  
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.drawRect((this.x)*20,(this.y)*20,20,20);
		g.setColor(c);
	}
  
}