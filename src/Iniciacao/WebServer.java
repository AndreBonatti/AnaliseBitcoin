package Iniciacao;

import java.util.Map;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class WebServer {

	private Map<Integer, String> meuCache;

	@PostConstruct
	public void start() {
		Logger.getLogger("MeuLoggerGlobal").info("Iniciou!");
//		meuCache = new HashMap<Integer, String>();
	}

	public void addUsuario(Integer id, String nome) {
		meuCache.put(id, nome);
	}

	public String getNome(Integer id) {
		return meuCache.get(id);
	}

}
