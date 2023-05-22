package Model.Enums;

public enum ExerciseTypes {
    BodyBuilding(1),
    Cardio(2);

    private int label;
    ExerciseTypes(int label) {
        this.label = label;
    }

    public int getLabel(){
        return this.label;
    }
}
