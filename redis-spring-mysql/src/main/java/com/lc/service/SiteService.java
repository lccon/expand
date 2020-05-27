package com.lc.service;

import com.lc.domain.Site;

import java.util.List;

/**
 * Description:
 *
 * @Date:2020/5/26
 * @Author:lc
 */
public interface SiteService {

    Site getSiteById(Long id);

    Site insertSite(Site site);

    Site updateSite(Site site);

    Integer deleteSite(Long id);

    List<Site> findSiteForList();

}
