package businessLogic.validators;


import model.Student;

public class StudentAgeValidator implements Validator<Student> {
    private static final int MIN_AGE = 7;
    private static final int MAX_AGE = 70;

    public void validate(Student t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Student Age limit is not respected!");
        }

    }

}

