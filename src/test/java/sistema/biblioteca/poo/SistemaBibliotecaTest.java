package sistema.biblioteca.poo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class SistemaBibliotecaTest {

    @Test
    public void TestaCadastraLivro(){
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        try{
            sistema.cadastraLivro("Uma noite de verão","Maria", 2002,001, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        livros = sistema.getLivros();
        for (Livro l:livros) {
            System.out.println(l.getCodigoDoLivro());
        }
    }
    @Test
    public void TestaRemoveLivro(){
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        try{
            sistema.cadastraLivro("Uma noite de verão","Maria", 2002,001, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Os lobos","Ana", 2016,002, true);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }

        sistema.removerLivro(001);

        livros = sistema.getLivros();
        for (Livro l:livros) {
            System.out.println(l.getCodigoDoLivro());
        }
    }

    @Test
    public void TestaPesquisarLivro() throws LivroNaoExistenteException {
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        String titulo = "";
        try{
            sistema.cadastraLivro("Uma noite de verão","Maria", 2002,001, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Os lobos","Ana", 2016,002, true);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Colorindo entre as linhas","Beatriz", 1989,003, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }

        try {
            titulo = sistema.pesquisarLivro("Uma noite de verão");
        } catch (LivroNaoExistenteException e) {
            throw new RuntimeException(e);
        }
        System.out.println(titulo);
    }
    @Test
    public void TestaPesquisarLivroEmprestado(){
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        try{
            sistema.cadastraLivro("Uma noite de verão","Maria", 2002,001, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Os lobos","Ana", 2016,002, true);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }

        String livro = "";
        try {
            livro = sistema.pesquisarLivroEmprestado(002);
        } catch (LivroNaoExistenteException e) {
            throw new RuntimeException(e);
        }
        assertEquals("Este livro está emprestado!",livro);
        try {
            livro = sistema.pesquisarLivroEmprestado(001);
        } catch (LivroNaoExistenteException e) {
            throw new RuntimeException(e);
        }
        assertEquals("Este livro ainda está na biblioteca",livro);

    }
    @Test
    public void TestaPesquisarLivrosEmAtraso(){
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        ArrayList<Livro> livrosEmAtraso = new ArrayList<Livro>();
        try{
            sistema.cadastraLivro("Uma noite de verão","Maria", 2002,001, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Os lobos","Ana", 2016,002, true);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Colorindo entre as linhas","Beatriz", 1989,003, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }

        livrosEmAtraso = sistema.pesquisarLivrosEmAtraso();
        for (Livro l:livrosEmAtraso) {
            System.out.println(l.getCodigoDoLivro());
        }
    }

    @Test
    public void TestaPesquisarLivroPorAutor(){
        SistemaBiblioteca sistema = new SistemaBiblioteca();
        ArrayList<Livro> livrosEmAtraso = new ArrayList<Livro>();
        try{
            sistema.cadastraLivro("Uma noite de verão","Maria", 2002,001, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Os lobos","Ana", 2016,002, true);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }
        try{
            sistema.cadastraLivro("Colorindo entre as linhas","Maria", 1989,003, false);
        }catch (LivroJaExistenteException e){
            System.out.println(e.getMessage());
        }

        livrosEmAtraso = sistema.pesquisarLivroPorAutor("Maria");
        for (Livro l:livrosEmAtraso) {
            System.out.println("Livro de titulo: "+l.getTitulo()+". Publicado em: "+l.getAnoDePublicacao());
        }
    }
}
