package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
        listaMidias.add(musica);
        return salvar();
    }

    @Override
    public boolean remover(String Titulo) {
        Musica nova = new Musica(Titulo);
        listaMidias.remove(nova);
        return salvar();
    }

    @Override
    public boolean carregar() {
        listaMidias = new ArrayList();
        File arquivo = new File("src/Arquivos/musicas.txt");
        String linha;
        String[] dados = new String[10];
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

    @Override
    public boolean editar(String[] dados, String tituloOriginal) {
        return false;

    }

}
