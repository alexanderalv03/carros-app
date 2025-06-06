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

import app.entity.Marca;
import app.service.MarcaService;

@RestController
@RequestMapping("api/marca")
@CrossOrigin("*")
public class MarcaController {

    @Autowired 
    private MarcaService marcaService;

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/save")
    public ResponseEntity <String> save(@RequestBody Marca marca) {
        try {
            String mensagem = this.marcaService.save(marca);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }        
       
        }
    


    @PreAuthorize("hasRole('admin')")
    @PutMapping("/update/{id}")
    public ResponseEntity <String> updade( @RequestBody Marca marca, @PathVariable Long id) {
        try {
            String mensagem = this.marcaService.update(marca, id);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }                
        }
        

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/findAll")
    public ResponseEntity <List<Marca>> findAll() {
        try {

            List<Marca> lista = this.marcaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }  
        }
    
    
    @PreAuthorize("hasRole('admin')")    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <String> delete(@PathVariable Long id){
        try {
            String mensagem = this.marcaService.delete(id);
            return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
           
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }        
        }
        

    
       @PreAuthorize("hasRole('admin')")
    @GetMapping("/findById/{id}")
    public ResponseEntity <Marca> findById(@PathVariable Long id) {
        try {
            Marca marca = this.marcaService.findById(id);
            return new ResponseEntity<>(marca, HttpStatus.OK);
            
            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }           
        }

           @PreAuthorize("hasRole('admin')")
        @GetMapping("/findByNome")
    public ResponseEntity <List<Marca>> findByNome(@RequestParam String nome) {
        try {

            List<Marca> lista = this.marcaService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }  
        }


}
