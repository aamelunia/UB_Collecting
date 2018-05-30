package edu.buffalo.cse.ubcollecting;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

import edu.buffalo.cse.ubcollecting.data.models.Model;
import edu.buffalo.cse.ubcollecting.data.tables.Table;

import static edu.buffalo.cse.ubcollecting.data.tables.Table.EXTRA_MODEL;

/**
 * Created by kevinrathbun on 4/2/18.
 */

public abstract class EntryActivity<E extends Model> extends AppCompatActivity {

    public final static int REQUEST_CODE_EDIT_ENTRY = 0;
    public final static int REQUEST_CODE_GET_ENTRY = 1;
    protected E entry;
    private Button updateButton;
    private Button submitButton;

    abstract void setUI(E entry);

    abstract void handleResultGet(int requestCode, Intent data);

    abstract void setEntryByUI();

    abstract boolean validateEntry();

    public void setEntryUpdatedResult(E entry) {
        Intent data = new Intent();
        data.putExtra(EXTRA_MODEL, entry);
        setResult(RESULT_OK, data);
    }

    public void setEntryCreatedResult(E entry) {
        Intent data = new Intent();
        data.putExtra(EXTRA_MODEL, entry);
        setResult(RESULT_OK, data);
    }

    public E getEntry(Intent data) {
        Serializable serializableObject = data.getSerializableExtra(EXTRA_MODEL);

        return (E) serializableObject;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_GET_ENTRY) {
            handleResultGet(requestCode, data);
        }
    }

    class UpdateButtonOnClickListener implements View.OnClickListener {

        Table<E> table;

        public UpdateButtonOnClickListener(Table<E> table) {
            this.table = table;
        }

        @Override
        public void onClick(View view) {
            setEntryByUI();
            if (validateEntry()) {
                table.update(entry);
                setEntryUpdatedResult(entry);
                finish();
            }
        }
    }

    class SubmitButtonOnClickListener implements View.OnClickListener {

        Table<E> table;

        public SubmitButtonOnClickListener(Table<E> table) {
            this.table = table;
        }

        @Override
        public void onClick(View view) {
            setEntryByUI();
            if (validateEntry()) {
                table.insert(entry);
                setEntryCreatedResult(entry);
                finish();
            }
        }
    }
}
