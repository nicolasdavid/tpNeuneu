/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphisme;

/**
 *
 * @author Nicolas
 */

import java.awt.Graphics;
import java.awt.Rectangle;

public interface IDrawable {
	
	public  void draw(Graphics g);

	public Rectangle getRectangle();
}
