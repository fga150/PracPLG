package Vista;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;

import Controlador.Controlador;

public class MyKeyListener implements KeyListener{
	
	private Controlador controlador;
	private JTextArea textoConsola;
	
	public MyKeyListener(Controlador controlador, JTextArea textoConsola2) {
		this.controlador = controlador;
		this.textoConsola = textoConsola2;
	}

	public void keyTyped(KeyEvent arg0){
		String temp;
		char c = arg0.getKeyChar();
		if ((c == '\n') && (controlador.isLecturaOn())){
			temp = this.getLastLine();
			controlador.setLecturaOn(false);
			controlador.enviaLectura(temp);
			
		}
	}
	
	private String getLastLine(){
		Document document = textoConsola.getDocument();
		Element rootElem = document.getDefaultRootElement();
		int numLines = rootElem.getElementCount();
		Element lineElem = rootElem.getElement(numLines - 2);
		int lineStart = lineElem.getStartOffset();
		int lineEnd = lineElem.getEndOffset();
		String lineText = "";
		try {
			lineText = document.getText(lineStart, lineEnd - lineStart);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return lineText;
	}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

}
