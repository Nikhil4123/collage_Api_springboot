function populateStudentTable(){
	$("#studentTable tbody tr").remove();
	 $.ajax({
   	  type: "GET",
   	  url: "/course-app/student/",
   	  data: "",
   	  success: function(data){
   	     var table = "";
   	     var response = "";
   	     $.each(data.response, function(key, val) {
   	    		  response = val;	  
   	    		  table = table + "<tr>" 
   	    		  				+ "<td style='display:none;'>" + response.id+ "</td>"
   	    		  				+ "<td>" + response.name+ "</td>"
   	    		  				+ "<td>" + response.address+ "</td>"
   	    		  				+ "<td>" + response.city+ "</td>"
   	    		  				+ "<td>" + response.university + "</td>"
   	    		  				+ "<td>" + response.course + "</td>"
   	    		  				+ "<td><p data-placement='top' data-toggle='tooltip' title='Edit'><button class='btn btn-primary btn-xs' onclick='editStudent(" + response.id +")' data-title='Edit' data-toggle='modal' data-target='#studentCourse' ><span class='glyphicon glyphicon-pencil'></span></button></p></td>"
   	    		  		    	+ "<td><p data-placement='top' data-toggle='tooltip' title='Delete'><button class='btn btn-danger btn-xs' onclick='deleteStudent(" + response.id +")' data-title='Delete' data-toggle='modal' data-target='#delete' ><span class='glyphicon glyphicon-trash'></span></button></p></td>"
   	    		  				+ "</tr>" 
   	
   	    	});
   	     $("#studentTable tbody").append(table);
   	  },
         error: function(data){
       	 console.log("Error Occured");
         }
   	});
} 

function deleteStudent(id){
	$.ajax({
  	  type: "DELETE",
  	  url: "/course-app/student/" + id,
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

function addStudent(){
	$("#selectSUniversity option").remove();
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
	   	     $("#selectSUniversity").append(table);
	   	  },
	         error: function(data){
	       	 console.log("Error Occured");
	         }
	   	});
}

function getCourses(){
	var selectedValue = $('#selectSUniversity option:selected').val();
	var strArray = selectedValue.split("-");
	var uId = strArray[0];
	$("#selectSCourse option").remove();
	var table1 = "<option>Select Course</option>";
	 $.ajax({
	   	  type: "GET",
	   	  url: "/course-app/university/course/" + uId,
	   	  data: "",
	   	  success: function(data){
	   	     var response = "";
	   	     $.each(data.response, function(key, val) {
	   	    		  response = val;	  
	   	    		  table1 = table1 + "<option>" + response + "</option>"
	   	    	  
	   	    	});
	   	     $("#selectSCourse").append(table1);
	   	  },
	         error: function(data){
	       	 console.log("Error Occured");
	         }
	   	});
}


function editStudent(id){
	addStudentPlaceHolder();
	 $.ajax({
	  	  type: "GET",
	  	  url: "/course-app/student/" + id,
	  	  data: "",
	  	  success: function(data){
	  		$("#studentId").val(data.response.id);
	  	    $("#studentName").val(data.response.name);
	  	    $("#studentAddress").val(data.response.address);
	  	    $("#studentCity").val(data.response.city);
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	 });
}


function updateStudentData(){
	var selectedValue = $('#selectSUniversity option:selected').val();
	var strArray = selectedValue.split("-");
	var uId = strArray[0];
	var selectedValue1 = $('#selectSCourse option:selected').val();
	var strArray1 = selectedValue1.split("-");
	var cId = strArray1[0];
	
	var requestData = {
			id : $("#studentId").val(),
	  	    name :  $("#studentName").val(),
	  	    address : $("#studentAddress").val(),
	  	    city : $("#studentCity").val(),
	  	    universityId : uId,
	  	    courseId : cId
		}
	$.ajax({
	  	  type: "POST",
	  	  url: "/course-app/student/save",
	  	  data: JSON.stringify(requestData),
	  	  contentType: "application/json; charset=utf-8",
	  	  success: function(data){
	  		populateStudentTable();
	  	  },
		  error : function(data){
			 console.log("Error Occured");
		  }
	 });
	addStudentPlaceHolder();
}

function addStudentPlaceHolder(){
		$("#studentId").val(null);
  	    $("#studentName").val();
  	    $("#studentAddress").val();
  	    $("#studentCity").val();
}
