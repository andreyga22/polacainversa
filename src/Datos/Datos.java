/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Datos {

    private char[] listOper = {('+'), ('-'), ('*'), ('/'), ('^')};
    private final char[] listParentAbierto = {('{'), ('['), ('(')};
    private final char[] listParentCerrado = {('}'), (']'), (')')};

//    private int actualIndex= 0;
//    public boolean buscarNum(int num) {
//        for (int i = 0; i < listNum.length; i++) {
//            if(num == listNum[i]) {
//                return true;
//            }
//        }
//        return false;
//    }
    public int buscarOperador(Character num) {
        for (int i = 0; i < listOper.length; i++) {
            if (num == listOper[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean buscarParentesisAbierto(Character num) {
        for (int i = 0; i < listParentAbierto.length; i++) {
            if (num == listParentAbierto[i]) {
//                actualIndex = i;
                return true;
            }
        }
        return false;
    }

    public char buscarParentesisCerrado(Character num) {
        for (int i = 0; i < listParentCerrado.length; i++) {
            if (num == listParentCerrado[i]) {
//                actualIndex = i;
                return listParentAbierto[i];
            }
        }
        return ' ';
    }
}
