/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kamal
 */
public class ConnectDB {
    private String url = "jdbc:mysql://localhost/cdc";
	private String user = "root";
	private String passwd = "";
	private Connection conn ;
	private static ConnectDB mycnx ;


	public static int exec(String req) throws SQLException {// cud
		  Connection conn =  ConnectDB.connectionFactory().getConn();
			Statement state = (Statement) conn.createStatement();
			return state.executeUpdate(req);
	}

	public static ResultSet load(String request) throws SQLException{//r ==selet
		Connection conn =  ConnectDB.connectionFactory().getConn();
		Statement state = (Statement) conn.createStatement();
		ResultSet beans = state.executeQuery(request);
		return beans;
	}
	public static ConnectDB connectionFactory(){
		if(mycnx == null )
			mycnx =  new ConnectDB();

		return mycnx;
	}


	private ConnectDB(){

		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = (Connection) DriverManager.getConnection(url, user, passwd);

	} catch (Exception e) {
		e.printStackTrace();
	}
}


	public void loadAssocietedAccount(int id){


	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
       

    
}
