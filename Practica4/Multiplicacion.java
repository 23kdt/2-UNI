package Practica4;

public class Multiplicacion implements Operaciones {

	public int elementos(int x, int y) {
		int r = x * y;

		if (r <= x || r <= y) {
			return 0;
		} else {
			return r;
		}
	}

	public String simbolo() {
		return "*";
	}

}
