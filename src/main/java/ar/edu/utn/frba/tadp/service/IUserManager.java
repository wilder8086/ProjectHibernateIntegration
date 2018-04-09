package ar.edu.utn.frba.tadp.service;

import java.util.List;

import ar.edu.utn.frba.tadp.entity.Usuario;

public interface IUserManager {
    public void addUser(Usuario user);
    
    public List<Usuario> getAllUsers();
    
    public void deleteUser(Integer userId);
}
