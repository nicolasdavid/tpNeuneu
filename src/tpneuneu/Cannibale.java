package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

public class Cannibale extends Vorace {

    /**
     * 
     * @param a X
     * @param b Y
     */
    public Cannibale(int a, int b,Color color, Point pos, Dimension dim, JCanvas jc) {
     super(a, b,color, pos,dim, jc);
     this.name="Cannibale"+this.nameId;
    }
    /*
  @Override
  public void manger(Mangeable repas) {
  }*/

  @Override
  public void seDeplacer(Loft loft) {
  }
  
   public void manger(LinkedList<Mangeable> repas) {
        int bouffeInt = repas.size();
        
        if (bouffeInt > 0){
            int intABouffer=0;
                
            if (repas.get(intABouffer) instanceof Neuneu) { //if eat a Neuneu
                repas.get(intABouffer).setNiveau(0);
                this.setNiveau(100); //set energie of neuneu eaten to 0 (as dead) and to 100 for the eater
            }
            else if(repas.get(intABouffer).niveau+this.niveau>100){ //if eat a nourriture
                  repas.get(intABouffer).setNiveau(100-repas.get(intABouffer).niveau+this.niveau); //set new niveau
                  this.setNiveau(100); //Neuneu has full energy
            }
            else{
                this.setNiveau(this.niveau+repas.get(intABouffer).niveau);  
                repas.get(intABouffer).setNiveau(0); //no more food           
            }
        }
  }
     	public void draw(Graphics g) {
                if(niveau==0){
		Color c = g.getColor();
		g.setColor(color);
		g.drawRect((this.posX)*20+10,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                if(niveau>0){
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect((this.posX)*20+10,(this.posY)*20,5,5);
                  g.setColor(c);
                }
                
	}   
   
}
