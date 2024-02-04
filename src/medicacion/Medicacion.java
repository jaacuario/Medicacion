/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medicacion;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
 
       
        public static void IniciaRecetasBaseDatos(){
        
       
        System.out.println("recorremos la BaseDatos db4Object, para visualizarla.");
        ObjectContainer db = Db4oEmbedded.openFile(".\\src\\bd\\pacientesmedicamentos.db4o");
                
        DateFormat formatoSencillo = new SimpleDateFormat("dd/MM/yyyy");
        
           try {
               Date fecha1 = formatoSencillo.parse("02/02/2024");
                 Receta r1 = new Receta("R001","P001",fecha1);
        
                LinReceta lr1 = new LinReceta("R001",1,"M001",2,fecha1, null,"r1-Observac sin nada");
                LinReceta lr2 = new LinReceta("R001",2,"M003",1,fecha1, fecha1,"r1-xxx");
        
                r1.addLinReceta(lr1);
                r1.addLinReceta(lr2);
                 
                Date fecha2 = formatoSencillo.parse("05/01/2024");
                Receta r2 = new Receta("R021","P121",fecha2);
                
                LinReceta lr3 = new LinReceta("R021",1,"M002",4,formatoSencillo.parse("10/01/2024"), formatoSencillo.parse("20/01/2024"),"r2-nada");
                LinReceta lr4 = new LinReceta("R021",2,"M003",3,formatoSencillo.parse("05/01/2024"), null,"r2-xxx");
                LinReceta lr5 = new LinReceta("R021",3,"M003",2,formatoSencillo.parse("02/02/2024"), null,"");
                
                r2.addLinReceta(lr3);
                r2.addLinReceta(lr4);
                r2.addLinReceta(lr5);
        
                Date fecha3 = formatoSencillo.parse("20/01/2024");  
                Receta r3 = new Receta("R010","P010",fecha3);
                
                LinReceta lr6 = new LinReceta("R010",1,"M003",3,formatoSencillo.parse("28/01/2024"), formatoSencillo.parse("02/02/2024"),"r3-yyy");
                
                r3.addLinReceta(lr6);
        
        //Los guardamos en la base-datos
                db.store(r1);
                db.store(r2);
                db.store(r3);
          
           } catch (ParseException ex) {
               Logger.getLogger(Medicacion.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        // ahora vamos a mostrarlos, primero las recetas 
        Receta r = new Receta();
        ObjectSet<Receta> result3= db.queryByExample(r);
        while (result3.hasNext()) {
             System.out.println(result3.next());
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
            case 0: LinReceta lr = new LinReceta();
                    ObjectSet<LinReceta> resultLinRec = db.queryByExample(lr);  
                    while (resultLinRec.hasNext()) {
                        System.out.println(resultLinRec.next());
                    }
                    break;
                    
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
            case 3:  Receta r = new Receta();
                    ObjectSet<Receta> resultRec = db.queryByExample(r);
                    while (resultRec.hasNext()) {
                        System.out.println(resultRec.next());
                    }
                    break;
            case 4:  Receta r2 = new Receta();
                    ObjectSet<Receta> resultRec2 = db.queryByExample(r2);
                    System.out.println("ResultRec2 INICIAL, con todo"+resultRec2);
                    System.out.println("");
                   // while (resultRec2.hasNext()) {
                       // System.out.println("ResultRec2 dentro del while.... "+resultRec2);
                        System.out.println("");
                        //Imprimimos la cabecera de la receta
                        //System.out.println("ResultRec2 de recetas, TODAS: "+resultRec2.toString());
                       // System.out.println("ResultRec2 de recetas, TODAS: "+resultRec2.next());
                       // System.out.println("ResultRec2 de recetas, TODAS: "+resultRec2);
                        
                        //String queIdRecetaTiene = resultRec2.next().getIdReceta();
                        int cuantos = resultRec2.size();
                        System.out.println("Las recetas son en total: "+cuantos);
                        for(int i = 0; i < cuantos; i++){
                            Receta queRecetaCoge = resultRec2.get(i);
                            System.out.println("La receta ACTUAL: "+queRecetaCoge.toString());
                            String queIdTieneLaReceta = queRecetaCoge.getIdReceta();
                            System.out.println("El identifik de recetita: "+queIdTieneLaReceta);
                            
                        
                            Query q = db.query();
                            q.constrain(LinReceta.class);
                            //Constraint constrain = q.descend("idQReceta").constrain(queReceta).equal();
                            //q.descend("idQReceta").constrain(queReceta).equal();
                            q.descend("idQReceta").constrain(queIdTieneLaReceta).equal();
                            ObjectSet resultfinal = q.execute();
                            System.out.println("Justo tras el q.execute... y antes del while");
                            
                            
                             while(resultfinal.hasNext()){
                                System.out.println(resultfinal.next());
                                System.out.println("xxxx--Otra línea--xxxxx");
                               // System.out.println(resultfinal.toString());
                            } //del while (resultfinal.hasNext(), que es el de LineaRecetas
                        
                            System.out.println("Otra receta de aquí para abajo...");
                            
                        } // del for()
                        
                    //   resultRec2.next();
                        
                  //  } //del while (resultRec2.Next(), que es el de las Recetas
                
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
            System.out.println("Está Vd. en BASE DATOS MEDICAMENTOS en Versión 01 (02-02-2024)");
            System.out.println("0. Ver  solo las líneas-de-recetas.");
            System.out.println("1. Ver los pacientes.");
            System.out.println("2. Ver los medicamentos.");
            System.out.println("3. Ver las recetas, solo Recetas.");
            System.out.println("4. Ver Recetas con Línea-de-Recetas.");
            System.out.println("5. Salir.");
        
            System.out.println("Elija su opción.");
            opcionElegida = entrada.nextInt();
            
            switch (opcionElegida){
                case 0: RecorreBaseDatos(0);
                       System.out.println("Actuamos sobre Linea-de-Recetas. ");          
                       break;
                case 1: //Presenta pacientes
                        RecorreBaseDatos(1);
                        System.out.println("Actuamos sobre Pacientes. ");
                        break;
                case 2: //Pressenta medicamentos
                        System.out.println("Actuamos sobre Medicamentos.");
                       // int edadCorrecta = entrada.nextInt();
                        //PonerEdadCorrecta(edadCorrecta);
                        RecorreBaseDatos(2);
                        break;
                case 3: //Presenta Recetas
                        System.out.println("Opción de Recetas, solo Recetas.");
                        RecorreBaseDatos(3);
                        break;
                case 4: //Aqui cargamos (lo usamos una vez) 
                        // IniciaRecetasBaseDatos();
                        System.out.println("Opción de Recetas, con Linea-de-Recetas.");
                        RecorreBaseDatos(4);
                        break;
                case 5: opcionFinalizar = true;
                        System.out.println("Salimos del programa. Gracias.");
                        break;
                default: System.out.println("Opción no válida. Reinténtelo. Gracias.");
                        
            } //del switch
            
        } //del while(!opcionFinalizar)
        
        
        
        
        
        
        
        
        
        
        
    }// del public static void main
    
}
