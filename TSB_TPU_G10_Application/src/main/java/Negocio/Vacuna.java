package Negocio;

// Clase para usar de contador en el ArrayList de vacunas en Departamento
public class Vacuna {
    private String key;
    private int contador;

    public Vacuna(String key){
        this.key = key;
        this.contador = 1;
    }

    public String getKey() {
        return key;
    }

    public int getContador() {return contador;}

    public void setContador(int cont) {
        this.contador = cont;
    }

    @Override
    public String toString() {
        return "Vacuna: "+key+", Cantidad de Dosis Aplicadas: "+ contador;
    }
}