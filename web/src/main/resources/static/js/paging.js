$(document).ready(function() {
	changePageAndSize();
});

$('.pagination .disabled a, .pagination .active a').on('click', function(e) {
    e.preventDefault();
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		window.location.replace(window.location.pathname + "?pageSize=" + this.value + "&page=1");
	});
}
