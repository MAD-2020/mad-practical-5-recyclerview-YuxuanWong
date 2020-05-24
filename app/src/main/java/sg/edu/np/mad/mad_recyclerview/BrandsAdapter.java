package sg.edu.np.mad.mad_recyclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BrandsAdapter extends RecyclerView.Adapter<BrandViewHolder> {
    ArrayList<String> data;
    Context context;

    public BrandsAdapter (ArrayList<String> input){
        data = input;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list, parent,false);
        return new BrandViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, final int position){
        final String s = data.get(position);
        holder.txt.setText(s);holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                View message = ((Activity)context).getLayoutInflater().inflate(R.layout.dialog, null);
                TextView text = message.findViewById(R.id.textView3);
                text.setText(data.get(position) + "?");
                builder.setView(message);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
