/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cic.entity;

/**
 *
 * @author 
 */
public enum ClaimComplexity {
    NOT_CLASSIFIED{
        @Override
    public String toString() {
        return "NOT CLASSIFIED";
        }
    },SIMPLE{
        @Override
    public String toString() {
        return "SIMPLE";
        }
    },COMPLEX{
        @Override
    public String toString() {
        return "COMPLEX";
        }
    }
    
}
