package com.codegym.example1.repository;

import com.codegym.example1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select * from product p where p.name  like concat('%',:name,'%') and p.manufacturer like concat ('%',:manufacturer,'%') and product_status = 1 ",
            nativeQuery = true,
            countQuery = "select count('*') from (select * from product p  where p.name like concat('%',:name,'%' ) and p.manufacturer like concat ('%',:manufacturer,'%') and product_status = 1) p ")
    Page<Product> findAllByName(@Param("name") String name,@Param("manufacturer") String manufacturer, Pageable page);

    @Modifying
    @Transactional
    @Query("update Product  p set p.status = false  where p.id = :id")
    void updateStatusById(@Param("id") Long id);

}
