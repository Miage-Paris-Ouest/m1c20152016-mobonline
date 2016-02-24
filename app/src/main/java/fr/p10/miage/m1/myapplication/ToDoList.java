package fr.p10.miage.m1.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import fr.p10.miage.m1.myapplication.model.CustomAdapter;
import fr.p10.miage.m1.myapplication.model.ToDo;

public class ToDoList extends AppCompatActivity {

    ListView lv;
    ArrayList<ToDo> als = new ArrayList<ToDo>();
    CustomAdapter adapter;
    final Context context = this;

    private int year;
    private int month;
    private int day;
    String dateTxt;
    //file
    String[] to_do_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        lv = (ListView) findViewById(R.id.listView);

        TextView date = (TextView) findViewById(R.id.date);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        dateTxt = month+1+"-"+day+"-"+year+" ";


        //file
        to_do_list = getResources().getStringArray(R.array.to_do_list);


        for(int i=0;i<to_do_list.length;i++)
        {
            als.add( new ToDo(to_do_list[i], 0,dateTxt));
        }

        //test
        /*
        als.add( new ToDo("test1", 0));
        als.add( new ToDo("test2", 1));
        */

        adapter = new CustomAdapter(this, als);
        lv.setAdapter(adapter);

        Button loginButton = (Button) findViewById(R.id.button_add_to_list);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.to_do_list_txt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextView);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text

                                            String txt = userInput.getText().toString();

                                            //datePicke est null
                                            /*
                                            DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
                                            day = datePicker.getDayOfMonth();
                                            Log.w("className ERROR"," jour : " + day);
                                            month = datePicker.getMonth() + 1;
                                            year = datePicker.getYear();
                                            dateTxt = month+"-"+day+"-"+year+" ";
                                            */

                                            ToDo td=new ToDo(txt, 0,dateTxt);

                                            als.add(td);
                                            lv.setAdapter(adapter);


                                        }
                                    }

                                    )
                                            .

                                    setNegativeButton("Cancel",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    dialog.cancel();
                                                }
                                            }

                                    );

                                    // create alert dialog
                                    AlertDialog alertDialog = alertDialogBuilder.create();

                                    // show it
                                    alertDialog.show();

                                }
            });
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
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
