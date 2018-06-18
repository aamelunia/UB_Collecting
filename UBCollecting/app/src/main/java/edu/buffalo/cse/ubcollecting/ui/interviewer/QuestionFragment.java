package edu.buffalo.cse.ubcollecting.ui.interviewer;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import edu.buffalo.cse.ubcollecting.R;
import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Answer;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.QuestionLangVersion;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireContent;
import edu.buffalo.cse.ubcollecting.data.models.Session;
import edu.buffalo.cse.ubcollecting.data.models.SessionAnswer;
import edu.buffalo.cse.ubcollecting.ui.EntryOnItemSelectedListener;
import edu.buffalo.cse.ubcollecting.ui.QuestionManager;

import static edu.buffalo.cse.ubcollecting.ui.interviewer.TakeQuestionnaireActivity.QUESTIONNAIRE_CONTENT;
import static edu.buffalo.cse.ubcollecting.ui.interviewer.UserSelectSessionActivity.SELECTED_SESSION;

/**
 * Created by aamel786 on 6/17/18.
 */

public class QuestionFragment extends Fragment{

    private QuestionnaireContent questionContent;
    private Spinner questionLangSpinner;
    private TextView questionText;
    private EditText answerText;
    private Button nextQuestion;
    private HashMap<Language,QuestionLangVersion> questionTexts;
    private ArrayList<Language> questionLanguages;
    private ArrayAdapter<Language> questionLanguagesAdapter;
    private QuestionManager questionManager;
    private Answer answer;
    private SessionAnswer sessionAnswer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        answer = new Answer();
        sessionAnswer = new SessionAnswer();
        questionText = view.findViewById(R.id.question_text);
        answerText = view.findViewById(R.id.answer_text);
        questionContent = (QuestionnaireContent) getArguments().getSerializable(QUESTIONNAIRE_CONTENT);
        questionTexts = DatabaseHelper.QUESTION_LANG_VERSION_TABLE.getQuestionTexts(questionContent.getQuestionId());
        questionLanguages = new ArrayList<>();
        questionLanguages.addAll(questionTexts.keySet());

        questionLangSpinner = view.findViewById(R.id.question_language_spinner);
        questionLanguagesAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, questionLanguages);
        questionLangSpinner.setAdapter(questionLanguagesAdapter);
        questionLangSpinner.setOnItemSelectedListener(new QuestionFragment.LanguageOnItemSelectedListener());
        questionLangSpinner.setSelection(getEnglishQuestionIndex());

        nextQuestion = view.findViewById(R.id.next_question);

        if(questionManager.isLastQuestion()){
            nextQuestion.setText("Finish");
        }
        nextQuestion.setOnClickListener(new QuestionFragment.NextQuestionOnClickListener());


        return view;
    }



    public void onAttach(Context context){
        super.onAttach(context);
        questionManager = (QuestionManager) context;
    }

    private int getEnglishQuestionIndex(){
        for (int i = 0; i<questionLanguages.size(); i++){
            if (questionLanguages.get(i).getName().toLowerCase().equals("english")){
                Log.i("found","english");
                return i;
            }
        }
        Log.i("not found","english");
        return 0;
    }

    private class LanguageOnItemSelectedListener extends EntryOnItemSelectedListener<Language> {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            super.onItemSelected(parent, view, position, id);
            Language language = (Language) questionLangSpinner.getSelectedItem();
            questionText.setText(questionTexts.get(language).getQuestionText());
        }
    }

    private class NextQuestionOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            submitTextAnswer();
            submitSessionAnswer();
            questionManager.getNextQuestion();
        }
    }

    private void submitTextAnswer(){
        answer.setQuestionId(questionContent.getQuestionId());
        answer.setQuestionnaireId(questionContent.getQuestionnaireId());
        answer.setText(answerText.getText().toString());
        DatabaseHelper.ANSWER_TABLE.insert(answer);
    }

    private void submitSessionAnswer(){
        sessionAnswer.setAnswerId(answer.getId());
        sessionAnswer.setSessionId(((Session) getArguments().getSerializable(SELECTED_SESSION)).getId());
        sessionAnswer.setQuestionId(questionContent.getQuestionId());
        sessionAnswer.setQuestionnaireId(questionContent.getQuestionnaireId());
        DatabaseHelper.SESSION_ANSWER_TABLE.insert(sessionAnswer);
    }



}
