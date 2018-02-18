package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Questionnaire  {

    private static final String TAG = Questionnaire.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Questionnaire";

    // Questionnaire Table - column names
    public static final String KEY_QUES_ID = "QuestionnaireId";
    public static final String KEY_QUES_LABEL = "QuestionnaireLabel";
    public static final String KEY_QUES_NAME = "QuestionnaireName";
    public static final String KEY_QUES_DESCRIPTION = "QuestionnaireDescription";
    public static final String KEY_QUES_TYPE = "QuestionnaireType";

    public String id;
    public String label;
    public String name;
    public String description;
    public String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
