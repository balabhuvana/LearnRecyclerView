package adapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kannan.learnrecyclerview.BR;
import com.example.kannan.learnrecyclerview.Fruits;
import com.example.kannan.learnrecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kannan on 6/9/2016.
 */
public class GroceryAdapterDataBinding extends RecyclerView.Adapter<GroceryAdapterDataBinding.FruitViewHolderDataBinding> {

    private Context mContext;
    private List<Fruits> mArrayListFruits;

    public GroceryAdapterDataBinding(Context oContext, List<Fruits> oArrayListFruits) {
        mContext = oContext;
        mArrayListFruits = oArrayListFruits;
    }


    public static class FruitViewHolderDataBinding extends RecyclerView.ViewHolder {
        public ViewDataBinding mViewDataBinding;

        public FruitViewHolderDataBinding(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            mViewDataBinding = viewDataBinding;
            mViewDataBinding.executePendingBindings();
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }


    @Override
    public FruitViewHolderDataBinding onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.fruits_view_with_data_binding, viewGroup, false);
        return new FruitViewHolderDataBinding(binding);
    }

    @Override
    public void onBindViewHolder(FruitViewHolderDataBinding FruitViewHolderDataBinding, int i) {
        ViewDataBinding viewDataBinding = FruitViewHolderDataBinding.getViewDataBinding();
        viewDataBinding.setVariable(BR.fruit, mArrayListFruits.get(i));
    }

    @Override
    public int getItemCount() {
        return mArrayListFruits.size();
    }


}
