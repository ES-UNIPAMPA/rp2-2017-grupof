package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roliv
 */
public class CatalagoMusicas extends Catalogo {

    String novaLinha = System.getProperty("line.separator");

    public CatalagoMusicas() {
        listaMidias = new ArrayList<>();
    }

    @Override
    public boolean adicionar(String[] dados) {
        Musica musica = new Musica(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8]);
        return listaMidias.add(musica);
    }

    @Override
    public boolean remover(String Titulo) {
        Musica nova = new Musica(Titulo);
        return listaMidias.remove(nova);
    }

    @Override
    public boolean carregar() {
        listaMidias = new ArrayList();
        File arquivo = new File("src/Arquivos/musicas.txt");
        String linha;
        String[] dados = new String[10];
        int cont = 0;
        boolean retorno = true;
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
            linha = lerArq.readLine();
            while (linha != null) {
                if (!linha.equals("")) {
                    dados[cont] = linha;
                    cont++;
                } else {
                    adicionar(dados);
                    cont = 0;
                }
            }
            lerArq.close();
        } catch (IOException e) {
            retorno = false;
            return retorno;
        }
        return false;
    }

    @Override
    protected boolean salvar() {
        String caminho = "";
        String texto = "";
        try {
            FileWriter arq = new FileWriter(caminho);
            try (PrintWriter gravarArq = new PrintWriter(arq)) {
                gravarArq.println(texto);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean editar(String[] dados, String tituloOriginal) {
        return true;
    }

}
