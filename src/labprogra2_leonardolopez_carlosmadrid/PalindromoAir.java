package labprogra2_leonardolopez_carlosmadrid;

import java.awt.Color;
import javax.swing.JButton;

public class PalindromoAir {

    public ClaseTicket asientos[];
    private JButton[] botones;

    public PalindromoAir(JButton[] botones) {
        this.asientos = new ClaseTicket[30];
        this.botones = botones;
    }

    public int firstAvailable(int i) {
        if (i >= asientos.length) {
            return -1; //Esto significa que no encontró asientos
        }
        if (asientos[i] == null) {
            return i;
        }

        return firstAvailable(i + 1); //Sigue buscando si hay más asientos
    }

    public int searchPassenger(String name, int i) {
        if (i >= asientos.length) {
            return -1; //Si no se encontró el pasajero en los asientos
        }

        if (asientos[i] != null && asientos[i].getName().equalsIgnoreCase(name)) {
            return i; //Devuelve el asiento
        }

        return searchPassenger(name, i + 1); //Si no lo encuentra busca con el mismo nombre, pero diferente asiento.
    }

    private boolean isPalindromoVerificacion(String nombrePasajero, int inicio, int fin) {

        if (inicio >= fin) {
            return true;
        }
        if (nombrePasajero.charAt(inicio) != nombrePasajero.charAt(fin)) {
            return false;
        }

        return isPalindromoVerificacion(nombrePasajero, inicio + 1, fin - 1);
    }

    public boolean isPalindromo(String nombrePasajero) {
        String nombreMinus = nombrePasajero.toLowerCase();
        return isPalindromoVerificacion(nombreMinus, 0, nombrePasajero.length() - 1);
    }

    public String printPassengers(int i) {
        if (i >= asientos.length) {
            return "";
        }
        String pasajero = "";
        if (asientos[i] != null) {
            pasajero = "Asiento N. " + (i + 1) + ": " + asientos[i].print() + "\n";
        }
        return pasajero + printPassengers(i + 1);
    }

    public double income(int i) {
        double sumaIngresos = 0;
        if (i >= asientos.length) {
            return 0;
        }

        if (asientos[i] != null) {
            sumaIngresos = asientos[i].getFinalAmount();
        }
        return sumaIngresos + income(i + 1);
    }

    private void reset(int i) {
        if (i >= asientos.length) {
            return;
        }

        asientos[i] = null;
        if (botones != null && botones[i] != null) {
            botones[i].setBackground(Color.GREEN);
        }

        reset(i + 1);
    }

    public String dispatch() {
        double totalRecaudado;
        totalRecaudado = income(0);
        reset(0);
        return "El ingreso total es de: Lps." + totalRecaudado + " \n"
                + "Nota: Los asientos han sido reestablecidos.";
    }
    
    public String sellTicket(String nombrePasajero) {
        int asientoDisponible;
        asientoDisponible = firstAvailable(0);
        if (asientoDisponible == -1) {
            return "Todos los asientos están ocupados. No hay asientos disponibles.";
        }

        ClaseTicket asientoNuevo = new ClaseTicket(nombrePasajero, 100, isPalindromo(nombrePasajero));
        asientos[asientoDisponible] = asientoNuevo;
        String descuento = "";
        if(isPalindromo(nombrePasajero)){
           descuento = "Descuento del 20% aplicado por nombre palíndromo.\n";
        }
        
        botones[asientoDisponible].setBackground(Color.red);
        return descuento + "\nNumero de Asiento: "+(asientoDisponible+1)+"\n"+
                "Nombre de Pasajero: "+nombrePasajero+"\n"+
                "Valor de Ticket: Lps.100.00."+"\n"+
                "Monto Final Pagado: Lps."+asientoNuevo.getFinalAmount();
    }
    
    public String cancelTicket(String name){
        int asientoPasajero;
        asientoPasajero = searchPassenger(name, 0);
        if(asientoPasajero == -1){
            return "Pasajero no encontrado.";
                    
        }else{
            asientos[asientoPasajero] = null;
            botones[asientoPasajero].setBackground(Color.green);
            return """
                   Asiento cancelado exitosamente.
                   Nombre Pasajero: """+ name+ "\nAsiento Numero: "+ (asientoPasajero+1);
        }
        
    }
}