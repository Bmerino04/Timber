package com.example;

import java.util.Scanner;

public class FormularioUsuario {

    public static String solicitarFechaNacimiento() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese su fecha de nacimiento (dd/mm/aaaa): ");
            String input = scanner.nextLine();
            if (Validador.esFechaValida(input)) {
                return input;
            } else {
                System.out.println("Fecha de nacimiento inválida. Por favor, use el formato dd/mm/aaaa.");
            }
        }
    }

    public static String solicitarEmail() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Ingrese su email: ");
            String input = scanner.nextLine();
            if (Validador.esEmailValido(input)) {
                return input;
            } else {
                System.out.println("Email inválido. Por favor, ingrese un email válido.");
            }
        }
    }

    public static String solicitarContrasennia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su contraseña: ");
        return scanner.nextLine();
    }
}

