package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Questionnaire extends Model {

    private static final String TAG = Questionnaire.class.getSimpleName().toString();

    public String label;
    public String name;
    public String description;
    public String typeId;

    public String getIdentifier() {
        return name;
    }

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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

}
