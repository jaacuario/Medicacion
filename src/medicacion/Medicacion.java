/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medicacion;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jose
 */
public class Medicacion {

    /**
     * @param args the command line arguments
     */
    
       public static void IniciaBaseDatos(){
        //Borramos el fichero que contendrá los datos para que no se repitan
        //así se inicializa cada vez con los datos originales básicos.
        // Una vez lo inicialicemos, después hay que comentar estas dos líneas inferiores.
        File f = new File(".\\src\\bd\\pacientesmedicamentos.db4o");
        f.delete();
        
        System.out.println("Iniciamos la BaseDatos db4Object");
        ObjectContainer db = Db4oEmbedded.openFile(f.getAbsolutePath());
        
        
        //Creamos los objetos Pacientes con sus valores
        Paciente p1 = new Paciente("P001","JOSE","SUAREZ SUAREZ", 53, "PEPITO SUAREZ, DIABETICO");
        Paciente p2 = new Paciente("P033","JUANA","SMITH SANTANA", 33, "ESPALDA DESTROZADA");
        Paciente p3 = new Paciente("P121","ANSELMO","MARTIN DEL RIO", 18, "DEPORTISTA ");
        Paciente p4 = new Paciente("P004","CATALINA","PARQUE REDONDO", 20, "PROGRAMADOR");
        Paciente p5 = new Paciente("P010","LUISO ","SAAVEDRA PUMPIDO", 73, "ANTIGUO FUTBOLISTA");
        
        //Los guardamos en la base-datos
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        db.store(p5);


        //Creamos los objetos Medicamentos con sus valores
        Medicamento m1 = new Medicamento("M001","TERMALGIN 10 mg",28, "PARA DOLORES SUAVES");
        Medicamento m2 = new Medicamento("M002","NOLOTIL 25 MG",30, "PARA DOLORES FUERTES, BAJA LA TENSIÓN");
        Medicamento m3 = new Medicamento("M003","FRENADOL 100 MG",20, "ALIVIA LA CONGESTION");
        
        
        //Los guardamos en la base-datos
        db.store(m1);
        db.store(m2);
        db.store(m3);
        

        // ahora vamos a mostrarlos, primero los pacientes
        Paciente p = new Paciente();
        ObjectSet<Paciente> result = db.queryByExample(p);
        while (result.hasNext()) {
             System.out.println(result.next());
        }
        
         // ahora vamos a mostrarlos, ahora los medicamentos
        Medicamento m = new Medicamento();
        ObjectSet<Medicamento> result1 = db.queryByExample(m);
        while (result1.hasNext()) {
             System.out.println(result1.next());
        }
 
        //cerramos base-datos
        db.close();
        System.out.println("Cerramos la base-datos");
    } //de public void IniciaBaseDatos
    
 
    
    
       public static void RecorreBaseDatos(int opcionElegida){
        //Conectamos con la base de datos
        System.out.println("recorremos la BaseDatos db4Object, para visualizarla.");
        ObjectContainer db = Db4oEmbedded.openFile(".\\src\\bd\\pacientesmedicamentos.db4o");
        
        
        switch (opcionElegida){
            case 1: Paciente p = new Paciente();
                    ObjectSet<Paciente> resultPac = db.queryByExample(p);  
                    while (resultPac.hasNext()) {
                        System.out.println(resultPac.next());
                    }
                     break;
            case 2: Medicamento m = new Medicamento();
                    ObjectSet<Medicamento> resultMed = db.queryByExample(m);
                    while (resultMed.hasNext()) {
                        System.out.println(resultMed.next());
                    }
                    break;
            case 3: 
                    break;
        }
        
        
        //cerramos base-datos
        db.close();
        System.out.println("Cerramos la base-datos");
        
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        boolean opcionFinalizar = false;
        int opcionElegida;
        
        Scanner entrada = new Scanner(System.in);
    
        while(!opcionFinalizar){
            System.out.println("Está Vd. en BASE DATOS MEDICAMENTOS en Versión 00 (30-01-24)");
            System.out.println("1. Ver los pacientes.");
            System.out.println("2. Ver los medicamentos.");
            System.out.println("3. Ver las recetas.");
            System.out.println("4. Otros.");
            System.out.println("5. Salir.");
        
            System.out.println("Elija su opción.");
            opcionElegida = entrada.nextInt();
            
            switch (opcionElegida){
                case 1: //La comentamos para que no los genere más 
                        //IniciaBaseDatos();
                        RecorreBaseDatos(1);
                        System.out.println("Actuamos sobre Pacientes. ");
                        //int edadTopeJefe = entrada.nextInt();
                        //VerJefesMayores(edadTopeJefe);
                        break;
                case 2: //RecorreBaseDatos();
                        System.out.println("Actuamos sobre Medicamentos.");
                       // int edadCorrecta = entrada.nextInt();
                        //PonerEdadCorrecta(edadCorrecta);
                        RecorreBaseDatos(2);
                        break;
                case 3: 
                        System.out.println("Opción de Recetas.");
                       // int aniosTope = entrada.nextInt();
                        //BorrarJefesAntiguedad(aniosTope);
                        RecorreBaseDatos(3);
                        break;
                case 4: 
                        break;
                case 5: opcionFinalizar = true;
                        System.out.println("Salimos del programa. Gracias.");
                        break;
                default: System.out.println("Opción no válida. Reinténtelo. Gracias.");
                        
            } //del switch
            
        } //del while(!opcionFinalizar)
        
        
        
        
        
        
        
        
        
        
        
    }// del public static void main
    
}
