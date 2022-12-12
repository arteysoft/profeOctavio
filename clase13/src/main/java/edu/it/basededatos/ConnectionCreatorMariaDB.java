package edu.it.basededatos;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionCreatorMariaDB implements ConnectionCreator {
	Logger logger = Logger.getLogger(getClass());
	
	public Connection crearConexion() {
		try {
			logger.debug("Intentando con la parte static del Driver");
			Class.forName ("org.mariadb.jdbc.Driver");
			logger.debug("Abriendo base de datos");
			var connStr = "jdbc:mariadb://localhost:3306/bojack";
			var conn = java.sql.DriverManager.getConnection(connStr, "root", "");
			
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
