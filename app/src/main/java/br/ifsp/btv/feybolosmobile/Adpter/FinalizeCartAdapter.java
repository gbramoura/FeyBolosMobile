package br.ifsp.btv.feybolosmobile.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.List;

import br.ifsp.btv.feybolosmobile.Model.ShoppingItem;
import br.ifsp.btv.feybolosmobile.R;

public class FinalizeCartAdapter extends BaseAdapter {

    private final Context _context;
    private final List<ShoppingItem> _cakesToFinalize;

    public FinalizeCartAdapter(Context context, List<ShoppingItem> cakesToFinalize){
        this._context = context;
        this._cakesToFinalize = cakesToFinalize;
    }

    @Override
    public int getCount() { return _cakesToFinalize.size(); }

    @Override
    public Object getItem(int position) {
        return _cakesToFinalize.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        View layout = LayoutInflater.from(_context).inflate(R.layout.finalize_product, viewGroup, false);

        ImageView imgCake = (ImageView) layout.findViewById(R.id.imageCake);
        TextView txtCakeName = (TextView)  layout.findViewById(R.id.txtCakeName);
        TextView txtCakePrice = (TextView) layout.findViewById(R.id.txtPriceCake);
        TextView txtQuantity = (TextView) layout.findViewById(R.id.txtQuantity);

        ShoppingItem item = _cakesToFinalize.get(pos);

        imgCake.setImageResource(item.getImage());
        txtCakeName.setText(item.getName());
        txtQuantity.setText(String.valueOf(item.getQuantity()));
        txtCakePrice.setText(String.valueOf("R$ " + String.format("%.2f",item.getPrice())));

        return layout;
    }
}
