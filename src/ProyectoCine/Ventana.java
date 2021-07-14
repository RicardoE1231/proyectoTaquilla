/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCine;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 *
 * @author Ricar
 */
public class Ventana extends JFrame implements ActionListener, ItemListener {

    public Ventana() {
        setResizable(false);
        loginGUI();
    }

    private JLabel usuario, clave;
    private JTextField txtUsuario, txtClave;
    private JButton login;

    public void loginGUI() {
        actualizaDatos();
        actualizaComboBox();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana = getContentPane();
        ventana.setLayout(null);
        setSize(400, 200);
        this.setTitle("Iniciar Sesion");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo2.png"));
        setIconImage(icon);
        setVisible(true);
        setLocationRelativeTo(null);
        ventana.setBackground(new Color(39, 110, 144));

        usuario = new JLabel("Usuario");
        ventana.add(usuario);
        usuario.setBounds(80, 30, 80, 20);
        usuario.setFont(new java.awt.Font(" ", Font.BOLD, 16));
        usuario.setForeground(Color.WHITE);

        txtUsuario = new JTextField();
        ventana.add(txtUsuario);
        txtUsuario.setBounds(150, 30, 150, 20);

        clave = new JLabel("Clave");
        ventana.add(clave);
        clave.setBounds(90, 60, 80, 20);
        clave.setFont(new java.awt.Font(" ", Font.BOLD, 16));
        clave.setForeground(Color.WHITE);

        txtClave = new JTextField();
        ventana.add(txtClave);
        txtClave.setBounds(150, 60, 150, 20);

        login = new JButton("Ingresar");
        ventana.add(login);
        login.setBounds(150, 90, 100, 30);
        login.setFont(new java.awt.Font(" ", Font.BOLD, 16));
        login.addActionListener(this);
    }

    private JLabel boletos, titulo, cliente, nombre_c, rfc_c, vendedor, fecha, promos;
    private JTextField txtCliente;
    private JComboBox boxVendedor;
    private JButton buscar_c, agregar_c, agregar_v;
    private JPanel jpBoletos, jpPromos;

    public void ventasGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container ventana2 = new Container();
        ventana2.setLayout(null);
        setSize(1000, 800);
        this.setTitle("Cine \"Cinecito\"");
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/logo.png"));
        setIconImage(icon);
        setVisible(true);
        setLocationRelativeTo(null);
        setBackground(new Color(39, 110, 144));
        setContentPane(ventana2);

        titulo = new JLabel("Cine \"Cinecito\"");
        ventana2.add(titulo);
        titulo.setFont(new java.awt.Font("BankGothic Lt BT", Font.BOLD, 36));
        titulo.setForeground(Color.WHITE);
        titulo.setBounds(368, 0, 265, 50);

        cliente = labelPersonalizado("Cliente");
        ventana2.add(cliente);
        cliente.setBounds(80, 60, 80, 20);

        txtCliente = new JTextField();
        ventana2.add(txtCliente);
        txtCliente.setBounds(140, 60, 200, 20);

        buscar_c = botonTransparente("/imagenes/buscar.png");
        buscar_c.setBounds(340, 55, 30, 30);
        buscar_c.addActionListener(this);
        ventana2.add(buscar_c);

        agregar_c = botonTransparente("/imagenes/agregar.png");
        agregar_c.setBounds(365, 55, 30, 30);
        agregar_c.addActionListener(this);
        ventana2.add(agregar_c);

        vendedor = labelPersonalizado("Vendedor");
        ventana2.add(vendedor);
        vendedor.setBounds(450, 60, 80, 20);

        /* realizar el codigo para que los datos los lea desde la BD*/
        /*boxVendedor = new JComboBox();
        boxVendedor.addItem("Ricardo");
        boxVendedor.addItem("Carlos");*/
        boxVendedor.addActionListener(this);
        ventana2.add(boxVendedor);
        boxVendedor.setBounds(530, 60, 140, 20);

        agregar_v = botonTransparente("/imagenes/agregar.png");
        agregar_v.setBounds(670, 55, 30, 30);
        agregar_v.addActionListener(this);
        ventana2.add(agregar_v);

        Date date = new Date();
        DateFormat formateadorFechaMedia = DateFormat.getDateInstance(DateFormat.LONG);
        fecha = labelPersonalizado("Fecha: " + formateadorFechaMedia.format(date));
        ventana2.add(fecha);
        fecha.setBounds(730, 60, 200, 20);

