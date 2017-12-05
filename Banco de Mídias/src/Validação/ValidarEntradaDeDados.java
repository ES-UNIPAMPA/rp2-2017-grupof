/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validação;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Matheus Montanha
 */
public class ValidarEntradaDeDados {

    /**
     * Método que recebe um texto e verifica se não contém numeros no meio da
     * String passado
     *
     * @param texto contendo o texto recebido
     * @return String caso o texto tenha somente texto
     */
    public static String nextLine(String texto) {
        boolean ficar;
        do {
            Scanner e = new Scanner(System.in);
            ficar = false;
            texto = e.nextLine();
            texto = texto.trim();
            if (texto == null || texto.equals("")) {
                ficar = true;
                System.out.println("Formato incorreto. Digite novamente: ");
            } else {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(texto);
                if (matcher.find()) {
                    ficar = true;
                    System.out.println("Formato incorreto. Digite novamente: ");
                }
            }
        } while (ficar);
        return texto;
    }

    /**
     * Método que recebe uma String e verifica se contém apenas numeros
     *
     * @param numero contendo o texto recebido
     * @return String caso o texto contenha somente numeros
     */
    public static String nextInt(String numero) {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            try {
                numero = e.nextLine();
                // e.nextLine();
                Integer.parseInt(numero);
                return numero;
            } catch (NumberFormatException e5) {
                ficar = true;
                System.out.println("Incorreto. Digite novamente.");
            }
        } while (ficar);
        return numero;
    }

    /**
     * Método que recebe uma String e verifica se o texto passado é do formato
     * Double.
     *
     * @param numero contendo o texto
     * @return String caso o texto esteja em formato Double
     */
    public static String nextDouble(String numero) {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            try {
                numero = e.next();
                Double.parseDouble(numero);
                return numero;
            } catch (NumberFormatException e2) {
                ficar = true;
                System.out.println("Formato incorreto. Digite novamente.");
            }
        } while (ficar);
        return numero;
    }

    /**
     * Método que recebe um número inteiro já encapsulado
     *
     * @param numero inteiro recebido
     * @return inteiro caso o numero passado seja inteiro
     */
    public static int validarInteiro(int numero) {
        Scanner e = new Scanner(System.in);
        try {
            numero = e.nextInt();
            return numero;
        } catch (InputMismatchException e7) {
        }
        return numero;
    }

    /**
     * Método que valida o texto aceitando enter
     *
     * @param texto recebido para validação
     * @return String caso tenha somente texto
     */
    public static String enterTexto(String texto) {
        boolean ficar;
        do {
            Scanner e = new Scanner(System.in);
            ficar = false;
            texto = e.nextLine();
            if (texto == null || texto.equals(" ")) {
                ficar = true;
                System.out.println("Formato incorreto. Digite novamente: ");
            } else {
                Pattern pattern = Pattern.compile("[0-9]");
                Matcher matcher = pattern.matcher(texto);
                if (matcher.find()) {
                    ficar = true;
                    System.out.println("Formato incorreto. Digite novamente: ");
                }
            }
        } while (ficar);
        return texto;

    }

    /**
     * Método que valida a entrada de texto em formato de numero, aceitando
     * enter.
     *
     * @param texto recebido para validação
     * @return String caso contenha apenas numeros
     */
    public static String enterNumero(String texto) {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            ficar = false;
            texto = e.nextLine();
            Pattern pattern = Pattern.compile("[a-z, A-Z]");
            Matcher matcher = pattern.matcher(texto);
            if (matcher.find() || texto.equals(" ")) {
                ficar = true;
                System.out.println("O campo não pode ser em branco ou conter letras. Digite novamente: ");
            }
        } while (ficar);
        return texto;
    }
}
