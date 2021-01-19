package ctr;

import java.util.List;

import dao.LibriDao;
import model.Libri;

public class LibriCtr {
	private LibriDao libriDao = new LibriDao();
	
	public boolean insert(Libri d) {
		boolean res = libriDao.insert(d);
		return res;		
	}
	public boolean update(Libri d) {
		boolean res = libriDao.update(d);
		return res;
	}
	public boolean remove(Libri d) {
		boolean res = libriDao.remove(d);
		return res;
	}
	public Libri findById(int id) {
		Libri res = libriDao.findById(id);
		return res;
	}
	
	public List<Libri> findAll(){
		List<Libri> res = libriDao.findAll();
		return res;
	}
}
