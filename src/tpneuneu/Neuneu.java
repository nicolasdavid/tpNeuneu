package tpneuneu;

public abstract class Neuneu implements Mangeable{

  protected String name;

  protected int sexe;

  protected int niveau;

  public int posX;

  public int posY;

  protected static int nameId=1;

  public void setNiveau(int i) {
  }

  public void manger(Mangeable repas) {
  }

  public void seReproduire() {
  }

  public abstract void seDeplacer();

  public void majPresence(Case c) {
  }

  public void newOperation() {
  }

  public void plusProcheVoisin() {
  }

  public void plusProcheNourriture() {
  }

}