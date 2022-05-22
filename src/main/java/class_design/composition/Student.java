package class_design.composition;

import java.util.HashMap;
import java.util.Map;

import static class_design.composition.LocationType.CANTINA;
import static class_design.composition.LocationType.LIBRARY;

public class Student
{
    private long studentId;
    private String name;
    private long dateOfBirth;

    private Map<LocationType, Membership> studentMemberships = new HashMap<>();

    private Course course;

    public Student(String name)
    {
        try
        {
            validateInputData(name);
            this.name = name;
            studentMemberships.put(LIBRARY, new LibraryMembership());
            studentMemberships.put(CANTINA, new CantinaMembership());
            createLibraryMembership();
            createCantinaMembership();
        } catch (StudentCreationException e)
        {
            // log exception
            e.printStackTrace();
        }
    }

    private void createCantinaMembership() throws StudentCreationException
    {
        //logic
        throw new StudentCreationException("Cannot create cantina membership");
    }

    private void createLibraryMembership()
    {

    }

    private void validateInputData(String name) throws StudentCreationException
    {
        if (name == null || name.isEmpty()) {
            throw new StudentCreationException("Name is null or empty");
        }
    }

    public long getStudentId()
    {
        return studentId;
    }

    public String getName()
    {
        return name;
    }

    public long getDateOfBirth()
    {
        return dateOfBirth;
    }

    public Membership getLibraryMembership()
    {
        return studentMemberships.get(LIBRARY);
    }

    public Membership getCantinaMembership()
    {
        return studentMemberships.get(CANTINA);
    }

    public Course getCourse()
    {
        return course;
    }
}
