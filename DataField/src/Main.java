import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ibm.icu.util.Calendar;

public class Main extends JFrame implements ActionListener {

	JLabel dateLabel;
	JButton button;
	JTextField number;
	
	// Main function
	public static void main(String[] args) {

		Main myWindow = new Main();
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setVisible(true);
	}

	// Constructor 
	public Main() { 
		setSize(300,200);
		setTitle("Example Window");
		setLayout(null);
		
		// text field
		dateLabel = new JLabel("Date");
		dateLabel.setBounds(50,50,300,20);
		add(dateLabel);
		
		// button 
		button = new JButton("Confirm");
		button.setBounds(100,100,100,20);
		add(button);
		button.addActionListener(this);
		
		// user number field
		number = new JTextField();
		number.setBounds(50,70,50,20);
		add(number);
	}

	// action function
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == button) { 			
			Integer userNumber = Integer.parseInt(number.getText());
			
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, userNumber);
			date = calendar.getTime();
			dateLabel.setText(date.toString());
		}
	}
}