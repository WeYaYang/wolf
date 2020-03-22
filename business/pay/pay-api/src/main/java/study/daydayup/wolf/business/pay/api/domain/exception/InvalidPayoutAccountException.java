package study.daydayup.wolf.business.pay.api.domain.exception;

import study.daydayup.wolf.common.lang.exception.SystemException;

/**
 * study.daydayup.wolf.business.goods.api.exception
 *
 * @author Wingle
 * @since 2019/12/12 2:04 下午
 **/
public class InvalidPayoutAccountException extends SystemException {
    public InvalidPayoutAccountException() {
        super(170000, "Invalid payout account");
    }
}
