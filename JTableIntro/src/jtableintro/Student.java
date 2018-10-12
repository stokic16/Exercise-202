

package jtableintro;

import java.awt.Color;
import java.time.LocalDate;

/**
 * @author Kilian Stöckler
 */
public class Student {
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private Color hairColor;

    public Student(String firstname, String lastname, LocalDate birthday, Color hairColor) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.hairColor = hairColor;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public String getLastname() {
        return lastname;
    }
    
    
}
