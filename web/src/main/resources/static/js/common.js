$(document).submit(function(e){
    var form = $(e.target);
    if(form.data("custom-form") == "yes") {
        e.preventDefault();
        $.ajax({
            type: "POST",
            url: form.attr("action"),
            data: form.serialize(), // serializes the form's elements.
            success: function (data) {
                $(form.data("results-to")).html(data);
            }
        });
        $(form.data("modal-to-dismiss")).modal('hide');
    }
});