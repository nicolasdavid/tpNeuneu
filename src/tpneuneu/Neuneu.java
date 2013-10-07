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
        /**
         * @var bouffeInt the number of elements in the ListePresence
         */
        int bouffeInt = repas.size();
        
        if (bouffeInt > 0){ //if there is more than 1 Mangeable in the case (more than the neuneu recently moved)
            int intABouffer=0, pasManger=0;
                //Case of none cannibale so we search the first not neuneu in ListePresence
                //we do a while to have the first Mangeable different from a Neuneu (not cannibale !)
                while (intABouffer<bouffeInt && repas.get(intABouffer) instanceof Neuneu){
                    intABouffer++;
                }
                if (intABouffer >= bouffeInt){ //no Nourriture, only Neuneu on the case so skip the manger function
                    pasManger = 1;
                }
              
            if (pasManger==0){
                //if eat a nourriture
                if(repas.get(intABouffer).niveau+this.niveau>100){ //if eating food would make the niveau >100 for the neuneu
                      repas.get(intABouffer).setNiveau(-100+repas.get(intABouffer).niveau+this.niveau); //set new niveau
                      this.setNiveau(100); //Neuneu has full energy
                }
                else{ //if food.niveau+neuneu.niveau<=100 so will eat totaly the nourriture !
                    this.setNiveau(this.niveau+repas.get(intABouffer).niveau);  
                    repas.get(intABouffer).setNiveau(0); //no more food           
                }
            }   
        }
  }
 
  public void seReproduire(Loft loft) {
  }

  public abstract int seDeplacer(Loft loft);
  
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
  public int plusProcheVoisin(Loft loft) {
 int i=0;
      int foodFound = 0;
      
      do { 
          for (int m=-1; m<=1; m+=2){
              for (int n=-1; n<=1; n=+2){
                  /**
                   * Take into account the bords effects !
                   */
                  int valeurX =this.posX+i*m;
                  int valeurY =this.posY+i*m;
                  if (this.posX+i*m>=20)
                      valeurX = 19;
                   if (this.posX+i*m<0)
                       valeurX = 0;
                   if (this.posY+i*m>=20)
                      valeurY = 19;
                   if (this.posY+i*m<0)
                       valeurY = 0;
                   
                    for (Mangeable element : loft.plateau[valeurX][valeurY].listPresence)
                          if(element instanceof Neuneu) {
                              ((Neuneu) this).posX = ((Neuneu) element).posX;
                              ((Neuneu) this).posY = ((Neuneu) element).posY;
                              return 1;
                          }
              }
          }
          i++;
      } while (i<10 && foodFound==0);
      
      if(foodFound==1){
        //We get off the while if no close match of food so by default he moves like an erratique
        ((Neuneu) this).seDeplacer(loft);
      }
      return 1;
  }

  public int plusProcheNourriture(Loft loft) {
      int i=0;
      int foodFound = 0;
      
      do { 
          for (int m=-1; m<=1; m+=2){
              for (int n=-1; n<=1; n=+2){
                  /**
                   * Take into account the bords effects !
                   */
                  int valeurX =this.posX+i*m;
                  int valeurY =this.posY+i*m;
                  if (this.posX+i*m>=20)
                      valeurX = 19;
                   if (this.posX+i*m<0)
                       valeurX = 0;
                   if (this.posY+i*m>=20)
                      valeurY = 19;
                   if (this.posY+i*m<0)
                       valeurY = 0;
                   
                    for (Mangeable element : loft.plateau[valeurX][valeurY].listPresence)
                          if(element instanceof Nourriture) {
                              ((Neuneu) this).posX = ((Nourriture) element).posX;
                              ((Neuneu) this).posY = ((Nourriture) element).posY;
                              return 1;
                          }
              }
          }
          i++;
      } while (i<10 && foodFound==0);
      
      if(foodFound==1){
        //We get off the while if no close match of food so by default he moves like an erratique
        ((Neuneu) this).seDeplacer(loft);
      }
      return 1;
  }
  


}
