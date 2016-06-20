package Balanceo;

public class Balanceo {

    ArrayStack pila;
    Char[] Char = {new Char('{', '}'), new Char('[', ']'), new Char('(', ')')};
    char[] string;

    public boolean setString(String frase) throws ExcepcionBalanceo {
        pila = new ArrayStack();
        string = new char[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            string[i] = frase.charAt(i);
        }
        return balan();
    }

    public boolean balan() throws ExcepcionBalanceo {
        for (int i = 0; i < string.length; i++) {
            if (caracter(string[i]) == false) {
                return false;
            }
        }

        if (pila.isEmpty() == false) {
            return false;
        }
        return true;
    }

    public boolean caracter(char a) throws ExcepcionBalanceo {
        for (int i = 0; i < Char.length; i++) {
            if (a == Char[i].open) {

                pila.push(a);
            } else if (a == Char[i].close) {

                if (pila.isEmpty() != true && Char[i].open == pila.top()) {
                    pila.pop();
                } else {
                    return false;
                }
            }

        }
        return true;

    }

}
