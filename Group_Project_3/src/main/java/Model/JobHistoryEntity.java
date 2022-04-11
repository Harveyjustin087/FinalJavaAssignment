package Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "job_history", schema = "hr", catalog = "")
@IdClass(JobHistoryEntityPK.class)
public class JobHistoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Employee_Id")
    private int employeeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Start_Date")
    private Date startDate;
    @Basic
    @Column(name = "End_Date")
    private Date endDate;
    @Basic
    @Column(name = "Job_Id")
    private Integer jobId;
    @Basic
    @Column(name = "Department_Id")
    private Integer departmentId;
    @ManyToOne
    @JoinColumn(name = "Job_Id", referencedColumnName = "job_id", insertable = false, updatable = false)
    private JobsEntity jobsByJobId;
    @ManyToOne
    @JoinColumn(name = "Department_Id", referencedColumnName = "department_id", insertable = false, updatable = false)
    private DepartmentsEntity departmentsByDepartmentId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobHistoryEntity that = (JobHistoryEntity) o;
        return employeeId == that.employeeId && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(jobId, that.jobId) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, startDate, endDate, jobId, departmentId);
    }

    public JobsEntity getJobsByJobId() {
        return jobsByJobId;
    }

    public void setJobsByJobId(JobsEntity jobsByJobId) {
        this.jobsByJobId = jobsByJobId;
    }

    public DepartmentsEntity getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(DepartmentsEntity departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }
}
