package adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kannan.learnrecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.GroceryItemFruits;

/**
 * Created by Kannan on 6/9/2016.
 */
public class GroceryAdapter extends RecyclerView.Adapter<GroceryAdapter.FruitViewHolder> {

    private Activity mActivity;
    private ArrayList<GroceryItemFruits> mArrayListFruits;

    public GroceryAdapter(Activity oActivity, ArrayList<GroceryItemFruits> oArrayListFruits) {
        mActivity = oActivity;
        mArrayListFruits = oArrayListFruits;
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFruits, ivRightArrow;
        private TextView tvFruitName, tvFruitPrice, tvFruitWeight;

        public FruitViewHolder(View oView) {
            super(oView);
            ivFruits = (ImageView) oView.findViewById(R.id.ivFruit);
            ivRightArrow = (ImageView) oView.findViewById(R.id.iv_right_arrow);
            tvFruitName = (TextView) oView.findViewById(R.id.tvFruitName);
            tvFruitPrice = (TextView) oView.findViewById(R.id.tvFruitPrice);
            tvFruitWeight = (TextView) oView.findViewById(R.id.tvFruitWeight);
        }
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mActivity)
                .inflate(R.layout.fruits_view, parent, false);
        return new FruitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        Picasso.with(mActivity).load("http://i.imgur.com/DvpvklR.png").into(holder.ivFruits);
        holder.tvFruitName.setText(mArrayListFruits.get(position).getFruitName());
        holder.tvFruitPrice.setText(String.valueOf(mArrayListFruits.get(position).getPrice()));
        holder.tvFruitWeight.setText(String.valueOf(mArrayListFruits.get(position).getWeight()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
