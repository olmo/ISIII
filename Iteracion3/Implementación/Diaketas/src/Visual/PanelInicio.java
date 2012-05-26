package Visual;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;



public class PanelInicio extends JPanel {

	private VentanaPrincipal padre;

	//
	PanelPersonas panel_personas;

	PanelDonaciones panel_donaciones;

	PanelActuaciones panel_actuaciones;

	PanelAyudas panel_ayudas;
	
	PanelOfertas panel_ofertas;

	PanelDemandas panel_demandas;

	PanelGestionBajas panel_GestionBajas;


	public AnadirTipoAyuda anadir_tipo_ayuda;
	public AniadirDonacion aniadir_donacion;
	public BusquedaFamiliares busqueda_familiares;
	public BusquedaUsuarios busqueda_usuarios;
	public ConcederAyuda conceder_ayuda;
	public GestionSolicitante gestion_solicitante;
	public ConfigurarTipoAyuda configurar_tipo_ayuda;
	public DatosFamiliar datos_familiar;
	public DatosUsuario datos_usuario;
	public EditarAyuda editar_ayuda;
	public EditarTipoAyuda editar_tipo_ayuda;
	public NuevoFamiliar nuevo_familiar;
	public NuevoUsuario nuevo_usuario;
	public AnadirOferta anadir_oferta; /*cambiado por lin, xk sino peta en panelOfertas*/
	public AniadirDemandas anadir_demandas;
	public VerDetallesDemandas verDetallesDemandas;
	public AniadirSolicitante aniadir_solicitante;
	public EditarSolicitante editar_solicitante;
	public GestionEmpresa gestion_empresa;
	public AnadirEditarEmpresa anadirEditar_empresa;

	final static int PERSONAS = 0;
	final static int DONACIONES = 1;
	final static int AYUDAS = 2;
	final static int ACTUACIONES = 3;
	final static int OFERTAS = 4;
	final static int DEMANDAS = 5;
	final static int GESTIONBAJAS = 6;

	//Usuarios
	public JPanel panelUsuarios;
	//Donaciones
	public JPanel panelDonaciones;
	//Ayudas
	public JPanel panelAyudas;
	//Actuaciones
	public JPanel panelActuaciones;
	//Ofertas
	public JPanel panelOfertas;
	//Demandas
	public JPanel panelDemandas;
	//Gestion bajas
	public JPanel panelGestionBajas;

