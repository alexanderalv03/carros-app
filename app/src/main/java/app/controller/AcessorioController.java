package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Acessorio;
import app.service.AcessorioService;

@RestController
@RequestMapping ("api/acessorio")
@CrossOrigin("*")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @PreAuthorize("hasRole('admin')")
     @PostMapping("/save")
    public ResponseEntity <String> save(@RequestBody Acessorio acessorio) {
        try {
            String mensagem = this.acessorioService.save(acessorio);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }        
       
        }
    

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update/{id}")
    public ResponseEntity <String> updade( @RequestBody Acessorio acessorio, @PathVariable Long id) {
        try {
            String mensagem = this.acessorioService.update(acessorio, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }                
        }
        

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/findAll")
    public ResponseEntity <List<Acessorio>> findAll() {
        try {

            List<Acessorio> lista = this.acessorioService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }  
        }
    
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        try {
            String mensagem = this.acessorioService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
           
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }        
        }
        

    
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/findById/{id}")
    public ResponseEntity <Acessorio> findById(@PathVariable Long id) {
        try {
            Acessorio acessorio = this.acessorioService.findById(id);
            return new ResponseEntity<>(acessorio, HttpStatus.OK);
            
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }           
        }

        @PreAuthorize("hasRole('admin')")
        @GetMapping("/findByNome")
    public ResponseEntity <List<Acessorio>> findByNome(@RequestParam String nome) {
        try {

            List<Acessorio> lista = this.acessorioService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }  
        }

}
