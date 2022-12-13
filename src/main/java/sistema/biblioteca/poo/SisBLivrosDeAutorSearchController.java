package sistema.biblioteca.poo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SisBLivrosDeAutorSearchController implements ActionListener {

    private SistemaBiblioteca biblioteca;
    private JFrame janelaPrincipal;
    public SisBLivrosDeAutorSearchController(SistemaBiblioteca biblioteca, JFrame janela){
        this.biblioteca = biblioteca;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        String nomeDoAutor = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do autor a pesquisar");

        ArrayList<Livro> livrosDoAutor = biblioteca.pesquisarLivroPorAutor(nomeDoAutor);
        if (livrosDoAutor.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal, "Livros encontrados: ");
            for (Livro l: livrosDoAutor) {
                JOptionPane.showMessageDialog(janelaPrincipal, l.toString());
            }
        }else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum livro do autor: "+ nomeDoAutor );
        }
    }
}
