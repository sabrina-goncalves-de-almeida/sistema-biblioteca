package sistema.biblioteca.poo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorDeLivros {
    private String fileName = "livros.txt";

    public void gravaLivros( Collection<Livro> livros) throws IOException {
        ObjectOutputStream gravador = null;
        try {
            gravador = new ObjectOutputStream(new FileOutputStream(fileName));
            ArrayList<Livro> livrosASalvar = new ArrayList<>(livros);
            gravador.writeObject(livrosASalvar);
        } finally {
            if (gravador != null){
                gravador.close();
            }
        }
    }

    public Collection<Livro> recuperaLivros() throws IOException, ClassNotFoundException{
        ObjectInputStream leitor = null;
        try {
            leitor = new ObjectInputStream( new FileInputStream(fileName) );
            Collection<Livro> livrosLidos = (Collection<Livro>) leitor.readObject();
            return livrosLidos;
        } finally {
            if (leitor != null){
                leitor.close();
            }
        }
    }
}
