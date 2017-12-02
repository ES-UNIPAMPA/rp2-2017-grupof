/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/*
import Validação.ValidarEntradaDeDados;
import dominio.GerenciadorMidia;
import Midias.Midia;
import Midias.Podcast;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AllissonChervenski
 */
/*
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
        Podcast p = new Podcast(caminhoArquivo, titulo, genero, idioma, descricao, autores, ano);
        
        if (gerenciador.adicionarMidia(p)) {
            System.out.println("Registrado com sucesos.");
            
        }
    }
    @Override
    public boolean editarMidia() {
        List<Midia> listaRetorno;
        Scanner e = new Scanner(System.in);
        boolean ficar;
        int id;
        String titulo = null, genero = null, idioma = null, descricao = null, autores = null, interpretes = null, duracao = null, ano = null;
        System.out.println("Digite o título da podcast que deseja editar: ");
        String tituloConsultaEditar = null;
        listaRetorno = gerenciador.consultarMidia(tituloConsultaEditar);
        int contador = 0;
        if (!listaRetorno.isEmpty()) {
            for (Midia midia : listaRetorno) {
                System.out.println("ID: " + contador + "\n" + midia.toString());
                contador++;
            }
            String idTemp = null;
            System.out.println("ESSAS SÃO OS PODCASTS COM O TÍTULO INFORMADO.");
            System.out.println("Idêntifique o ID do podcast que deseja editar e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaRetorno.size() - 1) {
                Podcast podcast = (Podcast) listaRetorno.get(id);
                if (gerenciador.verificarMidia(tituloConsultaEditar)) {
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
                if (gerenciador.editarMidia(tituloConsultaEditar, podcast)) {
                    System.out.println("Editado com sucesso.");
                    return true;
                } else {
                    System.out.println("Não foi possivel editar seu podcast.");
                    return false;
                }
            } else {
                System.out.println("ID infomado inexistente.");
            }
        } else {
            System.out.println("Podcast inexistente.");
            return false;
        }
        return false;
    }

    public void removerMidia() {
        List<Midia> listaPegaRetorno;
        Scanner e = new Scanner(System.in);
        String tituloRemover = null;
        int id;
        System.out.println("Digite o título do podcast que deseja remover: ");
        tituloRemover = Validação.ValidarEntradaDeDados.nextLine(tituloRemover);
        listaPegaRetorno = gerenciador.consultarMidia(tituloRemover);
        int contador = 0;
        if (!listaPegaRetorno.isEmpty()) {
            for (Midia midia : listaPegaRetorno) {
                System.out.println("ID: " + contador + "\n" + midia.toString());
                contador++;
            }
            String idTemp = null;
            System.out.println("ESSAS SÃO OS PODCASTS COM O TÍTULO INFORMADO.");
            System.out.println("Identifique o ID do podcast que deseja remover e informe-o: ");
            idTemp = ValidarEntradaDeDados.nextInt(idTemp);
            id = Integer.parseInt(idTemp);
            if (id <= listaPegaRetorno.size() - 1) {
                Midia podcastRemover = listaPegaRetorno.get(id);
                if (gerenciador.remover(podcastRemover)) {
                    System.out.println("Removido com sucesso.");
                } else {
                    System.out.println("Não foi possivel remover.");
                }
            } else {
                System.out.println("ID inexistente. Tente novamente.");
            }
        } else {
            System.out.println("Podcast inexistente.");
        }
    }

    public void consultarMidia() {
        Scanner e = new Scanner(System.in);
        List<Midia> listaPegaRetorno;
        String tituloConsulta = null;
        System.out.println("Digite o título da midia que deseja consultar: ");
        tituloConsulta = Validação.ValidarEntradaDeDados.nextLine(tituloConsulta);
        listaPegaRetorno = gerenciador.consultarMidia(tituloConsulta);
        if (!listaPegaRetorno.isEmpty()) {
            for (Midia midia : listaPegaRetorno) {
                System.out.println(midia.toString());
            }
        } else {
            System.out.println("Podcast inexistente.");
        }
    }
<<<<<<< HEAD
}
*/
=======
    

   }
 
        
       

>>>>>>> master
