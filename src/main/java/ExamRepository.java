import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    // JpaRepository provides findById, so no need to define it explicitly
}
