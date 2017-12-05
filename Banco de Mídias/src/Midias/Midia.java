package Midias;

import java.util.List;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author roliv
 */
public class Midia {

    protected String CaminhoDoArquivo;
    protected String titulo;
    protected String genero;
    protected String idioma;
    protected String descricao;
    protected String autores;
    protected String ano;

    public Midia(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano) {
        this.CaminhoDoArquivo = CaminhoDoArquivo;
        this.titulo = titulo;
        this.genero = genero;
        this.idioma = idioma;
        this.descricao = descricao;
        this.autores = autores;
        this.ano = ano;
    }

    public Midia(String titulo) {
        this.titulo = titulo;
    }

    public Midia(List lista) {
        List<Midia> listaMidia = lista;
    }

    public String getCaminhoDoArquivo() {
        return CaminhoDoArquivo;
    }

    public void setCaminhoDoArquivo(String CaminhoDoArquivo) {
        this.CaminhoDoArquivo = CaminhoDoArquivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String toFile() {
        String dados = this.CaminhoDoArquivo + "\n" + this.titulo + "\n" + this.descricao + "\n" + this.genero + "\n" + this.autores + "\n" + this.idioma + "\n" + this.ano;
        return dados;
    }

    @Override
    public String toString() {
        return "";
    }

    public boolean equalsTitulo(String nome) {
        return this.titulo.equalsIgnoreCase(nome);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Midia other = (Midia) obj;
        if (!Objects.equals(this.CaminhoDoArquivo, other.CaminhoDoArquivo)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.genero, other.genero)) {
            return false;
        }
        if (!Objects.equals(this.idioma, other.idioma)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.autores, other.autores)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        return true;
    }

    public int compareTo(Midia o) {
        return this.titulo.compareToIgnoreCase(o.getTitulo());
    }

}
