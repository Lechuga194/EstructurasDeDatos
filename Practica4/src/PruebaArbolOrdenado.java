public class PruebaArbolOrdenado {

    public static void main(String[] args) {

        System.out.println("*********Prueba*********");

        ArbolAVL<Integer> a = new ArbolAVL<>();
        a.agregar(50);
        a.agregar(25);
        a.agregar(75);
        a.agregar(20);
        a.agregar(30);
        a.agregar(70);
        a.agregar(80);
        a.agregar(26);
        System.out.println(a);

        ArbolAVL<Integer> b = new ArbolAVL<>();
        b.agregar(50);
        b.agregar(25);
        b.agregar(75);
        b.agregar(20);
        b.agregar(30);
        b.agregar(70);
        b.agregar(80);
        b.agregar(26);
        System.out.println(b);

        System.out.println("Son los arboles iguales? " + a.raiz.equals(b.raiz));

        a.eliminar(25);
        b.eliminar(50);

        System.out.println(a);
        System.out.println(b);

        System.out.println("Son los arboles iguales? " + a.raiz.equals(b.raiz));
    }
}
