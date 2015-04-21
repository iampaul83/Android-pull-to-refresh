package com.iampaul83.pulltorefresh;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;


public class PullToRefreshFragment extends Fragment {

    private static final String ARG_DATA = "data";
    private String[] data = new String[]{};

    private PtrFrameLayout ptrFrameLayout;
    private GridView gridView;

    public PullToRefreshFragment() {}

    public static PullToRefreshFragment newInstance(String[] data) {
        PullToRefreshFragment fragment = new PullToRefreshFragment();
        Bundle args = new Bundle();
        args.putStringArray(ARG_DATA, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            data = getArguments().getStringArray(ARG_DATA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pull_to_refresh, container, false);

        gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setAdapter(
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data)
        );

        ptrFrameLayout = (PtrFrameLayout) view.findViewById(R.id.ptrFrameLayout);

        final StoreHouseHeader header = new StoreHouseHeader(getActivity());
        header.setPadding(0, PtrLocalDisplay.dp2px(15), 0, 0);
        header.initWithString("Paul is Loading");
        header.setTextColor(Color.BLUE);

        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);

        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                //TODO: refresh code...
            }
        });


        return view;
    }

}
