function populateCourseTable(){
	$("#courseTable tbody tr").remove();
	 $.ajax({
   	  type: "GET",
   	  url: "/course-app/course/",
   	  data: "",
   	  success: function(data){
   	     var table = "";
   	     var response = "";
   	     $.each(data.response, function(key, val) {
   	    		  response = val;	  
   	    		  table = table + "<tr>" 
   	    		  				+ "<td style='display:none;'>" + response.id+ "</td>"
   	    		  				+ "<td>" + response.name+ "</td>"
   	    		  				+ "<td><p data-placement='top' data-toggle='tooltip' title='Edit'><button class='btn btn-primary btn-xs' onclick='editCourse(" + response.id +")' data-title='Edit' data-toggle='modal' data-target='#editCourse' ><span class='glyphicon glyphicon-pencil'></span></button></p></td>"
   	    		  		    	+ "<td><p data-placement='top' data-toggle='tooltip' title='Delete'><button class='btn btn-danger btn-xs' onclick='deleteCourse(" + response.id +")' data-title='Delete' data-toggle='modal' data-target='#delete' ><span class='glyphicon glyphicon-trash'></span></button></p></td>"
   	    		  		    	+ "<td><p data-placement='top' data-toggle='tooltip' title='Delete'><button class='btn btn-danger btn-xs' onclick='listOfUniversities(" + response.id +")' data-title='Delete' data-toggle='modal' data-target='#universityList' ><span class='glyphicon glyphicon-search'></span></button></p></td>"
   	    		  				+ "</tr>" 
   	
   	    	});
   	     $("#courseTable tbody").append(table);
   	  },
         error: function(data){
       	 console.log("Error Occured");
         }
   	});
} 


function listOfUniversities(id){
	$("#universityListUL li").remove();
	var list = "";
	$.ajax({
	  	  type: "GET",
	  	  url: "/course-app/course/university/" + id,
	  	  data: "",
	  	  success: function(data){
	  		 $.each(data.response, function(key, val) {
	  			 list = list + "<li class='list-group-item'>" + val + "</li>";
	  		 });
	  		$("#universityListUL").append(list);
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	  	  });
}

function deleteCourse(id){
	$.ajax({
  	  type: "DELETE",
  	  url: "/course-app/course/" + id,
  	  data: "",
  	  success: function(data){
  	     console.log("Deleted");
  	     populateCourseTable();
  	  },
	  error : function(data){
		 console.log("Error Occured");
	  }
  	  });
}

function addCourse(){
	$("#selectUniversity option").remove();
	var table = "<option>Select University</option>";
	 $.ajax({
	   	  type: "GET",
	   	  url: "/course-app/university/",
	   	  data: "",
	   	  success: function(data){
	   	     var response = "";
	   	     $.each(data.response, function(key, val) {
	   	    		  response = val;	  
	   	    		  table = table + "<option>" + response.id + "- " + response.name + "</option>"
	   	    	  
	   	    	});
	   	     $("#selectUniversity").append(table);
	   	  },
	         error: function(data){
	       	 console.log("Error Occured");
	         }
	   	});
}

function editCourse(id){
	addCoursePlaceHolder();
	$("#selectUniversity option").remove();
	var table = "<option>Select University</option>";
	 $.ajax({
	   	  type: "GET",
	   	  url: "/course-app/university/",
	   	  data: "",
	   	  success: function(data){
	   	     var response = "";
	   	     $.each(data.response, function(key, val) {
	   	    		  response = val;	  
	   	    		  table = table + "<option>" + response.id + "- " + response.name + "</option>"
	   	    	  
	   	    	});
	   	     $("#selectUniversity").append(table);
	   	  },
	         error: function(data){
	       	 console.log("Error Occured");
	         }
	   	});
	 
	 $.ajax({
	  	  type: "GET",
	  	  url: "/course-app/course/" + id,
	  	  data: "",
	  	  success: function(data){
	  		$("#courseId").val(data.response.id);
	  	    $("#courseName").val(data.response.name);
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	 });
}


function updateCourseData(){
	var selectedValue = $('#selectUniversity option:selected').val();
	var strArray = selectedValue.split("-");
	var uId = strArray[0];
	var requestData = {
			id : $("#courseId").val(),
	  	    name :  $("#courseName").val(),
	  	    universityId : uId 
		}
	$.ajax({
	  	  type: "POST",
	  	  url: "/course-app/course/save",
	  	  data: JSON.stringify(requestData),
	  	  contentType: "application/json; charset=utf-8",
	  	  success: function(data){
	  		populateCourseTable();
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	 });
	addCoursePlaceHolder();
}

function addCoursePlaceHolder(){
		$("#courseId").val(null);
	     $("#courseName").val("");
}
