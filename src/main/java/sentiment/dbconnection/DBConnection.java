package sentiment.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import sentiment.json.type.JsonTypeGeneral;

public class DBConnection {
	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	private static String url = "jdbc:mysql://localhost:3306/usfdb?autoReconnect=true&useSSL=false";
	private static String usrname = "root";
	private static String password = "hGTUTPHDFTD267";

	public static void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection(url, usrname, password);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from department");
			writeResultSet(resultSet);
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	public static JsonTypeGeneral getAllFeedback() throws Exception {
		JsonTypeGeneral jsonType = new JsonTypeGeneral();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url, usrname, password);
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from feedbacksentence");

			while (resultSet.next()) {
				int sentLabel = resultSet.getInt(4);
				int topicLabel = resultSet.getInt(3);

				switch (topicLabel) {
				case 0:
					jsonType.setNumLec();
					System.out.println(jsonType.getNumLec());
					switch (sentLabel) {
					case 0:
						jsonType.setNumNeg();
						jsonType.setLecNeg();
						break;
					case 1:
						jsonType.setNumNeu();
						jsonType.setLecNeu();
						break;
					case 2:
						jsonType.setNumPos();
						jsonType.setLecPos();
						break;
					}
					break;
				case 1:
					jsonType.setNumCur();
					switch (sentLabel) {
					case 0:
						jsonType.setNumNeg();
						jsonType.setCurNeg();
						break;
					case 1:
						jsonType.setNumNeu();
						jsonType.setCurNeu();
						break;
					case 2:
						jsonType.setNumPos();
						jsonType.setCurPos();
						break;
					}
					break;
				case 2:
					jsonType.setNumfac();
					switch (sentLabel) {
					case 0:
						jsonType.setNumNeg();
						jsonType.setFacNeg();
						break;
					case 1: 
						jsonType.setNumNeu();
						jsonType.setFacNeu();
						break;
					case 2:
						jsonType.setNumPos();
						jsonType.setFacPos();
						break;
					}
					break;
				case 3:
					jsonType.setNumOth();
					switch (sentLabel) {
					case 0:
						jsonType.setNumNeg();
						jsonType.setOthNeg();
						break;
					case 1: 
						jsonType.setNumNeu();
						jsonType.setOthNeu();
						break;
					case 2:
						jsonType.setNumPos();
						jsonType.setOthPos();
						break;
					}
					break;
				}
				
			}

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		
		return jsonType;
	}

	private static void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
	}

	private static void writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			String user = resultSet.getString("myuser");
			String website = resultSet.getString("webpage");
			String summary = resultSet.getString("summary");
			Date date = resultSet.getDate("datum");
			String comment = resultSet.getString("comments");
		}
	}

	// You need to close the resultSet
	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

	public static void main(String args[]) {
		try {
			getAllFeedback();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
