package tpneuneu;

public class Lapin extends Neuneu {
    
  public Lapin(int a, int b){
      this.nameId++;
      this.name="Lapin"+this.nameId;
      this.posX=a;
      this.posY=b;
      this.niveau=100;
      this.sexe=(int)Math.random()*2;
  }
  
  @Override
  public void seDeplacer() {
  }

}