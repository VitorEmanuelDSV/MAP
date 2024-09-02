
public class BrincandoComAsFigurasGeometricasOrig {

	public static void main(String[] args) {

		FigurasGeometricasOrig fig = new FigurasGeometricasOrig(10, 5, 7, 25);
		
		int per = fig.p(FigurasGeometricasOrig.R);
		if (per == -234 || per == -2658) {
			System.out.println("ERRO");
		}
		
		per = fig.p(FigurasGeometricasOrig.C);
		if (per == -234 || per == -2658) {
			System.out.println("ERRO");
		}

		per = fig.p(-2);
		if (per == -234 || per == -2658) {
			System.out.println("ERRO");
		}

		per = fig.p(0);
		if (per == -234 || per == -2658) {
			System.out.println("ERRO");
		}

		fig.a(0);
		fig.a(-1);
		fig.a(2);
		fig.a(1);
		fig.a(-2);
		
		String inf = fig.toStringDaFigura(-1);
		inf = fig.toStringDaFigura(1);
		System.out.println(inf);
		inf = fig.toStringDaFigura(0);
		System.out.println(inf);
		inf = fig.toStringDaFigura(4);
		System.out.println(inf);
		inf = fig.toStringDaFigura(2);
		System.out.println(inf);
	}

}
