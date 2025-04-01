package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Usuario;
import app.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        List<Usuario> lista = this.usuarioRepository.findAll();
            return lista;
        
    }

     public String save (Usuario usuario){

        this.usuarioRepository.save(usuario);
        return "marca salva com sucesso";

    }
     public List<Usuario> findByNome(String nome){
        return this.usuarioRepository.findByNome(nome);

    }

    public String delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            return "Erro: Usuario com ID " + id + " não encontrado.";
        }
    
        usuarioRepository.deleteById(id);
        return "Usuario removido com sucesso";
    }
    

    public String update(Usuario usuario, Long id) {
        if (!usuarioRepository.existsById(id)) {
            return "Erro: Marca com ID " + id + " não encontrada.";
        }
        
        usuario.setUserId(id);
        usuarioRepository.save(usuario);
        return "Usuario atualizado com sucesso";
    }
    
     public Usuario findById(Long id){
        Usuario usuario = this.usuarioRepository.findById(id).get();
        return usuario;
    }

}
