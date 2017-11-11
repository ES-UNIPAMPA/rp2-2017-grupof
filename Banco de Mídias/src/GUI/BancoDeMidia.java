/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author Matheus Montanha
 */

public class BancoDeMidia {

    public void MenuPrincipal() {
        Scanner e = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Bem-vindo. Escolha a midia que deseja: ");
            System.out.println("1 - Musica.");
            System.out.println("2 - Ebook.");
            System.out.println("3 - Filme.");
            System.out.println("4 - Podcast.");
            System.out.println("0 - Sair.");

            System.out.println("Digite a opção desejada: ");
            opcao = e.nextInt();
            switch (opcao) {
                case 1:
                    GUIMusica menuMusica = new GUIMusica();
                    menuMusica.MenuMusica();
                case 2:
                case 3:
                case 4:
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Digite o número da opção desejada.");
            }
        } while (opcao != 0);

    }

    public static void main(String[] args) {
        BancoDeMidia sb = new BancoDeMidia();
        sb.MenuPrincipal();
    }

}
