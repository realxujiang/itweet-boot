package cn.itweet.modules.admin.licence.service;

import cn.itweet.common.exception.ValidateException;
import cn.itweet.modules.admin.licence.entity.Licence;

import java.util.List;

/**
 * 说明：Licence授权管理Service层接口
 * 包名：cn.itweet.modules.admin.licence
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
public interface LicenceService {

    /**
     * Licence授权添加
     * @param licence
     * @throws ValidateException
     */
    public void add(Licence licence) throws ValidateException;

    /**
     * Licence授权列表
     * @return
     */
    public List<Licence> list();
}
