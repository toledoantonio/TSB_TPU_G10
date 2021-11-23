package Negocio;

import Soporte.*;
import java.util.Collection;

public class Departamentos {
    private TSBHashTableDA tablaDepartamentos;

    public Departamentos() {
        this.tablaDepartamentos = new TSBHashTableDA(11,0);
    }

    // Llama al metodo contarVacunas() en el que se contaran por parametros la cantidad de vacunaciones
    public String contarVacunaciones(String path){
        Archivo file = new Archivo(path);
        tablaDepartamentos = file.contarVacunados();
        return tablaDepartamentos.toString();
    }

    // Retorna los departamentos
    public Collection getDeptos(){
        Collection todos = tablaDepartamentos.values();
        todos.remove(tablaDepartamentos.get(01));
        System.out.println(tablaDepartamentos.get("01"));
        return todos;
    }
    public Departamento getDepto(){
        return (Departamento) tablaDepartamentos.get("01");
    }
}