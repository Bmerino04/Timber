package backend.config;

import backend.entities.User;
import backend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class SeederDatabase implements CommandLineRunner {

    private final UserRepository userRepository;

    public SeederDatabase(UserRepository usuarioRepository) {
        this.userRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verificar si ya hay datos en la tabla
        if (userRepository.count() == 0) {
            // Crear usuarios
            List<User> users = Arrays.asList(
                    new User("Juan Pérez", "juan.perez@example.com", "password123", LocalDate.of(1995, 5, 15)),
                    new User("María López", "maria.lopez@example.com", "password123", LocalDate.of(1990, 8, 10)),
                    new User("Carlos García", "carlos.garcia@example.com", "password123", LocalDate.of(1998, 2, 20)),
                    new User("Ana Rodríguez", "ana.rodriguez@example.com", "password123", LocalDate.of(1987, 1, 5)),
                    new User("Luis Fernández", "luis.fernandez@example.com", "password123", LocalDate.of(2000, 6, 18)),
                    new User("Laura Martínez", "laura.martinez@example.com", "password123", LocalDate.of(1994, 3, 25)),
                    new User("Pedro Sánchez", "pedro.sanchez@example.com", "password123", LocalDate.of(1992, 11, 11)),
                    new User("Marta Gómez", "marta.gomez@example.com", "password123", LocalDate.of(1996, 12, 30)),
                    new User("Andrés Torres", "andres.torres@example.com", "password123", LocalDate.of(1999, 7, 8)),
                    new User("Paula Ruiz", "paula.ruiz@example.com", "password123", LocalDate.of(1989, 9, 22))
            );

            // Guardar los usuarios en la base de datos
            userRepository.saveAll(users);

            System.out.println("Usuarios insertados en la base de datos.");
        } else {
            System.out.println("La tabla Usuario ya contiene datos. No se insertaron nuevos registros.");
        }
    }
}
