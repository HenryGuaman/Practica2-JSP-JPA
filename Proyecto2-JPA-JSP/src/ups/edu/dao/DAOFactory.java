package ups.edu.dao;

public abstract class DAOFactory {

	protected static DAOFactory factory = new JPADAOFactory();

	public static DAOFactory getDAOFactory() {
		return factory;
	}

	public abstract UsuarioDAO getUsuarioDAO();

	public abstract TelefonoDAO getTelefonoDAO();
}
