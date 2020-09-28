package Services;



import java.util.List;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entities.AnnonceVente;




@LocalBean
@Stateless
public class VenteService {

	
	
	
	
	 public List<AnnonceVente> GetAllAnnonceVente(){
		
		
	List<AnnonceVente> ReunionP = new ArrayList<AnnonceVente>();
	
	System.out.println("---- list of private Reunion ------");
	Client cl = ClientBuilder.newClient();
	WebTarget target = cl.target("http://localhost:20281/api/listitems"); 
	//WebTarget target = cl.target("http://192.168.1.111/api/listitems"); 
	Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

//	WebTarget hello = target.path("ReunionPrive"); 

//	Response res=(Response) hello.request().get();
	Response response = invocationBuilder.get();

	//  System.out.println(res.readEntity(String.class));
//	ArrayList<ReunionPrive> post = res.readEntity(new GenericType<ArrayList<ReunionPrive>>() {});

	
	
	AnnonceVente[] listQuestion =  response.readEntity(AnnonceVente[].class);
	for (AnnonceVente p:listQuestion){
		ReunionP.add(p);
	}
System.out.println("size of list is : "+ReunionP.size()+ReunionP);

	return ReunionP;
}
	
	
	
	
	
	
	  public AnnonceVente GetAnnonceVenteById(int id) {
	    	System.out.println("***** get Reunion Prive 11111111*****");
	    	
	    	Client cl = ClientBuilder.newClient();
	    	WebTarget target = cl.target("http://localhost:20281/api/listitems/"+id); 
			//WebTarget target = cl.target("http://192.168.1.111/api/listitems/"+id); 
			Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
			Response response = invocationBuilder.get();
			AnnonceVente AnnonceVente = response.readEntity(AnnonceVente.class);
			System.out.println("*** ref ****"+AnnonceVente);
			return AnnonceVente;
	    }
	
	  
	  
	  
	  public void DeleteAnnonceById(int id) {
	    	//System.out.println("***** get ReunionPrives *****");
			List<AnnonceVente> annonceVentes = new ArrayList<AnnonceVente>();

	    	Client cl = ClientBuilder.newClient();
	    	WebTarget target = cl.target("http://localhost:20281/api/listitems/"+id);
			//WebTarget target = cl.target("http://192.168.1.111/api/listitems/"+id); 
			    	
			
			Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);

			Response response = invocationBuilder.delete();
			
//	    	Response res=(Response) t.request().delete();
			
			AnnonceVente AnnonceVente = response.readEntity(AnnonceVente.class);

	    	
			
	    }
	
	  
	  
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public Response EditAnnonceVenteById(int id, AnnonceVente R) {
	    	System.out.println("---- update AnnonceVente ----");
	    	Client cl = ClientBuilder.newClient();
	    	WebTarget target = cl.target("http://localhost:20281/api/listitems/"+id);
			//WebTarget target = cl.target("http://192.168.1.111/api/listitems/"+id); 
			 Invocation.Builder invocationBuilder =  target.request(MediaType.APPLICATION_JSON);
				Response response = invocationBuilder.put(Entity.json(R));
	    	return response;
	    }
	  
	  
	  
	  
	  public void AddAnnonceVente (AnnonceVente R) {
	    	//System.out.println("***** get ReunionPrive *****");
	    	//ReunionPrive c;
	    	Client cl = ClientBuilder.newClient();
	    	WebTarget target = cl.target("http://localhost:20281/api/listitems"); 
			//WebTarget target = cl.target("http://192.168.1.111/api/listitems"); 
			 WebTarget hello = target.path("AnnonceVente");     	

	    	Response res=(Response) hello.request().post(Entity.json(R));
			//System.out.println(res.readEntity(String.class));

	    	// pa moi System.out.println(res.getStatusInfo().getStatusCode());
	    	// p moi System.out.println(res.readEntity(String.class));
	    	// p moi Condidate cond = res.readEntity(Condidate.class);

	    }
	  
	

	  
	  
	  
}