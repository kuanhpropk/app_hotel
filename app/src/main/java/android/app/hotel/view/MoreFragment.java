package android.app.hotel.view;


import android.app.hotel.R;
import android.app.hotel.adapter.MoreLayoutAdapter;
import android.app.hotel.model.more.MoreLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ListView listView = (ListView) view.findViewById(R.id.lvMore);
        MoreLayoutAdapter moreLayoutAdapter = new MoreLayoutAdapter(this.getContext(), generateData());

        listView.setAdapter(moreLayoutAdapter);

        return view;
    }

    public ArrayList<MoreLayout> generateData(){
        ArrayList<MoreLayout> moreLayouts = new ArrayList<MoreLayout>();

        moreLayouts.add(new MoreLayout("Thông tin ứng dụng"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_home, "Giới thiệu"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_action_news, "Liên hệ"));
        moreLayouts.add(new MoreLayout("Người dùng"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_assignment_ind, "Thông tin tài khoản"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_action_help, "Hướng dẫn"));

        return  moreLayouts;
    }

}
