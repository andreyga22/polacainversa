/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Balanceo.ExcepcionBalanceo;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class StackDouble extends ArrayList {

    int puntero = -1;
    ArrayList<Double> array;

    public StackDouble() {
        this.array = new ArrayList<>();
    }

    @Override
    public int size() {
        return puntero + 1;
    }

    @Override
    public boolean isEmpty() {
        return (puntero == -1);
    }

    public double top() throws ExcepcionBalanceo {
        if (isEmpty()) {
            throw new ExcepcionBalanceo(" pila vacia");
        }
        return array.get(puntero);
    }
    
    public double push(double o) throws ExcepcionBalanceo {
        puntero++;
        array.add(puntero, o);

        return array.get(puntero);
    }

    public void revers() {
        int aux = puntero;
        while (aux >= 0) {
            System.out.println(array.get(aux));
            aux--;
        }
    }

    public double pop() throws ExcepcionBalanceo {
        if (isEmpty()) {
            throw new ExcepcionBalanceo(" pila vacia");
        }
        puntero--;
        return array.get(puntero + 1);
    }

//    public int saberPrioridadTope(int prioridad) {
//        try {
//            char tope = top();
//            switch (tope) {
//                case '(':
//                    return 0;
//                case '[':
//                    return 0;
//                case '{':
//                    return 0;
//                case ')':
//                    return 0;
//                case ']':
//                    return 0;
//                case '}':
//                    return 0;
//                case '+':
//                    return 1;
//                case '-':
//                    return 1;
//                case '*':
//                    return 2;
//                case '/':
//                    return 2;
//                case '^':
//                    return 3;
//            }
//        } catch (ExcepcionBalanceo ex) {
//            return -1;
//        }
//        return -1;
//    }

}
