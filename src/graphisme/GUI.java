/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphisme;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Nicolas
 */
public class GUI {
        	
	public static void showOnFrame(JComponent component, String frameName) {
		JFrame frame = new JFrame(frameName);

		frame.getContentPane().add(component);
		frame.pack();
		frame.setVisible(true);
	}
    
}
