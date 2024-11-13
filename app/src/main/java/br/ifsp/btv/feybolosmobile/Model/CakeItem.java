package br.ifsp.btv.feybolosmobile.Model;

import java.util.ArrayList;
import java.util.List;

import br.ifsp.btv.feybolosmobile.R;

public class CakeItem {
    public int id;
    public String cakeName;
    public int cakeImage;
    public double cakePrice;

    public CakeItem(int id, String cakeName, int cakeImage, double cakePrice){
        this.id = id;
        this.cakeName = cakeName;
        this.cakeImage = cakeImage;
        this.cakePrice = cakePrice;
    }

    public static List<CakeItem> getCakes() {
        List<CakeItem> cakes = new ArrayList<CakeItem>();

        cakes.add(new CakeItem(1,"Bolo de Chocolate", R.drawable.bolo1,40.50));
        cakes.add(new CakeItem(2,"Bolo Morango",R.drawable.bolo4,50.50));
        cakes.add(new CakeItem(3,"Bolo de Festa",R.drawable.bolo3,90.50));
        cakes.add(new CakeItem(4,"Bolo de Cenoura",R.drawable.bolo2,20.50));
        cakes.add(new CakeItem(5,"Bolo de Chocolate G.",R.drawable.bolo5,60.50));
        cakes.add(new CakeItem(6,"Bolo de Prestígio",R.drawable.bolo6,22.50));
        cakes.add(new CakeItem(7,"Bolo de Laranja",R.drawable.bolo7,23.50));
        cakes.add(new CakeItem(8,"Bolo de Brigadeiro",R.drawable.bolo9,24.50));
        cakes.add(new CakeItem(9,"Bolo Especial",R.drawable.bolo8,54.50));
        cakes.add(new CakeItem(10,"Bolo de Limão",R.drawable.bolo10,33.50));
        return cakes;
    }
}
