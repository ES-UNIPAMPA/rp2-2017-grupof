/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Midia;
import Midias.Podcast;
import java.util.Scanner;

/**
 *
 * @author AllissonChervenski
 */
public class GUIPodcast extends GUIMidia implements IMenu {

    final String caminho = "src/Arquivos/podcast.txt";
    dominio.GerenciadorMidia gerenciador;
    
     public GUIPodcast() {
        gerenciador = new GerenciadorMidia(caminho);
        gerenciador.carregar();
        
    }
     public void MenuPodcast() {
        Scanner e = new Scanner(System.in);
        int opcao = Integer.MIN_VALUE;;
        do {
            System.out.println("1 - Criar Podcast.");
            System.out.println("2 - Excluir podcast.");
            System.out.println("3 - Consultar podcast.");
            System.out.println("4 - Editar podcast.");
            System.out.println("5 - Voltar ao menu principal");
            System.out.println("O que deseja fazer?");
            opcao = e.nextInt();
            switch (opcao) {
                case 1:
                    criarMidia();
                    break;
                case 2:
                    removerMidia();
                    break;
                case 3:
                    consultarMidia();
                    break;
                case 4:
                    editarMidia();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida. Digite o número da opção desejada.");
                    break;
            }
        } while (opcao != 5);
    }

  
    @Override
    public void criarMidia() {
    super.criarMidia();
    Scanner e = new Scanner(System.in);
        Podcast podcast = new Podcast(caminhoArquivo, titulo, genero, idioma, descricao, autores, ano);
        if (gerenciador.adicionarMidia(podcast)) {
            System.out.println("Registrado com sucesos.");
        }
    }

    @Override
    public boolean editarMidia() {
        Scanner e = new Scanner(System.in);
        boolean ficar;
        String titulo = null, genero = null, idioma = null, descricao = null, autores = null, interpretes = null, duracao = null, ano = null;
        System.out.println("Digite o título da podcast que deseja editar: ");
        String tituloEditar = null;
        tituloEditar = ValidarEntradaDeDados.nextLine(tituloEditar);
        Podcast podcast = (Podcast) gerenciador.consultarMidia(tituloEditar);
        if (gerenciador.verificarMidia(tituloEditar)) {
            System.out.println("Digite o novo titulo do podcast: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            titulo = ValidarEntradaDeDados.entradaEnterTexto(titulo);
            if (titulo.equals("")); else {
                podcast.setTitulo(titulo);
            }
            System.out.println("Digite o novo genero do podcast: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            genero = ValidarEntradaDeDados.entradaEnterTexto(genero);
            if (genero.equals("")); else {
                podcast.setGenero(genero);
            }
            System.out.println("Digite o novo idioma do podcast: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            idioma = ValidarEntradaDeDados.entradaEnterTexto(idioma);
            if (idioma.equals("")); else {
                podcast.setIdioma(idioma);
            }
            System.out.println("Digite a nova descrição do podcast: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            descricao = ValidarEntradaDeDados.entradaEnterTexto(descricao);
            if (descricao.equals("")); else {
                podcast.setDescricao(descricao);
            }
          
            System.out.println("Digite os novos autores da podcast: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            autores = ValidarEntradaDeDados.entradaEnterTexto(autores);
            if (autores.equals("")); else {
                podcast.setAutores(autores);
            }
           
            }
            System.out.println("Digite o novo ano: ");
            System.out.println("[TECLE ENTER PARA IGNORAR]");
            ano = ValidarEntradaDeDados.entradaEnterNumero(ano);
            if (ano.equals("")); else {
                podcast.setAno(ano);
            }
        if (gerenciador.editarMidia(tituloEditar, podcast)) {
            System.out.println("Editado com sucesso.");
            return true;
        }
        return false;
    }
      public void removerMidia() {
        Scanner e = new Scanner(System.in);
        String tituloRemover = null;
        System.out.println("Digite o título do podcast que deseja remover: ");
        tituloRemover = Validação.ValidarEntradaDeDados.nextLine(tituloRemover);
        if (gerenciador.remover(tituloRemover)) {
            System.out.println("Removido com sucesso.");
        }
}
      public void consultarMidia() {
        Scanner e = new Scanner(System.in);
        String tituloConsulta = null;
        System.out.println("Digite o título do podcast que deseja consultar: ");
        tituloConsulta = Validação.ValidarEntradaDeDados.nextLine(tituloConsulta);
        Midia dados = gerenciador.consultarMidia(tituloConsulta);
        if (dados == null) {
            System.out.println("Podcast inexistente.");
        } else {
            System.out.println(dados.toString());
        }
    }
}
