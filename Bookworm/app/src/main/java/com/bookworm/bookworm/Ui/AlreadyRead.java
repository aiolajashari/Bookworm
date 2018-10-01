package com.bookworm.bookworm.Ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bookworm.bookworm.Api.Model.Doc;
import com.bookworm.bookworm.Api.Model.Example;
import com.bookworm.bookworm.Api.Service.ApiInterface;
import com.bookworm.bookworm.Api.Service.SQLiteDatabaseHelper;
import com.bookworm.bookworm.R;
import com.bookworm.bookworm.Ui.Adapter.CostomAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AlreadyRead extends AppCompatActivity {


    SQLiteDatabaseHelper database;
    Cursor cursor=null;
    List<Doc> docList;
    CostomAdapter listAdapter;
    ListView listView;
    List<Doc> finishedBooks;
    //static int Score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read);
        //Score=0;


        database=new SQLiteDatabaseHelper(this,"BookwormDB",null,1);
        cursor=database.getBook("select * from BOOK where state=1");
        finishedBooks=getBookFromDatabase();
        listAdapter=new CostomAdapter(this, finishedBooks);
        listView=(ListView)findViewById(R.id.listViewBooksFinished);
        listView.setAdapter(listAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //
                Doc doc ;
                doc=docList.get(position);

                database.deleteBook(doc.getId());
                //Home.scorecount=getBookFromDatabase().size();
                listAdapter.notifyDataSetChanged();
                finishedBooks=getBookFromDatabase();
                listAdapter=new CostomAdapter(AlreadyRead.this, finishedBooks);
                listView.setAdapter(listAdapter);
                return false;
            }
        });

    }

    public List<Doc> getBookFromDatabase()
    {
        cursor=database.getBook("select * from BOOK where state=1");
        docList=new ArrayList<>();
        int id;
        String title;
        String author;
        String imagePath;
        while (cursor.moveToNext())
        {
            id=cursor.getInt(0);
            title=cursor.getString(1);
            author=cursor.getString(2);
            imagePath=cursor.getString(3);
            docList.add(new Doc(id,title,author,imagePath));

        }
        return docList;
    }
}

