/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.entity;

/**
 *
 * @author alfredo
 */
public class SimpleClaim extends Claim{
    public SimpleClaim(String ssn , String desc, Double costDamage, Double PriceCar){
        super(ssn,desc,costDamage,PriceCar);
    }
    
    private ClaimStatus PhoneGarageStatus=ClaimStatus.NOT_COMPLETED;

    public ClaimStatus getPhoneGarageStatus() {
        return PhoneGarageStatus;
    }

    public ClaimStatus getCheckInsuranceStatus() {
        return CheckInsuranceStatus;
    }
    private ClaimStatus CheckInsuranceStatus=ClaimStatus.NOT_COMPLETED;

    public String generateGarageText() {
        String smsText="Request of intervention for car belonging to "+
                this.getOwnerSsn() + " with these details:\n" + 
                this.getDescription();
        
        return smsText;
    }

    public void setPhoneGarageCompleted() {
        this.PhoneGarageStatus= ClaimStatus.COMPLETED;
    }
    
    
    
}
