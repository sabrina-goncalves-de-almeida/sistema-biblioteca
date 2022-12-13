package sistema.biblioteca.poo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaBibliotecaRemoveController implements ActionListener {


    private SistemaBiblioteca biblioteca;
    private JFrame janelaPrincipal;
    public SistemaBibliotecaRemoveController(SistemaBiblioteca biblioteca, JFrame janela){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int codigoLivro = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o código do Livro a remover?"));
        boolean removeu = biblioteca.removerLivro(codigoLivro);
        if (removeu){
            JOptionPane.showMessageDialog(janelaPrincipal, "Livro removido com sucesso!");
        }else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Livro não foi encontrado.");
        }
    }
}
