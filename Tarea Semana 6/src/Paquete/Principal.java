package Paquete;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	CalculadoraBasica1 calc=new CalculadoraBasica1();
	private JMenuItem mntmVerCalculadora;
	private JMenuItem mntmNmerosMultiplosDe;
	private JMenuItem mntmRegistroDeLibros;
	private JMenuItem mntmSalir;
	private JDesktopPane desktopPane;
	private JMenuItem mntmPlanillaDePago;
	private JMenu mnSemana;
	private JMenu mnTareaSemana;
	private JMenuItem mntmTablaDeProductos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal()
	{
		setTitle("Principal");
		inicializar();
		eventos();
	}
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivos = new JMenu("Archivos");
		menuBar.add(mnArchivos);
		
		mnTareaSemana = new JMenu("Tarea Semana 3");
		mnArchivos.add(mnTareaSemana);
		
		mntmVerCalculadora = new JMenuItem("Ver Calculadora");
		mnTareaSemana.add(mntmVerCalculadora);
		
		mntmNmerosMultiplosDe = new JMenuItem("N\u00FAmeros multiplos de 3 y 5");
		mnTareaSemana.add(mntmNmerosMultiplosDe);
		
		mnSemana = new JMenu("Tarea Semana 5");
		mnArchivos.add(mnSemana);
		
		mntmPlanillaDePago = new JMenuItem("Planilla de pago de Docentes");
		mnSemana.add(mntmPlanillaDePago);
		
		mntmTablaDeProductos = new JMenuItem("Tabla de Productos");
		mnSemana.add(mntmTablaDeProductos);
		
		mntmRegistroDeLibros = new JMenuItem("Registro de libros");
		mnArchivos.add(mntmRegistroDeLibros);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivos.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 160, 122));
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	public void eventos()
	{	
		mntmVerCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculadoraBasica1 calc=new CalculadoraBasica1();
				calc.setVisible(true);
				desktopPane.add(calc);
				Dimension desktopSize = desktopPane.getSize();
		        Dimension FrameSize = calc.getSize();
		        calc.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		        calc.show();
				
			}
		});
		
		mntmNmerosMultiplosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Multiplosde5y3 mult=new Multiplosde5y3();
				mult.setVisible(true);
				desktopPane.add(mult);
				Dimension desktopSize = desktopPane.getSize();
		        Dimension FrameSize = mult.getSize();
		        mult.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		        mult.show();
			}
		});
		
		mntmRegistroDeLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrodeLibros reg=new RegistrodeLibros();
				reg.setVisible(true);
				desktopPane.add(reg);
				Dimension desktopSize = desktopPane.getSize();
		        Dimension FrameSize = reg.getSize();
		        reg.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		        reg.show();
			}
		});
		
		mntmPlanillaDePago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanilladePagodeDocentes pag=new PlanilladePagodeDocentes();
				pag.setVisible(true);
				desktopPane.add(pag);
				Dimension desktopSize = desktopPane.getSize();
		        Dimension FrameSize = pag.getSize();
		        pag.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		        pag.show();
			}
		});
		
		mntmTablaDeProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaProductos prod=new TablaProductos();
				prod.setVisible(true);
				desktopPane.add(prod);
				Dimension desktopSize = desktopPane.getSize();
		        Dimension FrameSize = prod.getSize();
		        prod.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
		        prod.show();
			}
		});
		
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
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
