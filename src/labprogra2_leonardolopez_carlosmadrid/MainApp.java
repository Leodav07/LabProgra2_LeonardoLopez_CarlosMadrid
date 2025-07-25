package labprogra2_leonardolopez_carlosmadrid;

import java.awt.*;
import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {

        PalindromoAir palindromo = new PalindromoAir();

        palindromo.asientos[0] = new ClaseTicket("Fernando", 100, false);
        palindromo.asientos[1] = new ClaseTicket("Ana", 100, true);
        palindromo.asientos[2] = new ClaseTicket("Leo", 100, false);
        palindromo.asientos[3] = new ClaseTicket("Samuel", 100, false);

        JFrame frame = new JFrame();
        JLabel label = new JLabel("Nombre del Pasajero");
        JTextField pasajero = new JTextField();
        JButton sellticket = new JButton("Sell Ticket");
        JButton cancelticket = new JButton("Cancel Ticket");
        JButton dispatch = new JButton("Dispatch");
        JButton prtpassengers = new JButton("Print Passengers");
        JButton vwincomes = new JButton("View Incomes");
        JButton srcpassengers = new JButton("Search Passengers");

        frame.setLayout(null);
        frame.setSize(1100, 600);
        frame.setTitle("Recursividad");
        frame.setLocationRelativeTo(null);

        label.setBounds(620, -50, 300, 250);
        label.setFont(new Font("Kefa", Font.BOLD, 24));

        pasajero.setBounds(618, 90, 200, 35);
        pasajero.setFont(new Font("Kefa", Font.PLAIN, 18));

        sellticket.setBounds(618, 140, 190, 50);
        sellticket.setFont(new Font("Kefa", Font.BOLD, 20));
        sellticket.setForeground(Color.GREEN);

        cancelticket.setBounds(618, 200, 190, 50);
        cancelticket.setFont(new Font("Kefa", Font.BOLD, 20));
        cancelticket.setForeground(Color.RED);

        dispatch.setBounds(618, 260, 190, 50);
        dispatch.setFont(new Font("Kefa", Font.BOLD, 20));
        dispatch.setForeground(Color.BLUE);

        prtpassengers.setBounds(810, 140, 190, 50);
        prtpassengers.setFont(new Font("Kefa", Font.BOLD, 16));
        prtpassengers.setForeground(Color.MAGENTA);

        prtpassengers.addActionListener(e -> {
            String info = palindromo.printPassengers(0);
            if (info.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No hay pasajeros registrados.");
            } else {
                JTextArea area = new JTextArea(info);
                area.setEditable(false);
                JScrollPane scroll = new JScrollPane(area);
                scroll.setPreferredSize(new Dimension(400, 300));

                JOptionPane.showMessageDialog(frame, scroll, "Lista de Pasajeros", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        vwincomes.setBounds(810, 200, 190, 50);
        vwincomes.setFont(new Font("Kefa", Font.BOLD, 20));
        vwincomes.setForeground(Color.ORANGE);

        srcpassengers.setBounds(810, 260, 190, 50);
        srcpassengers.setFont(new Font("Kefa", Font.BOLD, 15));
        srcpassengers.setForeground(Color.cyan);

        srcpassengers.addActionListener(e -> {
            if (pasajero.getText() != null && !pasajero.getText().trim().isEmpty()) {
                int pos = palindromo.searchPassenger(pasajero.getText(), 0);
                if (pos != -1) {
                    JOptionPane.showMessageDialog(null, "El pasajero "+pasajero.getText()+" esta en el asiento #" + (pos + 1), "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "El pasajero "+pasajero.getText()+" no fue encontrado.", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe de llenar los campos.", "ADVERTENCIA", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 5; c++) {
                JButton asiento = new JButton();
                asiento.setBounds(50 + r * 90, 50 + c * 90, 80, 80);
                asiento.setOpaque(true);
                asiento.setBackground(Color.GREEN);
                asiento.setBorderPainted(false);
                frame.add(asiento);
            }
        }

        frame.add(label);
        frame.add(pasajero);
        frame.add(sellticket);
        frame.add(cancelticket);
        frame.add(prtpassengers);
        frame.add(dispatch);
        frame.add(vwincomes);
        frame.add(srcpassengers);

        frame.setVisible(true);

    }

}
