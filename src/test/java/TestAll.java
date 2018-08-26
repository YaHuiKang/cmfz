import com.baizhi.kyh.enity.Admin;
import com.baizhi.kyh.enity.Album;
import com.baizhi.kyh.enity.Banner;
import com.baizhi.kyh.enity.Menu;
import com.baizhi.kyh.Application;
import com.baizhi.kyh.dao.*;
import com.baizhi.kyh.dto.BannerSplitDto;
import com.baizhi.kyh.dto.UserEchartsDto;
import com.baizhi.kyh.service.AdminService;
import com.baizhi.kyh.service.BannerService;
import com.baizhi.kyh.service.MenuService;
import com.baizhi.kyh.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestAll {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private MenuService menuService;
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminService adminService;
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private AlbumDao albumDao;
    @Autowired
    private UserService service;
    @Autowired
    private UserDao userDao;
    //查所有
    @Test
    public void selMenu() {
        List<Menu> menus = menuDao.selectAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void quMenu(){
        List<Menu> menus = menuService.queryAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
    @Test
    public void seAdmin(){
        Admin a = adminDao.selectOneAdmin("kang");
        System.out.println(a);
    }

    @Test
    public void seAdmizn(){
        Admin a = adminService.queryOneAdmin("kang");
        System.out.println(a);
    }
    @Test
    public void semizn(){
        Banner banner = new Banner("2", "1", "1", "azzz", 0, new Date(), "fff");
        bannerDao.insertBanner(banner);
    }

    @Test
    public void queryBanner(){
        Page<Banner> sp = PageHelper.startPage(1, 2);
        bannerDao.selectAllBanner();
        List<Banner> banners = sp.getResult();
        System.out.println(banners);

    }
    @Test
    public void bannerCout(){
        Integer i= bannerDao.countRows();
        System.out.println(i);
    }

    @Test
    public void baser(){
        BannerSplitDto bannerSplitDto = bannerService.queryAllBannerBySplit(1, 2);
        System.out.println(bannerSplitDto);
    }
    @Test
    public void countrow(){
        Integer inn = bannerDao.countRows();
        System.out.println(inn);
    }

    @Test
    public void countro11w(){
        Album album = albumDao.selectAlbumById("30f73e6e72114b5093e88d5e013a6cc0");
        System.out.println(album);

    }
    @Test
    public void testServuce(){
        List<UserEchartsDto> userEchartsDtos = userDao.seletUserBySex(1);
        System.out.println(userEchartsDtos);
    }

    @Test
    public void sss() throws ParseException {
        Date date = new Date();
        long l = date.getTime() - 1 * 1000 * 60 * 60 * 24 * 30L;
        Date dat2 = new Date(l);
        long lq = 2147483647;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(dat2);
        System.out.println(s);
    }
    @Test
    public void testCalendar(){
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.MONTH);
    }
    @Test
    public void cal(){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE,-1);
//        sdf.format();
    }
    @Test
    public void tesdThread(){
        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread thread = new Thread(r);
        Callable c = new Callable() {
            @Override
            public Object call() throws Exception {
                int i = 1;
                return i;
            }
        };
        FutureTask t = new FutureTask(c);
        Thread thread1 = new Thread(t);
    }
}
