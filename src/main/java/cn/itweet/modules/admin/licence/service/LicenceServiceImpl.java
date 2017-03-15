package cn.itweet.modules.admin.licence.service;

import cn.itweet.modules.admin.licence.entity.Licence;
import cn.itweet.modules.admin.licence.repository.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 说明：
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
     * 添加Licence授权记录
     * @param licence
     * @return
     */
    @Override
    public Licence add(Licence licence) {
        System.out.println(licence.getCompany());
        System.out.println(licence.getNode());
        System.out.println(licence.getEmail());
        if(licence.getCompany() == null && "".equals(licence.getCompany())){
            licence.setId(0);
        }
        if(licence.getProject() == null && "".equals(licence.getProject())){

        }
        if(licence.getEmail() == null && "".equals(licence.getEmail())){

        }

        licence.setDate(new Date());
        licence.setStatus(0);
        licence.setCode(createLicenceCode(licence));


        return null;
    }


    /**
     * 创建Licence授权码
     * @param licence
     * @return
     */
    private String createLicenceCode(Licence licence){





        return null;
    }

}
