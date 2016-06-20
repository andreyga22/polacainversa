/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import Balanceo.Balanceo;
import Balanceo.ExcepcionBalanceo;
import Datos.ArrayStack;
import Datos.ColaException;
import Datos.ColaStrings;
import Datos.Datos;
import Datos.StackDouble;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Procesos {

    private ColaStrings cola;
    private Datos datos = new Datos();
    private ColaStrings colaFinal;
    private int textSize;
    private ArrayStack pila = new ArrayStack();
    private StackDouble pilaDouble = new StackDouble();

    public Procesos() {
    }

    private ColaStrings crearColaFormulaOriginal(String text) throws ColaException {
        textSize = text.length();
        for (int i = 0; i < textSize; i++) {
            cola.enqueue(text.charAt(i) + "");
        }
        return cola;
    }

    private void hacerColaFinal() throws ColaException, ExcepcionBalanceo {
        while (cola.size() != 0) {
            String longNum = "";
            boolean cambio = false;
            Character aux = cola.dequeue().charAt(0);
            while (Character.isDigit(aux) && cola.size() > 0) {
                longNum += aux;
                if (cola.size() > 0) {
                    aux = cola.dequeue().charAt(0);
                }
                cambio = true;

            }
            if (cambio) {
                colaFinal.enqueue(longNum);
            } else if (Character.isDigit(aux) && cola.size() > 0) {
                aux = cola.dequeue().charAt(0);
            }
            acomodarLetra(aux);
        }
    }

    private void acomodarLetra(Character letra) throws ExcepcionBalanceo, ColaException {
        int indiceOp = datos.buscarOperador(letra);
        if (indiceOp != -1) {
            int prioridadTope = pila.saberPrioridadTope(indiceOp);
            if (prioridadTope >= indiceOp) {
                while (prioridadTope >= indiceOp) {
                    Character aux = pila.pop();
                    colaFinal.enqueue(aux + "");
                    prioridadTope = pila.saberPrioridadTope(indiceOp);
                }
                pila.push(letra);
            } else if (prioridadTope < indiceOp) {
                pila.push(letra);
            }
        } else if (datos.buscarParentesisAbierto(letra)) {
            pila.push(letra);
        } else if (datos.buscarParentesisCerrado(letra) != ' ') {
            Character aux = pila.top();
            Character parentesis = datos.buscarParentesisCerrado(letra);
            while (aux.charValue() != parentesis.charValue()) {
                aux = pila.pop();
                colaFinal.enqueue(aux + "");
            }
            pila.pop();
        } else {
            colaFinal.enqueue(letra + "");
        }
    }

    private void terminarDeSacar() {
        try {
            while (!pila.isEmpty()) {
                colaFinal.enqueue(pila.pop() + "");
            }
        } catch (ColaException | ExcepcionBalanceo ex) {
            System.out.println("Se cae en sacar todo");
        }
    }

    public double notacionPolacaInversa(String frase) throws Exception {
        Balanceo balan = new Balanceo();
        boolean estaBalanceado = balan.setString(frase);
        if (estaBalanceado) {
            cola = new ColaStrings(frase.length());
            colaFinal = new ColaStrings(frase.length());
            crearColaFormulaOriginal(frase);
            hacerColaFinal();
            terminarDeSacar();
            System.out.println(colaFinal.listaDatos());
            return evaluarFormulaPostFija();
        } else {
            throw new Exception("La formula no esta balanceado");
        }
    }

    private double evaluarFormulaPostFija() throws ColaException, ExcepcionBalanceo, Exception {
        String aux = colaFinal.dequeue();
        double result = 0;
        while (colaFinal.size() > 0) {
            if (!esLetra(aux)) {
                double num = Double.parseDouble(aux);
                pilaDouble.push(num);
            } else {
                double num1 = pilaDouble.pop();
                double num2 = pilaDouble.pop();
                result = calcularResultado(aux, num1, num2);
                pilaDouble.push(result);
            }
//            if(colaFinal.size() > 0) {
            aux = colaFinal.dequeue();
//            }
        }
        if (colaFinal.size() == 0 && pilaDouble.size() > 0) {
            double num1 = pilaDouble.pop();
            double num2 = pilaDouble.pop();
            result = calcularResultado(aux, num1, num2);
            pilaDouble.push(result);
        }
        return result;
    }

    private boolean esLetra(String letra) {
        switch (letra) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            case "^":
                return true;
            default:
                return false;
        }
    }

    private double calcularResultado(String op, double num1, double num2) throws Exception {
        switch (op) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            case "^":
                return Math.pow(num2, num1);
            default:
                System.out.println("Error en el ingreso");
        }
        throw new Exception("No es ninguno de los casos");
    }
}
