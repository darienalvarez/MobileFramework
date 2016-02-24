package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import oracle.jdbc.pool.OracleDataSource;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.db.Association;
import com.gazoomobile.mfw.connector.db.AssociationColumn;
import com.gazoomobile.mfw.connector.db.Column;
import com.gazoomobile.mfw.connector.db.Table;
import com.gazoomobile.mfw.connector.db.oracle.OracleConnector;

public class Main {
	private String server = "10.36.19.106";
	private String sid = "UPPDB";
	private String user = "patrulla";
	private String pass = "desarrollo";
	private int port = 1521;

	private OracleDataSource datasource;

	public Connection getConnection() throws SQLException {
		if(datasource == null) {
			datasource = new OracleDataSource();
			datasource.setServerName(server);
			datasource.setServiceName(sid);
			datasource.setUser(user);
			datasource.setPassword(pass);
			datasource.setPortNumber(port);
			datasource.setDriverType("thin");
		}

		return datasource.getConnection();
	}

	public static void main(String[] args) throws ConnectorException {
		ej2();
	}
	
	static void ej2() throws ConnectorException {
		Main main = new Main();
		Properties conf = new Properties();
		conf.setProperty(OracleConnector.PASS_PROP_KEY, main.pass);
		conf.setProperty(OracleConnector.PORT_PROP_KEY, String.valueOf(main.port));
		conf.setProperty(OracleConnector.SERVER_PROP_KEY, main.server);
		conf.setProperty(OracleConnector.SID_PROP_KEY, main.sid);
		conf.setProperty(OracleConnector.USER_PROP_KEY, main.user);
		
		OracleConnector connector = new OracleConnector(conf);
		
		System.out.println("Leyendo tablas con relaciones...");
		long time = System.currentTimeMillis();
		
		List<Table> tables = connector.allTablesWithAssociationsByOwner("PATRULLA");
		System.out.println((System.currentTimeMillis() - time)/1000 + " segundos");
		
		for (Table t : tables) {
			System.out.println("------------------------------------------------");
			System.out.println("Tabla: " + t.getName());
			
			List<Column> cols = t.getColumns();
			if(cols.size() > 0) {
				System.out.println("Columnas:");
				
				for (Column col : cols) {
					System.out.print("Nombre: " + col.getColumnName() + " de tipo: " + col.getColumnType() + " ");
					
					if(col instanceof AssociationColumn) {
						AssociationColumn asscol = (AssociationColumn) col;
						
						System.out.println(", Asociacion en el campo: " + asscol.getAssociationColumn().getColumnName() +
								" de la tabla: " + asscol.getAssociationTable());
					}
					else {
						System.out.println();
					}
				}
			}
		}
	}
	
	static void ej1() throws ConnectorException {
		Main main = new Main();
		Properties conf = new Properties();
		conf.setProperty(OracleConnector.PASS_PROP_KEY, main.pass);
		conf.setProperty(OracleConnector.PORT_PROP_KEY, String.valueOf(main.port));
		conf.setProperty(OracleConnector.SERVER_PROP_KEY, main.server);
		conf.setProperty(OracleConnector.SID_PROP_KEY, main.sid);
		conf.setProperty(OracleConnector.USER_PROP_KEY, main.user);
		
		OracleConnector connector = new OracleConnector(conf);
		
		System.out.println("Leyendo tablas...");
		long time = System.currentTimeMillis();
		List<Table> tables = connector.allTablesByOwner("PATRULLA");
		System.out.println((System.currentTimeMillis() - time)/1000 + " segundos");
		
		System.out.println("Leyendo relaciones...");
		time = System.currentTimeMillis();
		List<Association> associations = connector.allTablesAssociations(tables.toArray(new Table[] {}));
		System.out.println((System.currentTimeMillis() - time)/1000 + " segundos");
		
		for (Table table : tables) {
			System.out.println("Tabla: " + table.getName());

			if(table.getColumns().size() > 0) {
				System.out.println("Columnas:");
				for (Column col : table.getColumns()) {
					System.out.println(">> Nombre: " + col.getColumnName() + " de Tipo: " + col.getColumnType());
				}
			}
			
			System.out.println("Relaciones:");
			for (Association association : associations) {
				if(association.getSourceTable().equals(table.getName())) {
					System.out.println(">> Campo Origen: " + association.getSource().getColumnName() 
							+ " en el Campo: " + association.getTarget().getColumnName()
							+ " de la tabla: " + association.getTargetTable());
				}
			}

		}
	}
}