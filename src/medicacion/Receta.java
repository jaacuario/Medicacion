/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jose
 */
public class Receta {
    private String idReceta;
    private String idQPaciente;
    private Date fechaReceta;
    private List linRecetas;
    
    public Receta(){
        
    }
    
    public Receta(String idRec, String idPac, Date fRec){
        this.idReceta = idRec;
        this.idQPaciente = idPac;
        this.fechaReceta = fRec;
        this.linRecetas = new ArrayList();
    }
    
    public void addLinReceta (LinReceta lr){
        linRecetas.add(lr);
    }
    
    public void setLinReceta (List lr){
        linRecetas = lr;
    }
    
    public List getLinReceta(){
        return linRecetas;
    }
    

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
        this.idReceta = idReceta;
    }

    public String getIdQPaciente() {
        return idQPaciente;
    }

    public void setIdQPaciente(String idQPaciente) {
        this.idQPaciente = idQPaciente;
    }

    public Date getFechaReceta() {
        return fechaReceta;
    }

    public void setFechaReceta(Date fechaReceta) {
        this.fechaReceta = fechaReceta;
    }

    @Override
    public String toString() {
        return "Receta{" + "idReceta=" + idReceta + ", idQPaciente=" + idQPaciente + ", fechaReceta=" + fechaReceta + '}';
    }
    
    
    
    
}
