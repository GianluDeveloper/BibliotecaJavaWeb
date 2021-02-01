//package main;
//import model.Cliente;
//import model.Dipendenti;
//import model.Libri;
//import model.Registro;
//import model.Turni;
//
//import java.util.List;
//
//import ctr.ClienteCtr;
//import dao.ClienteDao;
//import dao.DipendentiDao;
//import dao.LibriDao;
//import dao.RegistroLibriDao;
//import dao.TurniDao;
//import exceptions.CustomException;
//
//public class Main {
//	public static void main(String[] args) {
//		Cliente c1 = new Cliente(1,"ProvaCTR","SONOCTR","0000000");
//		ClienteCtr clienteCtr = new ClienteCtr();
//		try {
//			clienteCtr.insert(c1);
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		
//		c1.setNome("CAMBIATOCONCTR");
//		c1.setIdCliente(1);
//		boolean update = clienteCtr.update(c1);
//		System.out.println("Update corretto? "+update);
//		
//		c1.setIdCliente(3);
//		boolean rimosso = clienteCtr.remove(c1);
//		System.out.println("Rimozione corretta? "+rimosso);
//
//		
//		Cliente trovatoSingolo = clienteCtr.findById(4);
//		System.out.printf("Con in findById %d ho trovato il cliente '%s' '%s'\n",trovatoSingolo.getIdCliente(),
//				trovatoSingolo.getNome(),trovatoSingolo.getCognome());
//		
//		List<Cliente> clienti = clienteCtr.findAll();
//		for(int i=0;i<clienti.size();i++) {
//			Cliente trovato = clienti.get(i);
//			System.out.printf("All'id %d ho trovato il cliente '%s' '%s'\n",trovato.getIdCliente(),
//					trovato.getNome(),trovato.getCognome());
//		}
//		
//		
//	}
//	public static void mainOld(String []args){
//
//		// Clienti
//		Cliente c1 = new Cliente(1,"Cliente","Studente","1234675737");
//		
//		ClienteDao cdao = new ClienteDao();
//		cdao.insert(c1);
//		
//		///update
//		c1.setCognome("ho cambiato cognome!");
//		cdao.update(c1);
//		
//		//rimuovo un cliente
//		c1.setIdCliente(2);
//		cdao.remove(c1);
//		
//		Cliente clienteTrovato = cdao.findById(3);
//		
//		System.out.printf("Ho trovato nel database con id %d il cliente '%s' '%s' tel:'%s'\n",
//				clienteTrovato.getIdCliente(),clienteTrovato.getNome(),
//				clienteTrovato.getCognome(),clienteTrovato.getTelefono());
//		List<Cliente> clienti = cdao.findAll();
//		System.out.printf("Nella tabella ci sono %d clienti.\n",clienti.size());
//		
//		// Dipendenti
//		Dipendenti d1 = new Dipendenti(1,"Boss","Rossi","0123456789",true);
//		DipendentiDao ddao = new DipendentiDao();
//		//inserisco un dipendente
//		ddao.insert(d1);
//		// rimuovo il dipendente con l'id 2
//		d1.setMatricola(2);
//		ddao.remove(d1);
//		// aggiorno il dipendente con id 1
//		d1.setMatricola(1);
//		d1.setNome("CAMBIATO");
//		ddao.update(d1);
//		
//		
//		
//		//libri
//		Libri l1 = new Libri(1,1,2001,9,"provalibro","nuovogenere",
//				 "Eco", "asodfkaod", "casa");
//		LibriDao ldao = new LibriDao();
//		ldao.insert(l1);
//		
//		//registro
//		Registro r1 = new Registro(1,1,1,1,"12/12/2012","22/12/2012","15/12/2012");
//		RegistroLibriDao rdao = new RegistroLibriDao();
//		rdao.insert(r1);
//		
//		//turni
//		Turni t1 = new Turni(1,1,"02/12/2012","07/01/2013");
//		
//		TurniDao tdao = new TurniDao();
//		tdao.insert(t1);
//		t1.setIdDipendente(1);
//		tdao.update(t1);
//		t1.setIdTurni(3);
//		tdao.remove(t1);
//		
//		// gestione eccezioni e controllo del dato
//		Turni t2 = new Turni(1,10304,"04/01/2021","13/01/2021");
//		boolean risultatoInserimento = tdao.insert(t2);
//		if(risultatoInserimento) {
//			System.out.println("Inserimento ok");
//		}else {
//			System.out.println("L'inserimento non e' stato effettuato. "
//					+ "Problema con le foreign key?");
//		}
//		boolean risultatoUpdate = tdao.update(t2);
//		if(risultatoUpdate) {
//			System.out.println("Update ok");
//		}else {
//			System.out.println("L'update non e' stato effettuato. "
//					+ "Problema con le foreign key?");
//		}
//		Turni t3 = new Turni(1,238,"4-1/2022","4-1/2022");
//		System.out.println("Attualmente la data fine con i check di t3 e' "+
//				t3.getData_fine());
//		t3.setData_fine("04/01/2022");
//		System.out.println("Ora la data fine con i check di t3 e' "+
//				t3.getData_fine());
//		
//	}
//
//
//}
