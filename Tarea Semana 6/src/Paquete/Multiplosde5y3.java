package Paquete;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;


public class Multiplosde5y3 extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtTotal1;
	private JTextField txtPromedio1;
	private JTextField txtTotal2;
	private JTextField txtPromedio2;
	
	DefaultListModel modelo=new DefaultListModel();
	DefaultListModel modelo1=new DefaultListModel();

	int numero;
	int posicion;
	private JList list2;
	private JList list1;
	private JButton btnBorrar1;
	private JButton btnBorrarTodo1;
	private JButton btnBorrar2;
	private JButton btnBorrarTodo2;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Multiplosde5y3 frame = new Multiplosde5y3();
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
	public Multiplosde5y3() {
		setTitle("REGISTRO DE NUMEROS MULTIPLOS");
		setResizable(true);
		setClosable(true);
		Inicializar();
		Eventos();
		
	}
	public void Inicializar()
	{
		setBounds(100, 100, 555, 449);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeNumeros = new JLabel("REGISTRO DE NUMEROS MULTIPLOS");
		lblRegistroDeNumeros.setBounds(175, 22, 225, 14);
		contentPane.add(lblRegistroDeNumeros);
		
		JLabel lblIngreseNumero = new JLabel("Ingrese Numero:");
		lblIngreseNumero.setBounds(35, 61, 108, 14);
		contentPane.add(lblIngreseNumero);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(139, 58, 147, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNmerosMultiplosDe = new JLabel("N\u00FAmeros multiplos de 3");
		lblNmerosMultiplosDe.setBounds(35, 111, 177, 14);
		contentPane.add(lblNmerosMultiplosDe);
		
		JLabel lblNmerosMultiplosDe_1 = new JLabel("N\u00FAmeros multiplos de 5");
		lblNmerosMultiplosDe_1.setBounds(281, 111, 182, 14);
		contentPane.add(lblNmerosMultiplosDe_1);
		
		btnBorrar1 = new JButton("Borrar");
		btnBorrar1.setBounds(186, 151, 89, 23);
		contentPane.add(btnBorrar1);
		
		btnBorrarTodo1 = new JButton("Borrar todo");
		btnBorrarTodo1.setBounds(186, 198, 89, 23);
		contentPane.add(btnBorrarTodo1);
		
		btnBorrar2 = new JButton("Borrar");
		btnBorrar2.setBounds(433, 151, 89, 23);
		contentPane.add(btnBorrar2);
		
		btnBorrarTodo2 = new JButton("Borrar todo");
		btnBorrarTodo2.setBounds(433, 198, 89, 23);
		contentPane.add(btnBorrarTodo2);
		
		JLabel lblTotal = new JLabel("total");
		lblTotal.setBounds(24, 270, 46, 14);
		contentPane.add(lblTotal);
		
		txtTotal1 = new JTextField();
		txtTotal1.setBounds(49, 295, 86, 20);
		contentPane.add(txtTotal1);
		txtTotal1.setColumns(10);
		
		JLabel lblPromedioNumeros = new JLabel("Promedio numeros");
		lblPromedioNumeros.setBounds(24, 326, 108, 14);
		contentPane.add(lblPromedioNumeros);
		
		txtPromedio1 = new JTextField();
		txtPromedio1.setColumns(10);
		txtPromedio1.setBounds(49, 350, 86, 20);
		contentPane.add(txtPromedio1);
		
		JLabel label = new JLabel("total");
		label.setBounds(289, 270, 46, 14);
		contentPane.add(label);
		
		txtTotal2 = new JTextField();
		txtTotal2.setColumns(10);
		txtTotal2.setBounds(314, 295, 86, 20);
		contentPane.add(txtTotal2);
		
		JLabel label_1 = new JLabel("Promedio numeros");
		label_1.setBounds(289, 326, 108, 14);
		contentPane.add(label_1);
		
		txtPromedio2 = new JTextField();
		txtPromedio2.setColumns(10);
		txtPromedio2.setBounds(314, 350, 86, 20);
		contentPane.add(txtPromedio2);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(433, 322, 89, 23);
		contentPane.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 136, 115, 123);
		contentPane.add(scrollPane);
		
		list1 = new JList();
		scrollPane.setViewportView(list1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(291, 136, 115, 123);
		contentPane.add(scrollPane_1);
		
		list2 = new JList();
		scrollPane_1.setViewportView(list2);
	}
	
	public void Eventos()
	{
		btnBorrarTodo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarTodo();
			}
		});
		btnBorrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		btnBorrarTodo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarTodo1();
			}
		});
		btnBorrar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar1();
			}
		});
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()== KeyEvent.VK_ENTER)
				{
					agregar();
					limpiar();
				}
			}
		});
	}
	public void agregar()
	{ try
	  {
		numero=Integer.parseInt(txtNumero.getText());
		if(numero%3==0)
		{modelo.addElement(numero);
		 list1.setModel(modelo);
		 float suma=0;
			String cadena="";
			int cont=0;
			for (int i=0; i < list1.getModel().getSize(); i++){

				cadena = list1.getModel().getElementAt(i).toString();
				numero = Integer.parseInt(cadena);
				suma = suma + numero;
				cont++;
				}
				txtTotal1.setText(String.valueOf(suma));
				txtPromedio1.setText(String.valueOf(suma/cont));
		}
		if(numero%5==0)
		{
		modelo1.addElement(numero);
		list2.setModel(modelo1);
		 float suma1=0;
			String cadena="";
			int cont1=0;
			for (int i=0; i < list2.getModel().getSize(); i++){

				cadena = list2.getModel().getElementAt(i).toString();
				numero = Integer.parseInt(cadena);
				suma1 = suma1 + numero;
				cont1++;
				}
				txtTotal2.setText(String.valueOf(suma1));
				txtPromedio2.setText(String.valueOf(suma1/cont1));
	    }
	   }catch(Exception e1){
		JOptionPane.showMessageDialog(null,"Ingrese Número");
		}	
	}
	public void eliminar()
	{	try
		{
		modelo.remove(posicion);
				}
	catch(ArrayIndexOutOfBoundsException ms)
		{
		System.out.println("No hay elementos en lista");
		}
		
	}
	public void eliminarTodo()
	{	try
		{
		modelo.removeAllElements();
		}
	catch(ArrayIndexOutOfBoundsException ms)
		{
		System.out.println("No hay elementos en lista");
		}
		
	}
	public void eliminar1()
	{	try
		{
		modelo1.remove(posicion);
				}
	catch(ArrayIndexOutOfBoundsException ms)
		{
		System.out.println("No hay elementos en lista");
		}
		
	}
	public void eliminarTodo1()
	{	try
		{
		modelo1.removeAllElements();
		}
	catch(ArrayIndexOutOfBoundsException ms)
		{
		System.out.println("No hay elementos en lista");
		}
		
	}
	public void limpiar()
	{
		txtNumero.setText("");
		txtNumero.requestFocus();
	}
	public void salir()
	{
		int n=JOptionPane.showConfirmDialog(rootPane, "Desea Salir?","Seleccione su Opcion",JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.YES_OPTION)
			//System.exit(0);
			dispose();
	}
}
