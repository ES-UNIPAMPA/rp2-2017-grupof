package Midias;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AllissonChervenski
 */
public class Podcast extends Midia {
    
    public Podcast(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
    }
    public Podcast(String titulo){
    super(titulo);
    
    }
    
    public String[] ArraytoString(){
        String[] dados = new String[7];
        dados[0] = this.CaminhoDoArquivo;
        dados[1] = this.titulo;
        dados[2] = this.descricao;
        dados[3] = this.genero;
        dados[4] = this.autores;
        dados[5] = this.idioma;
        dados[6] = this.ano;
        return dados;
    }
    
    
    @Override
    public String toString(){
        String dados = this.CaminhoDoArquivo + "\n" + this.titulo + "\n" + this.genero + "\n" + this.idioma + "\n" + this.descricao + "\n" + this.autores + "\n" + this.ano;
        return dados;
    }
     @Override
    public String toFile() {
        String dados;
        dados = super.toFile();
        return dados;
    }
    
    public static List toArray(Podcast p){
        List<Podcast> podlist = new ArrayList<>();
        podlist.add(p);
        return podlist;
    }
     
    public int compareTo(Podcast o) {
        if (Integer.parseInt(ano) > Integer.parseInt(o.ano)) {
            return -1;
        }
        if (Integer.parseInt(ano) < Integer.parseInt(o.ano)) {
            return 1;
        }
        return 0;
    }
    
 
}
