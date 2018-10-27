package android.app.hotel.view;


import android.app.hotel.R;
import android.app.hotel.adapter.MoreLayoutAdapter;
import android.app.hotel.model.more.MoreLayout;
import android.app.hotel.view.huongdan.Huongdan_intent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        final MoreLayoutAdapter moreLayoutAdapter = new MoreLayoutAdapter(this.getContext(), generateData());

        listView.setAdapter(moreLayoutAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position==4){
//                            hướng dẫn
                            Intent intent = new Intent(getActivity(),Huongdan_intent.class);
                            startActivity(intent);
//                            Toast.makeText(view.getContext(),"gia tri da~ nhan la " + (x+1), Toast.LENGTH_SHORT).show();
                        }

            }
        });
        return view;
    }

    public ArrayList<MoreLayout> generateData(){
        ArrayList<MoreLayout> moreLayouts = new ArrayList<MoreLayout>();

        moreLayouts.add(new MoreLayout(R.drawable.ic_home, "Giới thiệu"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_action_news, "Liên hệ"));
        moreLayouts.add(new MoreLayout());
        moreLayouts.add(new MoreLayout(R.drawable.ic_assignment_ind, "Thông tin tài khoản"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_action_help, "Hướng dẫn"));

        return  moreLayouts;
    }

}
