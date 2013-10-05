/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphisme;

/**
 *
 * @author Nicolas
 */

import java.awt.*;

public abstract class ObjetGraphique implements IDrawable {

	
	protected Rectangle rect ;
	protected Color color;
	
	public ObjetGraphique(Color color, Point pos, Dimension dim){
		this.color=color;
		this.rect = new Rectangle(pos,dim);
	}
	
        @Override
	public abstract void draw(Graphics g);
	
        	public Rectangle getRectangle(){
		return (Rectangle) rect.clone();
	}
	
}

