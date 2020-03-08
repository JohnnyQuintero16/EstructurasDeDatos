/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author madarme
 */
public class Estudiante {

    private long codigo;
    private float notas[];

    public Estudiante() {
    }

    public Estudiante(long codigo) {
        this.codigo = codigo;
    }

    public Estudiante(String datos[]) {
        this.codigo = Long.parseLong(datos[0]);
        this.notas = new float[datos.length - 1];
        for (int i = 1; i < datos.length; i++) {
            this.notas[i - 1] = Float.parseFloat(datos[i]);
        }
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    //metodo calcular promedio
    public float calcularPromedio() {
        float numNotas = notas.length;
        float promedio = 0;

        for (int i = 0; i < notas.length; i++) {
            promedio += notas[i];
        }
        return promedio / numNotas;
    }

    //metodo para contar la cantidad de quices
    public boolean cantQuicesAprobados() {
        int c = 0;
        for (int i = 0; i < notas.length; i++) {
            if (this.notas[i] >= 3.0f && this.notas[i] <= 5.0f && this.notas[i] != 0) {
                c++;
            }
        }
        return c == notas.length;
    }

    public String toString() {
        String msg = "\nCodigo:" + this.codigo + "->";
        for (float dato : this.notas) {
            msg += dato + ",";
        }
        return msg;
    }

}
