package edu.nifu.sas.util;

public class PageUtil {

    private int currentPage;
    private long totalRecords;
    private int PageSize;
    private int maxPage;
    public PageUtil(long totalRecords, int pageSize, int currentPage){
        //this.currentPage=currentPage;
        this.totalRecords=totalRecords;
        this.PageSize=pageSize;
        this.maxPage=(int)(totalRecords%pageSize==0?(totalRecords/pageSize):(totalRecords/pageSize+1));
        setCurrentPage(currentPage);
    }
    /**
     * 是否为第一页??
     */
    public boolean isFirstPage(){
        return currentPage==1;
    }
    /**
     * 是否最后一页?
     */
    public  boolean isMaxPage(){
        return currentPage==maxPage;
    }

    /**
     * 获取下一页
     * @return
     */
    public int nextPage(){
        if(!isMaxPage())
            return currentPage++;
        else
            return currentPage;
        // return currentPage==maxPage?maxPage:currentPage++;
    }
    /**
     * 获取上一页
     */
    public int prevPage(){
        if(!isFirstPage())
            return currentPage--;
        else
            return currentPage;
        //return currentPage==1?1:currentPage--;
    }
    public void setCurrentPage(int CurrentPage){
        if(CurrentPage>maxPage){
            this.currentPage=maxPage;
        } else if(CurrentPage<1){
            this.currentPage=1;
        }else {
            this.currentPage = CurrentPage;
        }

    }
    public int getCurrentPage(){
        return this.currentPage;
    }

    public int getMaxPage(){
        return maxPage;
    }
}
