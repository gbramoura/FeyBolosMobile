package br.ifsp.btv.feybolosmobile.Sigleton;

import java.util.ArrayList;
import java.util.List;

import br.ifsp.btv.feybolosmobile.Model.ShoppingItem;

public class ShoppingCartSingleton {

    private static ShoppingCartSingleton _instance;
    private List<ShoppingItem> _shoppingItemList = new ArrayList<ShoppingItem>();

    private ShoppingCartSingleton() {

    };

    public static ShoppingCartSingleton getInstance() {
        if (_instance == null) {
            _instance = new ShoppingCartSingleton();
        }
        return _instance;
    }

    public void destroiInstance() {
        _instance = null;
    }

    public List<ShoppingItem> listar() {
        return _shoppingItemList;
    }

    public void addItem(ShoppingItem item) {
        _shoppingItemList.add(item);
    }

    public int countItem() {
        int total = 0;
        for (ShoppingItem item: _shoppingItemList) {
            total += item.getQuantity();
        }
        return  total;
    }


    public void limparLista() {
        _shoppingItemList.clear();
    }

    public boolean listaLimpa() {
        return _shoppingItemList.isEmpty();
    }

}
