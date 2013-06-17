package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import Controlador.Controlador;


public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int maxPila = 100;
	private static final int maxMemoria = 1000;
	
	private Controlador controlador;
	private DefaultTableModel dtm1,dtm2;
	private JMenuBar menuBar1;
	private JButton button1;
	private JComboBox<String> comboBox1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JPanel hSpacer;
	private JLabel registroSwap1;
	private JLabel registroSwap2;
	private JScrollPane scrollPane1;
	private JTextArea textoConsola;
	private JScrollPane scrollPane3;
	private JEditorPane textoPrograma;
	private JScrollPane scrollPane4;
	private JTable tablaPila;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel contadorPrograma;
	private JLabel estado;
	private JLabel contadorPila;
	private JScrollPane scrollPane2;
	private JTable tablaMemoria;
	
	public Ventana(Controlador controlador) {
		this.controlador = controlador;
		initComponents();
		this.setVisible(true);
		this.setTitle("Intérprete - Grupo 2");
		Dimension d = this.getSize();
		this.setMinimumSize(d);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initComponents() {
		menuBar1 = new JMenuBar();
		button1 = new JButton();
		comboBox1 = new JComboBox<String>(new String[]{"Normal","Traza"});
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		hSpacer = new JPanel(null);
		registroSwap1 = new JLabel();
		registroSwap2 = new JLabel();
		textoConsola = new JTextArea();
		textoPrograma = new JEditorPane();
		scrollPane3 = new JScrollPane(textoPrograma);
		scrollPane1 = new JScrollPane(textoConsola);
		scrollPane4 = new JScrollPane();
		panel1 = new JPanel();
		panel2 = new JPanel();
		contadorPrograma = new JLabel();
		estado = new JLabel();
		contadorPila = new JLabel();
		scrollPane2 = new JScrollPane();

		dtm1 = new DefaultTableModel();
		tablaPila = new JTable(dtm1);
		dtm1.addColumn("Contenido pila");
		for (int i=0;i<maxPila;i++){
			dtm1.addRow(new Object[]{""});
		}
		tablaPila.setEnabled(false);

		dtm2 = new DefaultTableModel();
		tablaMemoria = new JTable(dtm2);
		dtm2.addColumn("Dirección");
		dtm2.addColumn("Contenido");
		for (int i=0;i<maxMemoria;i++){
			dtm2.addRow(new Object[]{i,""});
		}
		tablaMemoria.setEnabled(false);

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== menuBar1 ========
		{

			//---- button1 ----
			button1.setText("Cargar");
			menuBar1.add(button1);
			button1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					JFileChooser fc = new JFileChooser();
					fc.setFileFilter(new PlgFilter());
					fc.setAcceptAllFileFilterUsed(false);
					
					int returnVal = fc.showOpenDialog(Ventana.this);
					if(returnVal == JFileChooser.APPROVE_OPTION){
						File file = fc.getSelectedFile();
						controlador.enviarFichero(file);
					}
					
				}
								
				
			});

			//---- comboBox1 ----
			comboBox1.setPreferredSize(new Dimension(4, 4));
			comboBox1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
				    ItemSelectable is = (ItemSelectable)actionEvent.getSource();
				    String temp = selectedString(is);
				    if (temp.equals("Normal")) button3.setEnabled(false);
				    else if (temp.equals("Traza")) button3.setEnabled(true);
					}	
			});
			menuBar1.add(comboBox1);

			//---- button2 ----
			button2.setText("Ejecutar");
			button2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
				    controlador.ejecutar();
					}	
			});
			menuBar1.add(button2);

			//---- button3 ----
			button3.setText("Siguiente");
			button3.setEnabled(false);
			button3.setToolTipText("Necesita esta en modo Traza para usar esta función");
			button3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
				    controlador.siguiente();
					}	
			});	
			menuBar1.add(button3);
			
			//---- button5 ----
			button5.setText("Reiniciar");
			button5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
				    controlador.reinciar();
					}	
			});	
			menuBar1.add(button5);

			//---- hSpacer ----                                                                                                        ");
			menuBar1.add(hSpacer);
			
			button4.setText("Ayuda");
			menuBar1.add(button4);
			
		}
		setJMenuBar(menuBar1);

		//======== scrollPane1 ========
		{

			//---- textArea1 ----

			scrollPane1.setPreferredSize(new Dimension(300, 155));	
			textoConsola.addKeyListener(new MyKeyListener(this.controlador,this.textoConsola));


		        // create the middle panel components
		        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		contentPane.add(scrollPane1,BorderLayout.SOUTH);
		}
		//======== scrollPane3 ========
		{

			//---- textArea2 ----
			textoPrograma.setPreferredSize(new Dimension(350,535));
			textoPrograma.setEditable(false);
			scrollPane3.setMinimumSize(new Dimension(350,535));
			scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane3.setViewportView(textoPrograma);
			
		}
		contentPane.add(scrollPane3, BorderLayout.WEST);

		//======== scrollPane4 ========
		{

			//---- tablaPila ----
			tablaPila.setPreferredSize(new Dimension(maxPila,maxPila*25));
			tablaPila.setRequestFocusEnabled(false);
			tablaPila.setRowHeight(25);
			scrollPane4.setViewportView(tablaPila);
			Rectangle visible = tablaPila.getVisibleRect();
		    Rectangle bounds = tablaPila.getBounds();
			visible.y = bounds.height - visible.height + maxPila*25;
			tablaPila.scrollRectToVisible(visible);
		}
		contentPane.add(scrollPane4, BorderLayout.CENTER);

		//======== panel1 ========
		{
			panel1.setEnabled(false);
			panel1.setPreferredSize(new Dimension(350, 438));
			panel1.setLayout(new BorderLayout());

			//======== panel2 ========
			{
				panel2.setPreferredSize(new Dimension(0, 150));
				panel2.setLayout(new GridLayout(5, 1));

				//---- label1 ----
				contadorPrograma.setText("Contador del programa:");
				contadorPrograma.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel2.add(contadorPrograma);

				//---- label2 ----
				estado.setText("Estado de ejecución:");
				estado.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel2.add(estado);

				//---- label3 ----
				contadorPila.setText("Contador de la pila:");
				contadorPila.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel2.add(contadorPila);
				
				registroSwap1.setText("Registro Swap1:");
				registroSwap1.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel2.add(registroSwap1);
				
				registroSwap2.setText("Registro Swap2:");
				registroSwap2.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel2.add(registroSwap2);
			}
			panel1.add(panel2, BorderLayout.NORTH);

			//======== scrollPane2 ========
			{

				//---- tablaMemoria ----
				tablaMemoria.setPreferredSize(new Dimension(maxMemoria, maxMemoria*25));
				tablaMemoria.setRowSelectionAllowed(false);
				tablaMemoria.setPreferredScrollableViewportSize(new Dimension(300, 850));
				tablaMemoria.setRowHeight(25);
				scrollPane2.setViewportView(tablaMemoria);
			}
			panel1.add(scrollPane2, BorderLayout.CENTER);
		}
		contentPane.add(panel1, BorderLayout.EAST);
		setSize(900, 680);
		setLocationRelativeTo(getOwner());
	}

	public void imprimeFichero(File file){
		textoConsola.setText("");
		textoPrograma.setText("");
		try {
			this.textoPrograma.setText(readFileAsString(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String readFileAsString(File fich) throws java.io.IOException{
		String texto = "";
		try {
		
			FileReader fr = new FileReader(fich);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			int i = 0;
			while (line!=null){
				if (!line.equals("\n")){
					texto = texto + (i + ". " + line+"\n");
					line = br.readLine();
					i++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}
	
	public void setContadorPrograma(String contadorPrograma) {
		this.contadorPrograma.setText("Contador del programa: "+contadorPrograma);
	}

	public void setContadorPila(String contadorPila) {
		this.contadorPila.setText("Contador de la pila: "+ contadorPila);		
	}

	public void setRegistroSwap1(String registroSwap1) {
		this.registroSwap1.setText("Registro Swap1: " + registroSwap1);	
	}

	public void setRegistroSwap2(String registroSwap2) {
		this.registroSwap2.setText("Registro Swap2: " + registroSwap2);
		
	}

	public void setEstado(String string) {
		this.estado.setText("Estado de ejecución: "+string);		
	}
	
	  static private String selectedString(ItemSelectable is) {
		    Object selected[] = is.getSelectedObjects();
		    return ((selected.length == 0) ? "null" : (String)selected[0]);
		  }

	public void setMemoria(Object[] memoria) {
		limpiaFilas(dtm2);
		for (int i=0;i<memoria.length;i++){
			if (memoria[i]!=null){
				String contenido = memoria[i].toString();
				String fila[] = {Integer.toString(i),contenido};
				dtm2.addRow(fila);
			}
			else dtm2.addRow(new String[]{Integer.toString(i),""});
		}
	}

	public void setPila(Object[] pila,int tamPila) {
		limpiaFilas(dtm1);
		for (int i=29;i>=0;i--){
			if (pila[i]!=null && i<=tamPila){
				String fila[] = {pila[i].toString()};
				dtm1.addRow(fila);
			}
			else dtm1.addRow(new String[]{""});
		}		
	}
	
	private void limpiaFilas(DefaultTableModel dtm) {
		int a = dtm.getRowCount()-1;
		for(int i=a;i>=0;i--) dtm.removeRow(i);
	}
	
	public void imprimeIntro(){
		textoConsola.setText(textoConsola.getText()+"\n");
		
	}

	public void imprimeOut(String string) {
		textoConsola.setText(textoConsola.getText()+string);
	}

	public void reinciar() {
		textoConsola.setText("");		
	}
}
