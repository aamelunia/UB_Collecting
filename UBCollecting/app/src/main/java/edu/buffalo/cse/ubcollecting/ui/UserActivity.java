package edu.buffalo.cse.ubcollecting.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

import edu.buffalo.cse.ubcollecting.R;
import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;

import static edu.buffalo.cse.ubcollecting.EntryActivity.REQUEST_CODE_EDIT_ENTRY;

public class UserActivity extends AppCompatActivity {

    private static final String TAG = AppCompatActivity.class.getSimpleName();

    private final static int REQUEST_CODE_ADD_ENTRY = 3;

    private Button createFieldTrip;
    private RecyclerView entryRecyclerView;
    private EntryAdapter entryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        entryRecyclerView = findViewById(R.id.fieldtrip_recycler_view);
        entryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        entryAdapter = new UserActivity.EntryAdapter(DatabaseHelper.FIELD_TRIP_TABLE.getActiveFieldTrips());
        entryRecyclerView.setAdapter(entryAdapter);

        createFieldTrip = findViewById(R.id.create_new_fieldtrip);

        createFieldTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = DatabaseHelper.FIELD_TRIP_TABLE.insertActivityIntent(UserActivity.this);
                startActivityForResult(i,REQUEST_CODE_ADD_ENTRY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_EDIT_ENTRY || requestCode == REQUEST_CODE_ADD_ENTRY) {
            entryAdapter.setEntryList(DatabaseHelper.FIELD_TRIP_TABLE.getActiveFieldTrips());
            entryAdapter.notifyDataSetChanged();
        }

    }

    private class EntryHolder extends RecyclerView.ViewHolder {

        private FieldTrip fieldTrip;
        private Button selectButton;
        private ImageButton editButton;
        private ImageButton deleteButton;


        public EntryHolder(View view) {
            super(view);

            selectButton = view.findViewById(R.id.entry_list_select_button);
            editButton = view.findViewById(R.id.entry_list_edit_button);
            deleteButton = view.findViewById(R.id.entry_list_delete_button);
        }

        public void bindEntry(FieldTrip fieldTrip) {
            this.fieldTrip = fieldTrip;
            selectButton.setText(this.fieldTrip.getIdentifier());

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = DatabaseHelper.FIELD_TRIP_TABLE.editActivityIntent(UserActivity.this, EntryHolder.this.fieldTrip);
                    startActivityForResult(i, REQUEST_CODE_EDIT_ENTRY);
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseHelper.FIELD_TRIP_TABLE.delete(EntryHolder.this.fieldTrip.id);
                    entryAdapter.setEntryList(DatabaseHelper.FIELD_TRIP_TABLE.getActiveFieldTrips());
                    entryAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    private class EntryAdapter extends RecyclerView.Adapter<UserActivity.EntryHolder> {

        private List<FieldTrip> entryList;

        public EntryAdapter(List<FieldTrip> entryList) {
            this.entryList = entryList;
        }

        public void setEntryList(List<FieldTrip> entryList) {
            this.entryList = entryList;
        }

        @Override
        public UserActivity.EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater
                    .inflate(R.layout.field_trip_item_view, parent, false);
            return new UserActivity.EntryHolder(view);
        }

        @Override
        public void onBindViewHolder(UserActivity.EntryHolder holder, int position) {
            FieldTrip entry = entryList.get(position);
            holder.bindEntry(entry);
        }

        @Override
        public int getItemCount() {
            return entryList.size();
        }
    }

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, UserActivity.class);
        return i;
    }

}