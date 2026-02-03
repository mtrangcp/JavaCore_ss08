package model;

public class Student {
    private String id;
    private String name;
    private double score;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getRank(){
        return score >= 8 ? "Gioi" : score >= 6.5 ? "Kha" : "Trung binh";
    }

    @Override
    public String toString() {
        return "\nStudent :" +
                "\nId : "+id+
                "\nName : "+name+
                "\nScore : "+score+
                "\nHoc luc : "+getRank();
    }
}
