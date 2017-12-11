package Paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JButton btnEntrar;
	private JButton btnSalir;
	
	Principal p=new Principal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		inicializar();
		eventos();
	}
	public void inicializar()
	{
		setFont(new Font("Dialog", Font.BOLD, 10));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 228);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(147, 112, 219));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(10, 11, 94, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(10, 96, 94, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(10, 42, 148, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtContraseña.setEchoChar('*');
		txtContraseña.setBounds(10, 121, 148, 31);
		contentPane.add(txtContraseña);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBackground(new Color(255, 165, 0));
		btnEntrar.setBounds(184, 12, 134, 83);
		contentPane.add(btnEntrar);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBackground(new Color(255, 140, 0));
		btnSalir.setBounds(184, 94, 134, 83);
		contentPane.add(btnSalir);
	}
	public void eventos()
	{
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ingresar();
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==arg0.VK_ENTER)
				{
					txtContraseña.requestFocus();
				}
			}
		});
		
		txtContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==e.VK_ENTER)
				{
					Ingresar();
				}
			}
		});
		
	}
	public void Ingresar()
	{
		char[] cla=txtContraseña.getPassword();
		String clave=new String(cla);
		if(txtUsuario.getText().equals("JWong") && clave.equals("123456"))
			{ dispose();
		  JOptionPane.showMessageDialog(null,"Usuario Registrado","Control de usuario",JOptionPane.INFORMATION_MESSAGE);
			p.setVisible(true);
			}
			else
			JOptionPane.showMessageDialog(null,"Usuario no registrado","Control de usuario",JOptionPane.ERROR_MESSAGE);
			txtUsuario.setText("");
			txtContraseña.setText("");
			txtUsuario.requestFocus();
	}
	public void salir()
	{
		int n=JOptionPane.showConfirmDialog(rootPane, "Desea Salir?","Seleccione su Opcion",JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.YES_OPTION)
			//System.exit(0);
			dispose();
	}
}
