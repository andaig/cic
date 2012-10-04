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
  
  public static Integer n=0;
  

    public Claim(String ssn, String description, Double costOfDamage, Double priceOfCar) {
        this.id=getNextId();
        this.ownerSsn=ssn;
        this.description=description;
        this.costOfDamage=costOfDamage;
        this.priceOfCar=priceOfCar;
    }
    
    public static Integer getNextId(){
        return n++;        
    }
    
}
