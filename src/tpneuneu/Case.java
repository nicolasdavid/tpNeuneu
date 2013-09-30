package tpneuneu;

import java.util.LinkedList;

public class Case {

  protected LinkedList<Mangeable> listPresence;
  
  
  //constructeur
  public Case(Mangeable n){
      this.listPresence = new LinkedList<>();
      this.listPresence.add(n);
  }

}