package ups.edu.mysql.jdbc;

import ups.edu.dao.TelefonoDAO;
import ups.edu.modelo.Telefono;
import ups.edu.modelo.Usuario;
import java.util.List;
import javax.persistence.criteria.Root;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO {

	public JPATelefonoDAO() {
		super(Telefono.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Telefono> findByUsuario(Usuario usuario) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);
		// Se establece la clausula FROM
		Root<Telefono> root = criteriaQuery.from(Telefono.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("usuario"), usuario)); // criteriaQuery.multiselect(root.get(atr))
		// // Se configuran los predicados,
		// combinados por AND
		System.out.println(em.createQuery(criteriaQuery).getResultList());

		return em.createQuery(criteriaQuery).getResultList();

	}

	@Override
	public Telefono read(String numero) {
		Query query = em.createNamedQuery("read");

		query.setParameter("usuario", numero);
		Telefono telefono = (Telefono) query.getSingleResult();
		return telefono;
	}

	@Override
	public Telefono findById(Integer id) {
		// TODO Auto-generated method stub
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Telefono> criteriaQuery = criteriaBuilder.createQuery(Telefono.class);

		Root<Telefono> usuarioRoot = criteriaQuery.from(Telefono.class);

		Predicate predicate = criteriaBuilder.equal(usuarioRoot.get("cedula"), id);

		criteriaQuery.select(usuarioRoot).where(predicate);

		try {
			return em.createQuery(criteriaQuery).getSingleResult();
		} catch (NoResultException e) {
			return new Telefono();
		}
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

}
