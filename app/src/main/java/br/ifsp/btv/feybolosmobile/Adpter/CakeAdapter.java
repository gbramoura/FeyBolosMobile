package br.ifsp.btv.feybolosmobile.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ifsp.btv.feybolosmobile.Model.CakeItem;
import br.ifsp.btv.feybolosmobile.R;

public class CakeAdapter extends BaseAdapter {

    private final Context context;

    private final List<CakeItem> cakes;


    public CakeAdapter(Context context, List<CakeItem> cakes){
        this.context = context;
        this.cakes = cakes;
    }

    @Override
    public int getCount() {
        return cakes.size();
    }

    @Override
    public Object getItem(int position) {
        return cakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View line = LayoutInflater.from(context).inflate(R.layout.product,viewGroup,false);
        ImageView imgCake = (ImageView) line.findViewById(R.id.cakeImage);
        TextView txtCake = (TextView) line.findViewById(R.id.txtCakeName);
        TextView txtPrice = (TextView) line.findViewById(R.id.txtPriceCake);

        CakeItem cakeItem = cakes.get(position);
        imgCake.setImageResource(cakeItem.cakeImage);
        txtCake.setText(cakeItem.cakeName);
        txtPrice.setText("R$" + String.format("%.2f",cakeItem.cakePrice));
        return line;
    }
}
