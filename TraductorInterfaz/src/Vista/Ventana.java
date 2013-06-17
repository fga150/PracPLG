package Vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

import Controlador.Controlador;


public class Ventana extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador controlador;
	private JMenuBar menuBar1;
	private JButton button3;
	private JButton button1;
	private JButton button4;
	private JPanel hSpacer1;
	private JButton button5;
	private JScrollPane scrollPane1;
	private JEditorPane editorPane1;
	private JScrollPane scrollPane2;
	private JEditorPane editorPane2;
	private JScrollPane scrollPane3;
	private JEditorPane editorPane3;
	
	
	public Ventana(Controlador controlador) {
		Dimension d = new Dimension(980,680);
		this.setMinimumSize(d);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		this.setVisible(true);
		this.controlador = controlador;
	}
	
	

	private void initComponents() {
		menuBar1 = new JMenuBar();
		button3 = new JButton();
		button4 = new JButton();
		button1 = new JButton();
		hSpacer1 = new JPanel(null);
		button5 = new JButton();
		scrollPane1 = new JScrollPane();
		editorPane1 = new JEditorPane();
		scrollPane2 = new JScrollPane();
		editorPane2 = new JEditorPane();
		scrollPane3 = new JScrollPane();
		editorPane3 = new JEditorPane();

		//======== this ========
		setTitle("Compilador - Grupo 2");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== menuBar1 ========
		{

			//---- button3 ----
			button3.setText("Cargar");
			menuBar1.add(button3);
			button3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					JFileChooser fc = new JFileChooser();
					
					int returnVal = fc.showOpenDialog(Ventana.this);
					if(returnVal == JFileChooser.APPROVE_OPTION){
						File file = fc.getSelectedFile();
						controlador.enviaRuta(file);
					}
					
				}
								
				
			});
			//---- button1 ----
			button1.setText("Guardar");
			menuBar1.add(button1);
			button1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent actionEvent) {
					
						controlador.guardaFuente(editorPane2.getText());
				}
								
				
			});

			//---- button4 ----
			button4.setText("Compilar");
			menuBar1.add(button4);
			menuBar1.add(hSpacer1);
			button4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
			
					controlador.compila(editorPane2.getText());
				}
				
							
			
		});

			//---- button5 ----
			button5.setText("Ayuda");
			menuBar1.add(button5);
			button5.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent actionEvent) {
				    JOptionPane.showMessageDialog(null, "\n\n- Cargar: Carga el fichero que se va a compilar.\n- Guardar: Guarda el código si se ha modificado." +
				    		"\n- Compilar: Compila el código cargado en el programa.\n\n");
					}	
			});	
		}
		setJMenuBar(menuBar1);

		//======== scrollPane1 ========
		{
			scrollPane1.setPreferredSize(new Dimension(569, 150));
			scrollPane1.setViewportView(editorPane1);
		}
		contentPane.add(scrollPane1, BorderLayout.SOUTH);

		//======== scrollPane2 ========
		{
			scrollPane2.setPreferredSize(new Dimension(450, 22));

			//---- editorPane2 ----
			editorPane2.setPreferredSize(new Dimension(10, 20));
			editorPane2.setMinimumSize(new Dimension(10, 20));
			scrollPane2.setViewportView(editorPane2);
		}
		contentPane.add(scrollPane2, BorderLayout.CENTER);

		//======== scrollPane3 ========
		{
			scrollPane3.setPreferredSize(new Dimension(350, 22));
			scrollPane3.setMinimumSize(new Dimension(200, 22));

			//---- editorPane3 ----
			editorPane3.setPreferredSize(new Dimension(200, 20));
			editorPane3.setMinimumSize(new Dimension(200, 20));
			scrollPane3.setViewportView(editorPane3);
		}
		contentPane.add(scrollPane3, BorderLayout.EAST);
		pack();
		setLocationRelativeTo(getOwner());
	}
	
	public void imprimeFichero(File file){
		editorPane1.setText("");
		editorPane2.setText("");
		editorPane3.setText("");
		try {
			this.editorPane2.setText(readFileAsString(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void imprimeCodigoP(File file){
		editorPane3.setText("");

		try {
			System.out.println(file);
			String texto = readFileAsString(file);
			this.editorPane3.setText(texto);
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
		
			while (line!=null){
				if (!line.equals("\n")){
					texto = texto + (line+"\n");
					line = br.readLine();
		
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}



	public void imprimeConsola(String string) {
		editorPane1.setText(string);
		
	}
	public void imprimeError(String string) {
		editorPane3.setText("");
		editorPane1.setText(string);
		
	}

}
