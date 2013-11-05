import javax.swing.*;
import java.awt.event.*;

public class screen extends JFrame {

    private JPanel panel,panel1;
    private JButton button;
    private JLabel label;
    private JTextField server_id,username_id,password_id,extention_id;

    private int totalClicked;

    	public void screen(){

	    	totalClicked = 0;

	    	//setup JFrame
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		panel = new JPanel();
	
		button = new JButton("Enter");

		server_id = new JTextField(10);
		extention_id = new JTextField(10);
		username_id = new JTextField(10);
		password_id = new JTextField(10);

		label = new JLabel(" ");
		
		button.addActionListener(new ActionListener(){
		    
		    public void actionPerformed(ActionEvent e){
			label.setText("enter is clicked " + totalClicked);
			totalClicked++;
			}
		});
		
		panel.add(button);
		panel.add(label);
		panel.add(server_id);
		panel.add(extention_id);
		panel.add(username_id);
		panel.add(password_id);

		this.add(panel);
		this.setVisible(true);
	}	
}
