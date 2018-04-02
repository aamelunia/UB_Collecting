package edu.buffalo.cse.ubcollecting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Model;
import edu.buffalo.cse.ubcollecting.data.tables.Table;

public class TableViewActivity extends AppCompatActivity {

    private static final String TAG = AppCompatActivity.class.getSimpleName();

    private static final String EXTRA_TABLE = "edu.buffalo.cse.ubcollecting.table";

    private Table<? extends Model> table;
    private RecyclerView entryRecyclerView;
    private EntryAdapter entryAdapter;


    public static Intent newIntent(Context packageContext, Table table) {
        Intent i = new Intent(packageContext, TableViewActivity.class);
        i.putExtra(EXTRA_TABLE, table);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_view);

        Serializable serializableExtra = getIntent().getSerializableExtra(EXTRA_TABLE);

        if (serializableExtra instanceof Table) {
            table = (Table) serializableExtra;
        } else {
            Log.e(TAG, "Extra was not of type Table");
            finish();
        }

        entryRecyclerView = findViewById(R.id.entry_list_view);
        entryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        entryAdapter = new TableViewActivity.EntryAdapter(table.getAll());
        entryRecyclerView.setAdapter(entryAdapter);
    }

    private class EntryHolder extends RecyclerView.ViewHolder {

        private Model entry;
        private TextView entryNameView;
        private Button editButton;
        private Button deleteButton;


        public EntryHolder(View view) {
            super(view);

            entryNameView = findViewById(R.id.entry_list_text_view);
            editButton = findViewById(R.id.entry_list_edit_button);
            deleteButton = findViewById(R.id.entry_list_delete_button);
        }

        public void bindEntry(Model entry1) {
            this.entry = entry1;
            entryNameView.setText(entry.getIdentifier());

            editButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO
                }
            });
        }
    }

    private class EntryAdapter extends RecyclerView.Adapter<TableViewActivity.EntryHolder> {

        private List<? extends Model> entryList;

        public EntryAdapter(List<? extends Model> entryList) {
            this.entryList = entryList;
        }

        @Override
        public TableViewActivity.EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater
                    .inflate(R.layout.entry_list_item_view, parent, false);
            return new TableViewActivity.EntryHolder(view);
        }

        @Override
        public void onBindViewHolder(TableViewActivity.EntryHolder holder, int position) {
            Model entry = entryList.get(position);
            holder.bindEntry(entry);

        }

        @Override
        public int getItemCount() {
            return entryList.size();
        }
    }
}
