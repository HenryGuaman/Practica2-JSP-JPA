package ups.edu.dao;
import java.util.List;

import ups.edu.modelo.Telefono;
import ups.edu.modelo.Usuario;

public interface GenericDAO<T, ID> {

    public void createTable();

    public void create(T entity);
    
    public T read(ID id);

    public T findById(ID id);

    public void update(T entity);

    public void delete(T entity);

    public List<T> find();
    
    Telefono read(Usuario usuario);

	List<Telefono> findByUsuario(Usuario usuario);
}
