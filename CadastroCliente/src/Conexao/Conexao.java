package Conexao;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.corba.se.pept.transport.Connection;

//Otimização
public class Conexao {

	    public static void main(String[] args)
	    {
	        String driver = "org.postgresql.Driver";
	        String user   = "postgres";
	        String senha = "postgres";
	        String url      = "jdbc:postgresql://localhost:5432/cadastro";
	        try
	        {
	            Class.forName(driver);
	            Connection con = null;
	            con = (Connection) DriverManager.getConnection(url, user, senha);
	            System.out.println("Conexão realizada com sucesso.");
	        }
	        catch (ClassNotFoundException ex)
	        {
	            System.err.print(ex.getMessage());
	        } 
	        catch (SQLException e)
	        {
	            System.err.print(e.getMessage());
	        }
	    }

private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastro");
	
	public EntityManager getEntityManager() {
		
		return factory.createEntityManager();
	}
	
}