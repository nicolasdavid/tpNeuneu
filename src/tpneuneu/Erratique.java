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
    	

    //protected JCanvas jcanvas;
    
  public Erratique(int a, int b, Color color, Point pos, Dimension dim, JCanvas jc){
      super(color,pos,dim,jc);
      
      this.nameId++;
      this.name="Erratique"+this.nameId;
      this.posX=a;
      this.posY=b;
      this.niveau=100;
      this.sexe=(int)(Math.random()*2);
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
  
    public void seReproduire(Loft loft){
        if (this.niveau>=50){
            Boolean findPart = false;
            Mangeable tampon ;
            int i = 0;
            while(!findPart && i<loft.plateau[this.posX][this.posY].listPresence.size()){
                tampon = loft.plateau[this.posX][this.posY].listPresence.get(i);
                // we verify that tampon is a Neuneu 
                // and tampon is not this
                // and tampon as enought energy to make a baby
                // and tampon and this can have a baby together
                if((tampon instanceof Neuneu)&& !(this.equals(tampon)) && tampon.niveau>=50 && (((Neuneu)tampon).sexe+this.sexe)==1){
                    this.niveau-=50;                    
                    tampon.niveau-=50;
                    //then the baby is created
                    Erratique baby = new Erratique(this.posX,this.posY,Color.RED,new Point(this.posX,this.posY),new Dimension(5,5),this.jcanvas);
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
