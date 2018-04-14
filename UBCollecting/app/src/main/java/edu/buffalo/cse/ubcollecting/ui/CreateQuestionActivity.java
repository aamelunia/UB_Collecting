package edu.buffalo.cse.ubcollecting.ui;

import java.util.ArrayList;

import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.QuestionPropertyDef;

/**
 * Created by aamel786 on 4/14/18.
 */

public class CreateQuestionActivity {

    ArrayList<QuestionPropertyDef> quesPropDefs = DatabaseHelper.QUESTION_PROPERTY_DEF_TABLE.getAll();
    ArrayList<Language> quesLangs = DatabaseHelper.LANGUAGE_TABLE.getResearchLanguages();

}
