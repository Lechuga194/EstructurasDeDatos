import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Clase para probar los metodos de Lista
 * 
 * @author Luis Manuel Martinez Damaso <luismanuel@ciencias.unam.mx>
 */
public class TestPilaCola {

	public static void main(String[] args) {

		System.out.println("----------------------------------PILAS------------------------------------------------------");

		System.out.println("Constructor iterable");
		Integer[] conjunto = { 3, 2, 1, 4, 5 };
		Iterable<Integer> c = Arrays.asList(conjunto);
		Lista<Iterable<Integer>> pilaIterable = new Pila(c);
		System.out.println(pilaIterable);

		System.out.println("Constructor pila iterable 2");
		Pila v = new Pila();
		v.push(1);
		v.push(2);
		v.push(3);
		v.push(4);
		Pila pilaPilaIterable = new Pila(v);
		System.out.println(v);
		System.out.println(pilaPilaIterable);

		System.out.println("Creamos la pila");
		Pila a = new Pila();
		System.out.println("Longitud: " + a.longitud);
		System.out.println(a);
		
		System.out.println("Agregamos elementos a la pila");
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		System.out.println("Longitud: " + a.longitud);
		System.out.println(a);

		System.out.println("Eliminamos elementos a la pila");
		int j = (int)a.pop();
		System.out.println("POP: " + j);
		System.out.println("Longitud: " + a.longitud);
		System.out.println(a);

		System.out.println("Peek de elementos a la pila");
		int top = (int)a.top();
		System.out.println(top);

		System.out.println("----------------------------------COLAS------------------------------------------------------");

		System.out.println("Constructor iterable");
		Integer[] conjuntoy = { 3, 2, 1, 4, 5 };
		Iterable<Integer> yy = Arrays.asList(conjuntoy);
		Cola<Iterable<Integer>> colaIterable = new Cola(yy);
		System.out.println(colaIterable);

		System.out.println("Constructor iterable 2");
		Cola v2 = new Cola();
		v2.queue(1);
		v2.queue(2);
		v2.queue(3);
		v2.queue(4);
		Cola colaColaIterable = new Cola(v2);
		System.out.println(v2);
		System.out.println(colaColaIterable);

		System.out.println("Creamos la cola");
		Cola b = new Cola();
		System.out.println("Longitud: " + b.longitud);
		System.out.println(b);

		System.out.println("Agregamos elementos");
		b.queue(2);
		b.queue(8);
		b.queue(1);
		System.out.println("Longitud: " + b.longitud);
		System.out.println(b);

		System.out.println("Obtenemos elementos");
		int r = (int)b.dequeue();
		System.out.println(r);

		System.out.println("peek");
		System.out.println(b.peek());

	}
}
