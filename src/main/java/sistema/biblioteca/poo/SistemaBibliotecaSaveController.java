package sistema.biblioteca.poo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SistemaBibliotecaSaveController implements ActionListener {
    private SistemaBiblioteca sistema;

    private GravadorDeLivros gravador;

    private JFrame janelaPrincipal;

    public SistemaBibliotecaSaveController(SistemaBiblioteca sistemaBiblioteca, JFrame janela, GravadorDeLivros gravador){
        this.sistema = sistemaBiblioteca;
        this.janelaPrincipal = janela;
        this.gravador = gravador;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            gravador.gravaLivros(sistema.getLivros());
            JOptionPane.showMessageDialog(janelaPrincipal, "Livros salvos com sucesso");
        }catch (IOException ioException){
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi possivel salvar os novos livros cadastrados");
            ioException.printStackTrace();
        }
    }
}
