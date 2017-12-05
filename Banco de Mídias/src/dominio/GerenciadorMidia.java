
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Midias.Ebook;
import Midias.Jogos;
import Midias.Midia;
import Midias.Musica;
import Midias.Podcast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus Montanha
 */
public class GerenciadorMidia {

    private ArrayList<Midia> listaMidia;
    private String caminho;

    /**
     * Método construtor para inicializar a list
     *
     * @param caminho do arquivo txt
     */
    public GerenciadorMidia(String caminho) {
        this.listaMidia = new ArrayList();
        this.caminho = caminho;
    }

    public ArrayList<Midia> getListaMidia() {
        return listaMidia;
    }

    /**
     * Método para adicionar uma nova midia
     *
     * @param novaMidia midia a ser adicionada na lista
     * @return True caso foi adicionado, caso contrário, retorna False
     */
    public boolean adicionarMidia(Midia novaMidia) {
        if (novaMidia != null) {
            listaMidia.add(novaMidia);
            return salvar();
        }
        return false;
    }

    /**
     * Método para excluir uma mídia.
     *
     * @param midias passado para ser removido
     * @return True caso foi removido com sucesso, caso contrário, retorna
     * False;
     */
    public boolean remover(Midia midias) {
        for (Midia midia : listaMidia) {
            if (midia.equals(midias)) {
                listaMidia.remove(midia);
                return salvar();
            }
        }
        return false;
    }

