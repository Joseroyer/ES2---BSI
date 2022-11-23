package es2.projeto.librarytree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es2.projeto.librarytree.models.Suspensao;

// public interface GerenTitulosRepository extends JpaRepository <GerenTitulos, Long>
public interface SuspensaoRepository extends JpaRepository <Suspensao, Long>{

@Query(value = "SELECT * FROM suspensao s WHERE s.sus_stt = 1", nativeQuery = true)
public List<Suspensao> findAll();

@Query(value = "SELECT * FROM suspensao s WHERE s.sus_stt = 1 AND UPPER(s.cliente_ra) LIKE %:fil%", nativeQuery = true)
public List<Suspensao> findAllWithFilter(@Param("fil") String fil);

// @Query(value = "SELECT * FROM suspensao s WHERE s.id = :id", nativeQuery = true)
// public List<Suspensao> findById(@Param("id")int id);

@Query(value = "SELECT * FROM suspensao s WHERE s.id = :id", nativeQuery = true)
public List<Suspensao> findById(@Param("id")int id);

}


