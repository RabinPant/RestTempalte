package com.rabin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

    private int courseId;
    @NotBlank(message = "Course name shouldn't be null or empty")
    private String name;
    @NotEmpty(message = "Trainer name should be define")
    private String trainerName;
    @NotNull(message = "duration must need to specify")
    private String duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-mm-yyyy")
    @Past(message = "start date cant be before date from current")
    private Date startDate;
    private String courseType;
    @Min(value=1500,message = "Course price can't be less than 1500")
    @Max(value=5000, message = "Course Price can't be more than 5000")
    private double fees;
    boolean isCertificateAvailable;
    @Email(message = "Please provide the valid email")
    private String emailId;
    @Pattern(regexp = "^[0-9]{10}$")
    private String contact;
}
