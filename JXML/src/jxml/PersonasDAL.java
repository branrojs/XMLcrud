package jxml;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.InputSource;
public class PersonasDAL {
    //obtiene valor del nodo
    private static String obtenerNodoValor(String strtag, Element ePersona){
        Node nValor;
        nValor = (Node)ePersona.getElementsByTagName(strtag).item(0).getFirstChild();
        return nValor.getNodeValue();
        
    }
    
    //obtiene los nodos y lo manda al anterior a verificar
    public ArrayList<Personas> obtenerPersonas(){
        ArrayList<Personas> listaPersonas = new ArrayList<Personas>();
        try{
        //Validacion y lectura del disco para abrir xml
       DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
       Document doc = docBuilder.parse(new File("xnlsrc/basededatos.xml"));
       //prepara el archivo y los datos
       doc.getDocumentElement().normalize();
       //obtiene nodos con etiquetas
       NodeList nodosPersonas = doc.getElementsByTagName("personas");
       //por cada nodo que se obtuvo se obtendran los datos y se guardaran en un objeto tipo personas
        for (int i = 0; i< nodosPersonas.getLength(); i++) {
            Node persona = nodosPersonas.item(i);
            if (persona.getNodeType() == Node.ELEMENT_NODE) {
                Element unElemento = (Element) persona;
                //se crea un objeto personas y se le da un valor a las variables de esa clase
                //se obtiene el valor de la clase obtener NodoValor con el tag y el elemento.
                Personas objPersona=new Personas();
                objPersona.setNombre(obtenerNodoValor("nombre", unElemento));
                objPersona.setApellidos(obtenerNodoValor("apellidos", unElemento));
                objPersona.setEmail(obtenerNodoValor("email", unElemento));
                objPersona.setDireccion(obtenerNodoValor("direccion", unElemento));
                objPersona.setTelefono(Integer.parseInt(obtenerNodoValor("telefono", unElemento)));
                
                listaPersonas.add(objPersona);
            }
            
        }
       
       }catch(ParserConfigurationException parseE){
           
       }catch (SAXException saxE){
            System.out.println(saxE.getMessage());
        }catch(IOException ioE){
            System.out.println(ioE.getMessage());
        }
        return listaPersonas;
    }
    //metodo para agregar personas al XML
    public void agregar(Personas person){
        try{
        DocumentBuilderFactory docFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new File("xnlsrc/basededatos.xml"));
        
        //prepara el archivo xml par aobtener datos
        doc.getDocumentElement().normalize();
        //obtenemos el nodo padre "basededatos"
        Node nodoRaiz=doc.getDocumentElement();
        //agregamos una nueva etiqueta al documento
        //primero creamos la etiqueta
        Element nuevaPersona=doc.createElement("personas");
        
        //creamos sus etiquetas hijas(noombre,apellidos,etc)
        Element nuevoNombre=doc.createElement("nombre");
        nuevoNombre.setTextContent(person.getNombre()); //se agrega contenido con estas lineas//
        
        Element nuevoApellidos=doc.createElement("apellidos");
        nuevoApellidos.setTextContent(person.getApellidos());
        
        Element nuevoEmail=doc.createElement("email");
        nuevoEmail.setTextContent(person.getEmail());
        
        Element nuevoDireccion=doc.createElement("direccion");
        nuevoDireccion.setTextContent(person.getDireccion());
        
        Element nuevoTelefono=doc.createElement("telefono");
        nuevoTelefono.setTextContent(""+person.getTelefono());
        //insertamos en nodo hijo (persona)
        nuevaPersona.appendChild(nuevoNombre);
        nuevaPersona.appendChild(nuevoApellidos);
        nuevaPersona.appendChild(nuevoEmail);
        nuevaPersona.appendChild(nuevoDireccion);
        nuevaPersona.appendChild(nuevoTelefono);
       //insertamos en el nodo razi (basededatos)
        nodoRaiz.appendChild(nuevaPersona);
        //lo transformamos a xml
        TransformerFactory transf=TransformerFactory.newInstance();
        Transformer trans = transf.newTransformer();
        DOMSource sour=new DOMSource(doc);
        StreamResult res=new StreamResult(new File("xnlsrc/basededatos.xml"));
        trans.transform(sour, res);
                
        
        
        }
        catch(ParserConfigurationException parseE){
            System.out.println(parseE.getMessage());
        }catch (SAXException saxE){
            System.out.println(saxE.getMessage());
        }catch(IOException ioE){
            System.out.println(ioE.getMessage());
        }catch(TransformerConfigurationException transar){
            System.out.println(transar.getMessage());
        }catch(TransformerException traser){
            System.out.println(traser.getMessage());
        }
    }
    
    public void deletePerson() {
        try{
            
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            File file = new File("xnlsrc/basededatos.xml");
            System.out.print("Nombre de la persona que desea eliminar: ");
            String remElement = bf.readLine();
            if (file.exists()){
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("xnlsrc/basededatos.xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer tFormer = tFactory.newTransformer();
            //lista de nodos
            NodeList nodosPersonas = doc.getElementsByTagName("personas");
            //por cada nodo que se obtuvo se obtendran los datos y se guardaran en un objeto tipo personas
            for (int i = 0; i< nodosPersonas.getLength(); i++) {
                Node persona = nodosPersonas.item(i);
                Node personasa = nodosPersonas.item(i);
                if (persona.getNodeType() == Node.ELEMENT_NODE) {
                    Element unElemento = (Element) persona;
                    String value = obtenerNodoValor("nombre", unElemento);
                    if (value.equals(remElement)) {
                        personasa.getParentNode().removeChild(persona);
                    }
                
            }
            
        }
            
            
            /*NodeList items = doc.getElementsByTagName("personas");
                for (int ix = 0; ix < items.getLength() ; ix++) {
                    Element element =(Element) items.item(ix);
                    if (element.getTextContent().equals(remElement)) {
                        /*element.getParentNode().removeChild(element); 
                    }
                }
                
                   //  Remueve el nodo,
                    element.getParentNode().removeChild(element);
                
                    */
            //  Normalize the DOM tree to combine all adjacent nodes
              doc.normalize();
              Result dest = new StreamResult(new File("xnlsrc/basededatos.xml"));
              Source source = new DOMSource(doc);
              tFormer.transform(source, dest);
              }
              else{
              System.out.println("File not found!");
              }
        
        
            
        }
        catch(ParserConfigurationException parseE){
            System.out.println(parseE.getMessage());
        }catch (SAXException saxE){
            System.out.println(saxE.getMessage());
        }catch(IOException ioE){
            System.out.println(ioE.getMessage());
        }catch(TransformerConfigurationException transar){
            System.out.println(transar.getMessage());
        }catch(TransformerException traser){
            System.out.println(traser.getMessage());
        } 
  }

    public void editarPersona(String tag, String oldtext, String newtext){
        try{
            
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            File file = new File("xnlsrc/basededatos.xml");
            if (file.exists()){
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("xnlsrc/basededatos.xml");
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer tFormer = tFactory.newTransformer();
            //lista de nodos 
            //Cambiar replace
            NodeList items = doc.getElementsByTagName(tag);
                for (int ix = 0; ix < items.getLength() ; ix++) {
                    Element element =(Element) items.item(ix);
                    if (element.getTextContent().equals(oldtext)) {
                        element.setTextContent(newtext);
                        
                    }else{
                        System.out.println("Datos no se encuentran");
                    }
                } 
            
            //  Normalize the DOM tree to combine all adjacent nodes
              doc.normalize();
              Result dest = new StreamResult(new File("xnlsrc/basededatos.xml"));
              Source source = new DOMSource(doc);
              tFormer.transform(source, dest);
              }
              else{
              System.out.println("File not found!");
              }
        
        
            
        }
        catch(ParserConfigurationException parseE){
            System.out.println(parseE.getMessage());
        }catch (SAXException saxE){
            System.out.println(saxE.getMessage());
        }catch(IOException ioE){
            System.out.println(ioE.getMessage());
        }catch(TransformerConfigurationException transar){
            System.out.println(transar.getMessage());
        }catch(TransformerException traser){
            System.out.println(traser.getMessage());
        } 
    }
}
