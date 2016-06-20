/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author andrey
 */
public class ColaStrings {

    private String[] cola;
    private int rear = -1;
    private final int TAM = 10;

    public ColaStrings(int tam) {
        cola = new String[tam];
    }

    public ColaStrings() {
        cola = new String[TAM];
    }

    public int size() {
        return rear + 1;
    }

    public String enqueue(String num) throws ColaException {
        if (rear < cola.length - 1) {
            cola[rear + 1] = num;
            rear++;
        } else {
            throw new ColaException("No se pueden agregar mas elementos a la cola");
        }
        return num;
    }

    public String dequeue() throws ColaException {
        String aux;
        if (isEmpty()) {
            throw new ColaException("No hay elementos en la cola");
        } else {
            aux = cola[0];
            for (int i = 0; i < rear; i++) {
                cola[i] = cola[i + 1];
            }
        }
        rear--;
        return aux;
    }

    public boolean isEmpty() {
        return (rear == -1);
    }

    public String front() {
        return cola[0];
    }

    public String listaDatos() {
        String text = "";
        for (int i = 0; i < cola.length; i++) {
            if (cola[i] != null) {
                text += cola[i] + " ";
            }
        }
        return text;
    }

}