	static Dimension tamanoPaneles = new Dimension(1100, 650);

	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public PanelInicio(VentanaPrincipal p, String usuario) {



		padre = p;
		//Inicialización paneles pestañas
		panelUsuarios = new JPanel();
		panelUsuarios.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelUsuarios.setSize(tamanoPaneles);

		padre.actualizaProgreso("Creado Panel Usuarios\n");

		panelDonaciones = new JPanel();
		panelDonaciones.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDonaciones.setSize(tamanoPaneles);

		padre.actualizaProgreso("Creado Panel Donaciones\n");

		panelAyudas = new JPanel();
		panelAyudas.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelAyudas.setSize(tamanoPaneles);

		padre.actualizaProgreso("Creado Panel Ayudas\n");

		panelActuaciones = new JPanel();
		panelActuaciones.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelActuaciones.setSize(tamanoPaneles);

		padre.actualizaProgreso("Creado Panel Actuaciones\n");

		panelDemandas = new JPanel();
		panelDemandas.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelDemandas.setSize(tamanoPaneles);

		panelGestionBajas = new JPanel();
		panelGestionBajas.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelGestionBajas.setSize(tamanoPaneles);

		padre.actualizaProgreso("Creado Panel Demandas\n");

		padre.actualizaProgreso("Rellenando tablas de la interfaz\n");

		anadir_tipo_ayuda = new AnadirTipoAyuda(p, this);

		padre.actualizaProgreso("Descargando Tipos de Ayuda\n");
		aniadir_donacion = new AniadirDonacion(p, this);
		padre.actualizaProgreso("Descargando Donaciones\n");
		//busqueda_familiares = new BusquedaFamiliares(p, id, pIni);
		busqueda_usuarios = new BusquedaUsuarios(p, this);
		padre.actualizaProgreso("Descargando Usuarios\n");
		conceder_ayuda = new ConcederAyuda(p, this);
		padre.actualizaProgreso("Descargando Ayudas\n");
		configurar_tipo_ayuda = new ConfigurarTipoAyuda(p, this);
		//datos_familiar = new DatosFamiliar(p, id, this);
		datos_usuario = new DatosUsuario(p, this);
		editar_ayuda = new EditarAyuda(p, this);
		editar_tipo_ayuda = new EditarTipoAyuda(p, this, null);
		//nuevo_familiar = new NuevoFamiliar(p, id_bene, this);
		nuevo_usuario = new NuevoUsuario(p, this);

		gestion_solicitante = new GestionSolicitante(p, this);
		padre.actualizaProgreso("Descargando gestion solicitante\n");

		aniadir_solicitante = new AniadirSolicitante(p, this);
		padre.actualizaProgreso("Descargando añadir solicitante\n");
		
		anadir_demandas = new AniadirDemandas(p, this);
		padre.actualizaProgreso("Descargando demandas\n");

		verDetallesDemandas = new VerDetallesDemandas(p, this);
		padre.actualizaProgreso("Descargando detalles demanda\n");

		panel_personas = new PanelPersonas(p, this);
		panel_actuaciones = new PanelActuaciones(p, this);
		padre.actualizaProgreso("Descargando Actuaciones\n");
		panel_donaciones = new PanelDonaciones(p, this);
		panel_ayudas = new PanelAyudas(p, this);
		panel_demandas = new PanelDemandas(p, this);
		panel_GestionBajas = new PanelGestionBajas(p, this);
		
		panel_ofertas = new PanelOfertas(p, this);
		anadir_oferta = new AnadirOferta(p, this);
		gestion_empresa = new GestionEmpresa(p, this);
		anadirEditar_empresa = new AnadirEditarEmpresa(p, this);

		//panelOfertas = new PanelOfertas(p,this);
		//anadir_oferta = new AnadirOferta(p,this);

		padre.actualizaProgreso("Tablas rellenas\n");

		//Fin inicialización


		setSize(p.getSize());
		this.padre = p;
		padre.setusuario(usuario);
		setLayout(null);

		//tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 64, 1180, 636);

		padre.actualizaProgreso("Creando Ventana Principal\n");

		panelUsuarios = panel_personas;

		panelDonaciones = panel_donaciones;

		panelActuaciones = panel_actuaciones;

		panelAyudas = panel_ayudas;
		
		panelOfertas = panel_ofertas;

		panelDemandas = panel_demandas;

		panelGestionBajas = panel_GestionBajas;


		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane, inicio, panel, textField, button, button_1, button_2, scrollPane, button_3, button_4, panel_1, textField_1, button_5, button_6, scrollPane_1, button_7, button_8, panel_2, textField_2, button_9, scrollPane_2, button_10, btnCerrarSesion, label}));

		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Home h= new Home(padre);
					padre.getContentPane().removeAll();
					padre.getContentPane().validate();
					padre.getContentPane().add(h);
					padre.getContentPane().repaint();
					tabbedPane.removeAll();

			}
		});
		btnCerrarSesion.setBounds(1064, 30, 126, 23);
		add(btnCerrarSesion);

		JLabel label = new JLabel("Bienvenido "+padre.getusuario());
		label.setBounds(1080, 11, 110, 14);
		add(label);

		tabbedPane.addTab("Personas", null, panelUsuarios, "Gestión de personas");
		tabbedPane.addTab("Donaciones", null, panelDonaciones, "Gestión de donaciones");
		tabbedPane.addTab("Ayudas", null, panelAyudas, "Gestión de ayudas");
		tabbedPane.addTab("Actuaciones", null, panelActuaciones, "Gestión de actuaciones");
		tabbedPane.addTab("Ofertas", null, panelOfertas, "Gestión de ofertas");
		tabbedPane.addTab("Demandas", null, panelDemandas, "Demandas");
		tabbedPane.addTab("Gestion de Bajas", null, panelGestionBajas, "Gestion de Bajas");
		add(tabbedPane);

		padre.actualizaProgreso("Terminado\n");
		//bProgreso.terminado();

	}

	public static void verPestana(Integer pestana){
		tabbedPane.setSelectedIndex(pestana);	
	}
	public void setPanelOnTab(JPanel panel,int index){
		tabbedPane.remove(index);
		switch(index){
		case PERSONAS:
			panelUsuarios = panel;
			tabbedPane.insertTab("Personas", null, panelUsuarios,"Gestión de personas", PERSONAS);
			break;
		case DONACIONES:
			panelDonaciones = panel;
			tabbedPane.insertTab("Donaciones", null, panelDonaciones, "Gestión de donaciones",DONACIONES);
			break;
		case AYUDAS:
			panelAyudas = panel;
			tabbedPane.insertTab("Ayudas", null, panelAyudas, "Gestión de ayudas",AYUDAS);
			break;
		case ACTUACIONES:
			panelActuaciones = panel;
			tabbedPane.insertTab("Actuaciones", null, panelActuaciones, "Gestión de actuaciones",ACTUACIONES);
			break;
		case OFERTAS:
			panelOfertas = panel;
			tabbedPane.insertTab("Ofertas", null, panelOfertas, "Gestión de ofertas",OFERTAS);
			break;
		case DEMANDAS:
			panelDemandas = panel;
			tabbedPane.insertTab("Demandas", null, panelDemandas, "Demandas",DEMANDAS);
			break;
		case GESTIONBAJAS:
			panelGestionBajas = panel;
			tabbedPane.insertTab("Gestion de Bajas", null, panelGestionBajas, "Gestion de Bajas",GESTIONBAJAS);
			break;
		}
		tabbedPane.setSelectedIndex(index);


	}
}