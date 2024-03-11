package mx.com.emeru.tienda_libros.repositorio;

import mx.com.emeru.tienda_libros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
}
