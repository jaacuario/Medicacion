/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicacion;

import java.util.Date;

/**
 *
 * @author jose
 */
public class LinReceta {
    private String idQReceta;
    private int numLineaR;
    private String idQMedicamento;
    private int cantidadATomar;
    private Date fechaInicio;
    private Date fechaFin;
    private String ObservacLinRecetas;
    
    public LinReceta(){
        
    }
    
    public LinReceta(String idqRec,int nlin,String idqMed,int numtomas,Date finic,Date ffin, String Observ){
        this.idQReceta = idqRec;
        this.numLineaR = nlin;
        this.idQMedicamento = idqMed;
        this.cantidadATomar = numtomas;
        this.fechaInicio = finic;
        this.fechaFin = ffin;
        this.ObservacLinRecetas = Observ;
    }

    public String getIdQReceta() {
        return idQReceta;
    }

    public void setIdQReceta(String idQReceta) {
        this.idQReceta = idQReceta;
    }

    public int getNumLineaR() {
        return numLineaR;
    }

    public void setNumLineaR(int numLineaR) {
        this.numLineaR = numLineaR;
    }

    public String getIdQMedicamento() {
        return idQMedicamento;
    }

    public void setIdQMedicamento(String idQMedicamento) {
        this.idQMedicamento = idQMedicamento;
    }

    public int getCantidadATomar() {
        return cantidadATomar;
    }

    public void setCantidadATomar(int cantidadATomar) {
        this.cantidadATomar = cantidadATomar;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservacLinRecetas() {
        return ObservacLinRecetas;
    }

    public void setObservacLinRecetas(String ObservacLinRecetas) {
        this.ObservacLinRecetas = ObservacLinRecetas;
    }

    @Override
    public String toString() {
        return "LinReceta{" + "idQReceta=" + idQReceta + ", numLineaR=" + numLineaR + ", idQMedicamento=" + idQMedicamento + ", cantidadATomar=" + cantidadATomar + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", ObservacLinRecetas=" + ObservacLinRecetas + '}';
    }
    
    
    
    
    
}
