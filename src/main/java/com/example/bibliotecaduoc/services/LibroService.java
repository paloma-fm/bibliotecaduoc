package com.example.bibliotecaduoc.services;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obtenerLibros();
    }
    public Libro saveLibro(Libro libro){
        return libroRepository.guardar(libro);
    }
    public Libro getLibroId(int id){
        return libroRepository.buscarPorId(id);
    }
    public Libro updateLibro(Libro libro){
        return libroRepository.actualizar(libro);
    }
    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "producto eliminado";
    }
    public int totalLibros() {
        return libroRepository.obtenerLibros().size();
    }

    // Opción 2: La acción la hace el Repositorio (Recomendado para arquitectura) [cite: 160]
    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }
    public Libro buscarPorIsbn(String isbn) {
        return libroRepository.buscarPorIsbn(isbn);
    }

    // 2. Cantidad por año
    public int totalPorAnio(int anio) {
        return libroRepository.totalLibrosPorAnio(anio);
    }

    // 3. Buscar por autor
    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.buscarPorAutor(autor);
    }

    public Libro obtenerAntiguo() {
        return libroRepository.obtenerMasAntiguo();
    }

    public Libro obtenerNuevo() {
        return libroRepository.obtenerMasNuevo();
    }

    public List<Libro> obtenerOrdenados() {
        return libroRepository.listarOrdenados();
    }
}


