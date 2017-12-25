package conexion.uno;
import java.sql.*;

import conexion.Conexion;

public class LLamadorConexion 
{
     public void llamada() {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        String query = "SELECT * FROM empleados";

        try {
            conn = Conexion.getConnection();
            statement = conn.prepareStatement(query);
            resultado = statement.executeQuery();

            while (resultado.next()) {
                System.out.println(resultado.getString(1) + "\t" + resultado.getString(2) + "\t" + resultado.getString(3) + "\t" );
            }
        } 
        catch (Exception e) {
            System.err.println("El porque del cascar: " + e.getMessage());
        } 
        finally {
            Conexion.closeConnection(conn);

        }
    }
    
}
