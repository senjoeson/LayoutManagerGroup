package com.dingmouren.example.layoutmanagergroup;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dingmouren.layoutmanagergroup.banner.BannerLayoutManager;

/**
 * <pre>
 *     author : sunqiao
 *     e-mail : sunqiao@kayak.com.cn
 *     time   : 2019/08/02
 *     desc   : 学习
 *     version: 1.0
 * </pre>
 */
public class LinearSnapHelperActivity extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    public LinearSnapHelper mLinearSnapHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_snap);


        mRecyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new BannerLayoutManager(this, mRecyclerView, 20);
        mLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //mLinearSnapHelper = new LinearSnapHelper();
      //  mLinearSnapHelper.attachToRecyclerView(mRecyclerView);

        RecyclerView.Adapter mAdapter = new MyAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public MyAdapter() {
            super();
        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(android.R.layout.simple_list_item_2, null);
            return new ViewHolder(view);
        }

        @SuppressLint("DefaultLocale")
        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.text1.setText(String.valueOf(i));
            viewHolder.text2.setText(String.format("pos:%d", i));

            int n = i % 2;
            int color = n == 0 ? Color.DKGRAY : Color.LTGRAY;

            viewHolder.itemView.setBackgroundColor(color);
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView text1;
            public TextView text2;

            public ViewHolder(View itemView) {
                super(itemView);

                text1 = itemView.findViewById(android.R.id.text1);
                text1.setTextColor(Color.RED);

                text1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 160);

                text2 = itemView.findViewById(android.R.id.text2);
                text2.setTextColor(Color.BLUE);
            }
        }
    }
}

