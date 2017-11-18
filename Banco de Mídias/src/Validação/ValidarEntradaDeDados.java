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
        Scanner e = new Scanner(System.in);
        boolean ficar;
        do {
            ficar = false;
            texto = e.nextLine();
            if (texto == null || " ".equals(texto)) {
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

    public static int nextInt(int numero) {
        Scanner e = new Scanner(System.in);
        boolean ficar = false;
        do {
            try {
                numero = Integer.parseInt(e.nextLine());
            } catch (NumberFormatException e7) {
                System.out.println("Formato incorreto. Digite novamente:");
                ficar = true;
            }
        } while (ficar);
        return numero;
    }

    public static double nextDouble(double numero) {
        Scanner e = new Scanner(System.in);
        boolean ficar = false;
        do {
            try {
                numero = e.nextDouble();
            } catch (Exception e2) {
                System.out.println("Formato incorreto. Digite novamente.");
                ficar = true;
            }
        } while (ficar);
        return numero;
    }
}
