/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inversionpolaca;

//import Balanceo.ArrayStack;
import Balanceo.Balanceo;
import Datos.ArrayStack;
import Balanceo.ExcepcionBalanceo;
import Datos.ColaException;
import Datos.ColaStrings;
import Datos.Datos;
import javax.swing.JOptionPane;
import proceso.Procesos;

/**
 *
 * @author andre
 */
public class Menu {

    private ColaStrings colaFinal;
    private Procesos proc;
    public Menu() throws Exception {
        boolean salir = false;
        ArrayStack array = new ArrayStack();
        do {
            try {
                int o = Integer.parseInt(JOptionPane.showInputDialog(null, "1. InversionPolaca\n2. Salir"));
                switch (o) {
                    case 1:
                        String frase = JOptionPane.showInputDialog(null, "digite la formula");
                        proc = new Procesos();
                        double result = proc.notacionPolacaInversa(frase);
                        JOptionPane.showMessageDialog(null, "El resultado de: " + frase +" es:\n" + result);
                        break;
                    case 2:
                        salir = true;
                        break;
                }
            } catch (ExcepcionBalanceo | NumberFormatException | ColaException e) {
                System.out.println(e.getMessage());
            }
        } while (salir == false);
    }
}
