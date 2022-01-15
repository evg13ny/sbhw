import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey id;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    public LinkedPurchaseList(LinkedPurchaseListKey id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }

    public LinkedPurchaseListKey getId() {
        return id;
    }

    public void setId(LinkedPurchaseListKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Embeddable
    public static class LinkedPurchaseListKey implements Serializable {
        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;

        public LinkedPurchaseListKey() {
        }

        public LinkedPurchaseListKey(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinkedPurchaseListKey that = (LinkedPurchaseListKey) o;
            return studentId == that.studentId && courseId == that.courseId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(studentId, courseId);
        }
    }
}
