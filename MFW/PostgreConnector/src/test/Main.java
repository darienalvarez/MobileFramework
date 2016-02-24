package test;

import java.util.List;
import java.util.Properties;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.db.Association;
import com.gazoomobile.mfw.connector.db.Column;
import com.gazoomobile.mfw.connector.db.Table;
import com.gazoomobile.mfw.connector.db.postgres.PostgresConnector;

public class Main {
	private String server = "10.31.18.2";
	private String db = "comcel_db";
	private String user = "postgres";
	private String pass = "euromicro";
	private String port = "5432";

	public static void main(String[] args) throws ConnectorException {
		Main main = new Main();
		Properties conf = new Properties();
		conf.setProperty(PostgresConnector.PASS_PROP_KEY, main.pass);
		conf.put(PostgresConnector.PORT_PROP_KEY, main.port);
		conf.setProperty(PostgresConnector.SERVER_PROP_KEY, main.server);
		conf.setProperty(PostgresConnector.DB_PROP_KEY, main.db);
		conf.setProperty(PostgresConnector.USER_PROP_KEY, main.user);
		
		PostgresConnector connector = new PostgresConnector(conf);
		
		System.out.println("Leyendo tablas...");
		long time = System.currentTimeMillis();
		List<Table> tables = connector.allTables();
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