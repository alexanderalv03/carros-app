package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Acessorio;
import app.repository.AcessorioRepository;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public String save (Acessorio acessorio){
        this.acessorioRepository.save(acessorio);
        return "acessorio salvo com sucesso";
    }

    public String update (Acessorio acessorio, Long id){

        acessorio.setId(id);
        this.acessorioRepository.save(acessorio);
        return "carro atualizado com sucesso";

    }

    public List<Acessorio> findAll(){
        List<Acessorio> lista = this.acessorioRepository.findAll();
            return lista;
        
    }

    public String delete(Long id){
        this.acessorioRepository.deleteById(id);
        return "Carro deletado com sucesso";

    }

    public Acessorio findById(Long id){
        Acessorio acessorio = this.acessorioRepository.findById(id).get();
        return acessorio;
    }

    public List<Acessorio> findByNome(String nome){
        return this.acessorioRepository.findByNome(nome);

    }




}
