package fr.p10.miage.m1.myapplication;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.p10.miage.m1.myapplication.ExpandableList.ExpandableListAdapter;

import fr.p10.miage.m1.myapplication.model.AsyncResponse;
import fr.p10.miage.m1.myapplication.model.CategoryPage;
import fr.p10.miage.m1.myapplication.model.Communicator;
import fr.p10.miage.m1.myapplication.model.Page;
import fr.p10.miage.m1.myapplication.model.ResourceHelper;


public class HowTo extends AppCompatActivity implements AsyncResponse {
    private RecyclerView recyclerview;
    private Map<Integer,CategoryPage> categories;

    private List<ExpandableListAdapter.Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expandable_list);

        categories=new HashMap<>();

        initChildrenPages(getIntent().getIntExtra("cat_id", -1));

        TextView title = (TextView) findViewById(R.id.TextView_list_header);
        title.setText("How To ?");

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }

    public void initChildrenPages(Integer parentId) {
        Log.i("HOW TO !!","Cat parent to take: "+parentId);
        Communicator c = new Communicator();
        c.delegate=this;
        c.execute("http://10.0.2.2:8080/NanterasmusWEB/REST/university/pages/enfants.json?university=" + ((ShareDatas) getApplicationContext()).univId + "&cat_parent="+parentId);
    }

    @Override
    public void processFinish(String output) {
        try {
            JSONObject parentObject = new JSONObject(output);

            String status = parentObject.getString("status");

            JSONArray categoriesArray=parentObject.getJSONArray("categories");

            for (int i = 0; i < categoriesArray.length(); i++) {
                JSONObject jsonCategory = categoriesArray.getJSONObject(i);
                CategoryPage childCategory=new CategoryPage(jsonCategory.getInt("cat_id"),jsonCategory.getString("cat_name"),null);
                JSONArray pagesArray=jsonCategory.getJSONArray("pages");
                Log.i("JSONPAGES !!!",pagesArray.toString());
                for (int j = 0; j < pagesArray.length(); j++) {

                    JSONObject jsonPage = pagesArray.getJSONObject(j);
                    Log.i("JSONPAGE !!!",jsonPage.toString());
                    childCategory.addPage(new Page(jsonPage.getInt("page_id"),jsonPage.getString("page_title"),jsonPage.getString("page_content")));
                    Log.i("Pages !!!", "Page id :"+jsonPage.getInt("page_id")+", Page title: "+jsonPage.getString("page_title"));
                }
                categories.put(jsonCategory.getInt("cat_id"),childCategory);

                Log.i("CategoriesFilles !!!","CatName :"+jsonCategory.getString("cat_name")+"Cat Id"+jsonCategory.getInt("cat_id")+", nombre de pages ="+pagesArray.length());
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // On récupère le nom de notre classe
        String className = getLocalClassName();

        // On crée notre liste avec les paramètres de notre classe et les informations requises
        data = new ArrayList<>();

        for(Map.Entry<Integer, CategoryPage> entry : categories.entrySet()) {

            data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER, entry.getValue().getTitle()));
            for(Map.Entry<Integer, Page> entryPage : entry.getValue().getPages().entrySet()) {
                Log.i("Remplissage !!!", "Page id :"+entryPage.getValue().getId()+", Page title: "+entryPage.getValue().getTitle());
                data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD, entryPage.getValue().getTitle(),entryPage.getValue().getContent()));
            }
        }
        // on set notre recyclerview avec les informations des listes qui renvoient sur la page de la classname passée en paramètre
        recyclerview.setAdapter(new ExpandableListAdapter(data,className));
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
        if (id == R.id.action_profile) {
            Intent intent = new Intent(this, Settings.class);
            //intent.putExtra("content_how_to",categories.g);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
