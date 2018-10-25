package android.app.hotel.adapter;

import android.app.hotel.R;
import android.app.hotel.model.room.Post;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends ArrayAdapter<Post> {

    public PostAdapter(Context context, int textViewResourceId){
        super(context,textViewResourceId);
    }
    public PostAdapter(Context context, int resource, List<Post> items){
        super(context,resource,items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        Post p = getItem(position);
        if (v== null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.view_post,null);
        }

        Post us = getItem(position);

        if (us != null)
        {
            TextView txttieude = (TextView)v.findViewById(R.id.txtTieuDe);
            txttieude.setText(us.getTitle());
//
            TextView txtNoiDung = (TextView)v.findViewById(R.id.txtNoiDung);
            txtNoiDung.setText(us.getShortDescription());
//
            TextView txtAdmin = (TextView)v.findViewById(R.id.txtadmin);
            txtAdmin.setText(us.getAdmin());
//
            TextView txtCreate = (TextView)v.findViewById(R.id.txtcreate);
            txtCreate.setText(us.getAgo());
//
            Picasso.get().load(us.getImage()).into((ImageView) v.findViewById(R.id.imageViewHinh));
//            Picasso.with(getContext())
//                    .load(us)
//                    .fit() // will explain later
//                    .into((ImageView) v.findViewById(R.id.imageViewHinh));
        }

        return  v;

    }
}
