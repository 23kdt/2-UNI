package Practica4;

public class Division implements Operaciones {

	public int elementos(int x, int y) {
		if (x < y) {
			int t = x;
			x = y;
			y = t;
		}

		if (x % y == 0) {
			return x / y;
		} else {
			return 0;
		}
	}

	public String simbolo() {
		return "/";
	}

}