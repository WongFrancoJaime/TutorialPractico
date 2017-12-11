package Paquete;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class PlanilladePagodeDocentes extends JInternalFrame {

	private JPanel view;
	private JTextField txtcodigo;
	private JTextField txtapellido;
	private JTextField txtnombre;
	private JTextField txthoras;
	private JTextField txtpago;
	private JTextField txtrim;
	private JTextField txtderrama;
	private JTextField txtsueldo;
	private JTextField txtbonif;
	private JTextField txtdesc;

	DefaultListModel lista =new DefaultListModel();
	DefaultTableModel modelo = new DefaultTableModel();
	double bonificacionmes;
	double descuento,sueldo,descuentodia,bonif,derrama,rim,boniftotal,bonificacion;		
	
	private JComboBox cbomes;
	private JComboBox cboturno;
	private JComboBox cbonivel;
	private JComboBox cbogrado;
	private JComboBox cbofaltas;
	private JList lstcarreras;
	private JTable table;
	private JButton btnGrabar;
	private JButton btnSalir;
	private JButton btnCancelar;
	private JButton btnNuevo;
	private JLabel lblNroHoras;
	private JLabel lblPagoXHora;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanilladePagodeDocentes frame = new PlanilladePagodeDocentes();
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
	public PlanilladePagodeDocentes() 
	{
		setResizable(true);
		setClosable(true);
		inicializar();
		cargarCombo();
		cargarlista();
		diseTabla();
		funcionalidad();
		
	}
	
	private void inicializar()
	{
		setBounds(100, 100, 576, 735);
		view = new JPanel();
		view.setBackground(Color.PINK);
		setContentPane(view);
		view.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mes");
		lblNewLabel.setBounds(23, 39, 46, 14);
		view.add(lblNewLabel);
		
		cbomes = new JComboBox();
		
		cbomes.setBounds(61, 36, 71, 20);
		view.add(cbomes);
		
		JLabel lblNewLabel_1 = new JLabel("PLANILLA DE PAGO DE DOCENTES");
		lblNewLabel_1.setBounds(109, 11, 333, 14);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		view.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo");
		lblNewLabel_2.setBounds(23, 89, 46, 14);
		view.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setBounds(23, 118, 46, 14);
		view.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		lblNewLabel_4.setBounds(23, 150, 46, 14);
		view.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Turno");
		lblNewLabel_5.setBounds(193, 89, 46, 14);
		view.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nivel");
		lblNewLabel_6.setBounds(193, 118, 46, 14);
		view.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Grado Academico");
		lblNewLabel_7.setBounds(193, 150, 71, 14);
		view.add(lblNewLabel_7);
		
		lblNroHoras = new JLabel("N\u00BA Horas");
		lblNroHoras.setBounds(407, 89, 46, 14);
		view.add(lblNroHoras);
		
		lblPagoXHora = new JLabel("Pago por Hora S/.");
		lblPagoXHora.setBounds(407, 150, 110, 14);
		view.add(lblPagoXHora);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(79, 86, 86, 20);
		view.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(79, 115, 86, 20);
		txtapellido.setColumns(10);
		view.add(txtapellido);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(79, 147, 86, 20);
		txtnombre.setColumns(10);
		view.add(txtnombre);
		
		cboturno = new JComboBox();
		cboturno.setBounds(286, 86, 86, 20);
		view.add(cboturno);
		
		cbonivel = new JComboBox();
		
		cbonivel.setBounds(286, 115, 86, 20);
		view.add(cbonivel);
		
		cbogrado = new JComboBox();
		
		cbogrado.setBounds(286, 147, 86, 20);
		view.add(cbogrado);
		
		txthoras = new JTextField();
		
		
		txthoras.setBounds(407, 115, 86, 20);
		view.add(txthoras);
		txthoras.setColumns(10);
		
		txtpago = new JTextField();
		
		txtpago.setBounds(407, 175, 86, 20);
		txtpago.setColumns(10);
		view.add(txtpago);
		
		JLabel lblNewLabel_10 = new JLabel("RIM");
		lblNewLabel_10.setBounds(23, 203, 46, 14);
		view.add(lblNewLabel_10);
		
		JLabel lblDerrama = new JLabel("Derrama M.");
		lblDerrama.setBounds(23, 244, 71, 14);
		view.add(lblDerrama);
		
		JLabel lblNFaltas = new JLabel("N\u00BA faltas");
		lblNFaltas.setBounds(23, 282, 46, 14);
		view.add(lblNFaltas);
		
		JLabel lblSueldoMensual = new JLabel("Sueldo Mensual");
		lblSueldoMensual.setBounds(23, 318, 84, 14);
		view.add(lblSueldoMensual);
		
		JLabel lblBonificacion = new JLabel("Bonificacion");
		lblBonificacion.setBounds(233, 203, 71, 14);
		view.add(lblBonificacion);
		
		JLabel lblDescuentos = new JLabel("Descuentos");
		lblDescuentos.setBounds(233, 282, 71, 14);
		view.add(lblDescuentos);
		
		btnNuevo = new JButton("Nuevo");
		
		btnNuevo.setBounds(29, 609, 110, 44);
		view.add(btnNuevo);
		
		btnCancelar = new JButton("Cancelar");
		
		btnCancelar.setBounds(165, 609, 99, 44);
		view.add(btnCancelar);
		
		btnGrabar = new JButton("Grabar");
		
		btnGrabar.setBounds(289, 609, 93, 44);
		view.add(btnGrabar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(418, 609, 99, 44);
		view.add(btnSalir);
		
		txtrim = new JTextField();
		txtrim.setBounds(109, 200, 86, 20);
		view.add(txtrim);
		txtrim.setColumns(10);
		
		txtderrama = new JTextField();
		txtderrama.setBounds(109, 241, 86, 20);
		txtderrama.setColumns(10);
		view.add(txtderrama);
		
		txtsueldo = new JTextField();
		txtsueldo.setBounds(109, 315, 86, 20);
		txtsueldo.setColumns(10);
		view.add(txtsueldo);
		
		txtbonif = new JTextField();
		txtbonif.setBounds(233, 241, 86, 20);
		txtbonif.setColumns(10);
		view.add(txtbonif);
		
		txtdesc = new JTextField();
		txtdesc.setBounds(233, 315, 86, 20);
		txtdesc.setColumns(10);
		view.add(txtdesc);
		
		cbofaltas = new JComboBox();
		
		cbofaltas.setBounds(109, 279, 56, 20);
		view.add(cbofaltas);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(407, 397, 181, -16);
		scrollBar_2.setOrientation(JScrollBar.HORIZONTAL);
		view.add(scrollBar_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 206, 166, 167);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		view.add(scrollPane);
		
		lstcarreras = new JList();
		scrollPane.setViewportView(lstcarreras);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(29, 422, 488, 167);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		view.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
	}
	
	//EVENTOS
		private void funcionalidad()
		{
			btnGrabar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					grabar();
				}
			});
			
			btnNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					nuevo();
				}
			});
			
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					salir();
				}
			});
			
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					nuevo();
				}
			});
			
			txthoras.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) 
				{
					if(e.getKeyCode()==e.VK_ENTER)
					{
						txtpago.requestFocus();
					}
				}
			});
			
			txtpago.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) 
				{	derrama();
					if(e.getKeyCode()==e.VK_ENTER)
					{
						double sueldo=0,cantidadhoras,pagohora;
						   cantidadhoras=Double.parseDouble(txthoras.getText());
						   pagohora=Double.parseDouble(txtpago.getText());
						   sueldo=cantidadhoras*pagohora;
						   txtrim.setText(String.valueOf(sueldo));
						   	   
					}
					
				}
			});
			
			cbonivel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
				    if (cbonivel.getSelectedItem()=="Seleccione Nivel")
				    {
				    	txtrim.setText("0");
				    	inhabilitar();
				    }
				    if (cbonivel.getSelectedItem()=="30")
				    {
				    	txtrim.setText("2500");
				    	inhabilitar();
				    }
				    else if (cbonivel.getSelectedItem()=="40")
				    {
				    	txtrim.setText("3000");
				    	inhabilitar();
				    }
				    else if (cbonivel.getSelectedItem()=="Bolsa")
				    {	habilitar();
				    	txtrim.setText("0");
				    	txthoras.requestFocus();
				    	
				    }
				    else
				    {
				    	inhabilitar();
				    }
				}
				
			});
			
			cbogrado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					
					derrama();
					 if (cbogrado.getSelectedItem()=="Seleccione Grado")
					    {
					    	txtrim.setText("0");
					    	inhabilitar();
					    }
					    if (cbogrado.getSelectedItem()=="Maestria")
					    {
					    	rim=Double.parseDouble(txtrim.getText());
							bonif=rim*0.10;
							boniftotal=bonif+bonificacionmes;
							txtbonif.setText(String.valueOf(boniftotal));
							
					    }
					    else if (cbogrado.getSelectedItem()=="Doctorado")
					    {
					    	rim=Double.parseDouble(txtrim.getText());
							bonif=rim*0.15;
							boniftotal=bonif+bonificacionmes;
							txtbonif.setText(String.valueOf(boniftotal));
							
					    }
					    
					    else
					    {
					    	inhabilitar();
					    }
				}
				
			});
			cbomes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					if(cbomes.getSelectedItem()=="Julio" || cbomes.getSelectedItem()=="Diciembre")
					{
						bonificacionmes=300;
					}
					else
					
						bonificacionmes=0;
					
				}
			});
			cbofaltas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					int faltas=Integer.parseInt(cbofaltas.getSelectedItem().toString());
					derrama=Double.parseDouble(txtderrama.getText());
					double rim=Double.parseDouble(txtrim.getText());
					descuentodia=(rim/30)*faltas;
					descuento=descuentodia+derrama;
					sueldo= (rim+boniftotal-descuento);
					txtdesc.setText(String.valueOf((float)descuento));
					txtsueldo.setText(String.valueOf((float)sueldo));
							
			
				}
				
			});
		}		
	    
		
	
	
		public void cargarCombo()
		{
			cbomes.addItem("Enero");
			cbomes.addItem("Febrero");
			cbomes.addItem("Marzo");
			cbomes.addItem("Abril");
			cbomes.addItem("Mayo");
			cbomes.addItem("Junio");
			cbomes.addItem("Julio");
			cbomes.addItem("Agosto");
			cbomes.addItem("Septiembre");
			cbomes.addItem("Octubre");
			cbomes.addItem("Noviembre");
			cbomes.addItem("Diciembre");
			
			cboturno.addItem("Seleccione Turno");
			cboturno.addItem("Diurno");
			cboturno.addItem("Nocturno");
			
			cbonivel.addItem("Seleccione Nivel");
			cbonivel.addItem("40");
			cbonivel.addItem("30");
			cbonivel.addItem("Bolsa");
			
			cbogrado.addItem("Ninguno");
			cbogrado.addItem("Maestria");
			cbogrado.addItem("Doctorado");
			
			for(int falta=0; falta<=15; falta++)
			{
				cbofaltas.addItem(falta);
			}
			
		}
		public void cargarlista()
		{
			lista.addElement("Computacion e Informatica");
			lista.addElement("Metalurgia");
			lista.addElement("Construccion Civil");
			lista.addElement("Electrotecnia Industrial");
			lista.addElement("Electronica");
			lista.addElement("Mecanica de Produccion");
			lista.addElement("Mecanica Automotriz");
			lstcarreras.setModel(lista);
		}
	
		public void diseTabla()
		{
			modelo.addColumn("Codigo");
			modelo.addColumn("Apellidos");
			modelo.addColumn("Nombres");
			modelo.addColumn("Area Academica");
			modelo.addColumn("Turno");
			modelo.addColumn("Nivel");
			modelo.addColumn("Descuentos");
			modelo.addColumn("Bonificacion");
			modelo.addColumn("Sueldo");
			table.setModel(modelo);
			
			
		}
		public void grabar()
		{
			Object [] fila = new Object[10];
			fila[0]=txtcodigo.getText();
			fila[1]=txtapellido.getText();
			fila[2]=txtnombre.getText();
			fila[3]=lstcarreras.getSelectedValue();
			fila[4]=cboturno.getSelectedItem();
			fila[5]=cbonivel.getSelectedItem();
			fila[6]=txtdesc.getText();
			fila[7]=txtbonif.getText();
			fila[8]=txtsueldo.getText();
			
			modelo.addRow(fila);
		}
		public void habilitar()
		{ 
			txtcodigo.setEnabled(true);
			txtapellido.setEnabled(true);
			txtnombre.setEnabled(true);
			txtdesc.setEnabled(true);
			txtbonif.setEnabled(true);
			txtsueldo.setEnabled(true);
			txtrim.setEnabled(true);
			cbofaltas.setEnabled(true);
			txthoras.setVisible(true);
			txtpago.setVisible(true);
			cbofaltas.setVisible(true);
			txthoras.setEnabled(true);
			txtpago.setEnabled(true);
			lblNroHoras.setVisible(true);
			lblPagoXHora.setVisible(true);
			
		}
		
		public void inhabilitar()
		{
			txthoras.setEnabled(false);
			txtderrama.setEnabled(false);
			txtdesc.setEnabled(true);
			txtbonif.setEnabled(true);
			txtsueldo.setEnabled(true);
			txtrim.setEnabled(true);
			cbofaltas.setEnabled(true);
			txthoras.setVisible(false);
			txtpago.setVisible(false);
			txtpago.setEnabled(false);
			lblNroHoras.setVisible(false);
			lblPagoXHora.setVisible(false);
		}
	 
		public void nuevo()
		{
			txtcodigo.setText("");
			txtapellido.setText(""); 
			txtnombre.setText("");
			txtdesc.setText("");
			txtbonif.setText("");
			txtsueldo.setText("");
			txtrim.setText("");
			cboturno.setSelectedIndex(0);
			cbonivel.setSelectedIndex(0);
			cbogrado.setSelectedIndex(0);
			cbofaltas.setSelectedIndex(0);
			cbomes.setSelectedIndex(0);
			txtderrama.setText("");
			txthoras.setText("");
			txtpago.setText("");
			lstcarreras.clearSelection();
			
		}
	
		public void salir()
		{
			int n=JOptionPane.showConfirmDialog(rootPane, "DESEA SALIR ?","Seleccione su opcion",JOptionPane.YES_NO_OPTION);
			if(n==JOptionPane.YES_NO_OPTION)
				dispose();
		}
		public void derrama()
		{
			txtderrama.setText(String.valueOf(18));
		}
		
		
}