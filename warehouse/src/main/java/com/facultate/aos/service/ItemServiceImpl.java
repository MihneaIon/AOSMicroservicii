package com.facultate.aos.service;

import com.facultate.aos.model.Item;
import com.facultate.aos.model.Warehouse;
import com.facultate.aos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository repo;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.repo = itemRepository;
    }

    @Override
    public Item getItem(long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Item> getAllItems() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public Item updateItem(long itemId, Item item) {
        Item itemToUpdate = getItem(itemId);
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setItemName(item.getItemName());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setQuantity(item.getQuantity());
        itemToUpdate.setWarehouse(item.getWarehouse());
        System.out.println(item.getWarehouse().getId());
        return repo.saveAndFlush(itemToUpdate);
    }

}
