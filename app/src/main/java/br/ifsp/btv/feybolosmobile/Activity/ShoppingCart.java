package br.ifsp.btv.feybolosmobile.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import br.ifsp.btv.feybolosmobile.Adpter.ShoppingCartAdapter;
import br.ifsp.btv.feybolosmobile.Model.ShoppingItem;
import br.ifsp.btv.feybolosmobile.R;
import br.ifsp.btv.feybolosmobile.Sigleton.ShoppingCartSingleton;

public class ShoppingCart extends AppCompatActivity {

    /** -- **/
    private List<ShoppingItem> shoppings;
    private ShoppingCartAdapter shopAdapter;

    /** -- **/
    private TextView txtTotal;
    private Button btnFechar;
    private ListView listShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        shoppings = ShoppingCartSingleton.getInstance().listar();
        shopAdapter = new ShoppingCartAdapter(this, shoppings);

        listShop = (ListView) findViewById(R.id.lvCakesCart);
        listShop.setAdapter(shopAdapter);

        Intent it = new Intent(this, FinalizeCart.class);

        btnFechar = (Button) findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ShoppingCartSingleton.getInstance().listaLimpa()) {
                    Toast.makeText(view.getContext(),"É necessario produto para fechar pedido.", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(it);
                }
            }
        });
    }
}