package br.ifsp.btv.feybolosmobile.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import br.ifsp.btv.feybolosmobile.Adpter.CakeAdapter;
import br.ifsp.btv.feybolosmobile.Model.CakeItem;
import br.ifsp.btv.feybolosmobile.Model.ShoppingItem;
import br.ifsp.btv.feybolosmobile.R;
import br.ifsp.btv.feybolosmobile.Sigleton.ShoppingCartSingleton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    /** --- **/
    private  TextView txtBadge;
    private MenuItem menuItem;
    private FrameLayout circuloRosa;

    /** --- **/
    private List<CakeItem> cakeItemList;
    private ListView lvCake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cakeItemList = CakeItem.getCakes();
        CakeAdapter adapter = new CakeAdapter(this,cakeItemList);

        lvCake = (ListView)findViewById(R.id.lvCakes);
        lvCake.setAdapter(adapter);
        lvCake.setOnItemClickListener(this);
        lvCake.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        boolean sup = super.onCreateOptionsMenu(menu);
        return sup;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menuItem = menu.findItem(R.id.abCarrinho);
        menuItem.setActionView(R.layout.badge_notificacao);
        FrameLayout view = (FrameLayout) menuItem.getActionView();

        circuloRosa = (FrameLayout) view.findViewById(R.id.ciruloRosa);
        txtBadge = (TextView) view.findViewById(R.id.txtContadorBadge);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOptionsItemSelected(menuItem);
            }
        });

        atulizarCount();
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abCarrinho:
                Intent it = new Intent(this, ShoppingCart.class);
                startActivity(it);
                break;
        }
        return  false;
    }

    public void atulizarCount() {
        int count = ShoppingCartSingleton.getInstance().countItem();
        txtBadge.setText(String.valueOf(count));
        circuloRosa.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        CakeItem cakeItem =  cakeItemList.get(Integer.parseInt(String.valueOf(id)));
        ShoppingItem shoppingItem = new ShoppingItem();

        boolean inUse = false;
        for(ShoppingItem item:ShoppingCartSingleton.getInstance().listar()) {
            if (item.getId() == cakeItem.id) {
                inUse = true;
                break;
            }
        }

        if (inUse) {
            Toast.makeText(view.getContext(),cakeItem.cakeName + " Já foi Adicionado em seu pedido", Toast.LENGTH_SHORT).show();
        } else {
            shoppingItem.setId(cakeItem.id);
            shoppingItem.setImage(cakeItem.cakeImage);
            shoppingItem.setName(cakeItem.cakeName);
            shoppingItem.setPrice(cakeItem.cakePrice);
            shoppingItem.setQuantity(1);

            ShoppingCartSingleton.getInstance().addItem(shoppingItem);
            Toast.makeText(view.getContext(),cakeItem.cakeName + " adicionado ao carrinho de compras!", Toast.LENGTH_SHORT).show();

            Intent it = new Intent(this, ShoppingCart.class);
            startActivity(it);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
        CakeItem cakeItem =  cakeItemList.get(Integer.parseInt(String.valueOf(id)));
        ShoppingItem shoppingItem = new ShoppingItem();

        boolean inUse = false;
        for(ShoppingItem item:ShoppingCartSingleton.getInstance().listar()) {
            if (item.getId() == cakeItem.id) {
                inUse = true;
                break;
            }
        }

        if (inUse) {
            Toast.makeText(view.getContext(),cakeItem.cakeName + " Já foi Adicionado em seu pedido", Toast.LENGTH_SHORT).show();
        } else {
            shoppingItem.setId(cakeItem.id);
            shoppingItem.setImage(cakeItem.cakeImage);
            shoppingItem.setName(cakeItem.cakeName);
            shoppingItem.setPrice(cakeItem.cakePrice);
            shoppingItem.setQuantity(1);

            ShoppingCartSingleton.getInstance().addItem(shoppingItem);
            Toast.makeText(view.getContext(),cakeItem.cakeName + " adicionado ao carrinho de compras!", Toast.LENGTH_SHORT).show();
            atulizarCount();
        }
        return  true;
    }
}