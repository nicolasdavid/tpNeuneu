package tpneuneu;

import graphisme.JCanvas;
import graphisme.ObjetGraphique;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Mangeable extends ObjetGraphique{
   
  protected JCanvas jcanvas;  
  protected int niveau;
  
  public abstract void setNiveau(int i);

  
  public Mangeable(Color color, Point pos, Dimension dim, JCanvas jc){
                super(color,pos,dim);
                this.jcanvas = jc;

	}
  

}