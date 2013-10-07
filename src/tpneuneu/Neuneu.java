package tpneuneu;

import graphisme.JCanvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;

public abstract class Neuneu extends Mangeable{

  protected String name;
  protected int sexe;
  protected int posX;
  protected int posY;
  protected static int nameId=-1;


  

  
  // getters
  public int getPosX(){
      return this.posX;
  }
  
    public int getPosY(){
      return this.posY;
  }
    
  public String getName(){
      return this.name;
  }
    public void setPosX(int i){
     posX=i;
  }  
    
  public void setPosY(int j){
     posY=j;
  }
    /**
     * 
     * @param repas repas à manger
     */
   public Neuneu(Color color, Point pos, Dimension dim, JCanvas jc){
                super(color,pos,dim,jc);
   }; 
    
    
  public void manger(LinkedList<Mangeable> repas) {
        int bouffeInt = repas.size();
        
        if (bouffeInt > 0){
            int intABouffer=0, pasManger=0;
            //Case of none cannibale so we search the first not neuneu in ListePresence
                while (intABouffer<bouffeInt && repas.get(intABouffer) instanceof Neuneu){
                    intABouffer++;
                }
                if (intABouffer >= bouffeInt){ //no Nourriture, only Neuneu on the case so skip the manger function
                    pasManger = 1;
                }
              
            if (pasManger==0){
                //if eat a nourriture
                if(repas.get(intABouffer).niveau+this.niveau>100){
                      repas.get(intABouffer).setNiveau(100-repas.get(intABouffer).niveau+this.niveau); //set new niveau
                      this.setNiveau(100); //Neuneu has full energy
                }
                else{
                    this.setNiveau(this.niveau+repas.get(intABouffer).niveau);  
                    repas.get(intABouffer).setNiveau(0); //no more food           
                }
            }   
        }
  }
 
  public void seReproduire() {
  }

  public abstract void seDeplacer(Loft loft);
  
       /**
       * Prevents out of bound for posX and posY
       */
  public void checkBords(int maxX, int maxY){
      if (this.posX>=maxX) 
          this.posX=maxX-1;
      if (this.posX<0)
          this.posX=0;
      
      if (this.posY>=maxY)
          this.posY=maxY-1;
      if (this.posY<0)
          this.posY=0;
  } 

  public void majPresence(Case c) {
      c.listPresence.add((Mangeable)this);
  }

  /**
   * 
   */
  public Neuneu plusProcheVoisin(Loft loft) {
      int i=0;
      
      do { 
          for (int m=-1; m<=1; m+=2){
              for (int n=-1; n<=1; n=+2){
                    for (Mangeable element : loft.plateau[this.posX+i*m][this.posY+i*n].listPresence)
                          if(element instanceof Neuneu) {
                              return (Neuneu) element;
                          }
              }
          }
      } while (true);
  }

  public Nourriture plusProcheNourriture(Loft loft) {
      int i=0;
      
      do { 
          for (int m=-1; m<=1; m+=2){
              for (int n=-1; n<=1; n=+2){
                    for (Mangeable element : loft.plateau[this.posX+i*m][this.posY+i*n].listPresence)
                          if(element instanceof Nourriture) {
                              return (Nourriture) element;
                          }
              }
          }
      } while (true);
  }
  


}
