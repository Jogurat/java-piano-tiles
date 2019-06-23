package Piano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.AbstractAction;

public class ButtonPressedAction extends AbstractAction {

	private String noteName;

	private JButton button;
	
	public ButtonPressedAction(JButton button) {
		this.button = button;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
//		button.setIcon(iconPressed);
//		GUI.midiPlayer.play(Symbol.nameMap.get(noteName));
//		new Timer(400, new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				button.setIcon(icon);
//				
//			}
//		}).start();
		button.doClick(100);
		
	}

}
