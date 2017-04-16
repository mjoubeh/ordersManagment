$(function x() {
	var a = 1;

	$("#jsGrid")
		.jsGrid(
			{
				height : "46%",
				width : "70%",
				autoload : true,
				confirmDeleting : true,
				paging : true,
				// pageLoading : true,
				sorting : true,
				pageSize : 10,
				// pageButtonCount : 5,

				// size : 10,
				selecting : true,

				controller : {
					sorting : true,
					loadData : function(filter) {
						var d = $.Deferred();
						$.ajax({
							type : "GET",
							url : "LoadProducts",
							data : filter
						}).done(function(result) {

							d.resolve(JSON.parse(result));
						});

						return d.promise();

					}
				},

				fields : [
					{
						headerTemplate : function() {
							return $("<button>").attr("type",
								"button").text("Delete").on(
								"click", function() {
									deleteSelectedItems();
								});
						},
						itemTemplate : function(_, item) {
							return $("<input>")
								.attr("type", "checkbox")

								.on(
									"change",
									function() {
										$(this).is(
											":checked") ? selectItem(
											item, this)
											: unselectItem(
												item,
												this);
									});
						},
						align : "center",
						width : 22
					}
					,
					{
						itemTemplate : function(_, item) {
							return $("<button>").attr("type",
								"button").text("update").on(
								"click", function() {
									showDetails(item);
								});
						},
						align : "center",
						width : 17
					}
					, {
						name : "id",
						title : "Product ID",
						filtering : true,
						type : "text",
						width : 10,
					//						"visible" : false
					}, {
						filtering : true,
						title : "Product Name",
						name : "name",
						type : "text",
						width : 70,
						sorting : true,
					}, {
						name : "price",
						title : "Price",
						filtering : true,
						type : "text",
						width : 30,
						sorting : true,
					} ]
			});
	
	$("#detailsDialog").dialog({
		autoOpen : false,
		width : 500,
		close : function() {}
	});

	var showDetails = function(item) {
		showDetailsDialog("Product Details", item);
	}

	var selectedItems = "";
	var selectItem = function(item, cbElement) {

		var td = $(cbElement).parent();
		$(td).parent().attr("class", "");
		$(td).parent().css("background-color", "D52D2D");
		selectedItems += item.id + "-";

	};

	var unselectItem = function(item, cbElement) {
		var x = true;
		selectedItems = $.grep(selectedItems, function(i) {
			if (x) {
				var td = $(cbElement).parent();
				$(td).parent().attr("class", "jsgrid-row");
				x = false;
			} else {
				var td = $(cbElement).parent();
				$(td).parent().attr("class", "jsgrid-alt-row");
				x = true;
			}
			return i !== item.id;
		});
	};

	var deleteSelectedItems = function() {
		if (!selectedItems.length || !confirm("Are you sure?"))
			return;

		var $grid = $("#jsGrid");

		$.getJSON('DeleteProduct', {
			idList : selectedItems,
		}, function() {
			x();
		});

		selectedItems = "";
	};

	$("#sort").click(function() {
		var field = $("#sortingField").val();
		$("#jsGrid").jsGrid("sort", field);
	});

	var showDetailsDialog = function(dialogType, showItem) {
		$("#id").val(showItem.id);
		$("#name").val(showItem.name);
		$("#total").val(showItem.price);

		$("#detailsDialog").dialog("option", "title", dialogType)
			.dialog("open");
	}

});

function addProduct() {
	var form = $('<table>'

		+ '<tr>'
		+ '<td><b>Product Name</b></td>  <td><input type="text" id="Oname" style="border-radius:3px; width:120px;"/> </td>'
		+ '</tr>'
		+ '<tr> '
		+ '<td><b>Price</b></td> <td><input type="text" id="Ototal" style="border-radius:3px; width:120px;"/> </td>'
		+ '</tr>'
		+ '</table>');
	newDiv = $("<div/>");

	newDiv.append(form);

	newDiv.dialog({
		closeOnEscape : false,
		beforeClose : function(event, ui) {
			return false;
		},
		open : function(event, ui) {
			$(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
		},
		dialogClass : "noclose",
		modal : true,
		width : 500,
		height : 350,
		title : "Add Product",
		buttons : {
			cancel : function() {
				$(newDiv).dialog("destroy").remove();
			},
			Add : function() {

				addNewProduct();
				$(newDiv).dialog("destroy").remove();

			},
		}
	});

}
function updateProduct() {
	$.getJSON('UpdateProduct', {
		name : $("#name").val(),
		total : $("#total").val(),
		id : $("#id").val()
	}, function(resp) {

		if (resp == 1) {
			showDialog("Product updated successfuly");
			$("#detailsDialog").dialog("close");
			var millisecondsToWait = 2000;
			setTimeout(function() {
				location.reload();

			}, millisecondsToWait);
		} else
			showErrDialog("Error !");
	});
}
function addNewProduct() {
	$.getJSON('AddProduct', {
		name : $('#Oname').val(),
		total : $('#Ototal').val()
	}, function(resp) {
		if (resp == 1) {
			showDialog("New Product added successfully");
			var millisecondsToWait = 3000;
			setTimeout(function() {
				location.reload();
			}, millisecondsToWait);

		} else
			showErrDialog("Error !");
	});

}