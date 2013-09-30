package tpneuneu;

public class Nourriture implements Mangeable {

  protected int type;

  protected int niveau;
  
  public Nourriture(int qte){
      this.niveau=qte;
      this.type=(int)Math.random()*2;
     
  }

  @Override
  public void setNiveau(int i) {
  }

}