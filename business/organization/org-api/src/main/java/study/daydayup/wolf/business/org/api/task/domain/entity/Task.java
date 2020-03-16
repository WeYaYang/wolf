package study.daydayup.wolf.business.org.api.task.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.daydayup.wolf.business.org.api.task.domain.entity.task.TaskContact;
import study.daydayup.wolf.business.org.api.task.domain.entity.task.TaskScheduler;
import study.daydayup.wolf.business.org.api.task.domain.entity.task.TaskTrade;
import study.daydayup.wolf.business.org.api.task.domain.event.TaskEvent;
import study.daydayup.wolf.framework.layer.api.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * study.daydayup.wolf.business.org.api.task.domain.entity
 *
 * @author Wingle
 * @since 2020/3/13 2:19 下午
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Model {
    private Long id;
    @NotNull @Min(1)
    private Long orgId;
    private Long staffId;

    private Long projectId;
    private Long parentId;

    private String name;

    @NotNull @Min(1)
    private Integer taskType;
    private Integer state;
    private TaskEvent stateEvent;

    private BigDecimal progressRate;
    private Integer priority;
    private Integer workLoad;
    private Integer storyPoints;

    private String memo;
    private String tags;
    private String extendFields;

    private LocalDateTime startAt;
    private LocalDateTime endAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TaskContact contact;
    private TaskScheduler scheduler;
    private TaskTrade trade;

}
