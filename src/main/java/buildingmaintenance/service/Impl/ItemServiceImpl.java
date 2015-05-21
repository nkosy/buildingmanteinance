package buildingmaintenance.service.Impl;

import buildingmaintenance.domain.Item;
import buildingmaintenance.repository.ItemRepository;
import buildingmaintenance.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nkosi on 2015/05/21.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository repository;


    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        Iterable<Item> values = repository.findAll();
        for (Item value : values) {
            items.add(value);
        }
        return items;
    }

    @Override
    public Item getItemByID(Long id) {
        if(repository.findOne(id) == null)
            return null;
        else
            return repository.findOne(id);
    }

    @Override
    public List<Item> getItemByCost(double cost) {
        List<Item> items = new ArrayList<>();
        List<Item> result = new ArrayList<>();
        items = getAllItems();
        for(Item theitem: items)
        {
            if(theitem.getCost() == cost)
            {
                result.add(theitem);
            }
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }

    @Override
    public List<Item> getItemByLastMantainedDate(Date date) {
        List<Item> items = new ArrayList<>();
        List<Item> result = new ArrayList<>();
        items = getAllItems();
        for(Item theitem: items)
        {
            if(theitem.getLast_mantained() == date)
            {
                result.add(theitem);
            }
        }
        if(result == null)
            System.out.println("Found Nothing!");
        return result;
    }
}
