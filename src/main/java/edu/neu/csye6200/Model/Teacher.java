package edu.neu.csye6200.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Teacher extends Person
{

    private static List<Integer> ageGroupRules;
    private List<Student> students;
    private int ageGroup;
    private LocalDate reviewDate;
    private Classroom classroom;

    public Teacher(String name, int ageGroup, LocalDate reviewDate)
    {
        super(name);
        this.ageGroup = ageGroup;
        this.reviewDate = reviewDate;
    }

    public static List<Integer> getAgeGroupRules()
    {
        return ageGroupRules;
    }

    protected static void setAgeGroupRules(List<Integer> ageGroupRules)
    {
        Teacher.ageGroupRules = ageGroupRules;
    }

    public int getNumOfStudents()
    {
        if (students == null) return 0;
        return students.size();
    }

    public boolean assignClassroom(Classroom room)
    {
        if (room.getNumOfTeachers() < Classroom.getRoomAgeGroupRules().get(room.getAgeGroup())
            && room.getAgeGroup() == this.ageGroup)
        {
            setClassroom(room);
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toCSV()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("%s,%s,%s",
                this.name,
                Classroom.getAgeRangeByAgeGroup(this.ageGroup),
                this.reviewDate.format(formatter));
    }

    @Override
    public String toString()
    {
        return "Teacher{" +
                "students=" + students +
                ", ageGroup=" + ageGroup +
                ", reviewDate=" + reviewDate +
                '}';
    }

    // ========= setters and getters ==========

    public Classroom getClassroom()
    {
        return classroom;
    }

    public void setClassroom(Classroom classroom)
    {
        this.classroom = classroom;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public int getAgeGroup()
    {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup)
    {
        this.ageGroup = ageGroup;
    }

    public LocalDate getReviewDate()
    {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate)
    {
        this.reviewDate = reviewDate;
    }

}