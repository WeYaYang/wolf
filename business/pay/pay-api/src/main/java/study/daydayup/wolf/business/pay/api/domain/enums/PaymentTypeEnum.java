package study.daydayup.wolf.business.pay.api.domain.enums;

import lombok.Getter;
import study.daydayup.wolf.common.lang.enums.CodeBasedEnum;

/**
 * study.daydayup.wolf.common.lang.enums
 *
 * @author Wingle
 * @since 2019/9/29 4:51 PM
 **/
@Getter
public enum PaymentTypeEnum implements CodeBasedEnum {

    C_TO_B(1, "私对公"),
    B_TO_B(2, "私对私"),
    B_TO_C(3, "公对私"),
    B_TO_BO(4, "公对公"),
    ;

    private int code;
    private String name;

    PaymentTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
