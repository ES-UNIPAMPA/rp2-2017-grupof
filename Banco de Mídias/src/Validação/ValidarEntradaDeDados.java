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

    public static String nextLine(String texto) {
        boolean ficar;
        do {
            Scanner e = new Scanner(System.in);
            ficar = false;
            texto = e.nextLine();
            if (texto == null || " ".equals(texto) || texto.equals("")) {
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

    public static String nextInt(String numero) {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            try {
                numero = e.nextLine();
                Integer.parseInt(numero);
                return numero;
            } catch (NumberFormatException e5) {
                ficar = true;
                System.out.println("Incorreto. Digite novamente.");
            }
        } while (ficar);
        return numero;
    }

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

    public static int validarInteiro(int numero) {
        boolean ficar;
        Scanner e = new Scanner(System.in);
        try {
            numero = e.nextInt();
            return numero;
        } catch (InputMismatchException e7) {
        }
        return numero;
    }
}
