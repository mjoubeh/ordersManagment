function showErrDialog(Msg) {
	swal({
		title : "ERROR!",
		text : Msg,
		type : "error",
		confirmButtonText : "OK"
	});
}
function showDialog(Msg) {
	swal({
		title : "SUCCESS",
		text : Msg,
		type : "success",
		confirmButtonText : "Done"
	});
}