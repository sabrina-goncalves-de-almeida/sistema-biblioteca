package sistema.biblioteca.poo;

import java.io.Serializable;

public class Livro implements Serializable {

    private String titulo;
    private String nomeAutor;
    private int anoDePublicacao;
    private int codigoDoLivro;
    private boolean estahEmprestado;

    public Livro(String titulo, String nomeAutor, int anoDePublicacao, int codigoDoLivro, boolean estahEmprestado){
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.anoDePublicacao = anoDePublicacao;
        this.codigoDoLivro = codigoDoLivro;
        this.estahEmprestado = estahEmprestado;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return this.nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getAnoDePublicacao() {
        return this.anoDePublicacao;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }

    public int getCodigoDoLivro() {
        return this.codigoDoLivro;
    }

    public void setCodigoDoLivro(int codigoDoLivro) {
        this.codigoDoLivro = codigoDoLivro;
    }

    public boolean isEstahEmprestado() {
        return this.estahEmprestado;
    }

    public void setEstahEmprestado(boolean estahEmprestado) {
        this.estahEmprestado = estahEmprestado;
    }

    @Override
    public String toString() {
        return "Livro de titulo: '" + titulo +
                "', ano de publicação: " + anoDePublicacao +
                ", de código:" + codigoDoLivro;
    }
}
