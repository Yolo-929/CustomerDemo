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
