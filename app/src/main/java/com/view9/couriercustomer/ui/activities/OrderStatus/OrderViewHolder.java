package com.view9.couriercustomer.ui.activities.OrderStatus;

import android.support.v7.widget.RecyclerView;

import com.view9.couriercustomer.databinding.OrderStatusItemBinding;


public class OrderViewHolder extends RecyclerView.ViewHolder {

    public final OrderStatusItemBinding binding;

    public OrderViewHolder(OrderStatusItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

}