
package labprogra2_leonardolopez_carlosmadrid;

public class ClaseTicket {
    private String nombrePasajero;
    private double montoFinalT;
    private double montoOriginalT;
    private boolean isPalindromo;
    
    public ClaseTicket(String nombrePasajero, double montoFinalT){
        this.nombrePasajero = nombrePasajero;
    }
    
    public String getName(){
        return nombrePasajero;
    }
    
    public double getFinalAmount(){
        return montoFinalT;
    }
    
    public double OriginalAmount(){
        return montoOriginalT;
    }
    
    public boolean isPalindrome(){
        return isPalindromo;
    }
    
    public void print(){
        
    }
    
}
