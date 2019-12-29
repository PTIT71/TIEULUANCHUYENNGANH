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
import com.material.components.model.Monitor;

import java.util.ArrayList;
import java.util.List;

public class AdapterDetailDeviceMonitor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Monitor> items = new ArrayList<>();

    private OnLoadMoreListener onLoadMoreListener;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public AdapterDetailDeviceMonitor(Context context, List<Monitor> items) {
        this.items = items;
        ctx = context;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, Monitor obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView status;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.nameMonitor);
            status = (TextView) v.findViewById(R.id.statusMonitor);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_monitor_device, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            //Tools.displayImageOriginal(ctx, view.image, items.get(position));
            view.name.setText(items.get(position).getName());
            if(items.get(position).getStatus() == 1)
            {
                view.status.setText("Đang hoạt động");
            }
            else
            {
                view.status.setText("Đang bị tắt");
            }
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
