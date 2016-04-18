package DAO;

import beans.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

public class UtilisateurDaoImpl implements UtilisateurDao{
    
     private daoFactory daoFactory;

    UtilisateurDaoImpl(daoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
     
    public Utilisateur verifierUser(int c, String p) {



        Utilisateur u = null;
        try {
            Connection connexion = daoFactory.getConnection();
            PreparedStatement ps = connexion.prepareStatement("SELECT * FROM utilisateur where cin=" + c + " and password='" + p + "' ;");
            ResultSet resultat = ps.executeQuery();


            if (resultat.next()) {
                int cin = resultat.getInt("cin");
                String password = resultat.getString("password");
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                String email = resultat.getString("e-mail");
                String image = resultat.getString("image");
                int idProfile = resultat.getInt("idProfile");
                int idRole=resultat.getInt("idRole");
                u = new Utilisateur(cin, firstname, lastname, email, password, image, idProfile, idRole);

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;

    }
    
    
    public List<Utilisateur> getAllUsers()
    {
        List<Utilisateur> lu= new ArrayList();
        
        try
        {
            Connection connexion = daoFactory.getConnection();
            PreparedStatement ps;
            ps = connexion.prepareStatement("Select * from utilisateur");
            ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()) {
                
                int cin = resultat.getInt("cin");
                String password = resultat.getString("password");
                String firstname = resultat.getString("firstname");
                String lastname = resultat.getString("lastname");
                String email = resultat.getString("e-mail");
                String image = resultat.getString("image");
                int idProfile = resultat.getInt("idProfile");
                int idRole=resultat.getInt("idRole");
              Utilisateur  u = new Utilisateur(cin, firstname, lastname, email, password, image, idProfile, idRole);
                lu.add(u);
                
            }
            ps.close();
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return lu;
        
    }
    
    
    public List<SelectItem> getCins()
    {
        List<SelectItem> items = new ArrayList<SelectItem>();
        
         try
        {
            Connection connexion = daoFactory.getConnection();
            PreparedStatement ps;
            ps = connexion.prepareStatement("Select * from utilisateur");
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
