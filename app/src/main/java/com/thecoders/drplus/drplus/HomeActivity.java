package com.thecoders.drplus.drplus;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class HomeActivity extends BaseActivity {
    public RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        ContentAdapter adapter = new ContentAdapter(mRecyclerView.getContext());
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);





    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iconeDocteur;
        public TextView name;
        public TextView specialite;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_list, parent, false));
            iconeDocteur = (ImageView) itemView.findViewById(R.id.list_icon);
            name = (TextView) itemView.findViewById(R.id.list_docteur);
            specialite = (TextView) itemView.findViewById(R.id.list_specialite);
        }
    }

    /**
     * Adapter to display recycler view.
     */
    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
        // Set numbers of List in RecyclerView.
        private static final int LENGTH = 18;
        private final String[] mDocteurs;
        private final String[] mSpecialites;
        private final Drawable[] mPlaceAvators;
        public ContentAdapter(Context context) {
            Resources resources = context.getResources();


            mDocteurs = resources.getStringArray(R.array.docteur);
            mSpecialites = resources.getStringArray(R.array.specialite);
            TypedArray a = resources.obtainTypedArray(R.array.icone_docteur);

            mPlaceAvators = new Drawable[a.length()];
            for (int i = 0; i < mPlaceAvators.length; i++) {
                mPlaceAvators[i] = a.getDrawable(i);
            }
            a.recycle();





        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.iconeDocteur.setImageDrawable(mPlaceAvators[position % mPlaceAvators.length]);
            holder.name.setText(mDocteurs[position % mDocteurs.length]);
            holder.specialite.setText(mSpecialites[position % mSpecialites.length]);
        }

        @Override
        public int getItemCount() {
            return LENGTH;
        }
    }
}
