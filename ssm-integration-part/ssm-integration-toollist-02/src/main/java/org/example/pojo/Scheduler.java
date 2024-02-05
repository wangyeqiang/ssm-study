package org.example.pojo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * projectName: com.atguigu.pojo
 *
 * description: 任务实体类
 */
@Data
public class Scheduler {

    private Integer id;

    @NotBlank
    private String title;

    @NotNull
    private Boolean completed;
}
