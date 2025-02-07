package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
    
    public List<Carro> findByNome(String nome);
    

    @Query("FROM Carro c WHERE c.ano > :ano")
    public List<Carro> findAcimaAno(int ano);

}
