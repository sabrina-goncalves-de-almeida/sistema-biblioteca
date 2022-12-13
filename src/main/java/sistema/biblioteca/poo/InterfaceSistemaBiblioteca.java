package sistema.biblioteca.poo;

import java.util.ArrayList;
import java.util.List;

public interface InterfaceSistemaBiblioteca {

    boolean cadastraLivro(String titulo, String nomeAutor, int anoDePublicacao, int codigoDoLivro, boolean estahEmprestado) throws LivroJaExistenteException;

    boolean removerLivro(int codigoDoLivro) throws LivroNaoExistenteException;

    String pesquisarLivroEmprestado(int codigoDoLivro) throws LivroNaoExistenteException ;

    ArrayList<Livro> pesquisarLivrosEmAtraso();

    ArrayList<Livro> pesquisarLivroPorAutor(String nomeAutor);
}
