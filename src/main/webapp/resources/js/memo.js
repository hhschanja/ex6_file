/**
 * 
 */

function memoWrite(writer,contents){
		$.ajax({
			url:"memoWrite",
			type:"POST",
			data:{writer:writer,contents:contents},
			success:function(data){
				var result = "<table>";
				$(data).each(function() { //하나 꺼내서 집어넣어라
					
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.reg_date+"</td>";
					result=result+"</tr>";
				});
					result=result+"</table>";
					$('#result').html(result);
			}
			
		});
	};
	
	
	function getList(curPage, kind, search) { //여기에다가 AJAX코드를 치면
		$.ajax({
			url:"getMemoList",
			type:"GET",
			data:{curPage:curPage,kind:kind,search:search},
			success:function(data){
				
				var result = "<table>";
				$(data).each(function() { //하나 꺼내서 집어넣어라
					
					result=result+"<tr>";
					result=result+"<td>"+this.num+"</td>";
					result=result+"<td>"+this.contents+"</td>";
					result=result+"<td>"+this.writer+"</td>";
					result=result+"<td>"+this.reg_date+"</td>";
					result=result+"</tr>";
				});
					result=result+"</table>";
					$('#result').html(result);
			}
		});
		
	}
	
	function memoView() {
		
		$.get("memoView/num="+num,function(data){
			alert(data.writer);
		})
		
	}