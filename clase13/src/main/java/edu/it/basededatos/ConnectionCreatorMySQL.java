package edu.it.basededatos;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionCreatorMySQL implements ConnectionCreator {
	Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Connection crearConexion() {
		try {
			logger.debug("Intentando con la parte static del Driver");
			Class.forName ("com.mysql.cj.jdbc.Driver");
			logger.debug("Abriendo base de datos");
			var connStr = "jdbc:mysql://137.184.1.230:3306/bojack";
			var conn = java.sql.DriverManager.getConnection(connStr, "root", "pepaPig");
			
			// conn.close();
			// logger.debug("Cerrando base de datos");
			return conn;
		}
		catch (SQLException ex) {
			logger.error("SQLException");
			logger.error(ex.getMessage());
			throw new RuntimeException(ex.getMessage());
		}
		catch (Exception ex) {
			logger.error("Exception");
			logger.error(ex.getMessage());
			throw new RuntimeException(ex.getMessage());
		}
	}

}
