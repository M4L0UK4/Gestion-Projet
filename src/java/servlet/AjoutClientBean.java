package servlet;

import DAO.ClientDao;
import DAO.daoFactory;
import beans.Client;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;


@RequestScoped
@ManagedBean(name = "AjoutClientBean")
public class AjoutClientBean  implements Serializable {
    public void init() {
        daoFactory df = daoFactory.getInstance();
        this.CD = df.getClientDao();
    }
    private ClientDao CD;
    
    private static final long serialVersionUID = 1L;
   
   
    private int cin;
    private List<SelectItem> elems;
    private String firstname;
    private String lastname;
    private String paymentDeadline;

    
    public void ajouterClient()
    {
        init();
        Client c=new Client(cin, firstname, lastname, paymentDeadline);
        CD.ajouterClient(c);
    }
    
    public List<SelectItem> getSelectedItems(){
        
        init();
        elems=CD.getCins();
        
        return elems;
    }
           
    
 
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setPaymentDeadline(String paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }
    
    
}
