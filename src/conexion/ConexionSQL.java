package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSQL {
    
   Connection conectar = null;
   
   private static com.mysql.jdbc.Connection conn = null;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "sasa";
    private static final String url = "jdbc:mysql://localhost/aprendejugando";
   
   public Connection conexion(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/aprendejugando","root","");
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error de conexion " + e.getMessage());
    }  
    return conectar;
   }
   
}
