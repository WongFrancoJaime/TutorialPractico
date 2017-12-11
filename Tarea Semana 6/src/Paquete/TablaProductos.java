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
import java.awt.Font;
import java.awt.Color;

public class TablaProductos extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtDescripcion;
	private JTextField txtPrecioUnit;
	private JTextField txtTotalPagar;
	private JTable table;

	DefaultTableModel modelo=new DefaultTableModel();
	private JComboBox cboMarca;
	private JComboBox cboCantidad;
	private JComboBox cboComprobante;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEliminarProducto;
	private JButton btnEliminarTodo;
	private JButton btnSalir;
	
	double neto=0;
	double precioU,total;
	double igv;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaProductos frame = new TablaProductos();
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
	public TablaProductos() 
	{
		setResizable(true);
		setClosable(true);	
		inicializar();
		disetabla();
		cargarComboComprobante();
		cargarComboMarca();
		cargarComboCantidad();
		funcionalidad();
		

		
	}
	public void inicializar() {
		setBounds(100, 100, 872, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTablaDeProductos = new JLabel("TABLA DE PRODUCTOS VENDIDOS EN EL DIA");
		lblTablaDeProductos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTablaDeProductos.setBounds(23, 20, 477, 35);
		contentPane.add(lblTablaDeProductos);
		
		JPanel panel = new JPanel();
		panel.setBounds(578, 66, 268, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(23, 25, 46, 14);
		panel.add(lblId);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(23, 67, 76, 14);
		panel.add(lblDescripcion);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(23, 112, 46, 14);
		panel.add(lblMarca);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(23, 157, 46, 14);
		panel.add(lblCantidad);
		
		JLabel lblPrecioUnit = new JLabel("Precio Unit");
		lblPrecioUnit.setBounds(23, 207, 76, 14);
		panel.add(lblPrecioUnit);
		
		JLabel lblComprobante = new JLabel("Comprobante");
		lblComprobante.setBounds(23, 254, 76, 14);
		panel.add(lblComprobante);
		
		JLabel lblTotalPagar = new JLabel("Total Pagar");
		lblTotalPagar.setBounds(23, 306, 64, 14);
		panel.add(lblTotalPagar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(92, 368, 89, 23);
		panel.add(btnGuardar);
		
		txtID = new JTextField();
		txtID.setBounds(125, 22, 86, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(125, 64, 86, 20);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		cboMarca = new JComboBox();
		cboMarca.setBounds(125, 109, 133, 20);
		panel.add(cboMarca);
		
		cboCantidad = new JComboBox();
		cboCantidad.setBounds(125, 154, 86, 20);
		panel.add(cboCantidad);
		
		txtPrecioUnit = new JTextField();
		txtPrecioUnit.setBounds(125, 204, 86, 20);
		panel.add(txtPrecioUnit);
		txtPrecioUnit.setColumns(10);
		
		cboComprobante = new JComboBox();
		cboComprobante.setBounds(125, 251, 112, 20);
		panel.add(cboComprobante);
		
		txtTotalPagar = new JTextField();
		txtTotalPagar.setBounds(125, 303, 86, 20);
		panel.add(txtTotalPagar);
		txtTotalPagar.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(58, 438, 502, 75);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnNuevo = new JButton("Nuevo");
		panel_1.add(btnNuevo);
		
		btnEliminarProducto = new JButton("Eliminar Producto");
		panel_1.add(btnEliminarProducto);
		
		btnEliminarTodo = new JButton("Eliminat Todo");
		panel_1.add(btnEliminarTodo);
		
		btnSalir = new JButton("Salir");
		panel_1.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 66, 539, 354);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	public void funcionalidad() {
		
		cboComprobante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val=Integer.parseInt((String)cboCantidad.getSelectedItem().toString());
				precioU=Double.parseDouble(txtPrecioUnit.getText());
				total=precioU*val;
				if(cboComprobante.getSelectedItem()=="Boleta")
				{	igv=0;
					
				}
				else if(cboComprobante.getSelectedItem()=="Factura")
				{	
					igv=total*0.19;
					
					
				}
				neto=total+igv;
				txtTotalPagar.setText(String.valueOf(neto));
			}
		});
		
		cboCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
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
		
		btnEliminarProducto.addActionListener(new ActionListener() {
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
	
	public void cargarComboMarca()
	{	cboMarca.addItem("--Seleccione--");
		cboMarca.addItem("Affresh");
		cboMarca.addItem("Aroma Housewares");
		cboMarca.addItem("Assurant");
		cboMarca.addItem("Best");
		cboMarca.addItem("Bissell");
		cboMarca.addItem("BLACK+DECKER");
		cboMarca.addItem("Coleman");
		cboMarca.addItem("Crock-Pot");
		cboMarca.addItem("DampRid");
		cboMarca.addItem("Dash");
		cboMarca.addItem("Dirt Devil");
		cboMarca.addItem("Ecovacs");
		cboMarca.addItem("Essential Values");
		cboMarca.addItem("First Alert");
		cboMarca.addItem("Folex");
		cboMarca.addItem("FoodSaver");
		cboMarca.addItem("Frigidaire");

	}
	public void cargarComboCantidad()
	{
		for(int cant=0; cant<=100; cant++)
		{
			cboCantidad.addItem(cant);
		}
	}
	public void cargarComboComprobante()
	{	cboComprobante.addItem("--Seleccione--");
		cboComprobante.addItem("Boleta");
		cboComprobante.addItem("Factura");
	}
	public void disetabla() {
		modelo.addColumn("ID");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Marca");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio Unit");
		modelo.addColumn("Total");
		table.setModel(modelo);
	}
	public void nuevo()
	{
		txtID.setText("");
		txtDescripcion.setText("");
		txtPrecioUnit.setText("");
		txtTotalPagar.setText("");
		cboMarca.setSelectedIndex(0);
		cboCantidad.setSelectedIndex(0);
		cboComprobante.setSelectedIndex(0);
		txtID.requestFocus();
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
		Object[] fila =new Object[6];
		fila[0]=txtID.getText();
		fila[1]=txtDescripcion.getText();
		fila[2]=cboMarca.getSelectedItem();
		fila[3]=cboCantidad.getSelectedItem();
		fila[4]=txtPrecioUnit.getText();
		fila[5]=txtTotalPagar.getText();
		modelo.addRow(fila);
	}
	


}
