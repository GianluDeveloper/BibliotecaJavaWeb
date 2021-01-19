package ctr;

import java.util.List;

import dao.RegistroLibriDao;
import model.Registro;

public class RegistroLibriCtr {
	private RegistroLibriDao registroLibriDao = new RegistroLibriDao();
	
	public boolean insert(Registro d) {
		boolean res = registroLibriDao.insert(d);
		return res;
	}
	public boolean update(Registro d) {
		boolean res = registroLibriDao.update(d);
		return res;
	}
	public boolean remove(Registro d) {
		boolean res = registroLibriDao.remove(d);
		return res;
	}
	public Registro findById(int id) {
		Registro res = registroLibriDao.findById(id);
		return res;
	}
	public List<Registro> findAll() {
		List<Registro> res = registroLibriDao.findAll();
		return res;
	}
}
