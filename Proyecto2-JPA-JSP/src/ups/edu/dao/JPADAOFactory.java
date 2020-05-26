package ups.edu.dao;


import ups.edu.mysql.jdbc.JPATelefonoDAO;
import ups.edu.mysql.jdbc.JPAUsuarioDAO;


public class JPADAOFactory extends DAOFactory{

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new JPAUsuarioDAO();
    }

    @Override
    public TelefonoDAO getTelefonoDAO() {
        return new JPATelefonoDAO();
    }
    
}
