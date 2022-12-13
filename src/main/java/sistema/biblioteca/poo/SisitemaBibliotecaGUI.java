package sistema.biblioteca.poo;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class SisitemaBibliotecaGUI extends JFrame {
    JLabel linha1, linha2;
    private Collection<Livro> livros = new ArrayList<Livro>();
    SistemaBiblioteca biblioteca = new SistemaBiblioteca();

    ImageIcon imagem = new ImageIcon("."+ File.separator+"src"+File.separator+"images"+File.separator+"biblioteca.png");
    JMenuBar barraDeMenu = new JMenuBar();
    GravadorDeLivros gravador = new GravadorDeLivros();
    public SisitemaBibliotecaGUI() throws IOException {

        File f = new File("src"+File.separator+"main"+File.separator+"java"+File.separator+"dcx"+File.separator+"ufpb"+File.separator+"br");
        System.out.println(f.getAbsolutePath());

        setTitle("Biblioteca");
        setSize(800, 600);
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);


        Collection<Livro> livros1 = null;

        try{
            livros1 = gravador.recuperaLivros();
            for (Livro l: livros1) {
                this.biblioteca.cadastraLivro(l.getTitulo(), l.getNomeAutor(), l.getAnoDePublicacao(), l.getCodigoDoLivro(),l.isEstahEmprestado());
            }
            JOptionPane.showMessageDialog(null, "Livros recuperados com sucesso");
        } catch (IOException| ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Livros não recuperados, erro: "+ e.getMessage());
            e.printStackTrace();
        } catch (LivroJaExistenteException e) {
            throw new RuntimeException(e);
        }

        linha1 = new JLabel("Livros, quadrinhos e lan house", JLabel.CENTER);
        linha1.setForeground(Color.blue);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(imagem, JLabel.CENTER);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarLivro = new JMenuItem("Cadastrar livro");
        menuCadastrar.add(menuCadastrarLivro);

        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarLivro = new JMenuItem("Pesquisar livro");
        menuPesquisar.add(menuPesquisarLivro);

        JMenuItem menuPesquisarLivrosEmAtraso = new JMenuItem("Pesquisar livro em atraso");
        menuPesquisar.add(menuPesquisarLivrosEmAtraso);

        JMenuItem menuPesquisarLivrosDoAutor = new JMenuItem("Pesquisar livro de autor x");
        menuPesquisar.add(menuPesquisarLivrosDoAutor);

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverLivro = new JMenuItem("Remover livro");
        menuRemover.add(menuRemoverLivro);

        JMenu menuSalvar = new JMenu("Salvar");
        JMenuItem menuSalvarLivro = new JMenuItem("Salvar livro");
        menuSalvar.add(menuSalvarLivro);

        menuPesquisarLivro.addActionListener(new SisBLivroSearchController(biblioteca, this));
        menuPesquisarLivrosEmAtraso.addActionListener(new SisBLivroEmAtrasoSearchController(biblioteca, this));
        menuPesquisarLivrosDoAutor.addActionListener(new SisBLivrosDeAutorSearchController(biblioteca, this));


        menuRemoverLivro.addActionListener(new SistemaBibliotecaRemoveController(biblioteca, this));

        menuCadastrarLivro.addActionListener((ae) -> {
            String titulo = JOptionPane.showInputDialog(this, "Qual o titulo do livro?");
            String nomeAutor = JOptionPane.showInputDialog(this, "Qual o nome do autor do livro?");
            int anoDePublicacao = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano de publicação do livro?"));
            int codigoDoLivro = Integer.parseInt(JOptionPane.showInputDialog("Qual o codigo do livro?"));
            boolean estahEmprestado = false;
            boolean cadastrou = false;
            try {
                cadastrou = biblioteca.cadastraLivro(titulo, nomeAutor, anoDePublicacao, codigoDoLivro, estahEmprestado);
                livros.add(new Livro(titulo,nomeAutor,anoDePublicacao,codigoDoLivro, estahEmprestado));
            } catch (LivroJaExistenteException e) {
                System.out.println(e);
            }
            if (cadastrou) {
                JOptionPane.showMessageDialog(this, "Livro registrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(this, "Livro não foi registrado.");
            }
        });
        menuSalvarLivro.addActionListener(new SistemaBibliotecaSaveController(biblioteca, this, gravador));

        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuSalvar);
        setJMenuBar(barraDeMenu);

    }

    public static void main(String[] args) throws IOException {
        JFrame janela = new SisitemaBibliotecaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
