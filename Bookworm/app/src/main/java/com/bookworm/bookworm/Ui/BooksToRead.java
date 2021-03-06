package com.bookworm.bookworm.Ui;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bookworm.bookworm.Api.Model.Doc;
import com.bookworm.bookworm.Api.Service.SQLiteDatabaseHelper;
import com.bookworm.bookworm.R;
import com.bookworm.bookworm.Ui.Adapter.CostomAdapter;

import java.util.ArrayList;
import java.util.List;

public class BooksToRead extends AppCompatActivity {


    SQLiteDatabaseHelper database;
    Cursor cursor=null;
    List<Doc> docList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_to_read);

        database=new SQLiteDatabaseHelper(this,"BookwormDB",null,1);
        cursor=database.getBook("select * from BOOK where state=3");

        ListAdapter listAdapter=new CostomAdapter(this,getBookFromDatabase());
        ListView listView=(ListView)findViewById(R.id.listViewBookToRead);
        listView.setAdapter(listAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Doc doc ;
                doc=docList.get(position);
                try {
                    database.deleteBook(doc.getId());
                    Toast.makeText(BooksToRead.this, "Delete", Toast.LENGTH_SHORT).show();
                }catch (Exception e)
                {
                    Toast.makeText(BooksToRead.this, "Error", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    public List<Doc> getBookFromDatabase()
    {
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
