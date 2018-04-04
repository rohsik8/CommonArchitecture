package com.view9.couriercustomer.ui.activities.OrderStatus.mvp;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.view9.couriercustomer.R;
import com.view9.couriercustomer.databinding.OrderStatusBinding;
import com.view9.couriercustomer.ext.storage.PreferencesManager;
import com.view9.couriercustomer.ui.activities.OrderStatus.OrderAdapter;
import com.view9.couriercustomer.ui.activities.OrderStatus.OrderListActivity;
import com.view9.couriercustomer.ui.activities.OrderStatus.OrderParams;
import com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse.OrderResponse;
import com.view9.couriercustomer.ui.activities.OrderStatus.orderResponse.ResultQuery;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


@SuppressLint("ViewConstructor")
public class OrderView extends FrameLayout {

    public AppCompatActivity activity;
    RecyclerView recyclerView;
    //ShowLoadingDialog progressDialog;
    PreferencesManager preferencesManager;
    OrderAdapter orderAdapter;
    LinearLayoutManager layoutManager;
   // private List<DiscoverDTO> discoverList = new ArrayList<>();
    ImageView backButton;

    OrderStatusBinding orderStatusBinding;
    public  static String status;



    private TimerTask NoticeTimerTask;
    private Handler handler = new Handler();
    Timer timer = new Timer();

    public OrderView(@NonNull AppCompatActivity activity, PreferencesManager preferencesManager, OrderAdapter orderAdapter) {
        super(activity);
        this.activity = activity;
        this.orderAdapter = orderAdapter;
        orderStatusBinding = DataBindingUtil.setContentView(activity, R.layout.order_status);

//        progressDialog = new ShowLoadingDialog(activity);
        this.preferencesManager = preferencesManager;
        recyclerView =  orderStatusBinding.rvOrder;
        layoutManager = new LinearLayoutManager(activity);
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();

//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(orderAdapter);
        layoutManager.scrollToPositionWithOffset(firstVisiblePosition, 0);

        orderStatusBinding.tvBack.setOnClickListener(v->{
            activity.finish();
        });


    }


    public void setOrderList(ArrayList<ResultQuery> exploreResponse, OrderResponse orderResponse) {
        orderAdapter.showList(exploreResponse, activity);

        if(exploreResponse.size()!=0) {
            orderStatusBinding.tvBillNo.setText(orderResponse.getData().getResultQuery().get(0).getBILLNO());
            orderStatusBinding.tvOrigin.setText(orderResponse.getData().getResultBooking().get(0).getORIGIN());
           // orderStatusBinding.tvStatus.setText(orderResponse.getData().getResultBooking().get(0).getStatus());
            status =orderResponse.getData().getResultBooking().get(0).getStatus();


            for (int i = 0; i < exploreResponse.size(); i++) {
                if (exploreResponse.get(i).getSTATUS().contains("SHIPMENT BOOKED")) {
                   // orderStatusBinding.rlBooked.setBackground(activity.getResources().getDrawable(R.drawable.circular_shape_green));
                    orderStatusBinding.ivBooked.setBackground(activity.getResources().getDrawable(R.drawable.booked_icon));

                }else if(exploreResponse.get(i).getSTATUS().contains("IN TRANSIT")){

                    orderStatusBinding.ivBooked.setBackground(activity.getResources().getDrawable(R.drawable.dispatched_icon));

                }else if(exploreResponse.get(i).getSTATUS().contains("DELIVERED")){

                    orderStatusBinding.ivBooked.setBackground(activity.getResources().getDrawable(R.drawable.delivered_icon));
                }else{

                    orderStatusBinding.ivBooked.setBackground(activity.getResources().getDrawable(R.drawable.dispatched_icon));
                }
            }


           // setViews(exploreResponse);

        }


    }

    private void setViews(final ArrayList<ResultQuery> exploreResponse ) {
        final int max = exploreResponse.size();
        final int[] current = {0};
        NoticeTimerTask = new TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        if(current[0] <max) {
                           // orderStatusBinding.rlDilevery.setBackground(activity.getResources().getDrawable(R.drawable.circular_shape_green));
                           // orderStatusBinding.tvDelivery.setText(exploreResponse.get(current[0]).getSTATUS());

                            current[0]++;
                        }
                        else {

                            // current[0] = 0; // do this if yu want to loop back from first item
                            timer.cancel(); // do this if you want to stop
                        }
                    }
                });
            }
        };
        if (timer!=null) {
            timer.schedule(NoticeTimerTask, 0, 5000);
        }
    }

   /* //like click observable
    public Observable<DatumN> getClickObservable() {
        return orderAdapter.getLikeClickedObservable();
    }

    //detail click observable
    public Observable<DatumN> getDetailClickObservable() {
        return orderAdapter.getDetailClickedObservable();
    }*/


   /* public void StartDetail(String id) {

        Intent intent = new Intent(activity, NewsDtailActivity.class);
        intent.putExtra("VIDEOID", id);
        activity.startActivity(intent);
    }
*/
  /* public void setManifest(ExploreNewsResponse exploreNewsResponse){

       mAdapter = new NewsAdapter(activity, preferencesManager,exploreNewsResponse, new NewsAdapter.OnItemClickListener() {
           @Override
           public void onItemClick(int position) {

               //startNewsDetailActivity(activity);
               Intent intent = new Intent(activity, NewsDtailActivity.class);
               intent.putExtra("VIDEOID",exploreNewsResponse.getData().get(position).getNewsId());
               activity.startActivity(intent);

           }
       });
       RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(activity);
       recyclerView.setLayoutManager(mLayoutManager);
       recyclerView.setItemAnimator(new DefaultItemAnimator());
       recyclerView.setAdapter(mAdapter);
   }*/


    public OrderParams orderParams() {
        return OrderParams.builder()
                .branchCode("")
                .billNo(OrderListActivity.id)
                .build();

    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    public void showLoading(boolean isLoading) {
        if (isLoading) {
            orderStatusBinding.loadingView.setVisibility(View.VISIBLE);
        } else {
            orderStatusBinding.loadingView.setVisibility(View.GONE);
        }

    }

    public LinearLayoutManager layoutManager() {
        return layoutManager;
    }

}
