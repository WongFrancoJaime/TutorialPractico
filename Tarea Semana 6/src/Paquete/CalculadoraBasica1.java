package Paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CalculadoraBasica1 extends JInternalFrame {
	private JTextField txtNumero1;
	private JTextField txtNumero2;
	private JTextField txtResultado;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMultiplicacion;
	private JButton btnDivision;
	private JButton btnSalir;
	private JButton btnReiniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraBasica1 frame = new CalculadoraBasica1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public CalculadoraBasica1() {
		setResizable(true);
		setClosable(true);
		
		inicializar();
		eventos();	
		limpiar();
	}
	public void inicializar() {
		setBounds(100, 100, 399, 238);
		getContentPane().setLayout(null);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(180, 175, 73, 23);
		getContentPane().add(btnReiniciar);
		
		btnSuma = new JButton("Suma");
		btnSuma.setBounds(25, 65, 71, 23);
		getContentPane().add(btnSuma);
		
		btnResta = new JButton("Resta");
		btnResta.setBounds(106, 65, 69, 23);
		getContentPane().add(btnResta);
		
		btnMultiplicacion = new JButton("Multiplicacion");
		btnMultiplicacion.setBounds(181, 65, 95, 23);
		getContentPane().add(btnMultiplicacion);
		
		btnDivision = new JButton("Division");
		btnDivision.setBounds(286, 65, 69, 23);
		getContentPane().add(btnDivision);
		
		txtNumero1 = new JTextField();
		txtNumero1.setColumns(10);
		txtNumero1.setBounds(25, 22, 155, 32);
		getContentPane().add(txtNumero1);
		
		txtNumero2 = new JTextField();
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(198, 22, 155, 32);
		getContentPane().add(txtNumero2);
		
		JLabel label = new JLabel("RESULTADO");
		label.setBounds(33, 133, 59, 14);
		getContentPane().add(label);
		
		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		txtResultado.setBounds(135, 130, 220, 20);
		getContentPane().add(txtResultado);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(266, 175, 89, 23);
		getContentPane().add(btnSalir);

	}
	public void eventos()
	{
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num1,num2,division;
				
				try{
					num1=Double.parseDouble(txtNumero1.getText());
					num2=Double.parseDouble(txtNumero2.getText());
					division=num1/num2;
					txtResultado.setText(Double.toString(division));
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Ingrese opcion valida");
				}
			}
		});
		btnMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1,num2,multiplicacion;
				
				try{
					num1=Integer.parseInt(txtNumero1.getText());
					num2=Integer.parseInt(txtNumero2.getText());
					multiplicacion=num1*num2;
					txtResultado.setText(Integer.toString(multiplicacion));
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Ingrese opcion valida");
				}
			}
		});
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1,num2,resta;
				
				try{
					num1=Integer.parseInt(txtNumero1.getText());
					num2=Integer.parseInt(txtNumero2.getText());
					resta=num1-num2;
					txtResultado.setText(Integer.toString(resta));
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Ingrese opcion valida");
				}
			}
		});
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1,num2,suma;
							
				try{
					num1=Integer.parseInt(txtNumero1.getText());
					num2=Integer.parseInt(txtNumero2.getText());
					suma=num1+num2;
					txtResultado.setText(Integer.toString(suma));
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Ingrese opcion valida");
				}
				
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
	}
	public void limpiar()
	{
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumero1.setText(null);
				txtNumero2.setText(null);
				txtResultado.setText(null);
				txtNumero1.requestFocus();
			}
		});
	}
	public void salir()
	{
		int n=JOptionPane.showConfirmDialog(rootPane, "Desea Salir?","Seleccione su Opcion",JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.YES_OPTION)
			//System.exit(0);
			dispose();
	}

}
