package ups.edu.dao;

import ups.edu.modelo.Telefono;

import java.util.List;


public interface TelefonoDAO extends GenericDAO<Telefono, Integer>{
	public abstract Telefono read(String numero);
}
