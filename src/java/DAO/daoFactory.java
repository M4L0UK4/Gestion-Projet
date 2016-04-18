
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class daoFactory {
    
    
      private String url;
    private String username;
    private String password;

    daoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
     public static daoFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        daoFactory instance = new daoFactory(
                "jdbc:mysql://localhost:3306/teampro", "root", "1234");
        return instance;
    }
     
       public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
       
        public UtilisateurDao getUtilisateurDao() {
        return new UtilisateurDaoImpl(this);
    }
        
           public ClientDao getClientDao() {
        return new ClientDaoImpl(this);
    }
           
           public ProjetDao getProjetDao(){
              return new ProjetDaoImpl(this);
           }
}
