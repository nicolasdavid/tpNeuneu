package tpneuneu;

public abstract class Neuneu implements Mangeable{

  protected String name;

  protected int sexe;

  protected int niveau;

  public int posX;

  public int posY;

  protected static int nameId=-1;

  public void setNiveau(int i) {
      this.niveau = i;
  }
  
    /**
     * 
     * @param repas repas à manger
     */
  public void manger(Mangeable repas) {
      if (repas instanceof Neuneu) { //if eat a Neuneu
          repas.setNiveau(0);
          this.setNiveau(100); //set energie of neuneu eaten to 0 (as dead) and to 100 for the eater
      }
      else{ //if eat a nourriture
          int niveauRestantNourriture = repas.niveau-this.niveau;
          if(niveauRestantNourriture<0){
                repas.setNiveau(0); //no more nourriture
                this.setNiveau(??); //TODO pas bon vca
          }
          else{
                repas.setNiveau(niveauRestantNourriture);
                this.setNiveau(this.niveau+niveauRestantNourriture);
          }
      }
  }

  public void seReproduire() {
  }

  public abstract void seDeplacer();

  public void majPresence(Case c) {
  }

  /**
   * 
   */
  public void plusProcheVoisin() {
      
      do {          
          
      } while (true);
  }

  public void plusProcheNourriture() {
  }

}