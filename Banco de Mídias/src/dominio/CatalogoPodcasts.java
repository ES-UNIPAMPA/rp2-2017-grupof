package dominio;

import Midias.Podcast;
import Midias.Midia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AllissonChervenski
 */
public class CatalogoPodcasts extends Catalogo {
    String novaLinha = System.getProperty("line.separator");
    
    public CatalogoPodcasts(){
           listaMidias = new ArrayList();
    }
       public List<Midia> getListaMidias() {
        return listaMidias;
    }
    @Override
    public boolean adicionar(String[] dados) {
                Podcast novo = new Podcast(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6]);
                listaMidias.add(novo);
                return salvar();
    }
            
    @Override
    public boolean remover(String titulo) {
         Podcast novo = new Podcast(titulo);
        listaMidias.remove(novo);
        return salvar();
    }

    @Override
    public boolean carregar() {
    listaMidias = new ArrayList();        
        File arquivo = new File("src/Arquivos/podcast.txt");
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader buffR = new BufferedReader(fileReader);
            String linhas;
            String[] dados = new String[7];
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
                    adicionar(dados);
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

    @Override
    protected boolean salvar() {
try {
            //cria obj do tipo FileWriter com a info do caminho do arquivo
            FileWriter escritorArquivo = new FileWriter(new File("src/Arquivos/podcast.txt"));
            //escreve o numero de midias no arquivo
            escritorArquivo.write(String.valueOf(listaMidias.size()));
            //pula a segunda linha
            escritorArquivo.write(novaLinha+novaLinha);
            String[] dados;

            //percorre a lista de midias pegando tds os ebooks
            for (Midia midia : listaMidias) {
                //casting de midia para ebook, para poder utilizar os metodos da Classe Ebook
                Podcast podcast = (Podcast) midia;
                dados = podcast.toArrayString();

                //escreve as info de cada midia ebook, linha por linha
                for (int i = 0; i < dados.length; i++) {
                    escritorArquivo.write(dados[i] + novaLinha);
                }
                escritorArquivo.write(novaLinha);
            }
            //necessario fechar o escritor de arquivos(FileWriter) depois de escrever
            escritorArquivo.close();
        } catch (IOException ex) {
            Logger.getLogger(CatalogoEbooks.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;   
    }

    @Override
    public boolean editar(String[] dados, String tituloOriginal) {
            int idOriginal = listaMidias.indexOf(new Podcast(tituloOriginal));
            Podcast original = (Podcast)listaMidias.get(idOriginal);
            original.setCaminhoDoArquivo(dados[0]);
            original.setTitulo(dados[1]);
            original.setDescricao(dados[2]);
            original.setGenero(dados[3]);
            original.setAutores(dados[4]);
            original.setIdioma(dados[5]);
            original.setAno(dados[6]);
            return salvar();
    }

    @Override
    public Midia buscar(String[] dados, String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
