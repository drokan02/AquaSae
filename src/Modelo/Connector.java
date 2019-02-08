package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connector {

  protected Connection conexion;
  private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost/aquasae";
  private final String user = "root";
  private final String pass = "";

  //metodo para realizar la coneccion
  public final void conectar() {
    Connection con = null;
    try {
      Class.forName(JDBC_DRIVER);
      conexion = DriverManager.getConnection(DB_URL, user, pass);
    } catch (ClassNotFoundException ex) {
         System.out.print(ex);
    } catch (SQLException ex) {
      String error = "Error: " + Errors.errorMessage(ex.getErrorCode(),
              ex.getMessage());
      //JOptionPane.showMessageDialog(null, error, "Mensaje de Error",JOptionPane.ERROR_MESSAGE);
    }
  }

  public final void desconectar() {
    if (conexion != null) {
      try {
        if (!conexion.isClosed()) {
          conexion.close();
        }
      } catch (SQLException ex) {
        String error = "Error: " + Errors.errorMessage(ex.getErrorCode(),
                ex.getMessage());
        //JOptionPane.showMessageDialog(null, error, "Mensaje de Error",JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  public final Connection getConexion() {
    if (conexion == null) {
      conectar();
    }
    return conexion;
  }
}
