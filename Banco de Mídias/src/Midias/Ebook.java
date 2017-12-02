package Midias;

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
public class Ebook extends Midia {

    private String local;
    private String editora;
    private String numPaginas;

    public Ebook(String CaminhoDoArquivo, String titulo, String descricao, String genero,
            String autores, String idioma, String numPaginas, String editora, String local, String ano) {

        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.local = local;
        this.editora = editora;
        this.numPaginas = numPaginas;
    }

    public Ebook(String titulo) {
        super(titulo);
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(String numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        String dados;
        dados = "1. Caminho do Arquivo: " + this.CaminhoDoArquivo + "\n" + "2. Titulo: " + this.titulo + "\n" + "3. Descrição: " + this.descricao + "\n" + "4. Genero: " + this.genero + "\n" + "5. Autores: " + this.autores + "\n" + "6. Idioma: " + this.idioma + "\n" + "7. Número de Páginas: " + this.numPaginas + "\n" + "8. Editora: " + this.editora + "\n" + "9. Local: " + this.local + "\n" + "10. Ano: " + this.ano;
        return dados;
    }
    
    @Override
    public String toFile() {
        String dados;
        dados = super.toFile() + "\n" + this.numPaginas + "\n" + this.editora + "\n" + this.local;
        return dados;
    }
    
    @Override
    public int compareTo(Midia o) {
        return this.titulo.compareToIgnoreCase(o.getTitulo());
    }
    
//    public String[] toArrayString() {
//        String[] dados = new String[10];
//        dados[0] = this.CaminhoDoArquivo;
//        dados[1] = this.titulo;
//        dados[2] = this.descricao;
//        dados[3] = this.genero;
//        dados[4] = this.autores;
//        dados[5] = this.idioma;
//        dados[6] = this.numPaginas;
//        dados[7] = this.editora;
//        dados[8] = this.local;
//        dados[9] = this.ano;
//
//        return dados;
//
//    }

    //substitui o equals para comparar o titulo dos obj
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
        final Ebook other = (Ebook) obj;
        if (!Objects.equals(this.local, other.local)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        if (!Objects.equals(this.numPaginas, other.numPaginas)) {
            return false;
        }
        return true;
    }

}
