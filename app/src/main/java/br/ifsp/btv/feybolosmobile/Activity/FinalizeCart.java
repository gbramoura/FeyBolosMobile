package br.ifsp.btv.feybolosmobile.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.ifsp.btv.feybolosmobile.Adpter.FinalizeCartAdapter;
import br.ifsp.btv.feybolosmobile.Adpter.ShoppingCartAdapter;
import br.ifsp.btv.feybolosmobile.Model.ShoppingItem;
import br.ifsp.btv.feybolosmobile.R;
import br.ifsp.btv.feybolosmobile.Sigleton.ShoppingCartSingleton;

public class FinalizeCart extends AppCompatActivity {

    /** -- **/
    private List<ShoppingItem> shoppings;
    private FinalizeCartAdapter finalizeAdapter;

    /** -- **/
    private ListView listFinalize;
    private TextView lblTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_cart);

        shoppings = ShoppingCartSingleton.getInstance().listar();
        finalizeAdapter = new FinalizeCartAdapter(this, shoppings);

        listFinalize = (ListView) findViewById(R.id.lvCakesCart);
        listFinalize.setAdapter(finalizeAdapter);

        float total = 0;
        for(ShoppingItem item: shoppings) {
            total += item.getQuantity() * item.getPrice();
        }

        lblTotal = (TextView) findViewById(R.id.txtTotal);
        lblTotal.setText(String.valueOf("R$ " + String.format("%.2f", total)));
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Terminal", "Passou aqui e so limpar agora");
        ShoppingCartSingleton.getInstance().limparLista();
    }

}