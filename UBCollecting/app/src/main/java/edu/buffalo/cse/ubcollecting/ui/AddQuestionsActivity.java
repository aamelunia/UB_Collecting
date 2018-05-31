package edu.buffalo.cse.ubcollecting.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.buffalo.cse.ubcollecting.R;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.QuestionLangVersion;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireContent;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionLangVersionTable;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.LANGUAGE_TABLE;
import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.QUESTIONNAIRE_CONTENT_TABLE;
import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.QUESTION_LANG_VERSION_TABLE;

public class AddQuestionsActivity extends AppCompatActivity {

    private static final String TAG = AddQuestionsActivity.class.getSimpleName().toString();
    private static final String EXTRA_QUESTIONNAIRE_ID = "edu.buffalo.cse.ubcollecting.ui.questionnaire_id";

    private ArrayList<QuestionLangVersion> selections;
    private ArrayList<Language> selectedLanguages;
    private String questionnaireId;

    private RecyclerView entryRecyclerView;
    private AddQuestionsActivity.EntryAdapter entryAdapter;
    private ListView filterList;
    private EditText searchText;
    private ImageButton clearSearchButton;
    private ImageButton searchButton;
    private Button doneButton;


    public static Intent newIntent(Context packageContext, Questionnaire questionnaire) {
        Intent i = new Intent(packageContext, AddQuestionsActivity.class);
        i.putExtra(EXTRA_QUESTIONNAIRE_ID, questionnaire.getId());
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_select);

        questionnaireId = getIntent().getExtras().getString(EXTRA_QUESTIONNAIRE_ID);

        selections = new ArrayList<>();
        Log.i(TAG, "Num selections: " + selections.size());
        selectedLanguages = LANGUAGE_TABLE.getAll();
        Log.i(TAG, "Num selected langs: " + selectedLanguages.size());

        searchText = findViewById(R.id.table_select_search_view);
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0) {
                    clearSearchButton.setVisibility(View.VISIBLE);
                } else {
                    clearSearchButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        clearSearchButton = findViewById(R.id.table_select_clear_button);
        clearSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchText.setText("");
                ArrayList<QuestionLangVersion> results = QUESTION_LANG_VERSION_TABLE.getAll();
                entryAdapter.setEntryList(results);
                entryAdapter.notifyDataSetChanged();
            }
        });

        searchButton = findViewById(R.id.table_select_search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchText.getText().toString();
                selections = search(query, QUESTION_LANG_VERSION_TABLE.getAll());
                entryAdapter.setEntryList(selections);
                entryAdapter.notifyDataSetChanged();
            }
        });

        doneButton = findViewById(R.id.table_select_done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectionDone(selections);
                finish();
            }
        });

        entryRecyclerView = findViewById(R.id.table_select_recycler);
        entryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        entryAdapter = new AddQuestionsActivity.EntryAdapter(QUESTION_LANG_VERSION_TABLE.getAll());
        entryRecyclerView.setAdapter(entryAdapter);

        filterList = findViewById(R.id.table_select_filter_list);
        filterList.setAdapter(new LanguageListAdapter(AddQuestionsActivity.this, LANGUAGE_TABLE.getAll()));
    }

    public ArrayList<QuestionLangVersion> search(String query, ArrayList<QuestionLangVersion> selections) {

        return null;
    }

    public void onSelectionDone(ArrayList<QuestionLangVersion> selections) {
        for (int i = 0; i < selections.size(); i++) {
            QuestionLangVersion questionLang = selections.get(i);
            QuestionnaireContent content = new QuestionnaireContent();
            content.setQuestionOrder(Integer.toString(i));
            content.setQuestionId(questionLang.getQuestionId());
            content.setQuestionnaireId(questionnaireId);

            QUESTIONNAIRE_CONTENT_TABLE.insert(content);
        }
    }

    private class EntryHolder extends RecyclerView.ViewHolder {

        private QuestionLangVersion question;
        private CheckBox selectBox;
        private TextView entryNameView;


        public EntryHolder(View view) {
            super(view);

            selectBox = view.findViewById(R.id.entry_list_select_box);
            entryNameView = view.findViewById(R.id.entry_list_select_text_view);

            selectBox.setChecked(selections.contains(question));
            selectBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        selections.add(question);
                    } else {
                        selections.remove(question);
                    }
                }
            });
        }

        public void bindEntry(QuestionLangVersion question1) {
            question = question1;
            String summary;
            if (question1.getQuestionText().length() < 20) {
                summary = question1.getQuestionText();
            } else {
                summary = question1.getQuestionText().substring(0, 20);
            }

            entryNameView.setText(summary);
            selectBox.setChecked(selections.contains(question));
        }
    }

    private class EntryAdapter extends RecyclerView.Adapter<AddQuestionsActivity.EntryHolder> {

        private List<QuestionLangVersion> entryList;

        public EntryAdapter(List<QuestionLangVersion> entryList) {
            this.entryList = entryList;
        }

        public List<QuestionLangVersion> getEntryList() {
            return entryList;
        }

        public void setEntryList(List<QuestionLangVersion> entryList) {
            this.entryList = entryList;
        }

        @Override
        public AddQuestionsActivity.EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater
                    .inflate(R.layout.entry_list_item_select, parent, false);
            return new AddQuestionsActivity.EntryHolder(view);
        }

        @Override
        public void onBindViewHolder(AddQuestionsActivity.EntryHolder holder, int position) {
            QuestionLangVersion entry = entryList.get(position);
            holder.bindEntry(entry);
        }

        @Override
        public int getItemCount() {
            return entryList.size();
        }
    }

    private class LanguageListAdapter extends ArrayAdapter<Language> {

        private LanguageListAdapter(Context context, ArrayList<Language> languages) {
            super(context, 0, languages);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final Language lang = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_list_item_select, parent, false);
            }
            TextView nameView = convertView.findViewById(R.id.entry_list_select_text_view);
            CheckBox checkBox = convertView.findViewById(R.id.entry_list_select_box);

            nameView.setText(lang.getIdentifier());
            checkBox.setChecked(selectedLanguages.contains(lang));
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b) {
                        selectedLanguages.add(lang);
                        String selection = QuestionLangVersionTable.KEY_QUESTION_LANG_ID + " = ?";
                        String[] value = new String[]{lang.getId()};
                        ArrayList<QuestionLangVersion> langQuestions = QUESTION_LANG_VERSION_TABLE.getAll(selection, value);
                        entryAdapter.getEntryList().addAll(langQuestions);
                        entryAdapter.notifyDataSetChanged();
                    } else {
                        selectedLanguages.remove(lang);
                        String selection = QuestionLangVersionTable.KEY_QUESTION_LANG_ID + " = ?";
                        String[] value = new String[]{lang.getId()};
                        ArrayList<QuestionLangVersion> langQuestions = QUESTION_LANG_VERSION_TABLE.getAll(selection, value);
                        entryAdapter.getEntryList().removeAll(langQuestions);
                        entryAdapter.notifyDataSetChanged();
                    }
                }
            });

            return convertView;
        }

    }
}
