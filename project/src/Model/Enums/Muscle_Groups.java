package Model.Enums;

public enum Muscle_Groups {
    Chest(1),
    Back(2),
    Biceps(3),
    Triceps(4),
    Deltoid(5),
    Forearm(6),
    Abs(7),
    Quads(8),
    Hamstring(9),
    Calves(10),
    Glutes(11),
    Cardio(12);
    private int label;

    Muscle_Groups(int label) {
        this.label = label;
    }

    public int getLabel(){
        return this.label;
    }
}
