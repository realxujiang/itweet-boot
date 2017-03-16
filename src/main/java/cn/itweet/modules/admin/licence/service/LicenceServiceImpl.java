package cn.itweet.modules.admin.licence.service;

import cn.itweet.common.exception.ValidateException;
import cn.itweet.modules.admin.licence.entity.Licence;
import cn.itweet.modules.admin.licence.repository.LicenceRepository;
import cn.itweet.modules.admin.licence.utils.EncrpptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 说明：Licence授权管理Service层接口实现
 * 包名：cn.itweet.modules.admin.licence.service
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Service
public class LicenceServiceImpl implements LicenceService{

    @Autowired
    private LicenceRepository licenceRepository;

    /**
     * Licence授权列表
     * @return
     */
    @Override
    public List<Licence> list() {
        return (List<Licence>) licenceRepository.findAll();
    }

    /**
     * Licence授权添加
     * @param licence
     * @throws ValidateException
     */
    @Override
    public void add(Licence licence) throws ValidateException{

        if(licence.getCompany() == null || "".equals(licence.getCompany())){
            throw new ValidateException("公司名称不能为空");
        }
        if(licence.getProject() == null || "".equals(licence.getProject())){
            throw new ValidateException("项目名称不能为空");
        }
        if(licence.getEmail() == null || "".equals(licence.getEmail())){
            throw new ValidateException("邮箱不能为空");
        }
        licence.setDate(new Date());
        licence.setStatus(0);
        System.out.println(licence.toString());
        licence.setCode(EncrpptionUtils.encryption(licence.toString()));
        licenceRepository.save(licence);
    }

}
