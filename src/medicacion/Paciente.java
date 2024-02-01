/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medicacion;

/**
 *
 * @author jose
 */
public class Paciente {
    private String idPaciente;
    private String nombrePaciente;
    private String apePaciente;
    private int edadPaciente;
    private String observacPaciente;
    
    public Paciente(){
        
    }
/*
    Paciente(String p001, String jose, String suarez_suarez, int i, String pepito_suarez_diabetico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  */  
    public Paciente(String idPac,String nombrePac, String apePac, int edadPac, String observacPac){
        this.idPaciente = idPac;
        this.nombrePaciente = nombrePac;
        this.apePaciente = apePac;
        this.edadPaciente = edadPac;
        this.observacPaciente = observacPac;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApePaciente() {
        return apePaciente;
    }

    public void setApePaciente(String apePaciente) {
        this.apePaciente = apePaciente;
    }

    public int getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(int edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public String getObservacPaciente() {
        return observacPaciente;
    }

    public void setObservacPaciente(String observacPaciente) {
        this.observacPaciente = observacPaciente;
    }

    @Override
    public String toString() {
        return "Paciente{" + "idPaciente=" + idPaciente + ", nombrePaciente=" + nombrePaciente + ", apePaciente=" + apePaciente + ", edadPaciente=" + edadPaciente + ", observacPaciente=" + observacPaciente + '}';
    }
 
    
}
