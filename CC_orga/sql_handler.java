package CC_orga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//======================================================================================
//			      						 	
//			class sql_handler:						      											
//		     			
//			-this class handels the Database
//				-connection
//					-connect();
//				-queries
//					-search();read();
//				-commands
//					-manipulate();
//		
//======================================================================================
public class sql_handler
{
	static Connection conn = null;
	static Statement stm = null;
	static gui_error error;


	public static Connection connect() // creates the Databaseconnection to communicate with the database
	{

		try
		{
			String url = "jdbc:sqlite:./testdaten.db";

			conn = DriverManager.getConnection(url);

		}
		catch (SQLException e)
		{
			error = new gui_error(6);
		}

		return conn;
	}


	public static void manipulate(String query) // sends commands to the database to manipulate data
	{
		conn = connect();

		try
		{
			stm = conn.createStatement();
			stm.executeUpdate(query);
		}
		catch (Exception e)
		{
			error = new gui_error(404);
		}
		finally
		{

			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}


	public static void search(String user) // sends a query to the database and assigns the tuple to dataset
	{
		conn = connect();

		try
		{
			stm = conn.createStatement();
			String query = "select * from Teilnehmer where User ='" + user + "';";

			ResultSet rs = stm.executeQuery(query);

			if (!rs.isBeforeFirst())
			{
				error = new gui_error(404);
			}
			else
			{

				while (rs.next())
				{

					dataset.name = rs.getString("Name");
					dataset.lastName = rs.getString("LastName");
					dataset.bDate = rs.getString("BDate");
					dataset.sex = rs.getString("Sex");
					dataset.adr = rs.getString("Adr");
					dataset.mail = rs.getString("Mail");
					dataset.tel = rs.getString("Tel");
					dataset.user = rs.getString("User");
					dataset.id = rs.getString("ID");
					dataset.pw = rs.getString("Password");
				}
			}

		}
		catch (SQLException e)
		{
			error = new gui_error(3);
		}
		finally
		{

			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}


	public static void read(String name) // send a query to the database to read name, lastname and id from user, to
											// create username
	{
		conn = connect();

		try
		{
			stm = conn.createStatement();
			String query = "select Name, LastName, ID from Teilnehmer where Name ='" + name + "';";

			ResultSet rs = stm.executeQuery(query);

			while (rs.next())
			{
				dataset.name = rs.getString("Name");
				dataset.lastName = rs.getString("LastName");
				dataset.id = rs.getString("ID");
			}
		}

		catch (SQLException e)
		{
			error = new gui_error(404);
		}
		finally
		{

			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
