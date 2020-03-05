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
        Estudiante prome[]=new Estudiante[this.estudiantes.length];
        prome=organizarPromedio();
        msg="Estudiantes Con El Mayor Promedio del Curso\n";
        for (Estudiante dato : prome) {
            if(dato.calcularPromedio()==prome[this.estudiantes.length-1].calcularPromedio()){
                msg+=dato.getCodigo()+"\n";
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
            if (num< 3.0) {
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
   public String cantidadQuices() {
        String msg = "Cantidad De Quices De Cada Estudiante\n";
         float can[]=new float[estudiantes.length];
        for(Estudiante dato:this.estudiantes){
            can=dato.getNotas();
            msg+=can.length+"\n";
        }
        return msg;
    }
   /*
   Metodo:
   4.Mostrar los estudiantes (codigo y nota definitiva) ordenados por la
   nota definitiva que obtuvieron de sus quices (forma descendente)
   */
   public String notaDefinitva(){
       String msg="Nota Definitiva De los Estudiantes\n";
       Estudiante prome[]= new Estudiante[estudiantes.length];
       prome=organizarPromedio();
       int i=prome.length-1;
       for(Estudiante dato:prome){
           msg+=dato.getCodigo()+" "+prome[i].calcularPromedio()+"\n";
           i--;
       }
       return msg;
   }
   
   
   /*
   Metodo:
   5.Mostrar los estudiantes (codgo y notas) que aprobaron todos sus quices
   */
    public String quicesAprobados() {
        String msg = "";
        for (Estudiante dato : this.estudiantes) {
            if (dato.cantQuicesAprobados()) {
                msg += dato.toString() + "" + dato.calcularPromedio() + "\n";
            }
        }
        return msg;
    }

 
    //Metodo para organizar los promedios
    public Estudiante[] organizarPromedio(){
        Estudiante prome[]=estudiantes;
        for (int i = 0; i < estudiantes.length-1; i++) {
            if(estudiantes[i].calcularPromedio()>estudiantes[i+1].calcularPromedio()){
                Estudiante otro = prome[i];
                prome[i]=prome[i+1];
                prome[i+1]=otro;
            }
        }
        return prome;
    }
}
