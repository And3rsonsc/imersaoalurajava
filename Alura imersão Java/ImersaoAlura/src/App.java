import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String xURL = "http://localhost:8080/tst";

        
        HttpCliente http = new HttpCliente();
        String xJsonString = http.BuscarDados(xURL);
        // Fazer uma conexão HTTP e buscar o Response no body
        ExtratorConteudoimdb extrator = new ExtratorConteudoimdb();
        List<Conteudo> conteudos = extrator.extraiConteudos(xJsonString);
        // Pegar alguns dados da String do response (Título, poster e a classificação) Extrair/Parsear os dados

        GeradoraFigurinhas geradoraFigurinhas = new GeradoraFigurinhas();
        
        System.out.println("Começando processamento de imagens"); 
        
         for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            geradoraFigurinhas.criar(inputStream, 
                                     "imagens/" + conteudo.getTitulo() + ".png"); 
            
            System.out.println("Procesando filme: " + conteudo.getTitulo()); 
                
        }
        System.out.println("Processamento de imagens finalizado"); 
        //Exibir e manipular os dados
         //FileInputStream fileInputStream = new FileInputStream(new File("imagens/filme.jpg")); lendo de arquivo
         //InputStream openStream = new URL("https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
    }
}
