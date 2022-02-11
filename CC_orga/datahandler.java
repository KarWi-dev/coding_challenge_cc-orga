package CC_orga;

	//================================================================================================
	//			      						 	
	//			class datahandler:						      											
	//		     			
	//			-this class provides the logic	for:					      											
	//												deleteing data,
	//												updateing data,
	//												creating data,
	//												creating user name,
	//												creating a new password,
	//												enabling and clearing the textfields,
	//												printing out the dataset in the textfields
	//												
	//================================================================================================

public class datahandler
{
	public static String deleteN() // delete whole user dataset when wrong
	{
		String delete = "Delete from Teilnehmer where Name = '" + dataset.name + "';)";
		return delete;
	}


	public static String deleteU() // delete whole user dataset
	{
		String delete = "Delete from Teilnehmer where User = '" + dataset.user + "';)";
		return delete;
	}


	public static String update() // change existing dataset
	{
		String update = "Update Teilnehmer set Name = '" + dataset.name + "', LastName = '" + dataset.lastName
				+ "', BDate = '" + dataset.bDate + "', Sex ='" + dataset.sex + "', Adr= '" + dataset.adr + "', Mail = '"
				+ dataset.mail + "', Tel = '" + dataset.tel + "', User = '" + dataset.user + "', Password = '"
				+ dataset.pw + "' where ID = '" + dataset.id + "';";
		return update;
	}


	public static String insert() // create new dataset
	{
		String insert = "Insert into Teilnehmer(Name,LastName,BDate,Sex,Adr,Mail,Tel) values('" + dataset.name + "','"
				+ dataset.lastName + "','" + dataset.bDate + "','" + dataset.sex + "','" + dataset.adr + "','"
				+ dataset.mail + "','" + dataset.tel + "');";
		return insert;
	}


	public static void newpw() // Passwortgenerator
	{
		// ================================================================================================
		//
		// PW generated of 1 each of caps, smalls, numbers, and special chars plus 8 random out of these
		// 
		// ================================================================================================

		String smalls = "abcdefghijklmnopqrstuvwxyz";
		String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String number = "0123456789";
		String special = "!?/\\€&%$§@#*+-{}[]=_";

		dataset.pw = "" + caps.charAt((int) (Math.random() * 26)) + smalls.charAt((int) (Math.random() * 26)) // fill out first 4 chars to match rules
				+ number.charAt((int) (Math.random() * 10)) + special.charAt((int) (Math.random() * 20));

		int i = 8;
		double x = 0;

		while (i > 0) // fill out 8 rest chars with random from random list
		{
			x = Math.random();

			if (x < 0.25)
			{
				dataset.pw += caps.charAt((int) (Math.random() * 26));
			}
			else if (x > 0.25 && x < 0.5)
			{
				dataset.pw += smalls.charAt((int) (Math.random() * 26));
			}
			else if (x > 0.5 && x < 0.75)
			{
				dataset.pw += number.charAt((int) (Math.random() * 10));
			}
			else
			{
				dataset.pw += special.charAt((int) (Math.random() * 20));
			}

			i -= 1;

		}

	}


	public static void user()// create username from first and last name + id
	{

		try
		{
//
//			if (dataset.name == "Anne" & dataset.lastName == "Heyer")
//			{
//				dataset.user = "Padavan1";
//				System.out.println(dataset.user);
//			}
//
//			else if (dataset.name == "Karsten" & dataset.lastName == "Witting")
//			{
//				dataset.user = "Padavan2";
//			}
//
//			else if (dataset.name == "Thomas" & dataset.lastName == "Jackisch")
//			{
//				dataset.user = "Master";
//			}
//
//			else
//			{
			dataset.user = dataset.lastName.substring(0, 3) + dataset.name.substring(0, 2) + dataset.id;
//			}
		}

		catch (Exception e)
		{
			gui_error error = new gui_error(7);
		}
	}


	public static void print() // output the data in textfields
	{
		gui_first.tf_name.setText(dataset.name);
		gui_first.tf_lastname.setText(dataset.lastName);
		gui_first.tf_bdate.setText(dataset.bDate);
		gui_first.tf_sex.setText(dataset.sex);
		gui_first.tf_adr.setText(dataset.adr);
		gui_first.tf_mail.setText(dataset.mail);
		gui_first.tf_tel.setText(dataset.tel);
		gui_first.tf_user.setText(dataset.user);
		gui_first.pf_pw.setText(dataset.pw);

	}


	public static void set() // save inout data in dataset
	{
		dataset.name = gui_first.tf_name.getText();
		dataset.lastName = gui_first.tf_lastname.getText();
		dataset.bDate = gui_first.tf_bdate.getText();
		dataset.sex = gui_first.tf_sex.getText();
		dataset.adr = gui_first.tf_adr.getText();
		dataset.mail = gui_first.tf_mail.getText();
		dataset.tel = gui_first.tf_tel.getText();
		dataset.user = gui_first.tf_user.getText();

	}


	public static void clear() // clear the textfields
	{
		gui_first.tf_name.setText("");
		gui_first.tf_lastname.setText("");
		gui_first.tf_bdate.setText("");
		gui_first.tf_sex.setText("");
		gui_first.tf_adr.setText("");
		gui_first.tf_mail.setText("");
		gui_first.tf_tel.setText("");
		gui_first.tf_user.setText("");
	}


	public static void disable() // make textfields non editable
	{
		gui_first.tf_name.setEditable(false);
		gui_first.tf_lastname.setEditable(false);
		gui_first.tf_bdate.setEditable(false);
		gui_first.tf_sex.setEditable(false);
		gui_first.tf_adr.setEditable(false);
		gui_first.tf_mail.setEditable(false);
		gui_first.tf_tel.setEditable(false);
		gui_first.tf_user.setEditable(false);
	}


	public static void enable() // make textfields editable
	{
		gui_first.tf_name.setEditable(true);
		gui_first.tf_lastname.setEditable(true);
		gui_first.tf_bdate.setEditable(true);
		gui_first.tf_sex.setEditable(true);
		gui_first.tf_adr.setEditable(true);
		gui_first.tf_mail.setEditable(true);
		gui_first.tf_tel.setEditable(true);
		gui_first.tf_user.setEditable(true);
	}
}
