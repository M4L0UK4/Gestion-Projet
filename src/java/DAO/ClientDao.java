package DAO;

import beans.Client;
import java.util.List;
import javax.faces.model.SelectItem;

public interface ClientDao {
    
    public void ajouterClient(Client c);
    public List<SelectItem> getCins();
    
}
