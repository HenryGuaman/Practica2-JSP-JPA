package ups.edu.dao;

import ups.edu.modelo.Usuario;

import java.util.List;


public interface UsuarioDAO extends GenericDAO<Usuario, String> {
    public abstract Usuario findUser(String correo, String pass);
    public abstract List<Usuario> findByIdOrMail(String context);
}
