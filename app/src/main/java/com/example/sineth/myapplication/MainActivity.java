package com.example.sineth.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //for a recycle view to work you need to have 3 components
    //those are the above mentioned types of objects.
    //adapter is for setting the data inside the recycler view
    // layout manager handles the overall layout operations like
    // recycling the views and making the UI more attractive

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //this is the way we map whatever in the GUI of the screen to the
        // java code lying here use findviewbyid method and cast to the needed
        // type like i've done here.

        layoutManager = new LinearLayoutManager(this);
        //setting the linear layout of the view this will look like a normal list
        recyclerView.setLayoutManager(layoutManager);


        //we need to set up the adapter here for the recycler view.
        adapter = new RVAdapter(getDataset());
        recyclerView.setAdapter(adapter);
    }

    //This method only provides the data for testing purposes
    //should be dumped in real testing purposes;
    private String[] getDataset() {
        return new String[]{"a", "b", "c"};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
