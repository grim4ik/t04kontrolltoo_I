public class Test{

	public static double kiirusedKokku(double kiirus1, double kiirus2) {
		return  (kiirus1 + kiirus2) / 2;
	}

	public static void main(String[] args) {
		System.out.println("Kahe kilomeetri labimise keskmine kiirus on "+kiirusedKokku(30.0, 60.0)+" km/h");
	}

}