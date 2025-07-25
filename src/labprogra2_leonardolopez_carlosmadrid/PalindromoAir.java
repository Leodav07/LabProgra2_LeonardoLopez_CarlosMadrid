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
        return "El ingreso total es de: " + totalRecaudado + " Lps. \n"
                + "Nota: Los asientos han sido reestablecidos.";
    }
}