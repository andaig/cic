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
  private String description;
  private Double costOfDamage;
  private Double priceOfCar;
  private ClaimStatus status=ClaimStatus.NOT_CLASSIFIED;
  
  public static Integer n=0;
  

    public Claim(String ssn, String description, Double costOfDamage, Double priceOfCar) {
        this.id=getNextId();
        this.ownerSsn=ssn;
        this.description=description;
        this.costOfDamage=costOfDamage;
        this.priceOfCar=priceOfCar;
    }
    
    public void classifyAsSimple(){
        this.status=ClaimStatus.SIMPLE;
    }
    
    public void classifyAsComplex(){
        this.status=ClaimStatus.COMPLEX;
    }
    public ClaimStatus getStatus(){
        return this.status;
    }
    
    public static Integer getNextId(){
        return n++;        
    }
    
}
