package sistema.biblioteca.poo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaBibliotecaAddController implements ActionListener {
    private SistemaBiblioteca biblioteca;
    private JFrame janelaPrincipal;

    public SistemaBibliotecaAddController(SistemaBiblioteca biblioteca, JFrame janela){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String titulo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o titulo do livro?");
        String nomeDoAutor = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do autor?");
        int anoDePublicacao = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano de publicação do livro?"));
        int codigoDoLivro = Integer.parseInt(JOptionPane.showInputDialog("Qual o codigo do livro?"));
        boolean estahEmprestado = false;
        try {
            boolean cadastrou = biblioteca.cadastraLivro(titulo, nomeDoAutor,anoDePublicacao,codigoDoLivro,estahEmprestado);
            if (cadastrou) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Cliente cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(janelaPrincipal, "Cliente não foi cadastrado.");
            }
        } catch (LivroJaExistenteException ex) {
            System.out.println(ex);
        }
    }
}
