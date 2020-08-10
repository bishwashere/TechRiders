$(function () {

    var manageSerialNumber = function () {
        var tbody = $('tbody');
        var sn = 1;
        tbody.find('tr').each(function (e) {
            $(this).find("td:nth-child(1)").text(sn++);
        })
    }
// ====================================================================

    // $("#catSubmit").submit(function (e) {
    //     // alert("hello");
    //     var catName = $('#catName').val();
    //     var descrip = $('#descrip').val();
    //     var productCategory = {
    //         name: catName,
    //         desc: descrip
    //     }
    //     $.post('/administration/product-cat', {productCategory: JSON.stringify(productCategory)}, addCatgory, 'json')
    //     e.preventDefault();
    //     return false;
    // })
    //
    // function addCatgory(data) {
    //     // alert('here');
    //     console.log(data);
    //     var tr = `<tr>
    //                 <td></td>
    //                 <td>${data.name}</td>
    //              <td>${data.desc}</td>
    //              <td><button class="btn btn-primary btn-xs edit-btn" value="${data.id}">
    //              <i class="fa fa-edit"></i></button>
    //           <button class="btn btn-danger btn-xs delete-btn" value="$(data.id)">
    //           <i class="fa fa-trash-o"></i></button></td></tr>`;
    //     $('#prod-cat-table>tbody').append(tr);
    //     manageSerialNumber();
    //     $("#catSubmit")[0].reset();
    //
    // }
    // ================================================
    $('#catSubmit').submit(function (e) {

        let id = $('[name="id"]').val();
        let name = $('#name').val();
        let desc = $('#desc').val();

        let myJson = {name: name, desc: desc};
        if (id) {
            myJson.id = id;
        }

        $.ajax({
            url: "/administration/product-cat",
            type: 'post',
            dataType: 'json',
            data: {
                cat: JSON.stringify(myJson)
            }
        }).done(function (productCategory) {
            if ($('#catSubmit').find('[name="id"]').val()) {

                $(`tr[data-key="${productCategory.id}"]`).find("td:nth-child(2)").text(productCategory.name);
                $(`tr[data-key="${productCategory.id}"]`).find("td:nth-child(3)").text(productCategory.desc);

            } else {

                var html = `<tr data-key="${productCategory.id}" data-desc="${productCategory.desc}">
               <td></td>
               <td>${productCategory.name}</td>
                <td>${productCategory.desc}</td>
                 <td>
                    <button type="button" class="btn btn-primary btn-xs edit-btn"><i class="fa fa-edit"></i></button>
                    <button type="button" class="btn btn-danger btn-xs delete-btn"><i class="fa fa-trash-o"></i></button>
                  </td>
                  </tr>`;
                $('#prod-cat-table').append(html);
            }
            manageSerialNumber();
            $('#catSubmit')[0].reset();
            $('[name="id"]').val('');
        });
        e.preventDefault();

    })

    $(document).on('click', '.delete-btn', function (e) {
        if (!confirm('Are you sure you want to delete this category?')) {
            return false;
        }
        var tr = $(this).parents('tr');
        var cat_id = tr.attr("data-key");

        $.post('/administration/delete-cat', {id: cat_id}, function (resp) {
            $(`tr[data-key="${cat_id}"]`).remove();
            manageSerialNumber();

        }, 'json');
        e.preventDefault();
    })


    $(document).on('click', '.edit-btn', function (e) {

        var tr = $(this).parents('tr');
        $('#catSubmit').find('[name="name"]').val(tr.find("td:nth-child(2)").text());
        $('#catSubmit').find('[name="desc"]').val(tr.find("td:nth-child(3)").text());
        $('#catSubmit').find('[name="id"]').val(tr.attr("data-key"));

        if (!$('.add-edit-btn').attr('aria-expanded')) {
            $('.add-edit-btn').click();
        }
        e.preventDefault();

    })


});