package ups.edu.mysql.jdbc;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ups.edu.dao.JPADAOFactory;
import ups.edu.dao.UsuarioDAO;
import ups.edu.modelo.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, String> implements UsuarioDAO {

	public JPAUsuarioDAO() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario findById(String id) {
		// TODO Auto-generated method stub
		
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
		
		Root<Usuario> usuarioRoot = criteriaQuery.from(Usuario.class);
		
		Predicate predicado = criteriaBuilder.equal(usuarioRoot.get("cedula"), id);
		
		criteriaQuery.select(usuarioRoot).where(predicado);
		
		try {
			return em.createQuery(criteriaQuery).getSingleResult();
		}catch(NoResultException e) {
			return new Usuario();
		}

	}

	@Override
	public Usuario findUser(String correo, String pass) {
		Usuario user = new Usuario();
		String consulta =("SELECT u FROM Usuario u WHERE u.correo='"+correo+"'and u.pass='"+pass+"'");
		try {
			user= (Usuario) em.createQuery(consulta).getSingleResult();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return user;
	}

	@Override
	public List<Usuario> findByIdOrMail(String context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

}
