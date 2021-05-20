
$(document).ready(function(e) {
		
	 fetchrolemanagetable();
});

	function fetchrolemanagetable() {

		$('#employeesTable').dataTable({
			"ajax" : {
				"url" : "/employee/list",
				"dataSrc" : (jsonData) => {return jsonData}

			},
			columns : [ {
				data : "id"
			}, {
				data : "name",
			}, {
				data : "department",
			}, {
				data : "salary",
			}, 
			{
				data : "date",
			},
			{
				data : "email",
			},
			{
				data : "contact",
			},
			{ 
            	data: "",
                "mRender": function (data, type, full) {
             	   return "<a class='btn btn-default btn-sm' ><i class='fa fa-pencil'></i> Edit</a><a class='btn btn-danger btn-sm' style='margin-left:5px' onclick=DeleteData("+full.id+")><i class='fa fa-trash'></i> Delete</a>";
                      		},
            }]
		});
	}
	
	function DeleteData(id){
		var result = confirm("Want to delete?");
			        if (result == true) {
			        	var param = {
			        			id: id
			        	}
			        	$.ajax({
			                url: '/employee/delete'+ id,
			                method: 'DELETE',
			            });
			    }
			         location.reload();
	}