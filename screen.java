import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class screen extends JFrame {
		
    	public void screen(){

	    	//setup JFrame
		JFrame jf = new JFrame();
		setVisible(true);
		setTitle("Polycom Phone Dialer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//setup JLabel
	    	JLabel jl = new JLabel();
		setSize(850,250);

		//set up buttons
		JButton enterBtn = new JButton("Enter");
		setVisible(true);

		//adding elements to window
		add(jl);
		add(enterBtn);
	}	

}
