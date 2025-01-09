package backend;

import UI.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication(scanBasePackages = {"backend", "UI"})
public class TimberApplication {

	public static void main(String[] args) {
		if (GraphicsEnvironment.isHeadless()) {
			System.out.println("Ejecutando en modo headless. No se iniciará la interfaz gráfica.");
		} else {
			// Inicializar UI (Swing)
			new Login();
		}

		SpringApplication.run(TimberApplication.class, args);
	}

}
