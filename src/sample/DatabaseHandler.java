package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends configs {
    Connection dbConnection;
    public Connection getDBConnection() throws ClassNotFoundException, SQLException{
        String connection_string = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName+ "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
Class.forName("com.mysql.cj.jdbc.Driver");

dbConnection = DriverManager.getConnection(connection_string,dbUser,dbPass);
return dbConnection;
    }
 public void signUpUser(String login, String password){

     try{String insert = "INSERT INTO "+ Const.USER_TABLE+"("+
             Const.USER_LOGIN+","+Const.USER_PASSWORD+")VALUES(?,?)";
         PreparedStatement prSt = getDBConnection().prepareStatement(insert);

         prSt.setString(1,login);
         prSt.setString(2,password);
         prSt.executeUpdate();}
     catch(SQLException e){e.printStackTrace();}
     catch (ClassNotFoundException e) {
         e.printStackTrace();
     }

 }
 public ResultSet getUser(String login, String password) {
     ResultSet reSet = null;
     String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
             Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
     try {
         PreparedStatement prSt = getDBConnection().prepareStatement(select);

         prSt.setString(1, login);
         prSt.setString(2, password);
        reSet= prSt.executeQuery();
     } catch (SQLException e) {
         e.printStackTrace();
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
     }
     return reSet;
 }
}
