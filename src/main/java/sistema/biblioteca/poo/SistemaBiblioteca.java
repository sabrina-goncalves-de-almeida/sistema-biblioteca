package sistema.biblioteca.poo;

import java.util.ArrayList;
import java.util.Collection;

public class SistemaBiblioteca implements InterfaceSistemaBiblioteca{

    private ArrayList<Livro> livros;

    public SistemaBiblioteca() {
        this.livros = new ArrayList<Livro>();
    }

    /* Método para cadastrar um livro no sistema
     * @param titulo do livro,
     * @param nome do autor do livro
     * @param ano da públicação do livro
     * @param código do livro
     * @param boleano para o estado de emprestimo do livro
     * @return false se não tiver ocorrido o cadastro d forma esperada, ou true se tiver ocorrido*/
    public boolean cadastraLivro(String titulo, String nomeAutor, int anoDePublicacao, int codigoDoLivro, boolean estahEmprestado) throws LivroJaExistenteException{
        boolean cadastrado = false;
        Livro l = new Livro(titulo, nomeAutor, anoDePublicacao, codigoDoLivro, estahEmprestado);
        if (livros.contains(l.getCodigoDoLivro())){
            throw new LivroJaExistenteException("Livro de código " + codigoDoLivro + " já foi registrado.");
        } else if (!livros.contains(l.getCodigoDoLivro())) {
            livros.add(l);
            cadastrado = true;
        }
        System.out.println(cadastrado);
        return cadastrado;

    }

    public boolean removerLivro(int codigoDoLivro) {
        boolean removido = false;
        for (Livro c: livros) {
            if (c.getCodigoDoLivro() == codigoDoLivro){
                livros.remove(c);
                removido = true;
                return removido;
            }
        }
        return removido;
    }

    public String pesquisarLivro(String titulo) throws LivroNaoExistenteException{
        String livro = "";
        for (Livro l: livros) {
            if (l.getTitulo().equals(titulo)){
                livro = "Livro de título: '" + l.getTitulo() + "' foi encontrado no sistema. " + pesquisarLivroEmprestado(l.getCodigoDoLivro()) + ". " ;
                return livro;
            }
        }
        throw new LivroNaoExistenteException("Livro de título '" + titulo + "' não foi encontrado!");
    }
    public String pesquisarLivroEmprestado(int codigoDoLivro) throws LivroNaoExistenteException{
        String livroEmprestado = "";
        for (Livro l: livros) {
            if (l.getCodigoDoLivro() == codigoDoLivro){
                boolean emprestado = l.isEstahEmprestado();
                if (emprestado){
                    livroEmprestado = "Este livro está emprestado!";
                }else if(!emprestado){
                    livroEmprestado = "Este livro ainda está na biblioteca";
                }
                return livroEmprestado;
            }
        }
        throw new LivroNaoExistenteException("Livro de código " + codigoDoLivro + " não foi encontrado!");
    }

    public ArrayList<Livro> pesquisarLivrosEmAtraso(){
        ArrayList<Livro> livrosEmAtraso = new ArrayList<Livro>();
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).isEstahEmprestado()){
                livrosEmAtraso.add(livros.get(i));
            }
        }
        return livrosEmAtraso;
    }

    public ArrayList<Livro> pesquisarLivroPorAutor(String nomeAutor){
        ArrayList<Livro> livrosDeAutor = new ArrayList<Livro>();
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getNomeAutor().equals(nomeAutor)){
                livrosDeAutor.add(livros.get(i));
            }
        }
        return livrosDeAutor;
    }

    public ArrayList<Livro> getLivros() {
        return this.livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

}
