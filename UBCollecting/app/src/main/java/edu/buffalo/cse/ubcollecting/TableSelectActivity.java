package edu.buffalo.cse.ubcollecting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import edu.buffalo.cse.ubcollecting.data.models.Model;
import edu.buffalo.cse.ubcollecting.data.tables.MainTable;
import edu.buffalo.cse.ubcollecting.data.tables.Table;

import static edu.buffalo.cse.ubcollecting.EntryActivity.REQUEST_CODE_EDIT_ENTRY;

/**
 * Created by kevinrathbun on 4/10/18.
 */

public class TableSelectActivity extends AppCompatActivity {

    private static final String TAG = TableSelectActivity.class.getSimpleName();

    private static final String EXTRA_TABLE = "edu.buffalo.cse.ubcollecting.select_table";

    private MainTable<? extends Model> table;
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
            table = (MainTable) serializableExtra;
        } else {
            Log.e(TAG, "Extra was not of type Table");
            finish();
        }

        entryRecyclerView = findViewById(R.id.add_questions_recycler);
        entryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        entryAdapter = new TableSelectActivity.EntryAdapter(table.getAll());
        entryRecyclerView.setAdapter(entryAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_EDIT_ENTRY) {
            entryAdapter.setEntryList(table.getAll());
            entryAdapter.notifyDataSetChanged();
        }
    }

    private class EntryHolder extends RecyclerView.ViewHolder {

        private Model entry;
        private CheckBox selectBox;
        private TextView entryNameView;


        public EntryHolder(View view) {
            super(view);

            selectBox = findViewById(R.id.entry_list_select_box);
            entryNameView = findViewById(R.id.entry_list_select_text_view);
        }

        public void bindEntry(Model entry1) {
            entry = entry1;
            entryNameView.setText(entry.getIdentifier());
        }
    }

    private class EntryAdapter extends RecyclerView.Adapter<TableSelectActivity.EntryHolder> {

        private List<? extends Model> entryList;

        public EntryAdapter(List<? extends Model> entryList) {
            this.entryList = entryList;
        }

        public void setEntryList(List<? extends Model> entryList) {
            this.entryList = entryList;
        }

        @Override
        public TableSelectActivity.EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater
                    .inflate(R.layout.entry_list_item_select, parent, false);
            return new TableSelectActivity.EntryHolder(view);
        }

        @Override
        public void onBindViewHolder(TableSelectActivity.EntryHolder holder, int position) {
            Model entry = entryList.get(position);
            holder.bindEntry(entry);
        }

        @Override
        public int getItemCount() {
            return entryList.size();
        }
    }


}

