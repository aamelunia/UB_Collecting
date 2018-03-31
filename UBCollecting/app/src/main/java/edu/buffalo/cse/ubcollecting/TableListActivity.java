package edu.buffalo.cse.ubcollecting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.tables.Table;

public class TableListActivity extends AppCompatActivity {

    public static final String TAG = TableListActivity.class.getSimpleName();

    private RecyclerView tableRecyclerView;
    private RecyclerView.Adapter tableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        tableRecyclerView = findViewById(R.id.table_recycler_view);
        tableRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tableAdapter = new TableAdapter(DatabaseHelper.TABLES);
        tableRecyclerView.setAdapter(tableAdapter);
    }

    private class TableHolder extends RecyclerView.ViewHolder {

        private Table table;
        private TextView tableNameView;
        private Button insertButton;
        private Button viewButton;
        private Button deleteButton;


        public TableHolder(View view) {
            super(view);

            tableNameView = view.findViewById(R.id.table_item_name_view);
            insertButton = view.findViewById(R.id.table_item_insert_button);
            viewButton = view.findViewById(R.id.table_item_view_button);
            deleteButton = view.findViewById(R.id.table_item_delete_button);
        }

        public void bindTable(Table<?> table) {
            this.table = table;
            tableNameView.setText(table.getTableName());
        }
    }

    private class TableAdapter extends RecyclerView.Adapter<TableHolder> {

        private List<Table<?>> tableList;

        public TableAdapter(List<Table<?>> tableList) {
            this.tableList = tableList;
        }

        @Override
        public TableHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater
                    .inflate(R.layout.table_list_item_view, parent, false);
            return new TableHolder(view);
        }

        @Override
        public void onBindViewHolder(TableHolder holder, int position) {
            Table table = tableList.get(position);
            holder.bindTable(table);

        }

        @Override
        public int getItemCount() {
            return tableList.size();
        }
    }
}

