package study.daydayup.wolf.business.org.api.task.domain.enums.task;

import lombok.Getter;
import study.daydayup.wolf.common.lang.enums.CodeBasedEnum;

/**
 * study.daydayup.wolf.business.trade.api.domain.enums
 * range(20 ~ 30)
 * @author Wingle
 * @since 2019/10/5 11:07 AM
 **/
@Getter
public enum CollectionStateEnum implements CodeBasedEnum {
    FAILED(9, "failed"),
    PARTLY_FAILED(8, "partly failed"),
    FAILING(7, "failing"),

    PAID(6, "paid"),
    PAYING(5, "paying"),

    CONTINUE_PAID(4, "continue paid"),
    CONTINUE_PAYING(3, "continue paying"),

    PARTLY_PAID(2, "partly paid"),
    PARTLY_PAYING(1, "partly paying"),
    ;

    private int code;
    private String name;
    CollectionStateEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
