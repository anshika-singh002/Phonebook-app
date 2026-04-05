package com.example.viewgroupapplication;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

public class EmergencyAdapter extends RecyclerView.Adapter<EmergencyAdapter.EmergencyViewHolder> {

    private List<EmergencyContact> contactList;

    // Constructor
    public EmergencyAdapter(List<EmergencyContact> contactList) {
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public EmergencyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emergency, parent, false);
        return new EmergencyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmergencyViewHolder holder, int position) {
        EmergencyContact contact = contactList.get(position);

        // Set the text for the UI
        holder.textTitle.setText(contact.getTitle());
        holder.textPhone.setText("Tap to call: " + contact.getPhoneNumber());

        // Attach the Dialer Intent to the entire CardView
        holder.emergencyCard.setOnClickListener(v -> {
            Context context = v.getContext();
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
            context.startActivity(dialIntent);
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    // ViewHolder Class
    public static class EmergencyViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView emergencyCard;
        TextView textTitle;
        TextView textPhone;

        public EmergencyViewHolder(@NonNull View itemView) {
            super(itemView);
            emergencyCard = itemView.findViewById(R.id.emergencyCard);
            textTitle = itemView.findViewById(R.id.textEmergencyTitle);
            textPhone = itemView.findViewById(R.id.textEmergencyPhone);
        }
    }
}