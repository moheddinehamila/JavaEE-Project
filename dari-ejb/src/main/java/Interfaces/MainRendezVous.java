package Interfaces;


import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import Entities.RendezVous;
import Services.RendezVousService;
import Services.RendezVousServiceAWS;
public class MainRendezVous {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		
	//	RendezVousServiceAWS rdv = new RendezVousServiceAWS();
		//String rdvList =  rdv.GetAll();			
		//System.out.println(rdvList);
 		
		
		RendezVousService rdv = new RendezVousService();
		//rdv.update(3, "Jee20", "06/03/2020 12:12:12", "06/03/2020 13:12:12","green",
		//"1f6fb3f4-a6ab-4818-91ea-16cc9f7b6e91", "445ba7a8-faf1-4990-bdf9-dcef0b1e6e01",
		//false, false, "ya rabi temchi");
	//List<RendezVous> lrdv = rdv.GetAll();
		
		//for (RendezVous myrdv : lrdv) {
			
			//System.out.println(myrdv);
 		//}
	//	System.out.println(rdv.Getbyid(21));

		//System.out.println("*************");
		//RendezVous rdva= new RendezVous(1,"testjee" , "06/06/2020 12:12:12", "06/06/2020 15:12:12"
			//	, "red", "1f6fb3f4 - a6ab - 4818 - 91ea - 16cc9f7b6e91", "445ba7a8-faf1-4990-bdf9-dcef0b1e6e01"
				//, false, true, "ya rabi temchi");
		
		rdv.addrdv(1,"testjaaee" , "06/06/2020 12:12:12", "06/06/2020 15:12:12"
				, "red", "1f6fb3f4 - a6ab - 4818 - 91ea - 16cc9f7b6e91", "445ba7a8-faf1-4990-bdf9-dcef0b1e6e01"
				, false, true, "ya rabi temchi");
		
		
	}

}
