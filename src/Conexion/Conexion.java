package Conexion;

import java.sql.*;
import javax.swing.JOptionPane;
	
  public class Conexion {
	  private Connection con=null;
		public Connection getConexion(){
			try {
				
				 con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_medica","root","");
				
				
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Error en la conexión "+e);
			}
		
			return con; 
		}
		

	}