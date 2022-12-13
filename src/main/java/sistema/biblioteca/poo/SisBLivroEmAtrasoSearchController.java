package sistema.biblioteca.poo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SisBLivroEmAtrasoSearchController implements ActionListener {

    private SistemaBiblioteca biblioteca;
    private JFrame janelaPrincipal;
    public SisBLivroEmAtrasoSearchController(SistemaBiblioteca biblioteca, JFrame janela){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        int codigoDoLivro = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o código do livro a pesquisar?"));

        String livrosEmAtraso = "";
        try {
            livrosEmAtraso = biblioteca.pesquisarLivroEmprestado(codigoDoLivro);
            JOptionPane.showMessageDialog(janelaPrincipal, livrosEmAtraso);
        } catch (LivroNaoExistenteException ex) {
            throw new RuntimeException(ex);
        }
    }
}
