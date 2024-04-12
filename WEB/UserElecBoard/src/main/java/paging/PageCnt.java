package paging;

public class PageCnt {
    private static int pageCnt;
    public static int pagesize;
    public static int pageNo;
    public int blockcount;

    public PageCnt(){}
    public PageCnt(int pagesize){
        this.pagesize = pagesize;
    }

    public static int getPageCnt() {
        return pageCnt;
    }

    public static void setPageCnt(int pageCnt) {
        PageCnt.pageCnt = pageCnt;
    }

    public static int getPagesize() {
        return pagesize;
    }

    public static void setPagesize(int pagesize) {
        PageCnt.pagesize = pagesize;
    }

    public static int getPageNo() {
        return pageNo;
    }

    public static void setPageNo(int pageNo) {
        PageCnt.pageNo = pageNo;
    }

    public int getBlockcount() {
        return blockcount;
    }

    public void setBlockcount(int blockcount) {
        this.blockcount = blockcount;
    }
}
