package Model;

public class Muscle_Group {
    private int Id;
    private String Name;

    public Muscle_Group(int Id, String name){
        this.Id = Id;
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getId() {
        return Id;
    }

}
