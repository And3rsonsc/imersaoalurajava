package com.and3rsonsc.treinamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {
    @Autowired
	private LingRepository repositorio;
	/*private List<Linguagem> linguagens = 
			List.of( new Linguagem("JAVA", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_512x512.png", 1),
					 new Linguagem("C", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/c/c_512x512.png", 2),
					 new Linguagem("KOTLIN", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/kotlin/kotlin_512x512.png", 3)
			);*/
	
	@GetMapping(value="/linguagem")
	public String buscaLinguagemPreferida() {
		return "Jelphi";
	}
	
	@GetMapping(value="/tst")
	public List<Linguagem> obterLinguagens() {
		List<Linguagem> linguagens = repositorio.findAll();
		return linguagens;
	}
	
	@PostMapping(value="/tst")
	public Linguagem gravarLinguagem(@RequestBody Linguagem linguagem) {
		return repositorio.save(linguagem);
	}
	
}
