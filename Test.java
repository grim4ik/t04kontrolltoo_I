public class Test{

	public static double kiirusedKokku(double kiirus1, double kiirus2) {
		return  2 / (1/kiirus1 + 1/kiirus2);
	}

	public static void main(String[] args) {
		System.out.println("Kahe kilomeetri labimise keskmine kiirus on "+kiirusedKokku(30.0, 60.0)+" km/h");
	}

}