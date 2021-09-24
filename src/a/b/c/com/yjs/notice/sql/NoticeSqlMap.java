package a.b.c.com.yjs.notice.sql;

public class NoticeSqlMap {
	
	// MaxChabun ���� 
	public static String getMaxChabunQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  /*+ INDEX_DESC(SYS_C0011177) */ 			\n");
		sb.append("         NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 MAXNUM	\n");
		sb.append(" FROM     A 								\n");	  

		return sb.toString();
	}

	// å ��ü ��ȸ
	public static String getBookSelectAllQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.BNUM 		BNUM			\n");
		sb.append("		,A.BTITLE 		BTITLE			\n");
		sb.append("		,A.BAUTH 		BAUTH			\n");
	    sb.append("		,A.ISBN   		BISBN			\n");	    
	    sb.append("		,A.BCOMP 		BCOMP			\n");	    
	    sb.append("		,A.BPRICE		BPRICE			\n");	    
	    sb.append("		,A.BQTY 		BQTY			\n");
	    sb.append("		,A.BCOVER   	BCOVER			\n");	    
	    sb.append("		,A.DELETEYN		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 TEST_BOOK A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC  					\n");

	    return sb.toString();	  
	}
	
	// å ���� ��ȸ
	public static String getBookSelectQuery(){ 
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.BNUM 		BNUM			\n");
		sb.append("		,A.BTITLE 		BTITLE			\n");
		sb.append("		,A.BAUTH 		BAUTH			\n");
	    sb.append("		,A.ISBN   		BISBN			\n");	    
	    sb.append("		,A.BCOMP 		BCOMP			\n");	    
	    sb.append("		,A.BPRICE		BPRICE			\n");	    
	    sb.append("		,A.BQTY 		BQTY			\n");
	    sb.append("		,A.BCOVER   	BCOVER			\n");	    
	    sb.append("		,A.DELETEYN		DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");
	    sb.append("	FROM 								\n");
	    sb.append("		 TEST_BOOK A 					\n");
	    sb.append("	WHERE A.DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.BNUM     = ? 				\n");

	    return sb.toString();	  

	}
	
	// ���� ���� ���
	public static String getBookInsertQuery(){ 
	
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		TEST_BOOK 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 BNUM 				\n");
		sb.append("					,BTITLE 			\n");
		sb.append("					,BAUTH 				\n");
	    sb.append("					,ISBN   			\n");	    
	    sb.append("					,BCOMP 				\n");	    
	    sb.append("					,BPRICE				\n");	    
	    sb.append("					,BQTY 				\n");
	    sb.append("					,BCOVER   			\n");	    
	    sb.append("					,DELETEYN			\n");
	    sb.append("					,INSERTDATE			\n");
	    sb.append("					,UPDATEDATE			\n");
		sb.append("			      )						\n");
		sb.append("	       VALUES (  					\n");		
		sb.append("     				 ? 				\n"); // placeholder 1
		sb.append("						,? 				\n"); // placeholder 2
	    sb.append("						,?   			\n"); // placeholder 3
	    sb.append("						,?   			\n"); // placeholder 4
	    sb.append("						,? 				\n"); // placeholder 5
	    sb.append("						,? 				\n"); // placeholder 6
	    sb.append("						,?				\n"); // placeholder 7
	    sb.append("						,?				\n"); // placeholder 8
	    sb.append("						,'Y'			\n"); // placeholder 9
	    sb.append("						,SYSDATE 		\n"); // placeholder 10
	    sb.append("						,SYSDATE 		\n"); // placeholder 11	
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
	// ���� ���� ����
	public static String getBookUpdateQuery(){ 
	
		StringBuffer sb = new StringBuffer();	
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 TEST_BOOK 			    	\n");	
		sb.append("	SET  								\n");		
		sb.append("			 BPRICE 		= ?			\n");	    	    
		sb.append("			,BQTY			= ?			\n");	    
	    sb.append("		  	,UPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 BNUM 			= ?			\n");	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");	
		
		return sb.toString();
		
	}
	
	
	// ���� ���� ����
	public static String getBookDeleteQuery(){ 
	
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   TEST_BOOK 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  BNUM 		= ?				\n");	    
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");	
		
		return sb.toString();
	}
	
}