    /**
     * Método para editar uma musica existente
     *
     * @param novaMidia recebe a nova mídia já editada
     * @return True caso foi editado com sucesso, caso contrário, retorna False
     */
    public boolean editarMidia(Midia novaMidia) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).equals(novaMidia)) {
                listaMidia.set(i, novaMidia);
            }
        }
        salvar();
        return true;
    }

    /**
     * Método para consultar uma mídia desejada
     *
     * @param midiaTitulo identifica todas as midias com esse titulo e add numa
     * lista.
     * @return retorna uma List com as midia com o titulo passado
     */
    public List consultarMidia(String midiaTitulo) {
        ArrayList<Midia> listaRetorno = new ArrayList<>();
        for (Midia midia : listaMidia) {
            if (midia.getTitulo().equalsIgnoreCase(midiaTitulo)) {
                listaRetorno.add(midia);
            }
        }
        return listaRetorno;
    }

    /**
     * Método para verificar se uma determinada midia existe
     *
     * @param titulo recebido para procurar a midia desejada
     * @return True caso exista a mídia, caso contrário, retorna false
     */
    public boolean verificarMidia(String titulo) {
        for (int i = 0; i < listaMidia.size(); i++) {
            if (listaMidia.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que retorna todas as mídias contidas na listMidia
     *
     * @return uma list com todas as midias
     */
    public ArrayList retornaMidias() {
        ArrayList<Midia> listaTodos = new ArrayList<>();
        for (int i = 0; i < listaMidia.size(); i++) {
            listaTodos.add(listaMidia.get(i));
        }
        return listaTodos;
    }

    /**
     * Método que escreve as midias contidas na lista em um arquivo de texto
     *
     * @return True caso salvo, caso contrário retorna False
     */
    public boolean salvar() {
        String novaLinha = System.getProperty("line.separator");
        try {
            FileWriter escritorArquivo = new FileWriter(new File(caminho));
            escritorArquivo.write(String.valueOf(listaMidia.size()));
            escritorArquivo.write(novaLinha + novaLinha);
            for (Midia midia : listaMidia) {
                escritorArquivo.write(midia.toFile());
                escritorArquivo.write(novaLinha + " " + novaLinha);
            }
            escritorArquivo.close();

        } catch (IOException ex) {
            Logger.getLogger(GerenciadorMidia.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Método que carrega as midias contidas no arquivo de texto
     *
     * @return True caso carregou, caso contrário, retorna False
     */
    public boolean carregar() {
        File arquivo;
        arquivo = new File(caminho);
        if (arquivo.exists()) {
            ArrayList<String> dados = new ArrayList();
            try {
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader buffR = new BufferedReader(fileReader);
                String linhas;
                buffR.readLine();
                buffR.readLine();
                while ((linhas = buffR.readLine()) != null) {
                    if (!linhas.equals(" ")) {
                        dados.add(linhas);
                    } else {
                        montarMidia(dados, arquivo);
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(GerenciadorMidia.class
                        .getName()).log(Level.SEVERE, null, ex);
                return false;

            } catch (IOException ex) {
                Logger.getLogger(GerenciadorMidia.class
                        .getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }

    /**
     * Método que identifica o tipo de midia que esta sendo passada para
     * realizar o carregamento para a listaMidia
     *
     * @param dados ArrayList contendo os dados do arquivo txt
     * @param arquivo para identificar o nome da musica que sendo passado
     */
    private void montarMidia(ArrayList<String> dados, File arquivo) {

        switch (arquivo.getName()) {
            case "ebook.txt":
                montarEbook(dados);
                break;
            case "musica.txt":
                montarMusica(dados);
                break;
            case "podcast.txt":
                montarPodcast(dados);
                break;
            case "jogos.txt":
                montarJogos(dados);
            default:
                System.out.println("Nome de arquivo inválido!");
                break;
        }

    }

    /**
     * Método que cria um objeto com as informações contidas no ArrayList dados
     *
     * @param dados ArrayList contendo os dados lidos do arquivo txt
     */
    private void montarEbook(ArrayList<String> dados) {
        Midia novo = new Ebook(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8),
                dados.get(9));
        listaMidia.add(novo);
        dados.clear();
    }

    /**
     * Método que cria um objeto com as informações contidas no ArrayList dados
     *
     * @param dados ArrayList contendo os dados lidos do arquivo txt
     */
    private void montarMusica(ArrayList<String> dados) {
        Midia novo = new Musica(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8));
        listaMidia.add(novo);
        dados.clear();
    }

    /**
     * Método que cria um objeto com as informações contidas no ArrayList dados
     *
     * @param dados ArrayList contendo os dados lidos do arquivo txt
     */
    private void montarPodcast(ArrayList<String> dados) {
        Midia novo = new Podcast(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6));
        adicionarMidia(novo);

    }

    private void montarJogos(ArrayList<String> dados) {
        Midia novo = new Jogos(dados.get(0),
                dados.get(1),
                dados.get(2),
                dados.get(3),
                dados.get(4),
                dados.get(5),
                dados.get(6),
                dados.get(7),
                dados.get(8),
                dados.get(9));
        listaMidia.add(novo);
        dados.clear();
    }

    /**
     * Método ordenador da midia Música. O método ordena com o Cocktail Sort.
     *
     * @param listaMidia contendo as midias a serem ordenadas
     */
    public void ordenadorMusica(List listaMidia) {
        if (listaMidia.size() == 2) {
            Musica musica = (Musica) listaMidia.get(0);
            Musica musica2 = (Musica) listaMidia.get(1);
            if (musica.compareTo(musica2) > 0) {
                Musica aux1 = musica;
                listaMidia.set(0, musica2);
                listaMidia.set(1, aux1);
            }
        }
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < listaMidia.size() - 2; i++) {
                Musica musica = (Musica) listaMidia.get(i);
                Musica musica2 = (Musica) listaMidia.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaMidia.get(i);
                    listaMidia.set(i, listaMidia.get(i + 1));
                    listaMidia.set(i + 1, aux);
                    houveTroca = true;
                }
            }
            if (!houveTroca) {
                break;
            }
            for (int i = listaMidia.size() - 2; i >= 0; i--) {
                Musica musica = (Musica) listaMidia.get(i);
                Musica musica2 = (Musica) listaMidia.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaMidia.get(i);
                    listaMidia.set(i, listaMidia.get(i + 1));
                    listaMidia.set(i + 1, aux);
                    houveTroca = true;
                }
            }

        } while (houveTroca);
    }

    /**
     * Método que ordena a midia Ebook. O método ordena com o Merge Sort
     *
     * @param lista recebido com as midias a serem ordenadas
     * @return
     */
    public List ordenadorEbook(List lista) {

        List<Midia> esqueda = new ArrayList();
        List<Midia> direita = new ArrayList();
        int meio;

        if (lista.size() == 1) {
            return lista;
        } else {
            meio = lista.size() / 2;

            for (int i = 0; i < meio; i++) {
                esqueda.add((Midia) lista.get(i));
            }

            for (int i = meio; i < lista.size(); i++) {
                direita.add((Midia) lista.get(i));
            }

            esqueda = ordenadorEbook(esqueda);
            direita = ordenadorEbook(direita);

            ordena(esqueda, direita, lista);
        }
        // salvar();
        return lista;
    }

    public List exibir() {
        return listaMidia;
    }

    private void ordena(List<Midia> esquerda, List<Midia> direita, List lista) {
        int indiceEsquerda = 0;
        int indiceDireita = 0;
        int indiceLista = 0;

        while (indiceEsquerda < esquerda.size() && indiceDireita < direita.size()) {
            if ((esquerda.get(indiceEsquerda).compareTo(direita.get(indiceDireita))) < 0) {
                lista.set(indiceLista, esquerda.get(indiceEsquerda));
                indiceEsquerda++;
            } else {
                lista.set(indiceLista, direita.get(indiceDireita));
                indiceDireita++;
            }
            indiceLista++;
        }

        while (indiceEsquerda < esquerda.size()) {

            lista.set(indiceLista, esquerda.get(indiceEsquerda));
            indiceEsquerda++;

            indiceLista++;
        }

        while (indiceDireita < direita.size()) {
            lista.set(indiceLista, direita.get(indiceDireita));
            indiceDireita++;

            indiceLista++;
        }
    }

    /**
     * Método que ordena a mídia PodCast
     *
     * @param listaMidia recebido com as midias que deseja ordenar
     */
    public void ordenadorPodcast(List listaMidia) {

        for (int i = 0; i < listaMidia.size() / 2; i++) {
            for (int j = 0; j <= listaMidia.size() - 2; j = j + 2) {
                Podcast podcast = (Podcast) listaMidia.get(j);
                Podcast podcast2 = (Podcast) listaMidia.get(j + 1);
                if (podcast.compareTo(podcast2) > 0) {
                    Podcast temp = podcast;
                    listaMidia.set(j, podcast2);
                    listaMidia.set(j + 1, temp);

                }
            }

            for (int j = 1; j <= listaMidia.size() - 2; j = j + 2) {
                Podcast podcast = (Podcast) listaMidia.get(j);
                Podcast podcast2 = (Podcast) listaMidia.get(j + 1);
                if (podcast.compareTo(podcast2) > 0) {
                    Podcast temp = podcast;
                    listaMidia.set(j, podcast2);
                    listaMidia.set(j + 1, temp);

                }
            }
        }
    }
}
