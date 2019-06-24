package Piano;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.AbstractAction;

public class ButtonPressedAction extends AbstractAction {

	private String noteName;
	private ImageIcon pressedIcon;
	private ImageIcon icon;
	private JButton button;
	
	public ButtonPressedAction(JButton button, String noteName, ImageIcon icon, ImageIcon pressedIcon) {
		this.button = button;
		this.noteName = noteName;
		this.icon = icon;
		this.pressedIcon = pressedIcon;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("akcija");
		button.setIcon(pressedIcon);
		GUI.midiPlayer.play(Symbol.nameMap.get(noteName));
		new Timer(400, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				button.setIcon(icon);
				
			}
		}).start();
		//button.doClick();
		
	}

}
