package com.lc.service.Impl;

import com.lc.domain.Site;
import com.lc.service.SiteService;
import com.lc.mapper.SiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Date:2020/5/26
 * @Author:lc
 */
@Service("siteService")
public class SiteServiceImpl implements SiteService{

    @Autowired
    private SiteDao siteDao;

    @Override
    public Site getSiteById(Long id) {
        return siteDao.selectByPrimaryKey(id);
    }

    @Override
    public Site insertSite(Site site) {
        siteDao.insert(site);
        return site;
    }

    @Override
    public Site updateSite(Site site) {
        siteDao.updateByPrimaryKeySelective(site);
        return site;
    }

    @Override
    public Integer deleteSite(Long id) {
        return siteDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Site> findSiteForList() {
        return siteDao.findSiteForList();
    }
}
