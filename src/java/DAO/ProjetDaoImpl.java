package DAO;

import beans.Projet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetDaoImpl implements ProjetDao {

    private daoFactory daoFactory;

    public ProjetDaoImpl(daoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void creerProjet(Projet p) {

        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO projet(titre,start_date,end_date,status,Manager,cin_client) VALUES(?,?,?,?,?,?);");
            preparedStatement.setString(1, p.getTitre());
            preparedStatement.setDate(2, p.getStartDate());
            preparedStatement.setDate(3, p.getEndDate());
            preparedStatement.setString(4, p.getStatus());
            preparedStatement.setInt(5, p.getManager());
            preparedStatement.setInt(6, p.getCinClient());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Projet> getProjets() {

        List<Projet> lp = new ArrayList();

        try {
            Connection connexion = daoFactory.getConnection();
            PreparedStatement ps;
            ps = connexion.prepareStatement("Select * from projet");
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {

                int id = resultat.getInt("id");
                String titre = resultat.getString("titre");
                Date start_date = resultat.getDate("start_date");
                Date end_date = resultat.getDate("end_date");
                String status = resultat.getString("status");
                int chef_de_projet = resultat.getInt("Manager");
                int cin_client = resultat.getInt("cin_client");
                Projet p = new Projet(id, titre, start_date, end_date, status, chef_de_projet, cin_client);
                lp.add(p);

            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lp;

    }

    public void updateProjet(Projet p) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("update projet set titre=? , start_date=? , end_date=? , status=? ,Manager=? ,cin_Client=? where id=?");

            preparedStatement.setString(1, p.getTitre());
            preparedStatement.setDate(2, p.getStartDate());
            preparedStatement.setDate(3, p.getEndDate());
            preparedStatement.setString(4, p.getStatus());
            preparedStatement.setInt(5, p.getManager());
            preparedStatement.setInt(6, p.getCinClient());
            preparedStatement.setInt(7, p.getId());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
      public void updateTitre(int id,String titre) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("update projet set titre=?  where id=?");

            preparedStatement.setString(1, titre);         
            preparedStatement.setInt(2, id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
