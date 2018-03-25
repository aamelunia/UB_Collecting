package edu.buffalo.cse.ubcollecting.data.tables;

import edu.buffalo.cse.ubcollecting.data.models.Answer;

/**
 * Created by aamel786 on 2/17/18.
 */
public class AnswerTable extends Table <Answer> {

    // Answer Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_QUESTIONNAIRE_ID = "QuestionnaireId";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_LABEL = "Label";
    public static final String KEY_TEXT = "Text";

    public AnswerTable () {
        super();
        TABLE = "Answer";
    }

    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT," + KEY_QUESTIONNAIRE_ID
                + " TEXT," + KEY_QUESTION_ID + " TEXT," + KEY_LABEL + " VARCHAR,"
                + KEY_TEXT + " VARCHAR,"
                + " PRIMARY KEY(" + KEY_QUESTIONNAIRE_ID+", " + KEY_QUESTION_ID+", " + KEY_ID + "),"
                + " FOREIGN KEY(" + KEY_QUESTION_ID + ") REFERENCES " + QuestionTable.TABLE
                + " (" + QuestionTable.KEY_ID + ")," + " FOREIGN KEY(" + KEY_QUESTIONNAIRE_ID + ") REFERENCES "
                + QuestionnaireTable.TABLE + " (" + QuestionnaireTable.KEY_ID + ")" + ")";
    }


}
