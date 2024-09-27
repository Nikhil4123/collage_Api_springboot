function populateTable(){
	$("#universityTable tbody tr").remove();
	 $.ajax({
   	  type: "GET",
   	  url: "/course-app/university/",
   	  data: "",
   	  success: function(data){
   	     var table = "";
   	     var response = "";
   	     $.each(data.response, function(key, val) {
   	    		  response = val;	  
   	    		  table = table + "<tr>" 
   	    		  				+ "<td style='display:none;'>" + response.id+ "</td>"
   	    		  				+ "<td>" + response.name+ "</td>"
   	    		  				+ "<td>" + response.alphaTwoCode+ "</td>"
   	    		  				+ "<td>" + response.country+ "</td>"
   	    		  				+ "<td>" + response.domain+ "</td>"
   	    		  				+ "<td>" + response.webPage+ "</td>"
   	    		  				+ "<td><p data-placement='top' data-toggle='tooltip' title='Edit'><button class='btn btn-primary btn-xs' onclick='editUniversity(" + response.id +")' data-title='Edit' data-toggle='modal' data-target='#edit' ><span class='glyphicon glyphicon-pencil'></span></button></p></td>"
   	    		  		    	+ "<td><p data-placement='top' data-toggle='tooltip' title='Delete'><button class='btn btn-danger btn-xs' onclick='deleteUniversity(" + response.id +")' data-title='Delete' data-toggle='modal' data-target='#delete' ><span class='glyphicon glyphicon-trash'></span></button></p></td>"  	    		  		      
   	    		  		   + "<td><p data-placement='top' data-toggle='tooltip' title='Delete'><button class='btn btn-danger btn-xs' onclick='listOfCourse(" + response.id +")' data-title='Delete' data-toggle='modal' data-target='#courseList' ><span class='glyphicon glyphicon-search'></span></button></p></td>"
   	    		  		    	+ "</tr>" 
   	    	  
   	    	});
   	     $("#universityTable tbody").append(table);
   	  },
         error: function(data){
       	 console.log("Error Occured");
         }
   	});
} 

function listOfCourse(id){
	
	$("#courseListUL li").remove();
	var list = "";
	$.ajax({
	  	  type: "GET",
	  	  url: "/course-app/university/course/" + id,
	  	  data: "",
	  	  success: function(data){
	  		 $.each(data.response, function(key, val) {
	  			 list = list + "<li class='list-group-item'>" + val + "</li>";
	  		 });
	  		$("#courseListUL").append(list);
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	  	  });		
}

function deleteUniversity(id){
	$.ajax({
  	  type: "DELETE",
  	  url: "/course-app/university/ " + id,
  	  data: "",
  	  success: function(data){
  	     console.log("Deleted");
  	   	 populateTable();
  	  },
	  error : function(data){
		 console.log("Error Occured");
	  }
  	  });
}


function editUniversity(id){
	$.ajax({
	  	  type: "GET",
	  	  url: "/course-app/university/ " + id,
	  	  data: "",
	  	  success: function(data){
	  		$("#univerSityId").val(data.response.id);
	  	     $("#name").val(data.response.name);
	  	     $("#alphaCode").val(data.response.alphaTwoCode);
	  	     $("#country").val(data.response.country);
	  	   	 $("#domain").val(data.response.domain);
	  	 	 $("#webPage").val(data.response.webPage);
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	 });
	addPlaceHolder();
}


function updateUniversityData(){
	var requestData = {
			id : $("#univerSityId").val(),
	  	    name :  $("#name").val(),
			alphaTwoCode : $("#alphaCode").val(),
			country : $("#country").val(),
			domain : $("#domain").val(),
			webPage : $("#webPage").val()
		}
	$.ajax({
	  	  type: "POST",
	  	  url: "/course-app/university/save",
	  	  data: JSON.stringify(requestData),
	  	  contentType: "application/json; charset=utf-8",
	  	  success: function(data){
	  		populateTable();
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	 });
	addPlaceHolder();
}

function addPlaceHolder(){
		$("#univerSityId").val(null);
	     $("#name").val("Name");
	     $("#alphaCode").val("alphaTwoCode");
	     $("#country").val("country");
	   	 $("#domain").val("domain");
	 	 $("#webPage").val("webpage");
}
