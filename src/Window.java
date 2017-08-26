import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Window extends JFrame
{
	private JLabel text;
	
	public Window()
	{
		setTitle("TMX Data Changer @ Sopoltrad by Zbyszek Góra");
		setSize(450, 90);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon("c:\\base\\logo.png").getImage());
		
		text = new JLabel("Przetwarzanie...");
		text.setBounds(30, 10, 200, 30);
		add(text);
	}
}
