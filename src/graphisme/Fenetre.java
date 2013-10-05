/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphisme;

import javax.swing.JFrame;

/**
 *
 * @author Nicolas
 */
public class Fenetre extends JFrame{
    
    private JCanvas jc ;
    
    public Fenetre(){
        super();
        jc=new JCanvas();
        this.setVisible(true);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(jc);
        
    }
    
    public JCanvas getJCanvas(){
        return jc;
    }
    
    public void actu(){
        this.setVisible(false);
        this.setVisible(true);
    }
}
