package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;



public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value="select *,count(*) from book group by `name`",nativeQuery = true)
    List<Book> showListBook();

    @Query(value="select * from book where (status =0 and `name` like :name) limit 1",nativeQuery = true)
    Book findByName(@Param("name") String name);

    @Query(value="select * from book where `name` like :name limit 1",nativeQuery = true)
    Book findAllByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "update book set status = 1 where id = :idbook ",nativeQuery = true)
    void borrowBook(@Param("idbook") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update book set status = 0 where id = :idbook ",nativeQuery = true)
    void returnBook(@Param("idbook") Integer id);

    @Query(value = "select status from book where id = :idbook and status =1 ",nativeQuery = true)
    Integer returnBookCheckId(@Param("idbook") Integer id);

}
