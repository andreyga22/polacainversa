/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Balanceo;

/**
 *
 * @author usuario
 */
public interface Stack {

    int size();

    boolean isEmpty();

    char top() throws ExcepcionBalanceo;

    char push(char o) throws ExcepcionBalanceo;

    char pop() throws ExcepcionBalanceo;

}
