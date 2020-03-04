package Vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.DatosUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private JPanel contentPane;
	public static JTextField dUs;
	public static JPasswordField pass;
	private int c=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 322);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngresoALa = new JLabel("Ingreso a la Agenda");
		lblIngresoALa.setForeground(new Color(255, 255, 255));
		lblIngresoALa.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
		lblIngresoALa.setBounds(149, 15, 147, 25);
		contentPane.add(lblIngresoALa);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lblUsuario.setBounds(49, 73, 69, 22);
		contentPane.add(lblUsuario);
		
		dUs = new JTextField();
		dUs.setBounds(135, 75, 220, 20);
		contentPane.add(dUs);
		dUs.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
		lblContrasea.setBounds(49, 138, 83, 22);
		contentPane.add(lblContrasea);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(29, 196, 89, 23);
		contentPane.add(btnSalir);
	
		JButton btnIngresar = new JButton("Ingresar\r\n");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clave = new String (pass.getPassword());
				if(dUs.getText().equals("") || clave.equals("")) {
					JOptionPane.showMessageDialog(null, "Por Favor Ingrese Todos Los campos");
				}
				else {
					DatosUsuario du = new DatosUsuario();
					if(du.validar()==true) {	
						MenuPrincipal mc= new MenuPrincipal();
						mc.setVisible(true);
						mc.setLocationRelativeTo(null);
						MenuPrincipal.idUsuario=dUs.getText();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrectos");
						c++;
					}
				}
				if(c==3) {
					JOptionPane.showMessageDialog(null,"Ha excedido el máximo de intentos");
					dispose();
				}
				
			}
			});
		btnIngresar.setBounds(318, 196, 89, 23);
		contentPane.add(btnIngresar);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 443, 54);
		contentPane.add(panel);
		
		pass = new JPasswordField();
		pass.setBounds(135, 140, 220, 20);
		contentPane.add(pass);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoUsuario usuario= new NuevoUsuario();
				usuario.setVisible(true);
				usuario.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNuevoUsuario.setBounds(149, 196, 147, 23);
		contentPane.add(btnNuevoUsuario);
	}
}