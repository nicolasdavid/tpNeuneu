package tpneuneu;

public class Erratique extends Neuneu {

    /**
     * 
     * @param a position in X
     * @param b position in Y
     */
  public Erratique(int a, int b){
      this.name="Erratique"+this.nameId;
      this.posX=a;
      this.posY=b;
      this.niveau=100;
      this.sexe=(int)Math.random()*2;
      this.nameId++;
  }
  @Override
  public void seDeplacer() {
  }

}