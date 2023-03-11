package org.example.DTO;

import org.example.Enums.Status;

import java.time.LocalDateTime;

public class StudentBook {
    private Integer id;
    private Integer studentId;
    private String bookId;
    private LocalDateTime createDate;
    private Status status;
    private LocalDateTime returnedDate;
    private Integer duration;

    public StudentBook() {
    }

    public StudentBook(Integer id, Integer studentId, String bookId, LocalDateTime createDate, Status status, LocalDateTime returnedDate, Integer duration) {
        this.id = id;
        this.studentId = studentId;
        this.bookId = bookId;
        this.createDate = createDate;
        this.status = status;
        this.returnedDate = returnedDate;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDateTime returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "StudentBook{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", bookId='" + bookId + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                ", returnedDate=" + returnedDate +
                ", duration=" + duration +
                '}';
    }
}
