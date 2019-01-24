package com.facultate.aos.service;

import com.facultate.aos.model.Item;
import com.facultate.aos.model.Warehouse;
import com.facultate.aos.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private WarehouseRepository repo;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository repo) {
        this.repo = repo;
    }

    @Autowired
    public ItemServiceImpl itemService;

    @Override
    public Warehouse getWarehouse(long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Item> getAllItems(long warehouseId) {
        Warehouse warehouse = getWarehouse(warehouseId);
        return warehouse.getItems();
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public Warehouse addWarehouse(Warehouse warehouse) {
        return repo.saveAndFlush(warehouse);
    }

    @Override
    @Transactional
    public void addItemsToWarehouse(Item items, long warehouseId) {
        Warehouse warehouse = getWarehouse(warehouseId);
        warehouse.addItem(items);
//        for(Item item : items) {
//            warehouse.addItem(item);
//        }
        repo.saveAndFlush(warehouse);
    }

    @Override
    @Transactional
    public void removeItemFromWarehouse(Item item, long warehouseId) {
        Warehouse warehouse = getWarehouse(warehouseId);
        warehouse.deleteItem(item);
    }

    @Override
    @Transactional
    public void removeAllItems(long warehouseId) {
        Warehouse warehouse = getWarehouse(warehouseId);
        warehouse.deleteAllItems();
    }

    @Override
    @Transactional
    public Warehouse updateWarehouse(long warehouseId, Warehouse warehouse) {
        Warehouse warehouseToUpdate = getWarehouse(warehouseId);
        warehouseToUpdate.setName(warehouse.getName());
        warehouseToUpdate.setLocation(warehouse.getLocation());
        return repo.saveAndFlush(warehouseToUpdate);
    }

    @Override
    @Transactional
    public void deleteWarehouse(long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllWarehouses() {
        repo.deleteAll();
    }

    @Override
    public Item getItem(long warehouseId, long itemId) {
        Warehouse auxWarehouse=repo.findById(warehouseId).get();
        if(auxWarehouse!= null)
        {
            Item auxItem=itemService.getItem(itemId);
            return auxItem;
        }
        return null;
    }
}
