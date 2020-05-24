package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class BrandViewHolder extends RecyclerView.ViewHolder {
    TextView txt;
    View view;

    public BrandViewHolder(View v){
        super(v);
        view = v;
        txt = v.findViewById(R.id.textView);
    }
}
