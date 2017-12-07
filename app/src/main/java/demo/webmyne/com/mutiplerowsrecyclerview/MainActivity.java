package demo.webmyne.com.mutiplerowsrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView rvMultipleViewType;
    private List<User> mData;
    private CustomAdaptor adaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMultipleViewType = (RecyclerView) findViewById(R.id.rv_multipe_view_type);
        mData = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            User user = new User();
            user.setImage(R.drawable.apple);
            user.setName("Chirag");
            user.setCity("Navsari");
            mData.add(user);
        }
       /* mData.add(new User(R.mipmap.ic_launcher,"Chirag","Navsari"));
        mData.add(R.drawable.one);
        mData.add("East");
        mData.add("West");
        mData.add(new User("Sagar Telyani", "Gothra"));
        mData.add("Android");
        mData.add(R.drawable.two);
        mData.add(R.drawable.three);
        mData.add(new User("Jay Patel", "Mehsana"));
        mData.add("North");
        mData.add("South");
        mData.add(new User("Varun", "Surat"));
        mData.add(R.drawable.four);
        mData.add(R.drawable.five);
        mData.add("Cyber");
        mData.add(new User("Antim Patel", "Navsari"));
        mData.add(R.drawable.six);*/
        adaptor = new CustomAdaptor(this, mData);
        rvMultipleViewType.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rvMultipleViewType.setAdapter(adaptor);
        rvMultipleViewType.setLayoutManager(new LinearLayoutManager(this));

    }
}
