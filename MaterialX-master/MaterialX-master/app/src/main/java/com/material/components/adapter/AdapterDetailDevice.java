package com.material.components.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.material.components.R;
import com.material.components.model.Device;
import com.material.components.model.SensorDevice;
import com.material.components.utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class AdapterDetailDevice  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SensorDevice> items = new ArrayList<>();

    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public AdapterDetailDevice(Context context, List<SensorDevice> items) {
        this.items = items;
        ctx = context;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, SensorDevice obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView max;
        public TextView min;
        public TextView currentvalue;
        public ImageButton btnMore;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);

            image = (ImageView) v.findViewById(R.id.unitSensor);
            name = (TextView) v.findViewById(R.id.namesensor);
            max = (TextView) v.findViewById(R.id.max);
            min = (TextView) v.findViewById(R.id.min);
            currentvalue = (TextView) v.findViewById(R.id.valueCurent);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_sensor_device, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            if(items.get(position).getType() == 1)
            {
                view.image.setImageDrawable(ctx.getResources().getDrawable(R.drawable.ic_image_tempurachure_unit));
            }
            else
            {
                view.image.setImageDrawable(ctx.getResources().getDrawable(R.drawable.phantram));
            }
           // Tools.displayImageOriginal(ctx, view.image, items.get(position));
            view.currentvalue.setText(items.get(position).getCurrentvalue());
            view.name.setText(items.get(position).getName());
            view.max.setText("Max: " + items.get(position).getMaxvalue());
            view.min.setText("Min: "+ items.get(position).getMinvalue());
           // view.name.setText(items.get(position).getName());
            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });


        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore(int current_page);
    }
}
