package study.daydayup.wolf.business.trade.api.domain.exception.buy;

import study.daydayup.wolf.common.lang.exception.BusinessException;
import study.daydayup.wolf.common.lang.string.Str;

/**
 * study.daydayup.wolf.business.trade.buy.domain.exception
 *
 * @author Wingle
 * @since 2019/10/7 11:28 下午
 **/
public class GoodsSoldOutException extends BusinessException {
    public GoodsSoldOutException(Long  goodsId) {
        super(160502, Str.join("Goods sold out:", goodsId));
    }
}
