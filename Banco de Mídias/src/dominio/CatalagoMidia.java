/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import Midias.Ebook;
import Midias.Filme;
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
public class CatalagoMidia {

    private static List<Midia> listaMidia;
    String novaLinha = System.getProperty("line.separator");

    public CatalagoMidia(List lista) {
        CatalagoMidia.listaMidia = lista;
    }

    public boolean adicionar(String[] dados, Midia midia) {
        if (midia instanceof Musica) {
            Musica musica = new Musica(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8]);
            listaMidia.add(musica);
            return salvar(musica);
        }
        if (midia instanceof Ebook) {
            Ebook novo = new Ebook(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8], dados[9]);
            //adiciona na lista de midias e chama o metodo salvar
            listaMidia.add(novo);
            return salvar(novo);
        }
        return false;
    }

    public boolean remover(String nome) {
        Midia midia = new Midia(nome);
        listaMidia.remove(midia);
        return salvar(midia);
    }

    public boolean editar(String[] dados, String tituloOriginal) {
        int idOriginal = listaMidia.indexOf(new Midia(tituloOriginal));
        Midia procurada = listaMidia.get(idOriginal);
        if (procurada instanceof Musica) {
            Musica musica = (Musica) procurada;
            musica.setCaminhoDoArquivo(dados[0]);
            musica.setTitulo(dados[1]);
            musica.setGenero(dados[2]);
            musica.setIdioma(dados[3]);
            musica.setDescricao(dados[4]);
            musica.setAutores(dados[5]);
            musica.setAno(dados[6]);
            musica.setInterpretes(dados[7]);
            musica.setDuracao(dados[8]);
            return salvar(musica);
        }
        if (procurada instanceof Ebook) {
            Ebook original = (Ebook) procurada;
            original.setCaminhoDoArquivo(dados[0]);
            original.setTitulo(dados[1]);
            original.setDescricao(dados[2]);
            original.setGenero(dados[3]);
            original.setAutores(dados[4]);
            original.setIdioma(dados[5]);
            original.setNumPaginas(dados[6]);
            original.setEditora(dados[7]);
            original.setLocal(dados[8]);
            original.setAno(dados[9]);
            return salvar(original);
        }
        return false;
    }

    public boolean carregar(Midia midia) {
        listaMidia = new ArrayList();
        String caminho;
        if (midia instanceof Musica) {
            caminho = "src/Arquivos/musica.txt";
        } else if (midia instanceof Ebook) {
            caminho = "src/Arquivos/Ebook.txt";
        } else {
            caminho = "src/Arquivos/Podcast.txt";
        }
        File arquivo = new File(caminho);
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader buffR = new BufferedReader(fileReader);
            String linhas;
            String[] dados = new String[10];
            int cont = 0;
            //primeira linha do arquivo, contém qnt de mídias
            buffR.readLine();
            //segunda linha do arquivo, apenas quebra de linha
            buffR.readLine();
            while ((linhas = buffR.readLine()) != null) { //lê uma linha, guarda na var "linhas"
                if (!linhas.equals("")) {  //adiciona "linhas" na posição "cont" do vetor dados se "linhas"
                    dados[cont] = linhas; //for diferente de vazio e incrementa o "cont"
                    cont++;
                } else { //se encontra linha vazia, cria um novo obj com os dados das linha e adiciona na lista
                    //de mídias e zera o contador
                    adicionar(dados, midia);
                    cont = 0;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CatalogoEbooks.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(CatalogoEbooks.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    protected boolean salvar(Midia midias) {
        try {
            String caminho;
            if (midias instanceof Musica) {
                caminho = "src/Arquivos/musica.txt";
            } else if (midias instanceof Ebook) {
                caminho = "src/Arquivos/Ebook.txt";
            } else {
                caminho = "src/Arquivos/Podcast.txt";
            }
            //cria obj do tipo FileWriter com a info do caminho do arquivo
            FileWriter escritorArquivo = new FileWriter(new File(caminho));
            //escreve o numero de midias no arquivo
            escritorArquivo.write(String.valueOf(listaMidia.size()));
            //pula a segunda linha
            escritorArquivo.write(novaLinha + novaLinha);
            String[] dados;
            if (midias instanceof Ebook) {
                //percorre a lista de midias pegando tds os ebooks
                for (Midia midia : listaMidia) {
                    //casting de midia para ebook, para poder utilizar os metodos da Classe Ebook
                    Ebook ebook = (Ebook) midia;
                    dados = ebook.toArrayString();
                    //escreve as info de cada midia ebook, linha por linha
                    for (int i = 0; i < dados.length; i++) {
                        escritorArquivo.write(dados[i] + novaLinha);
                    }
                    escritorArquivo.write(novaLinha);
                }
            }
            if (midias instanceof Musica) {
                for (Midia midia : listaMidia) {
                    //casting de midia para ebook, para poder utilizar os metodos da Classe Ebook
                    Musica musica = (Musica) midia;
                    dados = musica.ArraytoString();
                    //escreve as info de cada midia ebook, linha por linha
                    for (int i = 0; i < dados.length; i++) {
                        escritorArquivo.write(dados[i] + novaLinha);
                    }
                    escritorArquivo.write(novaLinha);
                }
            }
            /*
            if (midias instanceof Podcast) {
                for (Midia midia : listaMidia) {
                    //casting de midia para ebook, para poder utilizar os metodos da Classe Ebook
                    Podcast podcast = (Podcast) midia;
                    dados = podcast.ArraytoString();
                    //escreve as info de cada midia ebook, linha por linha
                    for (int i = 0; i < dados.length; i++) {
                        escritorArquivo.write(dados[i] + novaLinha);
                    }
                    escritorArquivo.write(novaLinha);
                }
            }
             */
            //necessario fechar o escritor de arquivos(FileWriter) depois de escrever
            escritorArquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(CatalogoEbooks.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public Midia buscar(String[] dados, String titulo) {
        int idProcurado = listaMidia.indexOf(new Musica(titulo));
        Musica procurada = (Musica) listaMidia.get(idProcurado);
        return procurada;
    }

}
