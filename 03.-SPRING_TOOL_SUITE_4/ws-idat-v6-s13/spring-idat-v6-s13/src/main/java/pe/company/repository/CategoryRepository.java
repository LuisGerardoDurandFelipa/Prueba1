package pe.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.company.model.Categoria;

@Repository  // indica que esta es una capa de datos
public interface CategoryRepository extends CrudRepository<Categoria, Long>{

	@Query("select c from Categoria c where c.descripcion like %:descripcion%")
	List<Categoria> findByDescription(@Param("descripcion") String descripcion);	

	
}
