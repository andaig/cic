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

  private Integer id;
  private String ownerSsn;
  private String description;
  private Double costOfDamage;
  private Double priceOfCar;
  private ClaimComplexity complexity=ClaimComplexity.NOT_CLASSIFIED;
  
  private ClaimStatus overallStatus=ClaimStatus.NOT_COMPLETED;


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
    
}
