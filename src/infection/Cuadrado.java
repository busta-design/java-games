package infection;
import java.awt.Color;
public class Cuadrado extends Rectangulo{
	public Cuadrado(int x, int y, int lado, Color color) {
		super(x, y, lado, lado, color);
	}

	public Cuadrado(int x, int y, int lado, Color color, int incX, int incY) {
		super(x, y, lado, lado, color, incX, incY);
	}

}
