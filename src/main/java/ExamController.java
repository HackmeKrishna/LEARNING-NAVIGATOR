@RestController
@RequestMapping("/api")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/exams/{examId}")
    public ResponseEntity<?> registerStudentForExam(@PathVariable Long examId, @RequestParam Long studentId) {
        examService.registerStudentForExam(examId, studentId);
        return ResponseEntity.ok("Student registered for exam successfully");
    }

    @GetMapping("/hidden-feature/{number}")
    public ResponseEntity<String> getNumberFact(@PathVariable int number) {
        String fact = examService.getNumberFact(number);
        return ResponseEntity.ok(fact);
    }
}
