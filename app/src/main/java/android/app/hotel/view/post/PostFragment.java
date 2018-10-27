package android.app.hotel.view.post;

import android.app.hotel.adapter.PostAdapter;
import android.app.hotel.model.post.Post;
import android.app.hotel.presenter.PostPresenter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.hotel.R;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment implements PostView{

    private PostAdapter postAdapter;
    private ListView lvPost;
    private PostPresenter postPresenter;

    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        lvPost = (ListView) view.findViewById(R.id.listviewPost);

        postPresenter = new PostPresenter(this);
        postPresenter.getposts();

        return view;
    }

    @Override
    public void postRead(List<Post> posts) {
        postAdapter = new PostAdapter(this.getContext(), R.layout.view_post, posts);
        lvPost.setAdapter(postAdapter);
        lvPost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int x=0; x<lvPost.getAdapter().getCount() ; x++){
                    if(position == x){
//                        Toast.makeText(view.getContext(),"gia tri da~ nhan la " + (x+1), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(),PostItent.class);
                        String Image = Objects.requireNonNull(postAdapter.getItem(position).getImage());
                        String Title = Objects.requireNonNull(postAdapter.getItem(position).getTitle());
                        String Admin = Objects.requireNonNull(postAdapter.getItem(position).getAdmin());
                        String Ago = Objects.requireNonNull(postAdapter.getItem(position).getAgo());
                        String Tag = Objects.requireNonNull(postAdapter.getItem(position).getTag());
                        String DescriptionLong = Objects.requireNonNull(postAdapter.getItem(position).getLongDescription());

                        intent.putExtra("Image", Image.toString());
                        intent.putExtra("Title", Title.toString());
                        intent.putExtra("Admin", Admin.toString());
                        intent.putExtra("Ago", Ago.toString());
                        intent.putExtra("Tag", Tag.toString());
                        intent.putExtra("DescriptionLong", DescriptionLong.toString());
                        startActivity(intent);
                    }
                }
            }
        });
    }


}
