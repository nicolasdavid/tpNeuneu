package tpneuneu;

import java.util.LinkedList;

public class Case {

  protected int x;

  protected int y;

  protected LinkedList<Mangeable> listPresence;
  
  
  //constructeur
  public Case(int a, int b){
      this.x = a ;
      this.y = b ;
      this.listPresence = new LinkedList<>();
  }

}