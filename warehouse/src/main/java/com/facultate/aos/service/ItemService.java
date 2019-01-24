package com.facultate.aos.service;

import com.facultate.aos.model.Item;
import com.facultate.aos.model.Warehouse;

import java.util.List;

public interface ItemService {

    Item getItem(long id);

    List<Item> getAllItems();

    Item updateItem(long itemId, Item item);

}
