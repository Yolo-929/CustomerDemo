package model;

import java.util.List;

public class Page {
    //保存着分页的数据
    private List<Customer> list;

    //总记录数
    private long totalRecord;

    //每页显示记录数，这里我规定每页显示3条
    private int linesize = 3;

    //总页数
    private int totalPageCount;

    //当前显示的页数
    private long currentPageCount;

    //记录开始的页数
    private int startPage;
    //记录结束的页数
    private int endPage;
    //记录开始的索引
    private int startIndex;

    private String url;

    public Page() {
    }

    //构造函数
    public Page(int currentPageCount, long totalRecord) {

        //将传递进来的currentPageCount初始化
        this.currentPageCount = currentPageCount;

        //总页数
        totalPageCount = (int) (totalRecord % linesize == 0 ? totalRecord / linesize : totalRecord / linesize + 1);

        //总记录数
        this.totalRecord = totalRecord;

        //开始取数据的位置
        startIndex = (currentPageCount - 1) * linesize;

        //定义页面范围
        startPage = (int)this.currentPageCount - 4;
        endPage = (int)this.currentPageCount + 5;

        //加减后页数越界的情况
        if (startPage < 1) {
            this.startPage = 1;
            this.endPage = Math.min(10,this.totalPageCount);
        }
        if (endPage > totalPageCount) {
            this.startPage = Math.max(1,this.totalPageCount-9);
            this.endPage = this.totalPageCount;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public List<Customer> getList() {
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getLinesize() {
        return linesize;
    }

    public void setLinesize(int linesize) {
        this.linesize = linesize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public long getCurrentPageCount() {
        return currentPageCount;
    }

    public void setCurrentPageCount(long currentPageCount) {
        this.currentPageCount = currentPageCount;
    }
}
