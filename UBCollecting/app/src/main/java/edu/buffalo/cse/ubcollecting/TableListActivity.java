package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.buffalo.cse.ubcollecting.data.tables.Table;

public class TableListActivity extends AppCompatActivity {

    private RecyclerView tableRecyclerView;
    private RecyclerView.Adapter tableAdapter;
    private RecyclerView.ViewHolder tableViewHolder;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        tableRecyclerView = findViewById(R.id.table_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        tableRecyclerView.setLayoutManager(layoutManager);
    }

    public class TableHolder extends RecyclerView.ViewHolder {
        public String tableName;

         public TableHolder(View view) {
             super(view);


         }
    }

    public class TableListRecyclerView extends RecyclerView.Adapter<TableHolder> {

        public List<Table> tableList;

        public TableListRecyclerView(List<Table> tableList) {
            this.tableList = tableList;
        }

        @Override
        public TableHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(TableHolder holder, int position) {
            Table table = tableList.get(position);
        }

        @Override
        public int getItemCount() {
            return tableList.size();
        }
    }
}
