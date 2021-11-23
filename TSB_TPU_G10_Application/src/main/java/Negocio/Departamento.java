package Negocio;

import java.util.Collection;
import Soporte.*;

public class Departamento {
    private String key;
    private String nombre;
    private int contMasculino;
    private int contFemenino;
    private int contPrimerDosis;
    private int contSegundaDosis;
    private TSBArrayList tipoVacuna;

    public Departamento(String key, String nombre){
        this.key = key;
        this.nombre = nombre;
        contMasculino = 0;
        contFemenino = 0;
        contPrimerDosis = 0;
        contSegundaDosis = 0;
        tipoVacuna = new TSBArrayList();
    }

    public String getKey() {
        return key;
    }

    // Suma 1 al contador del genero correspondiente segun el parametro recibido
    public void sumarGenero(String campo) {
        if (campo.compareTo("\"F\"")==0){
            contFemenino++;}
        else{
            contMasculino++;}
    }

    // Suma 1 al contador de dosis correspondiente segun el parametro recibido
    public void sumarDosis(String campo) {
        if (campo.compareTo("1")==0){
            contPrimerDosis++;}
        else{
            contSegundaDosis++;}
    }

    // Suma 1 al contador de la lista de tipo de vacuna correspondiente segun el parametro recibido
    public void sumarVacuna(String campo) {
        for (int i = 0; i < this.tipoVacuna.size(); i++) {
            Vacuna vac = (Vacuna) tipoVacuna.get(i);
            if (vac.getKey().compareTo(campo)==0){
                vac.setContador( vac.getContador()+1 );
                return;
            }
        }
        Vacuna vac = new Vacuna(campo);
        this.tipoVacuna.add(vac);
    }

    @Override
    public String toString() {
        return " ( " +key+ " ) " + nombre;
    }

    public String getContMasculino() {
        return "Cantidad de Hombres Vacunados: "+ contMasculino;
    }

    public String getContFemenino() {
        return "Cantidad de Mujeres Vacunadas: "+ contFemenino;
    }

    public String getPrimerDosis() {
        return "Cantidad de Primeras Dosis Aplicadas: "+ contPrimerDosis;
    }
    public String getSegundaDosis() {
        return "Cantidad de Segundas Dosis Aplicadas: "+ contSegundaDosis;
    }

    public Collection getVacunas(){
        Collection collection;
        return collection = tipoVacuna;
    }
    public String getNombre() {
        return nombre;
    }
}