package pkg;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.BrokenBarrierException;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLproba0 {
	private XMLStreamWriter xsw = null;
	private XMLOutputFactory xof = XMLOutputFactory.newInstance();
	public String fich = "C:\\Users\\David\\Desktop\\autores.xml";

	private String autor1[] = { "a1", "Alexandre Dumas", "El conde de Montecristo", "Los miserables" };
	private String autor2[] = { "a2", "Fiodor Dostoyevski", "El idiota", "Noches blancas" };

	public void crearXML() throws XMLStreamException, IOException {
		xsw = xof.createXMLStreamWriter(new FileWriter(fich));
		xsw.writeStartDocument("1.0");
		xsw.writeStartElement("autores"); //Inicio etiqueta raíz. 
		
		crearAutor(autor1);
		crearAutor(autor2);
		
		xsw.writeEndElement(); //Fin tiqueta raíz. 
		xsw.close(); //Cerramos el Streaming al fichero. 
	}

	private void crearAutor(String [] s) throws XMLStreamException{ //Método de creación de bloques autor. 
		xsw.writeStartElement("autor");
		xsw.writeAttribute("codigo", s[0]); 
		
		xsw.writeStartElement("nome");
		xsw.writeCharacters(s[1]);
		xsw.writeEndElement();
		
		xsw.writeStartElement("titulo");
		xsw.writeCharacters(s[2]);
		xsw.writeEndElement();
		
		xsw.writeStartElement("titulo");
		xsw.writeCharacters(s[3]);
		xsw.writeEndElement();
		
		xsw.writeEndElement();
		
	}

	public static void main(String[] s) {
		XMLproba0 obj = new XMLproba0 ();
		try {
			obj.crearXML();
			
			Desktop d = Desktop.getDesktop();	
			d.open(new File(obj.fich));
			
			} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
		}
	}

}
