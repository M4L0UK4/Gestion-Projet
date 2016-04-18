package DAO;

import beans.Projet;
import java.util.List;


public interface ProjetDao {
    
    public void creerProjet(Projet p);
    public List<Projet> getProjets();
    public void updateProjet(Projet p);
     public void updateTitre(int id,String titre);
    
}
