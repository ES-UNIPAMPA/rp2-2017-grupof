package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Matheus Montanha
 */
public class CatalagoMusicas extends Catalogo {

    String novaLinha = System.getProperty("line.separator");

    /**
     * Método construtor para inicializar a listaMidias
     */
    public CatalagoMusicas() {
        listaMidias = new ArrayList<>();
    }

    /**
     * Método para adicionar uma nova musica
     *
     * @param dados é recebido para que cada informação da musica guardada no
     * vetor preencha as variáveis do objeto musica
     * @return retorna true caso foi salvo com sucesso, caso contrário retorna
     * false
     */
    @Override
    public boolean adicionar(String[] dados) {
        Musica musica = new Musica(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8]);
        listaMidias.add(musica);
        return salvar();
    }

    /**
     * Método para remover a música desejada
     *
     * @param Titulo para localizar a música que dejesa remover
     * @return retorna true caso foi salvo com sucesso, caso contrário retorna
     * false
     */
    @Override
    public boolean remover(String Titulo) {
        Musica nova = new Musica(Titulo);
        listaMidias.remove(nova);
        return salvar();
    }

    /**
     * Método para carregar as informações em um arquivo de texto
     *
     * @return retorna true caso foi carregado com sucesso, caso contrário
     * retorna false
     */
    @Override
    public boolean carregar() {
        listaMidias = new ArrayList();
        File arquivo = new File("src/Arquivos/musicas.txt");
        String linha;
        String[] dados = new String[9];
        int contador = 0;
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();
            while (linha != null) {
                if (!linha.equals("")) {
                    dados[contador] = linha;
                    contador++;
                } else {
                    adicionar(dados);
                    contador = 0;
                }
            }
            lerArq.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     *
     * Método para salvar as informações em um arquivo de texto
     *
     * @return retorna true se foi salvo com sucesso, caso contrário retorna
     * false
     */
    @Override
    protected boolean salvar() {
        String caminho = "src/Arquivos/musica.txt";
        try {
            FileWriter arq = new FileWriter(new File(caminho));
            arq.write(String.valueOf(listaMidias.size()));
            arq.write(novaLinha + novaLinha);
            String[] infor = null;

            for (Midia midia : listaMidias) {
                Musica musica = (Musica) midia;
                infor = musica.ArraytoString();
                for (int i = 0; i < infor.length; i++) {
                    arq.write(infor[i] + novaLinha);
                }
                arq.write(novaLinha);
            }
            arq.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     *
     * @param dados recebido para conter as informações que serão editadas
     * @param tituloOriginal recido para achar a música desejada
     * @return retorna true caso seja editado com sucesso, caso contrário
     * retorna false
     */
    @Override
    public boolean editar(String[] dados, String tituloOriginal) {
        int idProcurado = listaMidias.indexOf(new Musica(tituloOriginal));
        Musica procurada = (Musica) listaMidias.get(idProcurado);
        procurada.setCaminhoDoArquivo(dados[0]);
        procurada.setTitulo(dados[1]);
        procurada.setDescricao(dados[2]);
        procurada.setGenero(dados[3]);
        procurada.setAutores(dados[4]);
        procurada.setIdioma(dados[5]);
        procurada.setAno(dados[6]);
        procurada.setDuracao(dados[7]);
        procurada.setInterpretes(dados[8]);

        return salvar();
    }

    @Override
    protected Midia buscar(String [] dados, String titulo) {
        return null;
        
    }
}
