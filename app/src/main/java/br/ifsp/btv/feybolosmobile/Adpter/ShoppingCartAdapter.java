package br.ifsp.btv.feybolosmobile.Adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import br.ifsp.btv.feybolosmobile.Activity.ShoppingCart;
import br.ifsp.btv.feybolosmobile.Model.CakeItem;
import br.ifsp.btv.feybolosmobile.Model.ShoppingItem;
import br.ifsp.btv.feybolosmobile.R;

public class ShoppingCartAdapter extends BaseAdapter implements View.OnClickListener {

    /** --- **/
    private final Context context;
    private final List<ShoppingItem> cakesInCart;

    /** --- **/
    private  TextView txtQtq;

    public ShoppingCartAdapter(Context context, List<ShoppingItem> cakesInCart){
        this.context = context;
        this.cakesInCart = cakesInCart;
    }

    @Override
    public int getCount() { return cakesInCart.size(); }

    @Override
    public Object getItem(int position) {
        return cakesInCart.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View layout = LayoutInflater.from(context).inflate(R.layout.shopping_product, viewGroup, false);
        ImageView imgCakesCart = (ImageView) layout.findViewById(R.id.imageCake);
        TextView txtCakeName = (TextView)  layout.findViewById(R.id.txtCakeName);
        TextView txtQuantity = (TextView) layout.findViewById(R.id.txtQuantity);
        TextView txtCakePrice = (TextView) layout.findViewById(R.id.txtPriceCake);
        Button btnSom = (Button) layout.findViewById(R.id.btnSom);
        Button btnSub = (Button) layout.findViewById(R.id.btnSub);
        Button btnExcluir = (Button) layout.findViewById(R.id.btnExcluir);

        ShoppingItem item = cakesInCart.get(position);

        imgCakesCart.setImageResource(item.getImage());
        txtCakeName.setText(item.getName());
        txtQuantity.setText(String.valueOf(item.getQuantity()));
        txtCakePrice.setText(String.valueOf("R$ " + String.format("%.2f",item.getPrice())));
        btnSom.setTag(item.getId());
        btnSub.setTag(item.getId());
        btnExcluir.setTag(item.getId());
        
        btnSub.setOnClickListener(this);
        btnSom.setOnClickListener(this);
        btnExcluir.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSom:
                Button btnSomar = (Button) view.findViewById(R.id.btnSom);

                int tagSomar = (int) btnSomar.getTag();
                cakesInCart.forEach((e) -> {
                    if (e.getId() == tagSomar) {
                        e.setQuantity(e.getQuantity() + 1);
                        this.notifyDataSetChanged();
                    }
                });
                break;
            case R.id.btnSub:
                Button btnSubtrair = (Button) view.findViewById(R.id.btnSub);
                int tagSubtracao = (int) btnSubtrair.getTag();
                cakesInCart.forEach((e) -> {
                    if (e.getId() == tagSubtracao && e.getQuantity() > 1) {
                        e.setQuantity(e.getQuantity() - 1);
                        this.notifyDataSetChanged();
                    }
                });
                break;
            case R.id.btnExcluir:
                Button btnExcluir = view.findViewById(R.id.btnExcluir);
                int tagExcluir = (int) btnExcluir.getTag();

                ShoppingItem item = null;
                for(ShoppingItem e : cakesInCart)  {
                    if (e.getId() == tagExcluir) {
                        item = e;
                    }
                }

                if(item != null) {
                    int indice = cakesInCart.indexOf(item);
                    cakesInCart.remove(indice);
                    this.notifyDataSetChanged();
                }

                break;
            default:
                Log.i("Terminal", "Não achou opção");
                break;
        }
    }
}
