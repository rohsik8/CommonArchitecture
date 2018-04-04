package com.view9.couriercustomer.ui.activities.OrderStatus;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.view9.couriercustomer.R;
import com.view9.couriercustomer.databinding.OrderStatusItemBinding;
import com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse.ResultQuery;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

import static com.view9.couriercustomer.ui.activities.OrderStatus.mvp.OrderView.status;


public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {


    Activity activity;

    private PublishSubject<ResultQuery> clickDetail = PublishSubject.create();
    private List<ResultQuery> arrayList = new ArrayList<>();

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        OrderViewHolder viewHolder = new OrderViewHolder(OrderStatusItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));


      /*  RxView.clicks(viewHolder.binding.cardView)
                .takeUntil(RxView.detaches(parent))
                .map(aVoid -> arrayList.get(viewHolder.getAdapterPosition()))
                .subscribe(clickDetail);*/

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {

        holder.binding.tvActivity.setText(arrayList.get(position).getACTIVITY());
        holder.binding.tvActivity.setTextColor(Color.parseColor("#00BB44"));


        if (arrayList.get(position).getSTATUS().equals(status)) {
            holder.binding.ivChange.setVisibility(View.VISIBLE);
        }else{
            holder.binding.ivChange.setVisibility(View.GONE);
        }

        holder.binding.tvDate.setText(arrayList.get(position).getTRACKDATE());
        holder.binding.tvState.setText(arrayList.get(position).getLOCATION());
        holder.binding.tvDestination.setText(arrayList.get(position).getLOCATION());
        holder.binding.tvReference.setText(arrayList.get(position).getREFERENCENO());

    }

    public void showList(ArrayList<ResultQuery> exploreNewsResponse, AppCompatActivity activity) {
        this.arrayList.clear();
        this.activity = activity;
        if (exploreNewsResponse != null && !exploreNewsResponse.isEmpty())
            this.arrayList.addAll(exploreNewsResponse);
        notifyDataSetChanged();
    }


   /* public Observable<DatumN> getDetailClickedObservable() {
        return clickDetail;
    }*/

    @Override
    public int getItemCount() {
        return arrayList.size();

//        return 10;
    }


}
