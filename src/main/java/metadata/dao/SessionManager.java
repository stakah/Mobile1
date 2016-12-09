package metadata.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Gerenciador de Sessões
 * 
 * @generated
 */
public class SessionManager {
  /**
   * Nome da unidade de persistência
   * 
   * @generated
   */
  private static final String PERSISTENCE_UNIT = "metadata";
  
  private static final String CLOUD_DB_FILE_LOCATION = "META-INF/cloud_db.properties";
  
  private static final Map<String, String> drivers = new HashMap<String, String>() {
    private static final long serialVersionUID = -5825874650070642307L;
    
    {
      put("mysql", "com.mysql.jdbc.Driver");
      put("ojdbc", "oracle.jdbc.OracleDriver");
      put("oracle", "oracle.jdbc.OracleDriver");
      put("sqlserver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
      put("sql-server", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
      put("postgres", "org.postgresql.Driver");
      put("postgresql", "org.postgresql.Driver");
      put("derby", "org.apache.derby.jdbc.EmbeddedDriver");
    }
  };
  
  /**
   * Gerenciador de Entidades
   * 
   * @generated
   */
  @PersistenceContext(unitName = PERSISTENCE_UNIT, type = PersistenceContextType.TRANSACTION)
  private EntityManager entityManager;
  /**
   * Fábrica de Gerenciadores de Entidade
   * 
   * @generated
   */
  private EntityManagerFactory factory;
  /**
   * Thread Local
   * 
   * @generated
   */
  private static ThreadLocal<SessionManager> threadLocal = new ThreadLocal<>();
  
  /**
   * Obtém Instância
   * 
   * @param recreate
   *          reaproveitar intância?
   * @return Gerenciador de Sessões
   * @generated
   */
  public static SessionManager getInstance(boolean recreate) {
    if(threadLocal.get() == null) {
      threadLocal.set(new SessionManager(recreate));
    }
    
    return threadLocal.get();
  }
  
  /**
   * Obtém Instância
   * 
   * @return Gerenciador de Sessões
   * @generated
   */
  public static SessionManager getInstance() {
    if(threadLocal.get() == null) {
      threadLocal.set(new SessionManager(false));
    }
    
    return threadLocal.get();
  }

  /**
   * Construtor
   * 
   * @param recreate
   *          Recriar?
   */
  private SessionManager(boolean recreate) {
    
    TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
    TimeZone.setDefault(timeZone);
    
    Properties properties = new Properties();
    
    InputStream cloudDbFile = this.getClass().getClassLoader().getResourceAsStream(CLOUD_DB_FILE_LOCATION);
    
    if(cloudDbFile != null) {
      properties = readCloudProperties(cloudDbFile);
    }
    
    this.factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, properties);
    this.entityManager = this.factory.createEntityManager();
  }
  
  private Properties readCloudProperties(InputStream cloudDbFile) {
    Properties cloudProperties = new Properties();
    
    Properties envProperties = new Properties();
    
    // busca as variáveis de ambiente
    try {
      cloudProperties.load(cloudDbFile);
      
      String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
      
      if(VCAP_SERVICES != null && !VCAP_SERVICES.trim().isEmpty()) {
        JsonReader jsonReader = Json.createReader(new StringReader(VCAP_SERVICES));
        JsonObject vcapObject = jsonReader.readObject();
        
          String envVar = (String)cloudProperties.get("jdbc/main");
          
          //obtém a variável de ambiente associada a conexão  
          if(vcapObject.containsKey(envVar)) {
            
            JsonObject objEnvVar = ((JsonArray)vcapObject.get(envVar)).getJsonObject(0);
            String uriString = objEnvVar.getJsonObject("credentials").getString("uri");
            
            //a partir da uri de conexão, monta os parâmetros da URL
            URI uri = new URI(uriString);
            String username = "";
            String password = "";
            
            if(uri.getUserInfo() != null) {
              String[] userInfo = uri.getUserInfo().split(":");
              username = userInfo[0];
              password = userInfo[1];
            }
            
            String provider = uri.getScheme();
            if(provider.equals("postgres")){
            	provider = "postgresql";
            }
            
            String url = String.format("jdbc:%s://%s:%s%s", provider, uri.getHost(), uri.getPort(),
                    uri.getPath());
            
            String driver = getDriverByScheme(provider);
            
            envProperties.put("javax.persistence.jdbc.driver", driver);
            envProperties.put("javax.persistence.jdbc.url", url);
            envProperties.put("javax.persistence.jdbc.user", username);
            envProperties.put("javax.persistence.jdbc.password", password);
            
            System.out.println("Contém propriedades: " + envProperties);

          }
		   jsonReader.close();
        }
    }
    
    catch(IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    
    return envProperties;
  }
  
  private String getDriverByScheme(String scheme) {
    return drivers.get(scheme);
  }
  
  /**
   * Iniciar
   * 
   * @generated
   */
  public void begin() {
    if(!this.entityManager.getTransaction().isActive()) {
      this.entityManager.getTransaction().begin();
    }
  }
  
  /**
   * Sessão é ativa?
   * 
   * @return booleano, indicado se a sessão esta ou não ativa
   * @generated
   */
  public boolean isActive() {
    return this.entityManager.getTransaction().isActive();
  }
  
  /**
   * Persistir dados da sessão
   * 
   * @generated
   */
  public void commit() {
    if(this.entityManager.getTransaction().isActive()) {
      try {
        this.entityManager.getTransaction().commit();
      }
      catch(Exception e) {
        try {
          this.entityManager.getTransaction().rollback();
        }
        catch(Exception e2) {
          // No action
        }
        throw e;
      }
    }
  }
  
  /**
   * Fechar
   * 
   * @generated
   */
  public void close() {
    this.entityManager.close();
    this.factory.close();
  }
  
  /**
   * Liberar dados da sessão
   * 
   * @generated
   */
  public void flush() {
    this.entityManager.flush();
  }
  
  /**
   * Desfazer
   * 
   * @generated
   */
  public void rollBack() {
    try {
      if(this.entityManager.getTransaction().isActive()) {
        this.entityManager.getTransaction().rollback();
      }
    }
    catch(Exception e) {
      // No action
    }
  }
  
  /**
   * Obtém Gerenciador de Entidades
   * 
   * @return Gerenciador de Entidades
   * @generated
   */
  public EntityManager getEntityManager() {
    return this.entityManager;
  }
  
  /**
   * Limpa instância, caso ela exista
   * 
   * @generated
   */
  public static void clearInstance() {
    SessionManager sessionManager = threadLocal.get();
    if(sessionManager != null) {
      sessionManager.getEntityManager().clear();
    }
  }
}