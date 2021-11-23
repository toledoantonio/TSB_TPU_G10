package Soporte;

import Negocio.Departamento;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Archivo {
    private File file;

    public Archivo(String path) {
        this.file = new File(path);
    }

    // Cuenta
    public TSBHashTableDA contarVacunados(){

        TSBHashTableDA hash = new TSBHashTableDA(11,0);

        // Vector para Campos de cada vacunacion
        String campos[];

        // Lectura del Archivo
        try {
            Scanner scanner = new Scanner(file);
            Departamento deptoTodos = new Departamento("0","Todos los Departamentos");

            // Introducir en la Tabla
            hash.put("01", deptoTodos);
            while (scanner.hasNext()){
                campos = scanner.nextLine().split(",");
                // Verifica si el campo jurisdiccion_aplicacion_id es 14 (Córdoba)
                if (campos[7].compareTo("\"14\"") == 0){
                    // Verifica que el campo departamento no existe en la tabla y lo crea
                    if (hash.get(campos[9])==null){
                        Departamento depto = new Departamento(campos[9],campos[8]);
                        hash.put(depto.getKey(), depto);
                        // Aumenta los contadores del departamento correspondiente y los contadores de TODOS
                        depto.sumarGenero(campos[0]);
                        depto.sumarDosis(campos[13]);
                        depto.sumarVacuna(campos[11]);
                        deptoTodos.sumarGenero(campos[0]);
                        deptoTodos.sumarDosis(campos[13]);
                        deptoTodos.sumarVacuna(campos[11]);
                    }
                    // Rama else si el departamento ya existe en la tabla
                    else {
                        Departamento depto = (Departamento) hash.get(campos[9]);
                        // Aumenta los contadores del departamento correspondiente y los contadores de TODOS
                        depto.sumarGenero(campos[0]);
                        depto.sumarDosis(campos[13]);
                        depto.sumarVacuna(campos[11]);
                        deptoTodos.sumarGenero(campos[0]);
                        deptoTodos.sumarDosis(campos[13]);
                        deptoTodos.sumarVacuna(campos[11]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el Archivo " + file);
        }
        return hash;
    }
}
