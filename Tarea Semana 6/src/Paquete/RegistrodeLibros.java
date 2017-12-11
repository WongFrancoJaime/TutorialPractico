package Paquete;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class RegistrodeLibros extends JInternalFrame {
	private JPanel contentPane;
	private JTextField txtIDLibro;
	private JTextField txtNombredelLibro;
	private JTextField txtAutordelLibro;
	private JTable table;

	DefaultTableModel modelo=new DefaultTableModel();
	private JComboBox cboEditorial;
	private JComboBox cboGenero;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEliminarRegistro;
	private JButton btnEliminarTodo;
	private JButton btnSalir;
	

	private JLabel label;
	private JTextField txtNombredeAlumno;
	private JLabel label_1;
	private JTextField txtApellidodeAlumno;
	private JLabel label_2;
	private JTextField txtAreaAcademica;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrodeLibros frame = new RegistrodeLibros();
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
	public RegistrodeLibros() 
	{
		setResizable(true);
		setClosable(true);	
		inicializar();
		disetabla();
		cargarComboEditorial();
		cargarComboGenero();
		funcionalidad();
		

		
	}
	public void inicializar() {
		setBounds(100, 100, 872, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTablaDeProductos = new JLabel("TABLA DE REGISTRO DE LIBROS");
		lblTablaDeProductos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTablaDeProductos.setBounds(108, 32, 340, 14);
		contentPane.add(lblTablaDeProductos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos Del Libro", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(572, 56, 268, 242);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdLibro = new JLabel("ID-Libro");
		lblIdLibro.setBounds(23, 25, 46, 14);
		panel.add(lblIdLibro);
		
		JLabel lblNombredeLibro = new JLabel("Nombre del Libro");
		lblNombredeLibro.setBounds(23, 67, 92, 14);
		panel.add(lblNombredeLibro);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(23, 112, 46, 14);
		panel.add(lblEditorial);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(23, 157, 46, 14);
		panel.add(lblGenero);
		
		JLabel lblPrecioUnit = new JLabel("Autor");
		lblPrecioUnit.setBounds(23, 207, 76, 14);
		panel.add(lblPrecioUnit);
		
		txtIDLibro = new JTextField();
		txtIDLibro.setBounds(143, 25, 86, 20);
		panel.add(txtIDLibro);
		txtIDLibro.setColumns(10);
		
		txtNombredelLibro = new JTextField();
		txtNombredelLibro.setBounds(143, 67, 86, 20);
		panel.add(txtNombredelLibro);
		txtNombredelLibro.setColumns(10);
		
		cboEditorial = new JComboBox();
		cboEditorial.setBounds(143, 112, 92, 20);
		panel.add(cboEditorial);
		
		cboGenero = new JComboBox();
		cboGenero.setBounds(143, 157, 86, 20);
		panel.add(cboGenero);
		
		txtAutordelLibro = new JTextField();
		txtAutordelLibro.setBounds(143, 207, 86, 20);
		panel.add(txtAutordelLibro);
		txtAutordelLibro.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(58, 438, 502, 75);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnNuevo = new JButton("Nuevo");
		panel_1.add(btnNuevo);
		
		btnEliminarRegistro = new JButton("Eliminar Registro");
		panel_1.add(btnEliminarRegistro);
		
		btnEliminarTodo = new JButton("Eliminat Todo");
		panel_1.add(btnEliminarTodo);
		
		btnSalir = new JButton("Salir");
		panel_1.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 66, 539, 354);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(572, 309, 268, 141);
		contentPane.add(panel_2);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Datos del Alumno", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
		panel_2.setLayout(null);
		
		label = new JLabel("Nombre del Alumno");
		label.setBounds(10, 29, 103, 14);
		panel_2.add(label);
		
		txtNombredeAlumno = new JTextField();
		txtNombredeAlumno.setColumns(10);
		txtNombredeAlumno.setBounds(153, 26, 86, 20);
		panel_2.add(txtNombredeAlumno);
		
		label_1 = new JLabel("Apellido del Alumno");
		label_1.setBounds(10, 62, 103, 14);
		panel_2.add(label_1);
		
		txtApellidodeAlumno = new JTextField();
		txtApellidodeAlumno.setColumns(10);
		txtApellidodeAlumno.setBounds(153, 62, 86, 20);
		panel_2.add(txtApellidodeAlumno);
		
		label_2 = new JLabel("\u00C1rea Academica");
		label_2.setBounds(10, 100, 103, 14);
		panel_2.add(label_2);
		
		txtAreaAcademica = new JTextField();
		txtAreaAcademica.setColumns(10);
		txtAreaAcademica.setBounds(153, 93, 86, 20);
		panel_2.add(txtAreaAcademica);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(606, 461, 202, 52);
		contentPane.add(btnGuardar);
	}
	public void funcionalidad() 
	{
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardar();
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		
		btnEliminarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				
			}
		});
		
		btnEliminarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarTodo();
				
			}
		});
		
	}
	
	public void cargarComboEditorial()
	{	cboEditorial.addItem("--Seleccione--");
		cboEditorial.addItem("Editorial Hispano Americana HASA");
		cboEditorial.addItem("Editorial La Calle");
		cboEditorial.addItem("Editorial Maipue");
		cboEditorial.addItem("Editorial Marea S.R.L.");
		cboEditorial.addItem("Editorial Mercosur ABC");
		cboEditorial.addItem("Editorial Milá");
		cboEditorial.addItem("Editorial Nobuko");
		cboEditorial.addItem("Editorial Universidad Adventista del Plata");
		cboEditorial.addItem("EdiUNS");
		cboEditorial.addItem("EDUCC - Editorial de la Universidad Católica de Córdoba");
		cboEditorial.addItem("Eduvim - Editorial Universitaria Villa María");
		cboEditorial.addItem("El Cid Editor");
		cboEditorial.addItem("El cuenco de plata");
		cboEditorial.addItem("Eseade");
		cboEditorial.addItem("Espacio Editorial");
		cboEditorial.addItem("Estudios Sociológicos Editora");
		cboEditorial.addItem("Eudeba");
		cboEditorial.addItem("Eudem");
		cboEditorial.addItem("Fundación H. A. Barceló");
		cboEditorial.addItem("Fundación Proturismo");
		cboEditorial.addItem("Gaceta Sanitaria - Ediciones Doyma, S.L.");
		cboEditorial.addItem("Grama Ediciones");
		cboEditorial.addItem("Gran Aldea editores");
		cboEditorial.addItem("Grupo Editor Latinoamericano SRL");
		cboEditorial.addItem("Grupo Editorial Lumen");
		cboEditorial.addItem("Homo Sapiens Ediciones");
		cboEditorial.addItem("Instituto de Cultura de Cundinamarca");
		cboEditorial.addItem("Jorge Sarmiento Editor - Universitas");
		cboEditorial.addItem("La Bisagra");
		cboEditorial.addItem("Lenguaje claro Editora");
		cboEditorial.addItem("Librería Editora Platense S.R.L.");
		cboEditorial.addItem("Libros del Zorzal");
		cboEditorial.addItem("Mármol-Izquierdo Editores");
		cboEditorial.addItem("Miño y Dávila");
		cboEditorial.addItem("Moglia Ediciones");
		cboEditorial.addItem("MV Ediciones S.R.L.");
		cboEditorial.addItem("SB Editorial");
		cboEditorial.addItem("SERVITEC");
		cboEditorial.addItem("Siglo XXI Editores Argentina");
		cboEditorial.addItem("Ugerman Editor");
		cboEditorial.addItem("Valletta Ediciones");

	}
	public void cargarComboGenero()
	{
		
			cboGenero.addItem("--Seleccione Genero--");
			cboGenero.addItem("Policial (o Thriller)");
			cboGenero.addItem("Romántica");
			cboGenero.addItem("Aventura");
			cboGenero.addItem("Terror");
			cboGenero.addItem("Ficcion / Realidad");
			cboGenero.addItem("Ciencia Ficción");
			cboGenero.addItem("Investigación");
			cboGenero.addItem("Biográfica");
			cboGenero.addItem("Infantil");
			cboGenero.addItem("Autoaydua");
			cboGenero.addItem("Erótica");
			cboGenero.addItem("Hogar");
			cboGenero.addItem("Enciclopedia / Manual");
			cboGenero.addItem("Politica");
			cboGenero.addItem("Economia / Marketing");
			cboGenero.addItem("Sociedad");
			cboGenero.addItem("Deportes");
			cboGenero.addItem("Viajes / Cultura");
			cboGenero.addItem("Otros temas / Varios.");

	}
	
	public void disetabla() {
		modelo.addColumn("ID-libro");
		modelo.addColumn("Nombre Libro");
		modelo.addColumn("Editorial");
		modelo.addColumn("Genero");
		modelo.addColumn("Autor");
		modelo.addColumn("Nombre Alumno");
		modelo.addColumn("Apellido Alumno");
		modelo.addColumn("Area Academica");
	
		table.setModel(modelo);
	}
	public void nuevo()
	{
		txtIDLibro.setText("");
		txtNombredelLibro.setText("");
		txtAutordelLibro.setText("");
		txtNombredeAlumno.setText("");
		txtApellidodeAlumno.setText("");
		cboEditorial.setSelectedIndex(0);
		txtAreaAcademica.setText("");
		cboGenero.setSelectedIndex(0);
		txtIDLibro.requestFocus();
	}
	public void salir()
	{
		int n=JOptionPane.showConfirmDialog(rootPane, "Desea Salir?","Seleccione su Opcion",JOptionPane.YES_NO_OPTION);
		if(n==JOptionPane.YES_OPTION)
			//System.exit(0);
			dispose();
	}

	public void eliminar()
	{
		int filase=table.getSelectedRow();
		if(filase>=0)
		{
			modelo.removeRow(filase);
		}
		else
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila");
	}
	public void eliminarTodo()
	{	try
		{
		int filas=table.getRowCount();
			for(int i=0;filas>i;i++)
			{
				modelo.removeRow(0);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila");
		}
	}
	public void guardar()
	{
		Object[] fila =new Object[8];
		fila[0]=txtIDLibro.getText();
		fila[1]=txtNombredelLibro.getText();
		fila[2]=cboEditorial.getSelectedItem();
		fila[3]=cboGenero.getSelectedItem();
		fila[4]=txtAutordelLibro.getText();
		fila[5]=txtNombredeAlumno.getText();
		fila[6]=txtApellidodeAlumno.getText();
		fila[7]=txtAreaAcademica.getText();
		modelo.addRow(fila);
	}
}
