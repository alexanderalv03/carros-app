package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.entity.Marca;
import app.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> findAll(){
        List<Marca> lista = this.marcaRepository.findAll();
            return lista;
        
    }

     public String save (Marca marca){

        this.marcaRepository.save(marca);
        return "marca salva com sucesso";

    }
     public List<Marca> findByNome(String nome){
        return this.marcaRepository.findByNome(nome);

    }

    public String delete(Long id) {
        if (!marcaRepository.existsById(id)) {
            return "Erro: Marca com ID " + id + " não encontrada.";
        }
    
        marcaRepository.deleteById(id);
        return "Marca removida com sucesso";
    }
    

    public String update(Marca marca, Long id) {
        if (!marcaRepository.existsById(id)) {
            return "Erro: Marca com ID " + id + " não encontrada.";
        }
        
        marca.setMarcaId(id);
        marcaRepository.save(marca);
        return "Marca atualizada com sucesso";
    }
    
     public Marca findById(Long id){
        Marca marca = this.marcaRepository.findById(id).get();
        return marca;
    }






}
