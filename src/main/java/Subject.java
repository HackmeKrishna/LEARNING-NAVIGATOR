import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Subject {
    @Id
    private Long subjectId;
    private String name;

    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> students;

    // Getters and Setters
}
