package android.app.hotel.view.service;


import android.app.hotel.R;
import android.app.hotel.adapter.RoomAdapter;
import android.app.hotel.adapter.ServiceAdapter;
import android.app.hotel.model.room.Room;
import android.app.hotel.model.service.Service;
import android.app.hotel.presenter.RoomPresenter;
import android.app.hotel.presenter.ServicePresenter;
import android.app.hotel.view.room.RoomDetail;
import android.app.hotel.view.room.RoomView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFragment extends Fragment implements ServiceView {

    private Toolbar toolbar;
    private ServiceAdapter serviceAdapter;
    private ListView lvService;

    public ServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_service, container, false);

        toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitle("Danh sách dịch vụ");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);


        lvService = (ListView) view.findViewById(R.id.listviewService);

        ServicePresenter servicePresenter = new ServicePresenter(this);
        servicePresenter.getServices();

        return view;
    }

    @Override
    public void serviceRead(final List<Service> services) {
        serviceAdapter = new ServiceAdapter(this.getContext(), R.layout.view_service, services);
        lvService.setAdapter(serviceAdapter);

        lvService.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), RoomDetail.class);
                intent.putExtra("name", services.get(position).getName());

                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home)
        {
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
