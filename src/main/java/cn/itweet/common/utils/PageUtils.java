package cn.itweet.common.utils;

/**
 * 说明：
 * 包名：cn.itweet.common.utils
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/4/17.
 */
public class PageUtils {

    private String url;

    private int currentPage;    //当前页码
    private int totalPages;      //总页数

    private long totalRecored;   //总记录数
    private int pageSize;        //每页记录数

    public PageUtils(String url,int currentPage, int totalPages, long totalRecored, int pageSize) {
        this.url = url;
        this.currentPage = currentPage + 1;
        this.totalPages = totalPages;
        this.totalRecored = totalRecored;
        this.pageSize = pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRecored() {
        return totalRecored;
    }

    public void setTotalRecored(long totalRecored) {
        this.totalRecored = totalRecored;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
