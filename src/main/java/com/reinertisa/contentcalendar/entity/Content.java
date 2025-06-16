package com.reinertisa.contentcalendar.entity;

import com.reinertisa.contentcalendar.enumarations.Status;
import com.reinertisa.contentcalendar.enumarations.Type;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private Long id;
    @NotBlank(message = "Title is required.")
    private String title;
    private String desc;
    @NotBlank(message = "Status is required.")
    Status status;
    @NotBlank(message = "Type is required.")
    Type type;
    LocalDateTime dateCreated;
    LocalDateTime dateUpdated;
    String url;
}
