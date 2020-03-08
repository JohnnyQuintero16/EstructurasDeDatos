/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Estudiante;

/**
 *
 * @author madarme
 */
public class SistemaNotas {

    private Estudiante estudiantes[];

    public SistemaNotas() {
    }

    public void cargarNotas(String info) {
        String m[] = info.split("\n");
        this.estudiantes = new Estudiante[m.length];
        for (int i = 0; i < m.length; i++) {
            String datosEstudiante[] = m[i].split(";");
            this.estudiantes[i] = new Estudiante(datosEstudiante);
        }

    }

    public String listarEstudiantes() {
        String msg = "";
        for (Estudiante dato : this.estudiantes) {
            msg += dato.toString();

        }

        return msg;
    }

    /*
    Metodo:
    1.Mostrar los codigos de los estudiantes que obtuvieron
    mayor promedio en el curso.
    */
    public String promedio() {
        String msg;
        Estudiante prome[] = new Estudiante[this.estudiantes.length];
        prome = organizarPromedio();
        msg = "Estudiantes Con El Mayor Promedio del Curso\n";
        for (Estudiante dato : prome) {
            if (dato.calcularPromedio() == prome[this.estudiantes.length - 1].calcularPromedio()) {
                msg += dato.getCodigo() + "\n";
            }
        }
        return msg;
    }

    /*
    Metodo:
    2.Mostrar los codigos de los estudiantes que reprobaron su tercer parcial.
    */
    public String reprobaron() {
        String msg = "Estudiantes Que Reprobaron Su Tercer Parcial\n";
        for (Estudiante dato : this.estudiantes) {
            float num = dato.calcularPromedio();
            if (num < 3.0) {
                msg += dato.getCodigo() + "\n";
            }
        }
        return msg;
    }

    /*
    Metodo:
    3.Mostrar los estudiantes (codigo y notas) ordenados por la 
    cantidad de quices que presento (forma ascendente)
    */
    public String mostrarCantQuices() {

        String msg = "Cantidad De Quices Por Cada Estudiante\n";
        Estudiante quices[] = organizarQuices();
        for (Estudiante quice : quices) {
            msg += quice.getCodigo() + " ---> ";
            for (int j = 0; j < quice.getNotas().length; j++) {
                msg += quice.getNotas()[j] + "; ";
            }
            msg += "\n";
        }
        return msg;
    }

    /*
   Metodo:
   4.Mostrar los estudiantes (codigo y nota definitiva) ordenados por la
   nota definitiva que obtuvieron de sus quices (forma descendente)
    */
    public String notaDefinitva() {
        String msg = "Nota Definitiva De los Estudiantes \n";
        Estudiante promedios[] = organizarPromedio();
        for (int i = promedios.length-1; i>=0; i--) {
             msg += promedios[i].getCodigo() + " --> " + promedios[i].calcularPromedio() + "\n";
        }
           
        return msg;
    }

    /*
   Metodo:
   5.Mostrar los estudiantes (codgo y notas) que aprobaron todos sus quices
    */
    public String quicesAprobados() {
        String msg = "Estudiante Que Aprobaron Todos Los Quices\n";
        for (Estudiante dato : this.estudiantes) {
            if (dato.cantQuicesAprobados()) {
                msg += dato.toString() + "-->" + dato.calcularPromedio();
            }
            msg+="\n";
        }
        return msg;
    }

    //Metodo para organizar los promedios
    public Estudiante[] organizarPromedio() {
        Estudiante prome[] = estudiantes;
        for (Estudiante estudiante : estudiantes) {
            for (int j = 0; j < estudiantes.length - 1; j++) {
                if (estudiantes[j].calcularPromedio() > estudiantes[j + 1].calcularPromedio()) {
                    Estudiante otro = prome[j];
                    prome[j] = prome[j + 1];
                    prome[j + 1] = otro;
                }
            }
        }
        return prome;
    }

    //Metodo para organizar los quices
    public Estudiante[] organizarQuices() {
        Estudiante quices[] = this.estudiantes;
        for (Estudiante estudiante : estudiantes) {
            for (int j = 0; j < estudiantes.length - 1; j++) {
                if (estudiantes[j].getNotas().length > estudiantes[j + 1].getNotas().length) {
                    Estudiante otro = quices[j];
                    quices[j] = quices[j + 1];
                    quices[j + 1] = otro;
                }
            }
        }
        return quices;
    }
}
