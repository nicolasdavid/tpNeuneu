package tpneuneu;

import java.util.LinkedList;

public class Loft {

  protected int h;

  protected int w;

  public Case[][] plateau;

  public LinkedList<Neuneu> population;

  
  
  //constructeur
  public Loft(int a, int b){
      
      this.h=a;
      this.w=b;
      this.plateau = new Case[a][b];
      
      for (int k=0;k<a;k++){
          for(int l=0; l<b; l++){
              int qte = (int)(Math.random()*(10+1)+(-1)); 
              Mangeable n = null;
              /**
              * si vaut -1 ==> c'est un neuneu            
              * si vaut 0 ==> pas de case
              * si vaut 1 à 10 ==> case avec de la nourriture
              */
              switch (qte){
                  case -1 : 
                        int type = (int)(Math.random()*(3)); 
                        /**
                        * si vaut 0 ==> erratique            
                        * si vaut 1 ==> vorace
                        * si vaut 2 ==> cannibale
                        * si vaut 3 ==> lapin
                        */
                        switch(type){
                            case 0 :
                                n = new Erratique(k,l);
                                break;
                            case 1 :
                                n = new Vorace(k,l);
                                break;
                            case 2 :
                                n = new Cannibale(k,l);
                                break;
                            default:
                                n = new Lapin(k,l);
                                break;
                        }
                      
                      break;
                  case 0 :
                      break;
                  default :
                      n = new Nourriture(qte);
                      break;                                 
              }
              
              Case c = new Case(n);
          }
      }
  }
}