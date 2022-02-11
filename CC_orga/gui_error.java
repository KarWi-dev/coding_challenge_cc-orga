package CC_orga;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
//======================================================================================
//	
// 			gui_error handles errors and security queries
//				error codes:
//						0=help;
//						1=delete;
//						2=save ;
//						3=syntax;
//						404=not found;
//						5=unknown;
//						6=DBerror; 
//						7=stringError; 
//						8=change; 
//						9=erfolgreich
//
//======================================================================================

public class gui_error
{
	public JFrame frame;


	public gui_error(int code)
	{
		// ========================================================================================================
		// generate frame ->

		frame = new JFrame("Hinweis:");
		frame.setLayout(null);
		frame.setSize(350, 175);

		// ========================================================================================================
		// generate icon and set new icon

		frame.setIconImage(gui_first.img.getImage());

		switch (code)
		{
		case (0) -> help();
		case (1) -> delete();
		case (2) -> save();
		case (3) -> syntax();
		case (404) -> not_found();
		case (5) -> unknown();
		case (6) -> DBerror();
		case (7) -> stringError();
		case (8) -> change();
		case (9) -> erfolgreich();
		}

		// ========================================================================================================
		// set frame to center + set frame visible ->

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	private void erfolgreich() // is shown when the action was successful
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Erfolgreich", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_ok = new JButton("schließen");
		bt_ok.setBounds(90, 100, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(bt_ok);
		frame.add(lb_1);

	}


	private void change() // security query change
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Wirklich ändern?", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_cancel = new JButton("ändern");
		bt_cancel.setBounds(90, 90, 150, 25);
		bt_cancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				sql_handler.manipulate(datahandler.update());
				sql_handler.read(dataset.id);
				datahandler.user();
				sql_handler.manipulate(datahandler.update());
				datahandler.print();
				frame.dispose(); // close the window
			}
		});

		JButton bt_ok = new JButton("abbrechen");
		bt_ok.setBounds(90, 60, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(lb_1);
		frame.add(bt_cancel);
		frame.add(bt_ok);

	}


	private void stringError() // error if name or lastname has not enough chars
	{

		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Vorname muss min. 2 Zeichen lang sein.", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		JLabel lb_2 = new JLabel("Nachname min. 3, bitte mit _ auffüllen", SwingConstants.CENTER);
		lb_2.setBounds(25, 45, 280, 35);
		lb_2.setOpaque(true);
		lb_2.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_ok = new JButton("schließen");
		bt_ok.setBounds(90, 100, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				sql_handler.manipulate(datahandler.deleteN());
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(bt_ok);
		frame.add(lb_1);
		frame.add(lb_2);

	}


	private void DBerror() // error if an database error occurred
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Es ist ein Datenbank Fehler aufgetreten.", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		JLabel lb_2 = new JLabel("Bitte Eingaben prüfen!", SwingConstants.CENTER);
		lb_2.setBounds(25, 45, 280, 35);
		lb_2.setOpaque(true);
		lb_2.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_ok = new JButton("schließen");
		bt_ok.setBounds(90, 100, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(bt_ok);
		frame.add(lb_1);
		frame.add(lb_2);

	}


	private void unknown()// unknown error
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Es ist ein unbekannter Fehler aufgetreten.", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		JLabel lb_2 = new JLabel("Bitte Eingaben prüfen oder neu starten!", SwingConstants.CENTER);
		lb_2.setBounds(25, 45, 280, 35);
		lb_2.setOpaque(true);
		lb_2.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_ok = new JButton("schließen");
		bt_ok.setBounds(90, 100, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(bt_ok);
		frame.add(lb_1);
		frame.add(lb_2);

	}


	private void not_found() // error if tuple not found
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Kein Datensatz gefunden.", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		JLabel lb_2 = new JLabel("Bitte Eingaben prüfen!", SwingConstants.CENTER);
		lb_2.setBounds(25, 45, 280, 35);
		lb_2.setOpaque(true);
		lb_2.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_ok = new JButton("schließen");
		bt_ok.setBounds(90, 100, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(bt_ok);
		frame.add(lb_1);
		frame.add(lb_2);

		// add elements to frame ->
		frame.add(bt_ok);
	}


	private void syntax()// syntax error
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Es ist ein SyntaxFehler aufgetreten.", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		JLabel lb_2 = new JLabel("Bitte Eingaben prüfen!", SwingConstants.CENTER);
		lb_2.setBounds(25, 45, 280, 35);
		lb_2.setOpaque(true);
		lb_2.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_ok = new JButton("schließen");
		bt_ok.setBounds(90, 100, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(bt_ok);
		frame.add(lb_1);
		frame.add(lb_2);

	}


	private void save() // security query for save
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Wirklich speichern?", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_ok = new JButton("speichern");
		bt_ok.setBounds(90, 90, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				//
				sql_handler.manipulate(datahandler.insert());
				sql_handler.read(dataset.name);
				datahandler.newpw();
				datahandler.user();
				gui_change pw = new gui_change();
				sql_handler.manipulate(datahandler.update());

				datahandler.print();
				frame.dispose(); // close the window
			}
		});

		JButton bt_cancel = new JButton("abbrechen");
		bt_cancel.setBounds(90, 60, 150, 25);
		bt_cancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(lb_1);
		frame.add(bt_cancel);
		frame.add(bt_ok);
	}


	private void delete() // security query for delete
	{
		// ========================================================================================================
		// generate labels ->

		JLabel lb_1 = new JLabel("Wirklich löschen?", SwingConstants.CENTER);
		lb_1.setBounds(25, 15, 280, 35);
		lb_1.setOpaque(true);
		lb_1.setBackground(Color.LIGHT_GRAY);

		// ========================================================================================================
		// generate buttons ->

		JButton bt_cancel = new JButton("löschen");
		bt_cancel.setBounds(90, 90, 150, 25);
		bt_cancel.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String delete = "Delete from Teilnehmer where User = '" + dataset.user + "'";
				sql_handler.manipulate(delete);
				datahandler.print();
				frame.dispose(); // close the window
			}
		});

		JButton bt_ok = new JButton("abbrechen");
		bt_ok.setBounds(90, 60, 150, 25);
		bt_ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose(); // closes the window
			}
		});

		// ========================================================================================================
		// add all elements to frame ->

		frame.add(lb_1);
		frame.add(bt_cancel);
		frame.add(bt_ok);
	}


	private void help() // help
	{

		{
			// ========================================================================================================
			// generate framesize ->

			frame.setSize(350, 250);

			// ========================================================================================================
			// generate TextArea ->

			JTextArea ta_help = new JTextArea(); // generate textarea to show help
			ta_help.setLineWrap(true);
			ta_help.setWrapStyleWord(true);
			ta_help.setText("\t" + "-NEU-\r\n" + "- starten einer neuen Eingabe/Suche\r\n" + " \r\n" + "\t"
					+ "-SPEICHERN-\r\n" + "- Die eingegebenen Daten werden in die Datenbank geschrieben\r\n" + "\r\n"
					+ "\t" + "-SUCHEN-\r\n" + "- erscheint erst bei Eingabe des Usernamens\r\n"
					+ "- sucht einen Teilnehmer anhand des Usernamens\r\n" + "\r\n" + "\t" + "-ÄNDERN-\r\n"
					+ "- Ändert die Daten des Teilnehmers mit dem eingegebenen Usernamen in der Datenbank\r\n" + "\r\n"
					+ "\t" + "-LÖSCHEN-\r\n"
					+ "- Löscht den Teilnehmer mit dem angegebenen Usernamen aus der Datenbank\r\n" + "\r\n" + "\t"
					+ "-NEUES PW-\r\n" + "- Generiert ein neues Passwort.\r\n\r\n "
					+ "!! DAS PASSWORT KANN AUS DATENSCHUTZRECHTLICHEN GRÜNDEN NUR BEI DER GENERIERUNG EINGESEHEN WERDEN !!\r\n");

			// ========================================================================================================
			// generate scrollPanel ->

			JScrollPane sc_help = new JScrollPane(ta_help); // combine textarea with scrollpane
			sc_help.setBounds(25, 15, 280, 100);

			// ========================================================================================================
			// generate buttons ->

			JButton bt_ok = new JButton("schließen");
			bt_ok.setBounds(90, 150, 150, 25);
			bt_ok.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					frame.dispose(); // closes the window
				}
			});

			// ========================================================================================================
			// add all elements to frame ->

			frame.add(bt_ok);
			frame.add(sc_help);
		}

	}
}
