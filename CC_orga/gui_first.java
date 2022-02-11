package CC_orga;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

	//======================================================================================
	//			      						 	
	//			class gui_first:						      											
	//		     			
	//			-this class provides the main window of the program							      											
	//			-buttons provide functions for help, saving, refreshing	
	//			-only constructor needet to draw windows with gadgets							      															      											
	//		
	//======================================================================================

public class gui_first
{
	public static JTextField tf_name; 						// declaring fields as public static to be 
	public static JTextField tf_user;						// able to read text from anywhere in the program
	public static JTextField tf_lastname;
	public static JTextField tf_bdate;
	public static JTextField tf_sex;
	public static JTextField tf_adr;
	public static JTextField tf_mail;
	public static JTextField tf_tel;
	public static JButton bt_save;
	public static JButton bt_new;
	public static JButton bt_update;
	public static JButton bt_del;
	public static JButton bt_change;
	public static JPasswordField pf_pw;


	public gui_first()
	{
		// ========================================================================================================
		// generate frame ->
		
		JFrame frame = new JFrame("CC-User_Organisator"); // set up a frame for the window
		frame.setLayout(null);
		frame.setSize(380, 450);
		
		// ========================================================================================================
		// generate icon and set new icon

		ImageIcon img = new ImageIcon("./cc_icon.png");
		frame.setIconImage(img.getImage());
		
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Hier können sie neue Nutzer anlegen,");
		lb_1.setBounds(15, 5, 250, 25);
		JLabel lb_2 = new JLabel("über die Suche ändern/löschen");
		lb_2.setBounds(15, 20, 250, 25);
		JLabel lb_3 = new JLabel("oder ein neues Passwort vergeben:");
		lb_3.setBounds(15, 35, 250, 25);
		
		JLabel lb_name = new JLabel(" Vorname:", SwingConstants.CENTER);
		lb_name.setBounds(15, 75, 120, 25);
		lb_name.setOpaque(true); 					// needed to show BG color
		lb_name.setBackground(Color.LIGHT_GRAY); 	// set BG color

		JLabel lb_lastname = new JLabel(" Nachname:", SwingConstants.CENTER);
		lb_lastname.setBounds(15, 102, 120, 25);
		lb_lastname.setOpaque(true);
		lb_lastname.setBackground(Color.LIGHT_GRAY);

		JLabel lb_bdate = new JLabel(" Geb.-Datum:", SwingConstants.CENTER);
		lb_bdate.setBounds(15, 129, 120, 25);
		lb_bdate.setOpaque(true);
		lb_bdate.setBackground(Color.LIGHT_GRAY);

		JLabel lb_sex = new JLabel(" Geschlecht:", SwingConstants.CENTER);
		lb_sex.setBounds(15, 156, 120, 25);
		lb_sex.setOpaque(true);
		lb_sex.setBackground(Color.LIGHT_GRAY);

		JLabel lb_adr = new JLabel(" Anschrift:", SwingConstants.CENTER);
		lb_adr.setBounds(15, 183, 120, 25);
		lb_adr.setOpaque(true);
		lb_adr.setBackground(Color.LIGHT_GRAY);

		JLabel lb_mail = new JLabel(" Email:", SwingConstants.CENTER);
		lb_mail.setBounds(15, 210, 120, 25);
		lb_mail.setOpaque(true);
		lb_mail.setBackground(Color.LIGHT_GRAY);

		JLabel lb_tel = new JLabel("Telefon:", SwingConstants.CENTER);
		lb_tel.setBounds(15, 237, 120, 25);
		lb_tel.setOpaque(true);
		lb_tel.setBackground(Color.LIGHT_GRAY);

		Character ch = ('\u21c8'); // unicode char "double arrow up"
		char prim = ch.charValue(); // get value of unicode character and parse to char

		JLabel lb_hint = new JLabel(prim + " " + prim + "    zum Suchen: nur");
		lb_hint.setBounds(15, 315, 150, 20);
		lb_hint.setOpaque(true);
		lb_hint.setBackground(Color.LIGHT_GRAY);

		JLabel lb_hint2 = new JLabel(prim + "    Usernamen eingeben");
		lb_hint2.setBounds(15, 330, 150, 25);
		lb_hint2.setOpaque(true);
		lb_hint2.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate textfields ->

		tf_name = new JTextField();
		tf_name.setBounds(150, 75, 200, 25);

		tf_lastname = new JTextField();
		tf_lastname.setBounds(150, 102, 200, 25);

		tf_bdate = new JTextField();
		tf_bdate.setBounds(150, 129, 200, 25);

		tf_sex = new JTextField();
		tf_sex.setBounds(150, 156, 200, 25);

		tf_adr = new JTextField();
		tf_adr.setBounds(150, 183, 200, 25);

		tf_mail = new JTextField();
		tf_mail.setBounds(150, 210, 200, 25);

		tf_tel = new JTextField();
		tf_tel.setBounds(150, 237, 200, 25);

		pf_pw = new JPasswordField();
		pf_pw.setBounds(150, 280, 200, 25);
		pf_pw.setOpaque(true);
		pf_pw.setBackground(Color.LIGHT_GRAY);

		tf_user = new JTextField();
		tf_user.setBounds(15, 280, 120, 25);
		tf_user.addKeyListener(new KeyListener() // listens for input in tf_user to change bt_save text 
		{

			@Override
			public void keyTyped(KeyEvent arg0)
			{
				bt_save.setText("suche");

				if (tf_user.getText().isEmpty())
				{
					bt_save.setText("speichern");
				}
			}

			@Override
			public void keyPressed(KeyEvent arg0)
			{				
			}
			@Override
			public void keyReleased(KeyEvent arg0)
			{
			}
		});

		// ========================================================================================================
		// generate buttons ->

		JButton bt_help = new JButton("HILFE");
		bt_help.setBounds(270, 25, 70, 25);
		bt_help.addActionListener(new ActionListener() //  open new window gui_error with help text
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				gui_error error = new gui_error(0);
			}
		});

		bt_save = new JButton("speichern");
		bt_save.setBounds(15, 375, 100, 25);
		bt_save.addActionListener(new ActionListener() // tuple gets saved if tf_user is empty. if not the according tuple will be read from db and put out
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				datahandler.set();

				if (tf_user.getText().isEmpty())
				{
					bt_save.setText("speichern");
					gui_error error = new gui_error(2);
					frame.remove(bt_save);
					frame.add(bt_new);
				}
				else
				{
					sql_handler.search(dataset.user);
					datahandler.print();
					datahandler.disable();
					bt_del.setEnabled(false);
					bt_update.setEnabled(false);
					bt_change.setEnabled(false);
					frame.remove(bt_save);
					frame.add(bt_new);
				}
			}
		});

		bt_new = new JButton("Neu");
		bt_new.setBounds(15, 375, 100, 25);
		bt_new.addActionListener(new ActionListener() // textfields get enabled and cleared. buttons get enabled. 
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				datahandler.enable(); 
				datahandler.clear();
				bt_del.setEnabled(true);
				bt_update.setEnabled(true);
				bt_change.setEnabled(true);
				frame.add(bt_save);
				frame.remove(bt_new);
			}
		});

		bt_update = new JButton("ändern");
		bt_update.setBounds(120, 375, 90, 25);
		bt_update.addActionListener(new ActionListener() // tupel get written in db and a windows opens to tell u it was succesful. button gets changed
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				datahandler.set();
				gui_error error = new gui_error(8);
				frame.remove(bt_save);
				frame.add(bt_new);
			}
		});

		bt_change = new JButton("neues PW");
		bt_change.setBounds(215, 340, 120, 25);
		bt_change.addActionListener(new ActionListener() // adding actionlistener to bt_help go give it life
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				sql_handler.search(tf_user.getText()); // get tupel from db
				gui_change change = new gui_change(); // open new window to perform action in new window
			}
		});

		bt_del = new JButton("löschen");
		bt_del.setBounds(215, 375, 120, 25);
		bt_del.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				gui_error error = new gui_error(1); // open new window to ask if action should be performed. action performed in new window
			}
		});


		// ========================================================================================================
		// add all elements to main frame ->		
		
		frame.add(lb_1);
		frame.add(lb_2);
		frame.add(lb_3);
		frame.add(lb_name);
		frame.add(lb_lastname);
		frame.add(lb_bdate);
		frame.add(lb_sex);
		frame.add(lb_adr);
		frame.add(lb_mail);
		frame.add(lb_tel);
		frame.add(pf_pw);
		frame.add(lb_hint);
		frame.add(lb_hint2);

		frame.add(tf_name);
		frame.add(tf_lastname);
		frame.add(tf_bdate);
		frame.add(tf_sex);
		frame.add(tf_adr);
		frame.add(tf_mail);
		frame.add(tf_tel);
		frame.add(tf_user);

		frame.add(bt_help);
		frame.add(bt_change);
		frame.add(bt_del);
		frame.add(bt_update);
		frame.add(bt_new);
		
		// ========================================================================================================
		// disable textfields so user needs to click "new" first ->
		
		datahandler.disable();
		
		// ========================================================================================================
		// set frame close operation(X-Button) + set frame visible ->

		frame.setLocationRelativeTo(null); // set frame to middle of monitor
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
