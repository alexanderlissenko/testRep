/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

/**
 *
 * @author emesven
 */
public class Admin implements User{
    private String email;
    private String name;       
    private String password;
    private String phoneNr;
    private String seqQuest;   
    private String address;
    private Boolean access; 
    
    
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword() {
        return password;
    } 
    public void setPassword(String password){
        this.password = password;
    }  
    public String getName() {
        return name;
    }
    
    public String getPhoneNr() {
        return phoneNr;
    }
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
    public String getSeqQuest() {
        return seqQuest;
    }
    public void setQuest(String seqQuest) {
        this.seqQuest = seqQuest;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Boolean getAccess() {
        return access;
    }
    public void setAccess(Boolean access) {
        this.access = access;
    }
    public void changeAccess(Customer c, Boolean b){
        c.setAccess(b);
    }
}