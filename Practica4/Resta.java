package Practica4;

public class Resta implements Operaciones {

	public int elementos(int x, int y) {
		if (x < y) {
			return y - x;
		} else {
			return x - y;
		}
	}

	public String simbolo() {
		return "-";
	}

}
