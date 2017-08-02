package com.ztb.nanke;

/**
 * Created by nanker on 2017/6/30.
 */

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;

import com.ztb.nanke.adapter.ExpandableAdapter;
import com.ztb.nanke.base.Product;
import com.ztb.nanke.base.Store;
import com.ztb.nankerlibrary.control.xexpandablelistview.XExpandableListView;

public class CheShi extends Activity implements XExpandableListView.IXExpandableListViewListener {
    protected static final int REFRESHING = 0;
    protected static final int LOADMOREING = 1;
    private List<Store> stores;
    private XExpandableListView lv;
    private ExpandableAdapter adapter;
    private int i = 0;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESHING:
                    List<Product> pps = new ArrayList<Product>();
                    for (int i = 0; i < 5; i++) {
                        pps.add(new Product("pre" + String.valueOf(i)));
                    }
                    Store pstore = new Store(String.valueOf("pre" + i++));
                    pstore.setProducts(pps);
                    stores.add(0, pstore);
                    lv.stopRefresh();
                    break;
                case LOADMOREING:
                    List<Product> aps = new ArrayList<Product>();
                    for (int i = 0; i < 5; i++) {
                        aps.add(new Product("after" + String.valueOf(i)));
                    }
                    Store astore = new Store(String.valueOf("after" + i++));
                    astore.setProducts(aps);
                    stores.add(astore);
                    lv.stopLoadMore();
                    break;
            }
            if (adapter != null) {
                adapter.setGroupData(stores);
                adapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceshi);
        initData();
        initView();
        adapter = new ExpandableAdapter(CheShi.this, stores);
        lv.setAdapter(adapter);
        lv.setGroupIndicator(null);
        //设置ExpandableListView全部展开
        for (int i = 0;i < adapter.getGroupCount();i++) {
            lv.expandGroup(i);
        }
    }

    private void initView() {
        lv = (XExpandableListView) findViewById(R.id.lv);
        lv.setPullRefreshEnable(true);    // open the pull to refresh
        lv.setPullLoadEnable(true);        // open the pull to load
        lv.setExpandableListViewListener(CheShi.this);// set the listener
    }

    private void initData() {
        stores = new ArrayList<Store>();
        for (int i = 0; i < 8; i++) {
            Store store = new Store(String.valueOf("store==>" + i));
            List<Product> ps = new ArrayList<Product>();
            for (int j = 0; j < 10; j++) {
                ps.add(new Product(String.valueOf("product==>" + i)));
            }
            store.setProducts(ps);
            stores.add(store);
        }
    }

    /**
     * it is called when the data already refreshed or loaded more
     */
    private void stopPull() {
        lv.stopLoadMore();
        lv.stopRefresh();
    }

    /**
     * it is called when you do not need refresh or load more
     */
    private void closePull() {
        lv.setPullLoadEnable(false);
        lv.setPullLoadEnable(false);
    }

    @Override
    public void onRefresh() {
        Message msg = Message.obtain();
        msg.what = REFRESHING;
        handler.sendMessageDelayed(msg, 2000);
    }

    @Override
    public void onLoadMore() {
        Message msg = Message.obtain();
        msg.what = LOADMOREING;
        handler.sendMessageDelayed(msg, 2000);
    }
}
