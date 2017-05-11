package com.fragments.apfol.andresramos.mymail.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fragments.apfol.andresramos.mymail.R;
import com.fragments.apfol.andresramos.mymail.models.Mail;

import java.util.List;

/**

 * Created by Andres Ramos on 5/7/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Mail> mails;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context context;


    public MyAdapter(List<Mail> mails, int layout, Context context, OnItemClickListener itemClickListener) {
        this.mails = mails;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.bind(mails.get(position), itemClickListener);
    }
    @Override
    public int getItemCount() {
        return mails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textSubject, textMessage, textLetter;

        public ViewHolder(View itemView) {
            super(itemView);
            textSubject = (TextView) itemView.findViewById(R.id.textViewSubject);
            textMessage = (TextView) itemView.findViewById(R.id.textViewMessage);
            textLetter = (TextView) itemView.findViewById(R.id.textViewLetter);
        }

        void bind(final Mail mail, final OnItemClickListener listener) {
            textSubject.setText(mail.getSubject());
            textMessage.setText(mail.getMessage());
            textLetter.setText(String.valueOf(mail.getSender().charAt(0)));
            textLetter.getBackground().setColorFilter(ContextCompat.getColor(context, mail.getColor()), PorterDuff.Mode.SRC_ATOP);
            //textLetter.setBackgroundColor(mail.getColor());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(mail, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Mail mail, int position);
    }
}