        nombre_c = labelPersonalizado("Cliente: Público En General");
        ventana2.add(nombre_c);
        nombre_c.setFont(new java.awt.Font("BankGothic Lt BT", Font.BOLD, 18));
        nombre_c.setBounds(100, 110, 250, 20);

        rfc_c = labelPersonalizado("RFC: XAXX010101000");
        ventana2.add(rfc_c);
        rfc_c.setFont(new java.awt.Font("BankGothic Lt BT", Font.BOLD, 18));
        rfc_c.setBounds(400, 110, 200, 20);

        jpBoletos = panelVentaBoletos();
        ventana2.add(jpBoletos);
        jpBoletos.setBounds(50, 200, 400, 500);

        boletos = new JLabel("Boletos");
        ventana2.add(boletos);
        boletos.setFont(new java.awt.Font("BankGothic Lt BT", Font.BOLD, 22));
        boletos.setForeground(Color.WHITE);
        boletos.setBounds(200, 150, 80, 50);

        jpPromos = panelPromos();
        ventana2.add(jpPromos);
        jpPromos.setBounds(540, 200, 400, 500);

        promos = new JLabel("Próximos Estrenos");
        ventana2.add(promos);
        promos.setFont(new java.awt.Font("BankGothic Lt BT", Font.BOLD, 22));
        promos.setForeground(Color.WHITE);
        promos.setBounds(650, 150, 300, 50);
    }

    private JSpinner nAdulto, nInfantil;
    private JComboBox boxPeliculas, boxFunciones, boxFormaPago;
    private JTextField txtDinero;
    private JLabel adulto, infantil, pelicula, funcion, precioA, precioI, totalB, subtotal,
            descuento, iva, granTotal, formaDePago, cambio;
    private JButton aceptar, limpiar, agregar_f, agregar_p, imprimir;
    private final int PRECIO_ADULDO = 60, PRECIO_INFANTIL = 40;
    private double dTotal = 0;

    private JPanel panelVentaBoletos() {
        JPanel boletosPanel = new JPanel();
        boletosPanel.setLayout(null);
        boletosPanel.setBackground(new Color(39, 110, 144));
        boletosPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 2),
                        BorderFactory.createEmptyBorder(0, 0, 0, 0)
                )
        );

        pelicula = labelPersonalizado("Peliculas");
        boletosPanel.add(pelicula);
        pelicula.setBounds(10, 10, 70, 20);

        /* realizar el codigo para que los datos los lea desde la BD*/
        /*boxPeliculas = new JComboBox();
        boxPeliculas.addItem("pelicula 1");
        boxPeliculas.addItem("pelicula 2");*/
        boxPeliculas.addActionListener(this);
        boletosPanel.add(boxPeliculas);
        boxPeliculas.setBounds(80, 10, 250, 20);

        agregar_p = botonTransparente("/imagenes/agregar.png");
        agregar_p.setBounds(330, 5, 30, 30);
        agregar_p.addActionListener(this);
        boletosPanel.add(agregar_p);

        funcion = labelPersonalizado("Funcion");
        boletosPanel.add(funcion);
        funcion.setBounds(10, 40, 70, 20);

        /* realizar el codigo para que los datos los lea desde la BD*/
        /*boxFunciones = new JComboBox();
        boxFunciones.addItem("11:00 am");
        boxFunciones.addItem("12:00 pm");*/
        boxFunciones.addActionListener(this);
        boletosPanel.add(boxFunciones);
        boxFunciones.setBounds(80, 40, 100, 20);

        agregar_f = botonTransparente("/imagenes/agregar.png");
        agregar_f.setBounds(180, 35, 30, 30);
        agregar_f.addActionListener(this);
        boletosPanel.add(agregar_f);

        adulto = labelPersonalizado("Adulto");
        boletosPanel.add(adulto);
        adulto.setBounds(80, 80, 70, 20);

        SpinnerNumberModel snm0 = new SpinnerNumberModel(0, 0, 10, 1);
        nAdulto = new JSpinner(snm0);
        boletosPanel.add(nAdulto);
        nAdulto.setBounds(140, 80, 40, 20);

        precioA = labelPersonalizado("Precio: $60");
        boletosPanel.add(precioA);
        precioA.setBounds(190, 80, 150, 20);

        infantil = labelPersonalizado("Infantil");
        boletosPanel.add(infantil);
        infantil.setBounds(80, 120, 70, 20);

        SpinnerNumberModel snm1 = new SpinnerNumberModel(0, 0, 10, 1);
        nInfantil = new JSpinner(snm1);
        boletosPanel.add(nInfantil);
        nInfantil.setBounds(140, 120, 40, 20);

        precioI = labelPersonalizado("Precio: $40");
        boletosPanel.add(precioI);
        precioI.setBounds(190, 120, 150, 20);

        totalB = labelPersonalizado("Total Boletos: 0");
        boletosPanel.add(totalB);
        totalB.setBounds(120, 150, 150, 20);

        subtotal = labelPersonalizado("Subtotal: $ 0.00");
        boletosPanel.add(subtotal);
        subtotal.setBounds(40, 200, 150, 20);

        descuento = labelPersonalizado("Descuento: $ 0.00");
        boletosPanel.add(descuento);
        descuento.setBounds(40, 230, 150, 20);

        iva = labelPersonalizado("IVA 16%: $ 0.00");
        boletosPanel.add(iva);
        iva.setBounds(40, 260, 150, 20);

        granTotal = labelPersonalizado("Total: $ 0.00");
        boletosPanel.add(granTotal);
        granTotal.setBounds(40, 290, 150, 20);

        aceptar = new BotonPersonalizado("Aceptar");
        boletosPanel.add(aceptar);
        aceptar.addActionListener(this);
        aceptar.setBounds(250, 210, 80, 30);

        limpiar = new BotonPersonalizado("Limpiar");
        boletosPanel.add(limpiar);
        limpiar.addActionListener(this);
        limpiar.setBounds(250, 260, 80, 30);

        formaDePago = labelPersonalizado("Forma De Pago");
        boletosPanel.add(formaDePago);
        formaDePago.setBounds(30, 340, 150, 20);

        boxFormaPago = new JComboBox();
        boxFormaPago.addItem("Efectivo");
        boxFormaPago.addItem("Tarjeta");
        boxFormaPago.addActionListener(this);
        boletosPanel.add(boxFormaPago);
        boxFormaPago.setBounds(150, 340, 100, 20);

        txtDinero = new JTextField();
        boletosPanel.add(txtDinero);
        txtDinero.setText("0.00");
        txtDinero.setBounds(260, 340, 100, 20);

        imprimir = new BotonPersonalizado("Imprimir Ticket");
        boletosPanel.add(imprimir);
        imprimir.addActionListener(this);
        imprimir.setBounds(120, 380, 150, 30);

        cambio = labelPersonalizado("Cambio: $ 0.00");
        cambio.setHorizontalAlignment(SwingConstants.CENTER);
        cambio.setFont(new java.awt.Font(" ", Font.BOLD, 18));
        boletosPanel.add(cambio);
        cambio.setBounds(120, 370, 150, 150);

        return boletosPanel;
    }

    private JPanel panelPromos() {
        JPanel promosPanel = new JPanel();
        promosPanel.setLayout(null);
        promosPanel.setBackground(new Color(39, 110, 144));
        promosPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 3),
                        BorderFactory.createEmptyBorder(0, 0, 0, 0)
                )
        );

        HilosGUI hilo = new HilosGUI();
        JLabel cartel = new JLabel();
        promosPanel.add(cartel);
        hilo.recibeJLabel(cartel);
        hilo.start();
        cartel.setBounds(2, 2, 396, 496);
        return promosPanel;
    }

    private JButton botonTransparente(String ruta) {
        JButton jb = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
        jb.setIcon(icon);
        jb.setFocusPainted(false);
        jb.setBorderPainted(false);
        jb.setContentAreaFilled(false);
        return jb;
    }

    private JLabel labelPersonalizado(String nombre) {
        JLabel jl = new JLabel(nombre);
        jl.setFont(new java.awt.Font(" ", Font.BOLD, 14));
        jl.setForeground(Color.WHITE);
        return jl;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            this.dispose();
            ventasGUI();
        } else if (ae.getSource() == buscar_c) {
            System.err.println("Buscar C");
        } else if (ae.getSource() == agregar_c) {
            System.err.println("Agregar C");
            agregarClienteGUI();
        } else if (ae.getSource() == agregar_v) {
            System.err.println("Agregar V");
            agregarVendedorGUI();
        } else if (ae.getSource() == agregar_f) {
            System.err.println("Agregar F");
            agregarFuncionGUI();
        } else if (ae.getSource() == agregar_p) {
            System.err.println("Agregar p");
            agregarPeliculaGUI();
        } else if (ae.getSource() == aceptar) {
            int tInfatil = (PRECIO_INFANTIL * ((int) nInfantil.getValue()));
            int tAdulto = (PRECIO_ADULDO * ((int) nAdulto.getValue()));
            int totalBoletos = ((int) nInfantil.getValue()) + ((int) nAdulto.getValue());
            double dSubtotal = (tInfatil + tAdulto) / 1.16;
            double dIVA = dSubtotal * 0.16;
            dTotal = dIVA + dSubtotal;
            totalB.setText("Total Boletos: " + totalBoletos);
            subtotal.setText(String.format("Subtotal: $ %1.2f", dSubtotal));
            descuento.setText("Descuento: $ 0.00");
            iva.setText("IVA 16%: " + String.format("$ %1.2f", dIVA));
            granTotal.setText(String.format("Total: $ %1.2f", dTotal));
            System.err.println("Aceptar");
        } else if (ae.getSource() == limpiar) {
            nAdulto.setValue(0);
            nInfantil.setValue(0);
            totalB.setText("Total Boletos: 0");
            subtotal.setText("Subtotal: $ 0.00");
            descuento.setText("Descuento: $ 0.00");
            iva.setText("IVA 16%: $ 0.00");
            granTotal.setText("Total: $ 0.00");
            cambio.setText("Cambio: $ 0.00");
            txtDinero.setText("");
            System.err.println("Limpiar");
        } else if (ae.getSource() == imprimir) {
            if ("0.00".equals(txtDinero.getText())) {
                JOptionPane.showMessageDialog(null, "Ingresa la cantidad de Efectivo");
            } else {
                double dCambio = Double.parseDouble(txtDinero.getText()) - dTotal;
                cambio.setText(String.format("Cambio: $ %1.2f", dCambio));
            }
            System.err.println("Imprimir");
        } else if (ae.getSource() == agregarC) {
            System.err.println("Agregar C");
        } else if (ae.getSource() == agregarV) {
            System.err.println("Agregar V");
        } else if (ae.getSource() == agregarP) {
            System.err.println("Agregar P");
        } else if (ae.getSource() == agregarF) {
            System.err.println("Agregar F");
        } else if (ae.getSource() == boxFormaPago) {
            int opcion = boxFormaPago.getSelectedIndex();
            if (opcion == 1) {
                txtDinero.setText("" + String.format("%1.2f", dTotal));
                System.err.println("Pago Tarjeta");
            } else if (opcion == 0) {
                txtDinero.setText("0.00");
                System.err.println("Efectivo");
            }
        }
    }

    private JLabel nombreC, rfcC, correoC;
    private JTextField txtnombreC, txtrfcC, txtcorreoC;
    private JButton agregarC;
    private JFrame ventanaAgCliente;

    private void agregarClienteGUI() {
        ventanaAgCliente = new JFrame();
        ventanaAgCliente.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/agregar.png"));
        ventanaAgCliente.setIconImage(icon);
        ventanaAgCliente.setTitle("Agregar Cliente");
        ventanaAgCliente.setLocationRelativeTo(null);
        ventanaAgCliente.setResizable(false);
        ventanaAgCliente.setVisible(true);
        ventanaAgCliente.setLocationRelativeTo(null);
        ventanaAgCliente.setSize(400, 200);
        ventanaAgCliente.setLayout(null);

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBackground(new Color(10, 49, 64));

        nombreC = labelPersonalizado("Nombre:");
        panelDatos.add(nombreC);
        nombreC.setBounds(10, 20, 70, 20);

        txtnombreC = new JTextField();
        panelDatos.add(txtnombreC);
        txtnombreC.setBounds(100, 20, 250, 20);

        rfcC = labelPersonalizado("RFC:");
        panelDatos.add(rfcC);
        rfcC.setBounds(10, 60, 70, 20);

        txtrfcC = new JTextField();
        panelDatos.add(txtrfcC);
        txtrfcC.setBounds(100, 60, 250, 20);

        correoC = labelPersonalizado("Correo:");
        panelDatos.add(correoC);
        correoC.setBounds(10, 100, 70, 20);

        txtcorreoC = new JTextField();
        panelDatos.add(txtcorreoC);
        txtcorreoC.setBounds(100, 100, 250, 20);

        agregarC = new BotonPersonalizado("Agregar");
        panelDatos.add(agregarC);
        agregarC.setBounds(160, 130, 80, 30);
        agregarC.addActionListener(this);

        ventanaAgCliente.add(panelDatos);
        panelDatos.setBounds(0, 0, 400, 200);

    }

    private JLabel nombreV;
    private JTextField txtnombreV;
    private JButton agregarV;
    private JFrame ventanaAgVendedor;

    private void agregarVendedorGUI() {
        ventanaAgVendedor = new JFrame();
        ventanaAgVendedor.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/agregar.png"));
        ventanaAgVendedor.setIconImage(icon);
        ventanaAgVendedor.setTitle("Agregar Vendedor");
        ventanaAgVendedor.setLocationRelativeTo(null);
        ventanaAgVendedor.setResizable(false);
        ventanaAgVendedor.setVisible(true);
        ventanaAgVendedor.setLocationRelativeTo(null);
        ventanaAgVendedor.setSize(400, 200);
        ventanaAgVendedor.setLayout(null);

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBackground(new Color(10, 49, 64));

        nombreV = labelPersonalizado("Nombre:");
        panelDatos.add(nombreV);
        nombreV.setBounds(10, 60, 70, 20);

        txtnombreV = new JTextField();
        panelDatos.add(txtnombreV);
        txtnombreV.setBounds(100, 60, 250, 20);

        agregarV = new BotonPersonalizado("Agregar");
        panelDatos.add(agregarV);
        agregarV.setBounds(160, 100, 80, 30);
        agregarV.addActionListener(this);

        ventanaAgVendedor.add(panelDatos);
        panelDatos.setBounds(0, 0, 400, 200);
    }

    private JLabel nombreP, idioma, clasificacion, duracion, genero;
    private JTextField txtnombreP, txtidioma, txtclasificacion, txtduracion, txtgenero;
    private JButton agregarP;
    private JFrame ventanaAgPelicula;

    private void agregarPeliculaGUI() {
        ventanaAgPelicula = new JFrame();
        ventanaAgPelicula.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/agregar.png"));
        ventanaAgPelicula.setIconImage(icon);
        ventanaAgPelicula.setTitle("Agregar Pelicula");
        ventanaAgPelicula.setLocationRelativeTo(null);
        ventanaAgPelicula.setResizable(false);
        ventanaAgPelicula.setVisible(true);
        ventanaAgPelicula.setLocationRelativeTo(null);
        ventanaAgPelicula.setSize(400, 200);
        ventanaAgPelicula.setLayout(null);

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBackground(new Color(10, 49, 64));

        nombreP = labelPersonalizado("Nombre:");
        panelDatos.add(nombreP);
        nombreP.setBounds(10, 10, 70, 20);

        txtnombreP = new JTextField();
        panelDatos.add(txtnombreP);
        txtnombreP.setBounds(70, 10, 320, 20);

        idioma = labelPersonalizado("Idioma:");
        panelDatos.add(idioma);
        idioma.setBounds(10, 50, 70, 20);

        txtidioma = new JTextField();
        panelDatos.add(txtidioma);
        txtidioma.setBounds(70, 50, 100, 20);

        clasificacion = labelPersonalizado("Clasificacion:");
        panelDatos.add(clasificacion);
        clasificacion.setBounds(175, 50, 120, 20);

        txtclasificacion = new JTextField();
        panelDatos.add(txtclasificacion);
        txtclasificacion.setBounds(270, 50, 120, 20);

        duracion = labelPersonalizado("Duracion(min):");
        panelDatos.add(duracion);
        duracion.setBounds(10, 90, 140, 20);

        txtduracion = new JTextField();
        panelDatos.add(txtduracion);
        txtduracion.setBounds(115, 90, 100, 20);

        genero = labelPersonalizado("Genero:");
        panelDatos.add(genero);
        genero.setBounds(220, 90, 80, 20);

        txtgenero = new JTextField();
        panelDatos.add(txtgenero);
        txtgenero.setBounds(280, 90, 110, 20);

        agregarP = new BotonPersonalizado("Agregar");
        panelDatos.add(agregarP);
        agregarP.setBounds(160, 130, 80, 30);
        agregarP.addActionListener(this);

        ventanaAgPelicula.add(panelDatos);
        panelDatos.setBounds(0, 0, 400, 200);
    }

    private JLabel hora, cupo, sala, idPelicula;
    private JTextField txthora, txtcupo, txtsala, txtidPelicula;
    private JButton agregarF;
    private JFrame ventanaAgFuncion;

    private void agregarFuncionGUI() {
        ventanaAgFuncion = new JFrame();
        ventanaAgFuncion.setLayout(null);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/agregar.png"));
        ventanaAgFuncion.setIconImage(icon);
        ventanaAgFuncion.setTitle("Agregar Funcion");
        ventanaAgFuncion.setLocationRelativeTo(null);
        ventanaAgFuncion.setResizable(false);
        ventanaAgFuncion.setVisible(true);
        ventanaAgFuncion.setLocationRelativeTo(null);
        ventanaAgFuncion.setSize(400, 200);
        ventanaAgFuncion.setLayout(null);

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBackground(new Color(10, 49, 64));

        hora = labelPersonalizado("Hora:");
        panelDatos.add(hora);
        hora.setBounds(10, 20, 70, 20);

        txthora = new JTextField();
        panelDatos.add(txthora);
        txthora.setBounds(70, 20, 40, 20);

        cupo = labelPersonalizado("cupo:");
        panelDatos.add(cupo);
        cupo.setBounds(130, 20, 70, 20);

        txtcupo = new JTextField();
        panelDatos.add(txtcupo);
        txtcupo.setBounds(180, 20, 40, 20);

        sala = labelPersonalizado("Sala:");
        panelDatos.add(sala);
        sala.setBounds(240, 20, 70, 20);

        txtsala = new JTextField();
        panelDatos.add(txtsala);
        txtsala.setBounds(280, 20, 40, 20);

        idPelicula = labelPersonalizado("Pelicula:");
        panelDatos.add(idPelicula);
        idPelicula.setBounds(10, 80, 70, 20);

        txtidPelicula = new JTextField();
        panelDatos.add(txtidPelicula);
        txtidPelicula.setBounds(80, 80, 250, 20);

        agregarF = new BotonPersonalizado("Agregar");
        panelDatos.add(agregarF);
        agregarF.setBounds(160, 130, 80, 30);
        agregarF.addActionListener(this);

        ventanaAgFuncion.add(panelDatos);
        panelDatos.setBounds(0, 0, 400, 200);

    }
    
    private Vector<Object[]> listClientes, listPeliculas, listFunciones, listVendedores;
    private ManejoDatos manejoDatos = new ManejoDatos();
    
    public void actualizaDatos(){
        String consultaCliente = "SELECT * FROM ROOT.CLIENTE";
        String consultaPelicula = "SELECT * FROM ROOT.PELICULA";
        String consultaFuncion = "SELECT * FROM ROOT.FUNCION";
        String consultaVendedor = "SELECT * FROM ROOT.VENDEDOR";
        listClientes = manejoDatos.conexionConsultaCliente(consultaCliente);
        listPeliculas = manejoDatos.conexionConsultaPelicula(consultaPelicula);
        listFunciones = manejoDatos.conexionConsultaFuncion(consultaFuncion);
        listVendedores = manejoDatos.conexionConsultaVendedor(consultaVendedor);
    }

    
    public void actualizaComboBox(){
        actualizaDatos();
        Vector<String> vecPeliculas = new Vector<>();
        for (int i = 0; i < listPeliculas.size(); i++) {
            String str = (String) listPeliculas.get(i)[1];
            vecPeliculas.add(str);
        }
        
        
        Vector<String> vecFunciones = new Vector<>();
        for (int i = 0; i < listFunciones.size(); i++) {
            String str = (String) listFunciones.get(i)[1];
            vecFunciones.add(str);
        }
        
        Vector<String> vecVendedores = new Vector<>();
        for (int i = 0; i < listVendedores.size(); i++) {
            String str = (String) listVendedores.get(i)[1];
            vecVendedores.add(str);
        }
        
        boxPeliculas = new JComboBox(vecPeliculas);
        boxFunciones = new JComboBox(vecFunciones);
        boxVendedor = new JComboBox(vecVendedores);
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie) {

    }

    /* -TEST- */
    public static void main(String[] args) {
        new Ventana();
    }
}
