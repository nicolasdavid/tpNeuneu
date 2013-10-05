package tpneuneu;

import graphisme.JCanvas;
import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;


public class Loft {

  protected int h;

  protected int w;

  public Case[][] plateau;

  public LinkedList<Neuneu> population;

  protected JCanvas jcanvas;
  
  //constructeur
  public Loft(int a, int b, JCanvas jc){
      
      this.jcanvas = jc;
      this.h=a;
      this.w=b;
      this.plateau = new Case[a][b];
      this.population = new LinkedList<>();
      
      for (int k=0;k<a;k++){
          for(int l=0; l<b; l++){
              int qte = (int)(Math.random()*5); 
              Mangeable n = null;
              /**
              * si vaut -1 ==> c'est un neuneu            
              * si vaut 0 ==> pas de case
              * si vaut 1 à 10 ==> case avec de la nourriture
              */
              switch (qte){
                  case (0) : 
                        int type = (int)(Math.random()*(3)); 
                        /**
                        * si vaut 0 ==> erratique            
                        * si vaut 1 ==> vorace
                        * si vaut 2 ==> cannibale
                        * si vaut 3 ==> lapin
                        */
                        switch(type){
                            case 0 :
                                n = new Erratique(k,l, new Point(k,l), new Dimension(5,5),jc);
                                break;
                            case 1 :
                                n = new  Erratique(k,l, new Point(k,l), new Dimension(5,5),jc);
                                break;
                            case 2 :
                                n = new  Erratique(k,l,new Point(k,l), new Dimension(5,5),jc);
                                break;
                            default:
                                n = new  Erratique(k,l, new Point(k,l), new Dimension(5,5),jc);
                                break;
                        }
                        /**
                         * initialisation de la liste de population
                         */
                        this.population.add((Neuneu)n);
                      
                      break;
                  case 1 :
                      break;
                  default :
                      n = new Nourriture(qte,new Point(k,l), new Dimension(5,5),jc );
                      break;                                 
              }
              
              Case c = new Case(n,new Point(k,l),new Dimension(20,20),jc);
              this.plateau[k][l]=c;
          }
      }
  }
}
