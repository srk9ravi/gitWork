package com.comcast.appone.model;
public class ClassDomain
{
    private CourseDescription[] courseDescription;

    private String CourseName;

    private String Instructor;

    private Circullam[] Circullam;

    private String in;

    public CourseDescription[] getCourseDescription ()
    {
        return courseDescription;
    }

    public void setCourseDescription (CourseDescription[] courseDescription)
    {
        this.courseDescription = courseDescription;
    }

    public String getCourseName ()
    {
        return CourseName;
    }

    public void setCourseName (String CourseName)
    {
        this.CourseName = CourseName;
    }

    public String getInstructor ()
    {
        return Instructor;
    }

    public void setInstructor (String Instructor)
    {
        this.Instructor = Instructor;
    }

    public Circullam[] getCircullam ()
    {
        return Circullam;
    }

    public void setCircullam (Circullam[] Circullam)
    {
        this.Circullam = Circullam;
    }

    public String getIn ()
    {
        return in;
    }

    public void setIn (String in)
    {
        this.in = in;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [courseDescription = "+courseDescription+", CourseName = "+CourseName+", Instructor = "+Instructor+", Circullam = "+Circullam+", in = "+in+"]";
    }
}