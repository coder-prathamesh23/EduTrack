package com.home.Entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculty_attendance")
public class FacultyAttendance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;
	@ManyToOne
	@JoinColumn(name = "class_schedule_id", nullable = false)
	private ClassSchedule classSchedule;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

}
