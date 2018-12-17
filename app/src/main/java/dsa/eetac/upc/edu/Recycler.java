package dsa.eetac.upc.edu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends RecyclerView.Adapter<Recycler.ViewHolder> {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private List<Track> data;
    private Context context;

    public void addTracks(List<Track> tracksList) {
        data.addAll(tracksList);
        notifyDataSetChanged();
    }

    //Asign the text TextView to the text1 in the layout
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private TextView idTrackView;
        private TextView titleTrackView;
        private TextView singerTrackView;

        public ViewHolder(View v) {
            super(v);
            idTrackView = v.findViewById(R.id.idTrack);
            titleTrackView = v.findViewById(R.id.titleTrack);
            singerTrackView = v.findViewById(R.id.singerTrack);
            linearLayout = v.findViewById(R.id.linearLayout);
        }
    }

    //Constructor
    public Recycler(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    @Override
    public Recycler.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Recycler.ViewHolder holder, int position) {
        Track trackData = data.get(position);
        holder.idTrackView.setText("ID: " + String.valueOf(trackData.id));
        holder.titleTrackView.setText("Title: " +trackData.title);
        holder.singerTrackView.setText("Singer: " +trackData.singer);

        /*holder.linearLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProfileFollowerActivity.class);
            TextView editText = v.findViewById(R.id.followerNameView);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            context.startActivity(intent);
        });*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
