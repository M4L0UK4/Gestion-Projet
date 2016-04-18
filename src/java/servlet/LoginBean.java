package servlet;

import DAO.UtilisateurDao;
import DAO.daoFactory;
import beans.Utilisateur;
import java.io.Serializable;
import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import javax.servlet.ServletException;

@RequestScoped
@ManagedBean(name = "LoginBean")
public class LoginBean implements Serializable {
    
      public void init() {
        daoFactory df = daoFactory.getInstance();
        this.UD = df.getUtilisateurDao();
    }
    private UtilisateurDao UD;

    private static final long serialVersionUID = 1L;
   
    private int cin;
    private String password;
    private Utilisateur user;
    private List<Utilisateur> luser;
    private List<SelectItem> elems;
    
    
    public String verrifierUtilisateur() {
        init();
        Utilisateur us = UD.verifierUser(cin,password);

        if (us != null) {
            return "welcome?faces-redirect=true";
        } else {
            return "index";
        }
    }
    
    
      public List<SelectItem> getSelectedItems(){
        init();
        
       elems=UD.getCins();
        
        return elems;
        
    }
    
    public List<Utilisateur> getUsers(){
        init();
        
       luser=UD.getAllUsers();
        
        return luser;
        
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    
    

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
