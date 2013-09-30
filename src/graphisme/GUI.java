/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphisme;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
