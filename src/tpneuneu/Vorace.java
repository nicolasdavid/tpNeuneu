package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;

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
  public int seDeplacer(Loft loft) {
      this.plusProcheNourriture(loft);
      
      //check no border exeption !
      this.checkBords(20,20);
      
      this.niveau-=10;
      return 1; //needed for some methods
  }
  
     public void manger(LinkedList<Mangeable> repas) {
       super.manger(repas);
   }
  
  
@Override
    public void seReproduire(Loft loft){
      int lvl = 50;
      if (this.niveau>=lvl){
          Boolean findPart = false;
          Mangeable tampon ;
          int i = 0;
          while(!findPart && i<loft.plateau[this.posX][this.posY].listPresence.size()){
              tampon = loft.plateau[this.posX][this.posY].listPresence.get(i);
              // we verify that tampon is a Neuneu 
              // and tampon is not this
              // and tampon as enought energy to make a baby
              // and tampon and this can have a baby together
              if((tampon instanceof Neuneu)&& !(this.equals(tampon)) && tampon.niveau>=lvl && (((Neuneu)tampon).sexe+this.sexe)==1){
                  this.niveau-=lvl;                    
                  tampon.niveau-=lvl;
                  //then the baby is created
                  Vorace baby = new Vorace(this.posX,this.posY,Color.MAGENTA,new Point(this.posX,this.posY),new Dimension(5,5),this.jcanvas);
                  baby.setNiveau(50);
                  findPart=true;
                  loft.populationToAdd.add((Neuneu)baby);
                  baby.majPresence(loft.plateau[this.posX][this.posY]);

              }
              else i++;
          }          
      }
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
