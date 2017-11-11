package dominio;

import Midias.Midia;
import java.util.List;

/**
 *
 * @author roliv
 */
public abstract class Catalogo {

    protected List<Midia> listaMidias;

    abstract public boolean adicionar(String[] dados);

    abstract public boolean remover(String nome);

    abstract public boolean editar(String[] dados, String tituloOriginal);

    abstract public boolean carregar();

    abstract protected boolean salvar();

    abstract public Midia buscar(String [] dados, String titulo);
}
