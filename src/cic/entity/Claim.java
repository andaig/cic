/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.entity;

/**
 *
 * @author alfredo
 */
public class Claim {

  protected Integer id;
  protected String ownerSsn;
  protected String description;
  protected Double costOfDamage;
  protected Double priceOfCar;
  protected ClaimComplexity complexity=ClaimComplexity.NOT_CLASSIFIED;
  protected ClaimStatus preliminaryStatus=ClaimStatus.NOT_COMPLETED;
  
  protected ClaimStatus overallStatus=ClaimStatus.NOT_COMPLETED;
  protected Decision finalDecision=Decision.NOT_TAKEN;
    
  private ClaimStatus CheckInsuranceStatus=ClaimStatus.NOT_COMPLETED;
  private ClaimStatus PhoneGarageStatus=ClaimStatus.NOT_COMPLETED;
  private ClaimStatus CheckHistoryStatus=ClaimStatus.NOT_COMPLETED;
  


    public Integer getId() {
        return id;
    }

    public String getOwnerSsn() {
        return ownerSsn;
    }

    public String getDescription() {
        return description;
    }

    public Double getCostOfDamage() {
        return costOfDamage;
    }

    public Double getPriceOfCar() {
        return priceOfCar;
    }
    public ClaimComplexity getComplexity(){
        return this.complexity;
    
    }
  
    public ClaimStatus getOverallStatus() {
        return overallStatus;
    }
    
    public ClaimStatus getPreliminaryStatus() {
        return preliminaryStatus;
    }
    
     public void setPreliminaryCompleted() {
           this.preliminaryStatus= ClaimStatus.COMPLETED;
    }
     
     
    public void setOverallCompleted(){
        this.overallStatus= ClaimStatus.COMPLETED;
    }
  
  
  public static Integer n=0;
  

    public Claim(String ssn, String description, Double costOfDamage, Double priceOfCar) {
        this.id=getNextId();
        this.ownerSsn=ssn;
        this.description=description;
        this.costOfDamage=costOfDamage;
        this.priceOfCar=priceOfCar;
    }
    
    public void classifyAsSimple(){
        this.complexity=ClaimComplexity.SIMPLE;
    }
    
    public void classifyAsComplex(){
        this.complexity=ClaimComplexity.COMPLEX;
    }
    public ClaimComplexity getStatus(){
        return this.complexity;
    }
    
    public static Integer getNextId(){
        return n++;        
    }
    public void decide(Decision d){
        this.finalDecision=d;
        this.overallStatus=ClaimStatus.COMPLETED;
    
    }
    public Decision getFinalDecision() {
        return this.finalDecision;
    }
    
    
    
    
    
    public ClaimStatus getPhoneGarageStatus() {
        return PhoneGarageStatus;
    }

    public ClaimStatus getCheckInsuranceStatus() {
        return CheckInsuranceStatus;
    }
     public ClaimStatus getCheckHistoryStatus() {
        return CheckHistoryStatus;
    }
   

    public String generateGarageText() {
        String smsText="Request of intervention for car belonging to "+
                this.getOwnerSsn() + " with these details:\n" + 
                this.getDescription();
        
        return smsText;
    }

    public void setPhoneGarageCompleted() {
        this.PhoneGarageStatus= ClaimStatus.COMPLETED;
    }

    public void setCheckInsuranceCompleted() {
        this.CheckInsuranceStatus = ClaimStatus.COMPLETED;
        
    }

    public void setCheckHistoryCompleted() {
        this.CheckHistoryStatus = ClaimStatus.COMPLETED;
    }

   

    
    
}
