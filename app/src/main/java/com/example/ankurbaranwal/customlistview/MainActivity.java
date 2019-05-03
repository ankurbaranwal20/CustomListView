package com.example.ankurbaranwal.customlistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button bt1;
    ListView listView;
    String [] name = {"Ankur","Subir","Pankaj","Harsh","Arun"};
    //String[] reg ={"101","102","103","104","105"};
    int  image ;
    ArrayList<User> a1;
    int count = 0;

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);
        bt1 = (Button)findViewById(R.id.bt1);
        listView =(ListView)findViewById(R.id.ls1);

        a1 = new ArrayList<>();
        adapter = new MyAdapter(this,a1);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                User u1 = (User)adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,u1.getName()+" " + u1.getReg() + " ",Toast.LENGTH_SHORT).show();
                Bundle b1= new Bundle();
                b1.putString("K1",u1.getName());
                b1.putString("K2",u1.getReg());
                intent.putExtras(b1);
                startActivity(intent);
//
            }
        });

        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                if (checked)
                {
                    count = count+1;
                    adapter.getItemId(position);

                }
                mode.setTitle("Seleceted item :" + count);
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.my_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(final ActionMode mode, MenuItem item)
            {
                switch  (item.getItemId()) {

                    case R.id.selectAll:

                        //

                        final int checkedCount  = myList.size();

                        // If item  is already selected or checked then remove or

                        // unchecked  and again select all

                        adapter.removeSelection();

                        for (int i = 0; i <  checkedCount; i++) {

                            listView.setItemChecked(i,   true);

                            //  listviewadapter.toggleSelection(i);

                        }

                        // Set the  CAB title according to total checked items



                        // Calls  toggleSelection method from ListViewAdapter Class



                        // Count no.  of selected item and print it

                        mode.setTitle(checkedCount  + "  Selected");

                        return true;

                    case R.id.delete:

                        // Add  dialog for confirmation to delete selected item

                        // record.

                        AlertDialog.Builder  builder = new AlertDialog.Builder(

                                MainActivity.this);

                        builder.setMessage("Do you  want to delete selected record(s)?");



                        builder.setNegativeButton("No", new  DialogInterface.OnClickListener() {



                            @Override

                            public void  onClick(DialogInterface dialog, int which) {

                                // TODO  Auto-generated method stub



                            }

                        });

                        builder.setPositiveButton("Yes", new  DialogInterface.OnClickListener() {



                            @Override

                            public void  onClick(DialogInterface dialog, int which) {

                                // TODO  Auto-generated method stub

                                SparseBooleanArray selected = adapter

                                        .getSelectedIds();

                                for (int i =  (selected.size() - 1); i >= 0; i--) {

                                    if  (selected.valueAt(i)) {

                                        String  selecteditem = (String) adapter

                                                .getItem(selected.keyAt(i));

                                        // Remove  selected items following the ids

                                        adapter.remove(selecteditem);

                                    }

                                }



                                // Close CAB

                                mode.finish();

                                selected.clear();



                            }

                        });

                        return true;

                    default:

                        return false;

                }



            }


            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
}


    public void dothis(View view)
    {

        String name= ed1.getText().toString();
         String reg = ed2.getText().toString();

         if(ed1.getText().toString().equalsIgnoreCase("Ankur"))
             image = R.drawable.ank ;
         else if (ed1.getText().toString().equalsIgnoreCase("Subir"))
             image =R.drawable.a ;
         else if (ed1.getText().toString().equalsIgnoreCase("Pankaj"))
             image =R.drawable.ank ;
         else if (ed1.getText().toString().equalsIgnoreCase("Harsh"))
             image = R.drawable.a;
         else if (ed1.getText().toString().equalsIgnoreCase("Arun"))
             image =R.drawable.ank ;
         else
             return;

         User user = new User(name, reg, image);
         a1.add(user);

         adapter.notifyDataSetChanged();
    }
}
