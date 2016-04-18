package DAO;

import beans.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class ClientDaoImpl implements ClientDao {

    private daoFactory daoFactory;

    public ClientDaoImpl(daoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouterClient(Client c) {
    
         Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO client VALUES(?,?,?,?);");
            preparedStatement.setInt(1, c.getCin());
            preparedStatement.setString(2, c.getFirstname());
            preparedStatement.setString(3, c.getLastname());
            preparedStatement.setString(4, c.getPaymentDeadline());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<SelectItem> getCins()
    {
         List<SelectItem> items = new ArrayList<SelectItem>();
         
          try
        {
            Connection connexion = daoFactory.getConnection();
            PreparedStatement ps;
            ps = connexion.prepareStatement("Select * from client");
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next())
            {
                 int cin = resultat.getInt("cin");
                 items.add(new SelectItem(cin));
            }
            ps.close();
        }
          
          catch(SQLException ex)
         {
             ex.printStackTrace();
         }
          
          return items;
    }

}
