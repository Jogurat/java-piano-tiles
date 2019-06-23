package Piano;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;

public class GUI{
	
	public static MidiPlayer midiPlayer;
	
	
	
	public GUI() {
		super();
		try {
			midiPlayer = new MidiPlayer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void prepareGUI() {
		
		ImageIcon frameIcon = new ImageIcon("images/piano.jpg");
		//pocetne koord klavira
		int x = 100;
		int y = 300;
		
		JFrame frame = new JFrame("MIDIPiano");
		frame.setIconImage(frameIcon.getImage());
		Container c = frame.getContentPane();
		
		frame.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
		
		String[] noteNames = {"C", "D", "E", "F", "G", "A", "B"};
		String[] sharpNames = {"C#", "D#", "F#", "G#", "A#"};
		
		//frame.setLayout(new FlowLayout());
		ImageIcon white = new ImageIcon("images/whitETile.png");
		ImageIcon black = new ImageIcon("images/blackTile.png");
		ImageIcon whitePressed = new ImageIcon("images/PressedWhiteTile.png");
		ImageIcon blackPressed = new ImageIcon("images/pressedBlackTile.png");
		JLayeredPane keyboard = new JLayeredPane();
		keyboard.setPreferredSize(new Dimension(white.getIconWidth()*7*5, white.getIconHeight()));
		System.out.println(white.getIconWidth());
		
		int[] newX = { x+23, x+white.getIconWidth() + 23, x+white.getIconWidth() * 3 + 23, x+white.getIconWidth() * 4 + 23,
				x+white.getIconWidth() * 5 + 23 };
		for (int i = 0; i < 5; i++) {
			for (int whitei = 0; whitei < 7; whitei++) {
				JButton button = new JButton(white);
				button.setPressedIcon(whitePressed);
				String noteName = noteNames[whitei]+(i+2);
				JLabel label = new JLabel(noteNames[whitei]+(i+2));
				label.setBounds(x + 11, y + 50, white.getIconWidth(), white.getIconHeight());
				button.setBounds(x, y, white.getIconWidth(), white.getIconHeight());
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println(Symbol.nameMap.get(noteName));
						midiPlayer.play(Symbol.nameMap.get(noteName));
						
					}
				});
				ButtonPressedAction pressed = new ButtonPressedAction(button);
				//button.addActionListener(pressed);
				
				button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Symbol.keyStrokeMap.get(noteName)), "pressed");
				button.getActionMap().put("pressed", pressed);
				x += white.getIconWidth();
				keyboard.add(button, new Integer(1));
				keyboard.add(label, new Integer(3));
			}
			//pocetno x = 0, white width = 37
			
			//crne dirke
			for (int blacki = 0; blacki < 5; blacki++) {
				JButton button = new JButton(black);
				button.setBounds(newX[blacki], y, black.getIconWidth(), black.getIconHeight());
				button.setPressedIcon(blackPressed);
				String noteName = sharpNames[blacki]+(i+2);
				ButtonPressedAction pressed = new ButtonPressedAction(button);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//System.out.println(Symbol.nameMap.get(noteName));
						midiPlayer.play(Symbol.nameMap.get(noteName));
						
					}
				});
				
				button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Symbol.keyStrokeMap.get(noteName)), "pressed");
				button.getActionMap().put("pressed", pressed);
				//button.setMnemonic(KeyEvent.getExtendedKeyCodeForChar(Symbol.keyStrokeMap.get(noteName).charAt(0)));
				JLabel label = new JLabel(sharpNames[blacki]+(i+2));
				label.setBounds(newX[blacki] + 4, y + 30, black.getIconWidth(), black.getIconHeight());
				//label.setFont(new Font());
				newX[blacki]+=white.getIconWidth()*7;
				label.setForeground(Color.WHITE);
				//newX+=white.getIconWidth()*2;
				keyboard.add(button, new Integer(2));
				keyboard.add(label, new Integer(4));
			} 
		}
		frame.add(keyboard);
		frame.setSize(1500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Symbol.loadMap();
		GUI gui = new GUI();
		gui.prepareGUI();
	}
}
