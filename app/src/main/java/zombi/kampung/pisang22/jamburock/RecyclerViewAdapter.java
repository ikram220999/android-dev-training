package zombi.kampung.pisang22.jamburock;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerView_MainLayout> {

   // declare variable
    String[] title, description;
    int[] images;
    Context ctx;

    public RecyclerViewAdapter(String[] title, String[] description, int[] images, Context ctx) {
        this.title = title;
        this.description = description;
        this.images = images;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerView_MainLayout onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.recyclerview_main_layout, parent, false);

        return new RecyclerView_MainLayout(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_MainLayout holder,
                                 @SuppressLint("RecyclerView") int position) {
        holder.tvTitle.setText(title[position]);
        holder.tvDesc.setText(description[position]);
        holder.ivImage.setImageResource(images[position]);


        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //create Intetn object to start description activity
                Intent i = new Intent(ctx, Description.class);

                // attach dataset (title, desc, image) to intent object
                i.putExtra("key_title", title[position]);
                i.putExtra("key_desc", description[position]);
                i.putExtra("key_image", images[position]);

                // start activity
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }


    public class RecyclerView_MainLayout extends RecyclerView.ViewHolder {
        ConstraintLayout main_layout;
        ImageView ivImage;
        TextView tvTitle, tvDesc;


        public RecyclerView_MainLayout(@NonNull View itemView) {
            super(itemView);

            main_layout = itemView.findViewById(R.id.main_layout);
            ivImage = itemView.findViewById(R.id.ivimage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDesc = itemView.findViewById(R.id.tvDescription);
        }
    }
}
