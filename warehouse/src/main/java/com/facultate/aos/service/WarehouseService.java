package com.facultate.aos.service;

import com.facultate.aos.model.Item;
import com.facultate.aos.model.Warehouse;

import java.util.List;

public interface WarehouseService {

    Warehouse getWarehouse(long id);

    List<Warehouse> getAllWarehouses();

    Warehouse addWarehouse(Warehouse warehouse);

    List<Item> getAllItems(long warehouseId);

    Item getItem(long warehouseId, long itemId);

    void addItemsToWarehouse(Item items, long warehouseId);

    void removeItemFromWarehouse(Item item, long warehouseId);

    void removeAllItems(long warehouseId);

    Warehouse updateWarehouse(long warehouseId, Warehouse warehouse);

    void deleteWarehouse(long id);

    void deleteAllWarehouses();

}
