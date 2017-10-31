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
    private int numPaginas;    

    public Ebook(String local, String editora, int numPaginas, String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, int ano) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.local = local;
        this.editora = editora;
        this.numPaginas = numPaginas;
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

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
}
