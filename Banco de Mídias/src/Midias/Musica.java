package Midias;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Matheus Montanha
 */
public class Musica extends Midia implements Comparable<Musica> {

    private String interpretes;
    private String duracao;

    public Musica(String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano, String interpretes, String duracao) {
        super(CaminhoDoArquivo, titulo, genero, idioma, descricao, autores, ano);
        this.interpretes = interpretes;
        this.duracao = duracao;
    }

    public Musica(String titulo) {
        super(titulo);
    }

    public Musica(List lista) {
        super(lista);
    }

    public String getInterpretes() {
        return interpretes;
    }

    public void setInterpretes(String interpretes) {
        this.interpretes = interpretes;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        String dados;
        //String CaminhoDoArquivo, String titulo, String genero, String idioma, String descricao, String autores, String ano, String interpretes, String duracao
        dados = this.CaminhoDoArquivo + "\n" + this.titulo + "\n" + this.genero + "\n" + this.idioma + "\n" +  this.descricao + "\n" + this.autores + "\n" + this.ano + "\n" + this.interpretes + "\n" + this.duracao + "\n";
        return dados;
    }

    @Override
    public String toFile() {
        String dados;
        dados = super.toFile() + "\n" + this.interpretes + "\n" + this.duracao + "\n";
        return dados;
    }

    public String[] ArraytoString() {
        String[] dados = new String[9];
        dados[0] = this.CaminhoDoArquivo;
        dados[1] = this.titulo;
        dados[2] = this.genero;
        dados[3] = this.idioma;
        dados[4] = this.descricao;
        dados[5] = this.autores;
        dados[6] = this.ano;
        dados[7] = this.interpretes;
        dados[8] = this.duracao;
        return dados;
    }

    @Override
    public int compareTo(Musica o) {
        if (Integer.parseInt(ano) > Integer.parseInt(o.ano)) {
            return -1;
        }
        if (Integer.parseInt(ano) < Integer.parseInt(o.ano)) {
            return 1;
        }
        return 0;
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
        final Musica other = (Musica) obj;
        if (!Objects.equals(this.interpretes, other.interpretes)) {
            return false;
        }
        if (!Objects.equals(this.duracao, other.duracao)) {
            return false;
        }
        return true;
    }

}
