package sistema.biblioteca.poo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SisBLivroSearchController  implements ActionListener {
    private SistemaBiblioteca biblioteca;
    private JFrame janelaPrincipal;
    public SisBLivroSearchController(SistemaBiblioteca biblioteca, JFrame janela){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        String titulo = JOptionPane.showInputDialog(janelaPrincipal, "Qual o título do livro a pesquisar");

        String livro = "";
        try {
            livro = biblioteca.pesquisarLivro(titulo);
            JOptionPane.showMessageDialog(janelaPrincipal, livro);
        } catch (LivroNaoExistenteException ex) {
            throw new RuntimeException(ex);
        }
    }
}
