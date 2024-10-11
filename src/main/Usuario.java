package src.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

	//Perfil perfil;
	//PreferenciasEmparejamiento preferencias;
	//Emparejamiento emparejamiento;
    private static int contadorUsuarios = 1;
	private int idUsuario;
	private String fechaNacimiento;
	private String email;
	private String contrasennia;
    private List<Integer> likesRecibidos;

    public Usuario() {
        this.idUsuario = contadorUsuarios++;
        this.likesRecibidos = new ArrayList<>(); // Inicializamos la lista de likes
    }

	public void validarInformacion() {
		// TODO - implement Usuario.validarInformacion
		throw new UnsupportedOperationException();
	}

	public void iniciarSesion() {
		// TODO - implement Usuario.iniciarSesion
		throw new UnsupportedOperationException();
	}

	public void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        
        // Validación de la fecha de nacimiento
        while (true) {
            System.out.print("Ingrese su fecha de nacimiento (dd/mm/aaaa): ");
            String input = scanner.nextLine();
            if (esFechaValida(input)) {
                this.fechaNacimiento = input;
                break;
            } else {
                System.out.println("Fecha de nacimiento inválida. Por favor, use el formato dd/mm/aaaa.");
            }
        }
        
        // Lectura y validación del email
        while (true) {
            System.out.print("Ingrese su email: ");
            String input = scanner.nextLine();
            if (esEmailValido(input)) {
                this.email = input;
                break;
            } else {
                System.out.println("Email inválido. Por favor, ingrese un email válido.");
            }
        }
        
        // Lectura de la contraseña
        System.out.print("Ingrese su contraseña: ");
        this.contrasennia = scanner.nextLine();
        
        System.out.println("Registro exitoso.");
        System.out.println("ID de usuario: " + this.idUsuario);
        System.out.println("Fecha de nacimiento: " + this.fechaNacimiento);
        System.out.println("Email: " + this.email);
    }

    private boolean esFechaValida(String fecha) {
        String patron = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(fecha);
        return matcher.matches();
    }

    private boolean esEmailValido(String email) {
        String patron = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

	public void registrarPreferencias() {
		// TODO - implement Usuario.registrarPreferencias
		throw new UnsupportedOperationException();
	}

	public void anniadirLike(int idUsuario) {
        try {
            if (likesRecibidos.contains(idUsuario)) {
                throw new Exception("El usuario con ID: " + idUsuario + " ya ha dado like anteriormente.");
            }
            this.likesRecibidos.add(idUsuario);
            System.out.println("Like recibido del usuario con ID: " + idUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Integer> getLikesRecibidos() {
        return this.likesRecibidos;
    }

	public void anniadirMatch() {
		// TODO - implement Usuario.anniadirMatch
		throw new UnsupportedOperationException();
	}

}
