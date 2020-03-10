package study.daydayup.wolf.business.uc.api.crm.customer.config;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * study.daydayup.wolf.business.uc.api.crm.customer.config
 *
 * @author Wingle
 * @since 2020/3/6 4:59 下午
 **/
@Data
@Builder
public class CreditLineConfig {
    private Integer minPromotionPeriod = 0;

    private Integer maxTimesPerDay = 1;
    private Integer maxTimesPerWeek = 1;
    private Integer maxTimesPerMonth = 1;
    private Integer maxTimesPerYear = 1;
    private Boolean useLastPromotionTime = true;

    private BigDecimal maxAmount;
    private BigDecimal minAmount;

}
