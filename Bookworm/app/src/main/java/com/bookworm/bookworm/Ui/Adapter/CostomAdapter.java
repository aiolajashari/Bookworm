package com.bookworm.bookworm.Ui.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookworm.bookworm.Api.Model.Doc;
import com.bookworm.bookworm.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Valdrin on 2/7/2018.
 */

public class CostomAdapter extends ArrayAdapter<Doc>{


    public CostomAdapter(Context context, List<Doc> docList) {
        super(context, R.layout.item_book,docList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View costumView=inflater.inflate(R.layout.item_book,parent,false);

        Doc singleDoc=getItem(position);
        TextView title=(TextView) costumView.findViewById(R.id.textviewTitle);
        TextView author=(TextView) costumView.findViewById(R.id.textviewAuthor);
        ImageView imageCover=(ImageView) costumView.findViewById(R.id.imageviewBookCover);

        title.setText(singleDoc.getTitleSuggest());
        if (singleDoc.getAuthorName()!=null)
        {
            author.setText(singleDoc.getAuthorName().get(0));
        }
        else{
            author.setText("");
        }
        Picasso.with(getContext()).load(Uri.parse(singleDoc.getLargeCoverUrl())).error(R.drawable.imagenotfound).into(imageCover);
        return costumView;

    }
}
