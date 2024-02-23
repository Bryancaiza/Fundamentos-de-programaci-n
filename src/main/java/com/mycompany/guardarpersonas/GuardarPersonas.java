
package com.mycompany.guardarpersonas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuardarPersonas extends JFrame {
    private DefaultListModel<String> modeloLista;
    private JList<String> listaPersonas;
    private JTextField campoNombre;
    private JTextField campoEdad;
    private JButton btnGuardar;
    private JButton btnBorrar;

    public GuardarPersonas() {
        setTitle("Guardar Personas");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        modeloLista = new DefaultListModel<>();
        listaPersonas = new JList<>(modeloLista);

        campoNombre = new JTextField(10);
        campoEdad = new JTextField(10);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                String edad = campoEdad.getText();
                String persona = nombre + " - " + edad;
                modeloLista.addElement(persona);
                campoNombre.setText("");
                campoEdad.setText("");
            }
        });

        btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaPersonas.getSelectedIndex();
                if (indiceSeleccionado != -1) {
                    modeloLista.removeElementAt(indiceSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(GuardarPersonas.this, "Selecciona una persona para borrar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Nombre:"));
        panelEntrada.add(campoNombre);
        panelEntrada.add(new JLabel("Edad:"));
        panelEntrada.add(campoEdad);
        panelEntrada.add(btnGuardar);
        panelEntrada.add(new JLabel("Guardar"));

        JPanel panelLista = new JPanel();
        panelLista.add(new JScrollPane(listaPersonas));

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnBorrar);
        panelBotones.add(new JLabel("Borrar"));

        add(panelEntrada, "North");
        add(panelBotones, "South");
        add(panelLista, "Center");

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuardarPersonas();
            }
        });
    }
}
