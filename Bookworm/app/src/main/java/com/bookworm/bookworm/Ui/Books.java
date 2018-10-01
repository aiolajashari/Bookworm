package com.bookworm.bookworm.Ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
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

public class Books extends AppCompatActivity {


    private ProgressDialog progressDialog;
    SQLiteDatabaseHelper database;
    ApiInterface apiInterface;
    EditText etSearch;
    Button btnSearch;
    Doc doc;
    Button btnSend;
    RadioButton rbFinished;
    RadioButton rbToRead;
    RadioButton rbToBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://openlibrary.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        etSearch=(EditText) findViewById(R.id.editTextSearch);
        btnSearch=(Button) findViewById(R.id.search_button);


        database=new SQLiteDatabaseHelper(this,"BookwormDB",null,1);

        database.query("create table if not exists " +
                "BOOK(" +
                "Id integer primary key autoincrement, " +
                "title varchar, " +
                "author varchar, " +
                "imagePath varchar, " +
                "state varchar" +
                ")");

        apiInterface=retrofit.create(ApiInterface.class);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBookRsponse();
            }
        });
    }



    public void loadBookRsponse(){
        Call<Example> call=apiInterface.getLibrary(etSearch.getText().toString());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMax(30);
        progressDialog.setIcon(R.mipmap.ponyload);
        progressDialog.setTitle("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example=response.body();
                progressDialog.cancel();
                displayResult(example);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                progressDialog.cancel();
            }
        });
    }

    public void displayResult(Example example)
    {
        if (example!=null)
        {
            final List<Doc> docList=example.getDocs();

            ListAdapter listAdapter=new CostomAdapter(this,docList);
            ListView listView=(ListView)findViewById(R.id.listViewBooks);
            listView.setAdapter(listAdapter);

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    doc=docList.get(position);
                    AlertDialog dialog;
                    final AlertDialog.Builder builder=new AlertDialog.Builder(Books.this);
                    final View dialogView=getLayoutInflater().inflate(R.layout.book_state_dialog,null);
                    btnSend=(Button)dialogView.findViewById(R.id.btnSend);
                    rbFinished=(RadioButton) dialogView.findViewById(R.id.rbFinished);
                    rbToBuy=(RadioButton)dialogView.findViewById(R.id.rbToBuy);
                    rbToRead=(RadioButton)dialogView.findViewById(R.id.rbToRead);

                    btnSend.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           ;
                            try {
                                if (rbFinished.isChecked())
                                {
                                    database.insertBook(
                                            1,
                                            doc.getTitleSuggest(),
                                            doc.getAuthorName().get(0),
                                            doc.getCoverEditionKey()

                                    );

                                    Toast.makeText(Books.this, "Libri u insertua Finished", Toast.LENGTH_SHORT).show();



                                }else if (rbToBuy.isChecked())
                                {
                                    database.insertBook(
                                            2,
                                            doc.getTitleSuggest(),
                                            doc.getAuthorName().get(0),
                                            doc.getCoverEditionKey()
                                    );

                                    Toast.makeText(Books.this, "Libri u insertua ToBuy", Toast.LENGTH_SHORT).show();

                                }else if (rbToRead.isChecked())
                                {
                                    database.insertBook(3,
                                            doc.getTitleSuggest(),
                                            doc.getAuthorName().get(0),
                                            doc.getCoverEditionKey()
                                    );

                                    Toast.makeText(Books.this, "Libri u insertua ToRead", Toast.LENGTH_SHORT).show();

                                }
                    }catch (Exception e)
                    {
                        Toast.makeText(Books.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                        }
                    });


                    builder.setView(dialogView);
                    dialog=builder.create();
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();
                    /*try {
                        database.insertBook(
                                doc.getTitleSuggest(),
                                doc.getAuthorName().get(0),
                                doc.getCoverEditionKey()
                        );
                        Toast.makeText(Books.this, "Libri u insertua", Toast.LENGTH_SHORT).show();
                    }catch (Exception e)
                    {
                        Toast.makeText(Books.this, "Error", Toast.LENGTH_SHORT).show();
                    }*/

                    return false;

                }

            });
        }
    }


}
