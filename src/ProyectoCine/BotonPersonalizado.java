/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author Ricardo Emmanuel Ojeda Mendoza
 */
public class BotonPersonalizado extends JButton {

    private String txtEtiqueta;
    private int ancho;
    private int alto;

    public BotonPersonalizado() {
        super();
        txtEtiqueta = "Botón";
        super.setText(txtEtiqueta);
        apariencia();
    }

    public BotonPersonalizado(String txtEtiqueta) {
        super(txtEtiqueta);
        this.txtEtiqueta = txtEtiqueta;
        apariencia();
    }

    public BotonPersonalizado(String txtEtiqueta, ImageIcon icon, int ancho, int alto) {
        super(txtEtiqueta, new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
        this.txtEtiqueta = txtEtiqueta;
        apariencia();
    }

    public BotonPersonalizado(String txtEtiqueta, ImageIcon icon, int ancho, int alto, boolean modoOscuro) {
        super(txtEtiqueta, new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
        this.txtEtiqueta = txtEtiqueta;
        if (modoOscuro) {
            aparienciaModOscuro();
        } else {
            apariencia();
        }
    }

    public BotonPersonalizado(ImageIcon icon, int ancho, int alto) {
        super(new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT)));
        this.txtEtiqueta = txtEtiqueta;
        apariencia();
    }

    private void apariencia() {
        alto = 50;
        ancho = 60;
        this.setBorder(null);
        this.setContentAreaFilled(true);
        this.setOpaque(true);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setBackground(Color.white);
        this.setForeground(Color.blue);
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

    private void aparienciaModOscuro() {
        alto = 50;
        ancho = 60;
        this.setBorder(null);
        this.setContentAreaFilled(true);
        this.setOpaque(true);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setBackground(Color.black);
        this.setForeground(Color.white);
        this.setPreferredSize(new Dimension(ancho, alto));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

}
