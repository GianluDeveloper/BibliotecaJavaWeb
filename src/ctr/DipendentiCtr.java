package ctr;

import java.util.List;

import dao.DipendentiDao;
import model.Dipendenti;

public class DipendentiCtr {
	private DipendentiDao dipendentiDao = new DipendentiDao();
	
	public boolean insert(Dipendenti d) {
		boolean res = dipendentiDao.insert(d);
		return res;
	}
	public boolean update(Dipendenti d) {
		boolean res = dipendentiDao.update(d);
		return res;
	}
	public boolean remove(Dipendenti d) {
		boolean res = dipendentiDao.remove(d);
		return res;
	}
	
	public Dipendenti findById(int id) {
		Dipendenti res = dipendentiDao.findById(id);
		return res;
	}
	
	public List<Dipendenti> findAll() {
		List<Dipendenti> res = dipendentiDao.findAll();
		return res;
	}
}
