package me.crafter.android.zjsnviewer.ui.info.infofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.crafter.android.zjsnviewer.util.DockInfo;
import me.crafter.android.zjsnviewer.R;
import rx.Observable;


public class TravelFragment extends Fragment {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.textView4)
    TextView textView4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.widget__travel, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshView();
    }

    public void refreshView(){

        try {

            Observable.just(DockInfo.getTravelBoard()).subscribe(this::setTextView);
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    private void setTextView(String[] strings){

        textView1.setText(strings[0]);
        textView2.setText(strings[1]);
        textView3.setText(strings[2]);
        textView4.setText(strings[3]);
    }
}
