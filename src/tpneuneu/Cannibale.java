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

    /**
     *
     * @param loft
     */
    @Override
     public int seDeplacer(Loft loft) {
        this.plusProcheVoisin(loft);

        //check no border exeption !
        this.checkBords(20,20);

        this.niveau-=10;
        return 1; //needed for some methods
      }
  
    @Override
   public void manger(LinkedList<Mangeable> repas) {
          /**
         * @var bouffeInt the number of elements in the ListePresence
         */
        int bouffeInt = repas.size();
        
        if (bouffeInt > 1){ //if there is more than 1 Mangeable in the case (more than the neuneu recently moved)
            int intABouffer=0;
                
            if (repas.get(intABouffer) instanceof Neuneu) { //if eat a Neuneu
                repas.get(intABouffer).setNiveau(0);
                this.setNiveau(100); //set energie of neuneu eaten to 0 (as dead) and to 100 for the eater
            }
            //if eat a nourriture
            else if(repas.get(intABouffer).niveau+this.niveau>100){ //if eating food would make the niveau >100 for the neuneu
                      repas.get(intABouffer).setNiveau(-100+repas.get(intABouffer).niveau+this.niveau); //set new niveau
                      this.setNiveau(100); //Neuneu has full energy
            }
            else{ //if food.niveau+neuneu.niveau<=100 so will eat totaly the nourriture !
                this.setNiveau(this.niveau+repas.get(intABouffer).niveau);  
                repas.get(intABouffer).setNiveau(0); //no more food           
            }
        }
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
                Cannibale baby = new Cannibale(this.posX,this.posY,Color.BLACK,new Point(this.posX,this.posY),new Dimension(5,5),this.jcanvas);
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
