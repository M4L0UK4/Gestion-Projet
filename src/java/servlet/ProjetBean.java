package servlet;

import DAO.ProjetDao;
import DAO.daoFactory;
import beans.Projet;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

@RequestScoped
@ManagedBean(name = "ProjetBean")
public class ProjetBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private ProjetDao PR;
    
    public void init() {
        daoFactory df = daoFactory.getInstance();
        this.PR = df.getProjetDao();
    }
    
    private int id;
    private String titre;
    private Date start_date;
    private Date end_date;
    private String status;
    private int Manager;
    private int cin_client;
    private List<Projet> projets;
    
    public List<Projet> getProjets() {
        init();
        projets = PR.getProjets();
        
        return projets;
    }
    
    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }
    
    public void CreerProjet() {
        init();
        java.sql.Date sd = new java.sql.Date(start_date.getTime());
        java.sql.Date ed = new java.sql.Date(end_date.getTime());
        
        Projet p = new Projet(titre, sd, ed, status, Manager, cin_client);
        PR.creerProjet(p);
    }
    
    public void getNewTitre(ValueChangeEvent event) {
        titre = (String) event.getNewValue();        
        
    }

    public void update() {
        init();
        
        PR.updateTitre(id, titre);
        
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitre() {
        return titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    public Date getStart_date() {
        
        return start_date;
    }
    
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
    
    public Date getEnd_date() {
        return end_date;
    }
    
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getManager() {
        return Manager;
    }
    
    public void setManager(int Manager) {
        this.Manager = Manager;
    }
    
    public int getCin_client() {
        return cin_client;
    }
    
    public void setCin_client(int cin_client) {
        this.cin_client = cin_client;
    }
    
}
