package ctr;

import java.util.List;

import dao.TurniDao;
import model.Turni;

public class TurniCtr {
	private TurniDao turniDao = new TurniDao();
	
	public boolean insert(Turni d) {
		boolean res = turniDao.insert(d);
		return res;
	}
	public boolean update(Turni d) {
		boolean res = turniDao.update(d);
		return res;
	}
	public boolean remove(Turni d) {
		boolean res = turniDao.remove(d);
		return res;
	}
	public Turni findByID(int id) {
		Turni res = turniDao.findById(id);
		return res;
	}
	public List<Turni> findAll() {
		List<Turni> res = turniDao.findAll();
		return res;
	}
}
