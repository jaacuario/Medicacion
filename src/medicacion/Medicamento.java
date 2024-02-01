/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicacion;

/**
 *
 * @author jose
 */
public class Medicamento {
    private String idMedicamento;
    private String nombreMedicamento;
    private int cantidadUnidades;
    private String observacMedicamento;
    
    public Medicamento(){
        
    }
    
    public Medicamento(String idMedic, String nombreMedic, int cantidadUni, String observacMedic){
        this.idMedicamento = idMedic;
        this.nombreMedicamento = nombreMedic;
        this.cantidadUnidades = cantidadUni;
        this.observacMedicamento = observacMedic;
    }

    public String getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(String idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getObservacMedicamento() {
        return observacMedicamento;
    }

    public void setObservacMedicamento(String observacMedicamento) {
        this.observacMedicamento = observacMedicamento;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "idMedicamento=" + idMedicamento + ", nombreMedicamento=" + nombreMedicamento + ", cantidadUnidades=" + cantidadUnidades + ", observacMedicamento=" + observacMedicamento + '}';
    }
    
    
    
    
}
