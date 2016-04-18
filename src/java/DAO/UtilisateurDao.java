/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Utilisateur;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author dell
 */
public interface UtilisateurDao {
    
    Utilisateur verifierUser(int c, String p);
    List<Utilisateur> getAllUsers();
    public List<SelectItem> getCins();

}
