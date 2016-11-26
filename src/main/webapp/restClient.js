function doGet() {
	$.ajax({
		type: "GET",
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		url:"http://localhost:8090/patientservice-svc/services/patientService/patient/"+$('#patientId').val()
	}).then(function(data){
		alert('Do you Just press GET.. awesome ');
		$('#patientId').val(data.id);
		$('#patientName').val(data.name);
	});
	
}

function doPost(){

	$.ajax({
		type:"POST",
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		data:JSON.stringify({name:$("#patientName").val()}),
		url:"http://localhost:8090/patientservice-svc/services/patientService/patient/"
	}).then(function(data){
		alert('Do you Just press POST.. awesome ');
		$('#patientId').val(data.id);
		$('#patientName').val(data.name);
	});
}



function doUpdate(){

	$.ajax({
		type:"PUT",
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		data:JSON.stringify({name:$("#patientName").val(),id:$("#patientId").val()}),
		url:"http://localhost:8090/patientservice-svc/services/patientService/patient/"
	}).then(function(data){
		alert('Do you Just press PUT.. awesome ');
		$('#patientId').val(data.id);
		$('#patientName').val(data.name);
	});
}

function doDelete(){

	$.ajax({
		type:"DELETE",
		contentType:"application/json;charset=utf-8",
		dataType:"json",
		url:"http://localhost:8090/patientservice-svc/services/patientService/patient/"+$('#patientId').val()
	}).then(function(data){
		alert('Do you Just press Delete.. awesome ');
		
	});
}