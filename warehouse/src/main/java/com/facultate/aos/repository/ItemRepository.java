package com.facultate.aos.repository;

import com.facultate.aos.model.Item;
import com.facultate.aos.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,Long> {

//    @Query("select w.name from items as i "+
//    "inner join warehouse as w on i.werehouse_id=w.id where i.warehouse_id = :warehouse_id ")
//    public Warehouse getMyWarehouseName(@Param("warehouse_id") Long warehouse_id);
}
