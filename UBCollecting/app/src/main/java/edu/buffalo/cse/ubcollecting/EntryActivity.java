package edu.buffalo.cse.ubcollecting;

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
    protected E entry;
    private Button updateButton;
    private Button submitButton;

    /**
     * Function that updates the view's fields/UI based on the entry from the SQlite Table.
     * Used for updating entries in the database.
     * @param entry The entry from the database by which to update the view's fields
     */
    abstract void setUI(E entry);

    /**
     * Function that sets the entry/model based on user submission in a view so that database
     * can be populated appropriately
     */
    abstract void setEntryByUI();

    /**
     * Helper function that validates user submission
     * @return {@link Boolean}
     */
    abstract boolean validateEntry();

    /**
     * TODO
     * @param entry
     */
    public void setEntryUpdatedResult(E entry) {
        Intent data = new Intent();
        data.putExtra(EXTRA_MODEL, entry);
        setResult(RESULT_OK, data);
    }

    /**
     * TODO
     * @param entry
     */
    public void setEntryCreatedResult(E entry) {
        Intent data = new Intent();
        data.putExtra(EXTRA_MODEL, entry);
        setResult(RESULT_OK, data);
    }

    /**
     * TODO
     * @param data
     * @return
     */
    public E getEntry(Intent data) {
        Serializable serializableObject = data.getSerializableExtra(EXTRA_MODEL);

        return (E) serializableObject;
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
