package com.iampaul83.pulltorefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class SwipeRefreshLayoutFragment extends Fragment {

    private static final String ARG_DATA = "data";
    private String[] data = new String[]{};

    private SwipeRefreshLayout swipeRefreshLayout;
    private GridView gridView;

    public static SwipeRefreshLayoutFragment newInstance(String[] data) {
        SwipeRefreshLayoutFragment fragment = new SwipeRefreshLayoutFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    public SwipeRefreshLayoutFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            data = getArguments().getStringArray(ARG_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe_refresh_layout, container, false);

        gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setAdapter(
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data)
        );

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeColors(
                Color.BLUE,
                Color.GREEN,
                Color.RED
        );
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO: refresh code...
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (swipeRefreshLayout!=null) {
            swipeRefreshLayout.setRefreshing(false);
            swipeRefreshLayout.clearAnimation();
        }
    }

}
