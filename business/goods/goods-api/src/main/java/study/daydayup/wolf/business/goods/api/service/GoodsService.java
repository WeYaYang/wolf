package study.daydayup.wolf.business.goods.api.service;

import study.daydayup.wolf.business.goods.api.entity.BaseGoods;

/**
 * study.daydayup.wolf.business.goods.api.service
 *
 * @author Wingle
 * @since 2019/10/29 12:12 上午
 **/
public interface GoodsService {
    BaseGoods findBaseGoodsById();
    BaseGoods[] findBaseGoodsByOrgId();
}