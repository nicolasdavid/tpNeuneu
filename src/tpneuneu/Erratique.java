package tpneuneu;

public class Erratique extends Neuneu {

    /**
     * 
     * @param a position in X
     * @param b position in Y
     */
  public Erratique(int a, int b){
      this.nameId++;
      this.name="Erratique"+this.nameId;
      this.posX=a;
      this.posY=b;
      this.niveau=100;
      this.sexe=(int)Math.random()*2;
  }
  @Override //TODO il va surement falloir ajouter un cas se dans seDeplacer qui se définira 
  public void seDeplacer() {
      this.posX+=(int)Math.random()*6-3;
      this.posY+=(int)Math.random()*6-3;
      this.niveau-=5;
      /**
       * on va appeler la fonction majpresence en dehors de cette fonction
       */

  }

}
