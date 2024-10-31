import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public void registerStudentForExam(Long examId, Long studentId) {
        Exam exam = examRepository.findById(examId)
            .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        if (!student.getEnrolledSubjects().contains(exam.getSubject())) {
            throw new InvalidOperationException("Student must be enrolled in the subject to register for the exam.");
        }

        exam.getEnrolledStudents().add(student);
        student.getRegisteredExams().add(exam);

        examRepository.save(exam);
        studentRepository.save(student);
    }

    public String getNumberFact(int number) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://numbersapi.com/" + number;
        return restTemplate.getForObject(url, String.class);
    }
}
