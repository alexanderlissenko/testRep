/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import longcatarmy.src.SuperSiteBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcat.auction.src.Customer;

/**
 *
 * @author William Axhav Bratt
 */
@SessionScoped
@Named("profileView")
public class ProfileViewBB implements Serializable{
    
    //uctionBB test = AuctionBB.INSTANCE;
    
    @Inject
    SuperSiteBean site;
    
    public ProfileViewBB()
    {
    }
    
    @PostConstruct
    public void post()
    { 
    }
    
    public Customer getCustomer()
    {
        //return site.getCustomerCatalogue().getCustomerByName("apa");
        return null;
    }
    
    public String goToEdit()
    {
        return "editProfile";
    }
}
