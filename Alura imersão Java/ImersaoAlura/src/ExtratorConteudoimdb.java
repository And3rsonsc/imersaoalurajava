import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoimdb implements ExtratorConteudo {

    public List<Conteudo> extraiConteudos(String json){
        JsonParser xParser = new JsonParser();
        List<Map<String, String>> listaAtributos = xParser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        for (Map<String,String> atributo : listaAtributos) {
            String urlImagem = atributo.get("image");
            String titulo = atributo.get("title");
            Conteudo conteudo = new Conteudo(titulo, urlImagem);
            conteudos.add(conteudo);
        }
        return conteudos;  
    }       
}
