package entities;

public class Camera implements FuncaoIF {

	public Camera() {}

	public Camera createCamera() {
		return new Camera();
	}

	@Override
	public String getNome() {
		return "Câmera";
	}
}
