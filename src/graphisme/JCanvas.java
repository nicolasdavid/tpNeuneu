/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphisme;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import java.awt.Graphics;
/**
 *
 * @author Nicolas
 */
public class JCanvas extends JPanel {

	private List drawables = new LinkedList();
	
        @Override
	public void paint(Graphics g) {
		for (Iterator iter = drawables.iterator(); iter.hasNext();) {
			IDrawable d = (IDrawable) iter.next();
			d.draw(g);	
		}
	}

	public void addDrawable(IDrawable d) {
		drawables.add(d);
		repaint();
	}

	public void removeDrawable(IDrawable d) {
		drawables.remove(d);
		repaint();
	}

	public void clear() {
		drawables.clear();
		repaint();
	}
	
}
