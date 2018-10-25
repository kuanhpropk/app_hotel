package android.app.hotel.view;

import android.app.hotel.R;

import android.app.hotel.view.post.PostFragment;
import android.app.hotel.view.room.RoomFragment;
import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private MoreFragment moreFragment;
    private RoomFragment roomFragment;
    private PostFragment postFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapped();


        mMainNav.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_more:
                        setFragment(moreFragment);
                        return true;

                    case  R.id.nav_room:
                        setFragment(roomFragment);
                        return true;

                    case  R.id.nav_post:
                        setFragment(postFragment);
                        return true;

                        default:
                            return true;
                }
            }
        });
    }

    private void mapped(){
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);

        moreFragment = new MoreFragment();
        roomFragment = new RoomFragment();
        postFragment = new PostFragment();

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
}
