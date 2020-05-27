package com.lc.test;

import com.lc.domain.Site;
import com.lc.service.SiteService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class TestApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        SiteService siteService = applicationContext.getBean(SiteService.class);

        insertSiteInfo(siteService);
        //  updateSiteInfo(siteService);
        // getSiteById(siteService);
        // deleteSite(siteService);
    }

    private static void insertSiteInfo(SiteService siteService) {
        Site site = new Site();
        site.setSiteName("平台");
        site.setSiteDetail("平台研发");
        site.setCreateUser("lc");
        site.setCreateDate(new Date());
        siteService.insertSite(site);
    }

    private static void updateSiteInfo(SiteService siteService) {
        Site site = new Site();
        site.setId(151L);
        site.setSiteName("五联西苑");
        site.setSiteDetail("西湖区五联西苑");
        site.setCreateUser("lc");
        site.setCreateDate(new Date());
        siteService.updateSite(site);
    }

    private static void getSiteById(SiteService siteService) {
        Site site = siteService.getSiteById(151L);
        System.out.println(site);
    }

    private static void deleteSite(SiteService siteService) {
        Integer count = siteService.deleteSite(154L);
        System.out.println(count > 0);
    }

}
