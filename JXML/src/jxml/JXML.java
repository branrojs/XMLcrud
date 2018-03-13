package jxml;
import java.io.IOException;
import jxml.Personas;
import jxml.PersonasDAL;
import java.util.ArrayList;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class JXML {
    
    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
        while (true) {
            
            System.out.println("Menu\nOpciones:\n1)Mostrar personas \n2)Agregar personas \n3)Eliminar personas \n4)Editar Personas \n5)Salir");
            Scanner sc=new Scanner(System.in);
            int i;
            
            i = sc.nextInt();
            
            switch (i) {
                case 1:
                    
                    mostrar();
                    break;
                case 2:
                    
                    agregar();
                    break;
                case 3:
                    
                    eliminar();
                    break;
                case 4:
                    
                    editar();
                    break;
                case 5:
                    
                    System.exit(0);
                    break;
            }
            
        }
        
    }
    
    public static void mostrar(){
        System.out.println("Mostrando toda la informacion en el XML");
        PersonasDAL pdl=new PersonasDAL();
        ArrayList<Personas> listaPersonas=pdl.obtenerPersonas();
        
        for (int i = 0; i <listaPersonas.size(); i++) {
            System.out.println("Nombre: "+listaPersonas.get(i).getNombre());
            System.out.println("Apellidos: "+listaPersonas.get(i).getApellidos());
            System.out.println("Email: "+listaPersonas.get(i).getEmail());
            System.out.println("Direccion: "+listaPersonas.get(i).getDireccion());
            System.out.println("Telefono: "+listaPersonas.get(i).getTelefono());
            System.out.println("\n");
        }
    
    }
    
    public static void agregar(){
        Personas per=new Personas();
        PersonasDAL pdls = new PersonasDAL();
        Scanner s = new Scanner(System.in);
        
        String nombre,apellidos,direccion,telf,email;
        
        System.out.println("\nAgregar n nuevo contacto\n");
        System.out.println("Ingrese el nombre: ");
        nombre=s.next();
        System.out.println("Ingrese el apellidos: ");
        apellidos=s.next();
        System.out.println("Ingrese el direccion: ");
        direccion=s.next();
        System.out.println("Ingrese el telefono: ");
        telf=s.next();
        System.out.println("Ingrese el email: ");
        email=s.next();
        
        per.setNombre(nombre);
        per.setApellidos(apellidos);
        per.setDireccion(direccion);
        per.setTelefono(Integer.parseInt(telf));
        per.setEmail(email);
        
        pdls.agregar(per);
        
    }
    
    public static void eliminar() {
        /*String par1,par2;
        Scanner sc = new Scanner(System.in);
        PersonasDAL pdlss = new PersonasDAL();
         System.out.println("Que desea eliminar?");
         System.out.println("1)Nombre,\n2)apellidos");
         int opc = sc.nextInt();
         
         switch (opc) {
            case 1:
                par1 = "nombre";
                par2=sc.next();
                pdlss.deletePerson(par1,par2);
                break;
            
        }*/
        PersonasDAL sd =new PersonasDAL();
        sd.deletePerson();
         
         
    }
    
    public static void editar(){
        Scanner sc=new Scanner(System.in);
        PersonasDAL sd =new PersonasDAL();
        System.out.println("Que desea cambiar\n 1)Nombre\n2)Apellidos\n3)Email\n4)Direccion\n5)Telefono)");
                    int camb = sc.nextInt();
                    String tag,oldtext,newtext;
                    switch (camb) {
                        case 1:
                            tag="nombre";
                            System.out.print("Nombre de la persona que desea cambiar: ");
                            oldtext=sc.next();
                            System.out.println("Ingrese el nuevo nombre: ");
                            newtext=sc.next();
                            sd.editarPersona(tag, oldtext, newtext);
                            break;
                        case 2: 
                            tag="apellidos";
                            System.out.print("Apellidos de la persona que desea cambiar: ");
                            oldtext=sc.next();
                            System.out.println("Ingrese el nuevo apellidos: ");
                            newtext=sc.next();
                            sd.editarPersona(tag, oldtext, newtext);
                            break;
                        case 3: 
                            tag="email";
                            System.out.print("email de la persona que desea cambiar: ");
                            oldtext=sc.next();
                            System.out.println("Ingrese el nuevo email: ");
                            newtext=sc.next();
                            sd.editarPersona(tag, oldtext, newtext);
                            break;
                        case 4: 
                            tag="direccion";
                            System.out.print("direccionde la persona que desea cambiar: ");
                            oldtext=sc.next();
                            System.out.println("Ingrese el nuevo direccion: ");
                            newtext=sc.next();
                            sd.editarPersona(tag, oldtext, newtext);
                            break;
                        case 5: 
                            tag="telefono";
                            System.out.print("telefono de la persona que desea cambiar: ");
                            oldtext=sc.next();
                            System.out.println("Ingrese el nuevo telefono: ");
                            newtext=sc.next();
                            sd.editarPersona(tag, oldtext, newtext);
                            break;
                        
                    }
    }
    
}
