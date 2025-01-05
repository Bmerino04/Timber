package com.example;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    /**
     * Valida el formato de la fecha de nacimiento y verifica si es una fecha válida.
     *
     * @param fecha la fecha en formato dd/mm/aaaa
     * @return true si la fecha es válida, false en caso contrario
     */
    public static boolean esFechaValida(String fecha) {
        String patron = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(fecha);

        if (!matcher.matches()) {
            return false;
        }

        String[] partes = fecha.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int anio = Integer.parseInt(partes[2]);

        if (mes < 1 || mes > 12) {
            return false;
        }

        Calendar calendario = Calendar.getInstance();
        calendario.set(anio, mes - 1, 1);
        int diasEnMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (dia < 1 || dia > diasEnMes) {
            return false;
        }

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        return anio <= anioActual;
    }

    /**
     * Valida el formato de un correo electrónico.
     *
     * @param email el correo electrónico a validar
     * @return true si el correo es válido, false en caso contrario
     */
    public static boolean esEmailValido(String email) {
        String patron = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

