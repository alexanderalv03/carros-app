package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {



    @Autowired
    private CarroRepository carroRepository;

    public String save (Carro carro){

        this.verificarNomeCarro(carro.getNome(), carro.getAno());
        this.carroRepository.save(carro);
        return "carro salvo com sucesso";

    }

    public boolean verificarNomeCarro(String nome, int ano){
        if(nome.equals("Jeep Compass") && ano < 2006)
        throw new RuntimeException();

        return true;
    }

    public String update (Carro carro, Long id){

        this.verificarNomeCarro(carro.getNome(), carro.getAno());
        carro.setId(id);
        this.carroRepository.save(carro);
        return "carro atualizado com sucesso";

    }

    public List<Carro> findAll(){
        List<Carro> lista = this.carroRepository.findAll();
            return lista;
        
    }

    public String delete(Long id){
        this.carroRepository.deleteById(id);
        return "Carro deletado com sucesso";

    }

    public Carro findById(Long id){
        Carro carro = this.carroRepository.findById(id).get();
        return carro;
    }

    public List<Carro> findByNome(String nome){
        return this.carroRepository.findByNome(nome);

    }
    

    public List<Carro> findAcimaAno(int ano){
        return this.carroRepository.findAcimaAno(ano);

    }
}