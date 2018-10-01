package com.bookworm.bookworm.Ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuInflater;
import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
import android.widget.ImageView;
//import android.widget.ListView;
import android.widget.TextView;

import com.bookworm.bookworm.Api.Model.Doc;
import com.bookworm.bookworm.Api.Service.SQLiteDatabaseHelper;
import com.bookworm.bookworm.R;

import java.util.ArrayList;
import java.util.List;


public class Home extends AppCompatActivity {

    SQLiteDatabaseHelper database;
    Cursor cursor=null;
    List<Doc> docList;
    TextView count;
    static int scorecount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        scorecount=0;
        database=new SQLiteDatabaseHelper(this,"BookwormDB",null,1);
        cursor=database.getBook("select * from BOOK where state=1");
        scorecount=getBookFromDatabase().size();



        ImageView ivWormPic = findViewById(R.id.ivLogo);
        ivWormPic.setImageResource(R.drawable.worm);


        ImageView ivOnePic = findViewById(R.id.ivBadge);
        ivOnePic.setImageResource(R.drawable.one);

         count= findViewById(R.id.tvCount);
         count.setText("Score: " + scorecount);
        //(TexptView)
    }

    public void buBooks(View view)
    {
        Intent intent = new Intent(this, Books.class);
        startActivity(intent);
    }

    public void buFinishedBooksClick(View view) {
        Intent intent = new Intent(this, AlreadyRead.class);
        startActivity(intent);
    }

    public void buBooksToBuyClicked(View view) {
        Intent intent = new Intent(this,WishList.class);
        startActivity(intent);
    }

    public void buScoreBoardClicked(View view) {
        Intent intent = new Intent(this,Scoreboard.class);
        intent.putExtra("tvpPrompt",count.getText().toString());
        startActivity(intent);
    }

    public void buBooksToReadClicked(View view) {
        Intent intent = new Intent(this,BooksToRead.class);
        startActivity(intent);
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
            //Score++;

        }
        return docList;
    }
}
