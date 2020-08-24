public class TestArboles {

	public static void main(String[] args) throws Exception {

		System.out.println("------------------------------------------------");
		ArbolBinarioBusqueda<Integer> a = new ArbolBinarioBusqueda<>();
		a.agregar(5);
		// a.agregar(2);
		a.agregar(8);

		System.out.println(a);

	}
}
