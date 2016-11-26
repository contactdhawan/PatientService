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