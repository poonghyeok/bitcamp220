package board.bean;

public class BoardPaging {
	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][다음]
	private int pageSize; //1페이지당 5개
	private int totalA; //총글수
	private StringBuffer pagingHTML;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageBlock() {
		return pageBlock;
	}

	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalA() {
		return totalA;
	}

	public void setTotalA(int totalA) {
		this.totalA = totalA;
	}

	public StringBuffer getPagingHTML() {
		return pagingHTML;
	}

	public void setPagingHTML(StringBuffer pagingHTML) {
		this.pagingHTML = pagingHTML;
	}

	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
	
		int totalP = (int)(Math.ceil(totalA / (float)pageSize));
		//int totalP = ( totalA - 1) / ( pageSize + 1); //총 페이지 수
		int startPage = (currentPage-1) / pageBlock * pageBlock +1; //시작 페이지 번호 
		int endPage = startPage + pageBlock - 1;
		if(endPage > totalP) {
			endPage = totalP;
		}
		
		System.out.println("@@@ caled totalP = " + totalP + "@@@ caled startPage  = " + startPage +"@@@ caled endPage = " + endPage );
		
		if(startPage != 1) { //if(startPage > pageBlock)
			int previousPage = startPage-1;
			pagingHTML.append("[<span id='paging' class='listPage'>이전</span>]");
		}
		
		for(int i = startPage; i<=endPage; i++) {
			if(i == currentPage) {
				pagingHTML.append("[<span id = 'currentPaging' class='listPage'>" + i + "</span>]" );
			}else {
				pagingHTML.append("[<span id = 'paging' class='listPage'>" + i + "</span>]" );
			}
		}
			
		if(endPage < totalP) {
				int nextPage = endPage+1;
				pagingHTML.append("[<span id = 'paging' class='listPage'> 다음 </span>]" );
		}
		/*
		 * if(startPage != 1) { //if(startPage > pageBlock) int previousPage =
		 * startPage-1; pagingHTML.append("[<span id='paging' onclick='boardPaging(" +
		 * previousPage + ")'>이전</span>]"); }
		 * 
		 * for(int i = startPage; i<=endPage; i++) { if(i == currentPage) {
		 * pagingHTML.append("[<span id = 'currentPaging' onclick = 'boardPaging(" + i +
		 * ")'>" + i + "</span>]" ); }else {
		 * pagingHTML.append("[<span id = 'paging' onclick = 'boardPaging(" + i + ")'>"
		 * + i + "</span>]" ); } }
		 * 
		 * if(endPage < totalP) { int nextPage = endPage+1;
		 * pagingHTML.append("[<span id = 'paging' onclick = 'boardPaging(" + nextPage +
		 * ")'> 다음 </span>]" ); }
		 */
	}
	
	public void makeSearchPagingHTML() {
		pagingHTML = new StringBuffer();
	
		int totalP = (int)(Math.ceil(totalA / (float)pageSize));
		//int totalP = ( totalA - 1) / ( pageSize + 1); //총 페이지 수
		int startPage = (currentPage-1) / pageBlock * pageBlock +1; //시작 페이지 번호 
		int endPage = startPage + pageBlock - 1;
		if(endPage > totalP) {
			endPage = totalP;
		}
		
		System.out.println("@@@ caled totalP = " + totalP + "@@@ caled startPage  = " + startPage +"@@@ caled endPage = " + endPage );
		
		if(startPage != 1) { //if(startPage > pageBlock)
			int previousPage = startPage-1;
			pagingHTML.append("[<span id='paging' class='searchListPage'>이전</span>]");
		}
		
		for(int i = startPage; i<=endPage; i++) {
			if(i == currentPage) {
				pagingHTML.append("[<span id = 'currentPaging' class='searchListPage'>" + i + "</span>]" );
			}else {
				pagingHTML.append("[<span id = 'paging' class='searchListPage'>" + i + "</span>]" );
			}
		}
			
		if(endPage < totalP) {
				int nextPage = endPage+1;
				pagingHTML.append("[<span id = 'paging' class='searchListPage'> 다음 </span>]" );
		}
		
	}
	
}
//1페이지에는 5개의 글, 페이징 블럭은 3개
