package ar.edu.utn.frba.tadp.dao;

import java.util.List;

import ar.edu.utn.frba.tadp.entity.Usuario;

public interface IUsuarioDao {
	
    public void addUser(Usuario user);
    
    public List<Usuario> getAllUsers();
    
    public void deleteUser(Integer userId);
    
    public void updateUser(Usuario user);
    
    Usuario findById(Integer id);
}
