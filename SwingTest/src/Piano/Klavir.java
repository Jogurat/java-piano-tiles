//package Piano;
//
//import java.awt.*;
//import java.util.ArrayList;
//import javax.swing.*;
//
//public class Klavir extends JFrame{
//	
//	ArrayList<JButton> buttonList = new ArrayList<>();
//	
//	public Klavir() {
//		setSize(1000,1000);
//		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//		this.setLocationRelativeTo(null);
//		
//		Composition c = new Composition();
//		Symbol.loadMap();
//		c.readFile("fur_elise");
//		JButton b;
//		for(Symbol i:c.getSymbolList()) {
//			b=new JButton(i.toString());
//			b.setSize(20, 40);
//			add(b);
//		}
//		setVisible(true);
//	}
//	public static void main(String[] args) {
//		new Klavir();
//	}
//}	
//
//	
///**		
//public static void main(String[] args) {
//		
//
//		//pocetne koord klavira
//		int x = 40;
//		int y = 300;
//		
//		JFrame frame = new JFrame();
//		Container c = frame.getContentPane();
//		
//		frame.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
//		
//		String[] noteNames = {"C", "D", "E", "F", "G", "A", "B"};
//		String[] sharpNames = {"C#", "D#", "F#", "G#", "A#"};
//		
//		//frame.setLayout(new FlowLayout());
//		ImageIcon white = new ImageIcon("images/whiteTile.png");
//		ImageIcon black = new ImageIcon("images/blackTile.png");
//		JLayeredPane keyboard = new JLayeredPane();
//		keyboard.setPreferredSize(new Dimension(white.getIconWidth()*7*5, white.getIconHeight()));
//		System.out.println(white.getIconWidth());
//		
//		int[] newX = { x+23, x+white.getIconWidth() + 23, x+white.getIconWidth() * 3 + 23, x+white.getIconWidth() * 4 + 23,
//				x+white.getIconWidth() * 5 + 23 };
//		for (int i = 0; i < 5; i++) {
//			for (int whitei = 0; whitei < 7; whitei++) {
//				JButton button = new JButton(white);
//				button.setPressedIcon(new ImageIcon("images/pressedWhiteTile.png"));
//				JLabel label = new JLabel(noteNames[whitei]+(i+2));
//				label.setBounds(x + 11, y + 50, white.getIconWidth(), white.getIconHeight());
//				button.setBounds(x, y, white.getIconWidth(), white.getIconHeight());
//				x += white.getIconWidth();
//				keyboard.add(button, new Integer(1));
//				keyboard.add(label, new Integer(3));
//			}
//			//pocetno x = 0, white width = 37
//			
//			//crne dirke
//			for (int blacki = 0; blacki < 5; blacki++) {
//				JButton button = new JButton(black);
//				button.setBounds(newX[blacki], y, black.getIconWidth(), black.getIconHeight());
//				button.setPressedIcon(new ImageIcon("images/pressedBlackTile.png"));
//				JLabel label = new JLabel(sharpNames[blacki]+(i+2));
//				label.setBounds(newX[blacki] + 4, y + 30, black.getIconWidth(), black.getIconHeight());
//				//label.setFont(new Font());
//				newX[blacki]+=white.getIconWidth()*7;
//				label.setForeground(Color.WHITE);
//				//newX+=white.getIconWidth()*2;
//				keyboard.add(button, new Integer(2));
//				keyboard.add(label, new Integer(4));
//			} 
//		}
//		frame.add(keyboard);
//		frame.setSize(1500, 500);
//		frame.setVisible(true);
//	}*/
//
