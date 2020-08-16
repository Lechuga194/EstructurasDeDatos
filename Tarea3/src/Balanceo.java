/**
 * Lechuga Martinez José Eduardo 314325749 joselechuga194@ciencias.unam.mx
 * 
 * Practica 1 | EDD | 2020-4
 */

public class Balanceo {

    /**
     * Metodo que calcula si una expresion tiene parentesis balanceados usando pilas
     * 
     * @param expresion Expresion a revisar
     * @return True si tiene parentesis balanceados o si la expresion no tiene
     *         paretesis, false en otro caso
     */
    public static boolean verificaBalanceo(String expresion) {
        Pila pila = new Pila();
        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);
            if (actual == '(')
                pila.push(actual);
            if (actual == ')') {
                if (!pila.esVacia())
                    pila.pop();
                else
                    return false;
            }

        }
        return true;
    }
}