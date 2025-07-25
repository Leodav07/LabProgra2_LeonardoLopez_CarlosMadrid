package labprogra2_leonardolopez_carlosmadrid;

public class ClaseTicket {

    private String nombrePasajero;
    private double montoFinalT;
    private double montoOriginalT;
    private boolean isPalindromo;

    public ClaseTicket(String nombrePasajero, double montoOriginalT, boolean isPalindromo) {
        this.nombrePasajero = nombrePasajero;
        this.montoOriginalT = montoOriginalT;
        this.isPalindromo = isPalindromo;

        if (isPalindromo) {
            montoFinalT = montoOriginalT * 0.8;

        } else {
            montoFinalT = montoOriginalT;
        }

    }

    public String getName() {
        return nombrePasajero;
    }

    public double getFinalAmount() {
        return montoFinalT;
    }

    public double OriginalAmount() {
        return montoOriginalT;
    }

    public boolean isPalindrome() {
        return isPalindromo;
    }
    
    public String print(){
        return "\nNombre Pasajero: " + nombrePasajero + "\n" +
                "Monto Original: " + montoOriginalT + "\n" +
                "Monto Final: " + montoFinalT + "\n" +
                "Es Palindromo: "+ (isPalindromo ? "Si\n" : "No\n");
    }

}
