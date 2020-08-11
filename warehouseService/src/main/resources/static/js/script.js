$(function () {

    var updateCart = function (key, qty) {


        $(`.item-container[data-key="${key}"] .check-icon`).addClass('fa fa-spinner fa-spin');
        $.ajax({
            url: "/buyer/add-to-cart",
            type: "post",
            data: {
                id: key,
                qty: qty
            },
            error:  function (jqXHR, timeout, message) {
                $(`.item-container[data-key="${key}"]`).find('.add-to-cart-btn').find('.check-icon').removeClass('fa-spinner fa-spin');
                if(jqXHR.status == 403){
                    alert("Seller Can not buy product.");
                }

            }

        }).done(function (resp) {
            if(typeof (resp) == 'number'){
                $(`.item-container[data-key="${key}"]`).addClass('added');
                $(`.item-container[data-key="${key}"]`).find('.add-to-cart-btn').find('.check-icon').removeClass('fa-spinner fa-spin');
                $(`.item-container[data-key="${key}"]`).find('.add-to-cart-btn').find('.check-icon').addClass('fa-check');
                $('.item-count').text(resp)
            }else{
                window.location.href = "/signin?error_msg=Please Login as buyer.";
            }

        });
    }

    $(".add-to-cart-btn").on('click', function (e) {

        e.preventDefault();

        updateCart($(this).parents(".item-container").attr('data-key'), 1);

    })
    var setGrandTotal = function () {

        var grandTotal = 0;

        $('.cart-item-body tr').each(function () {
            grandTotal += parseFloat($(this).find('.unit-price').attr('data-unitprice')) * parseFloat($(this).find('.qty-input').val());
        })
        $('.grand-total').text('USD ' + grandTotal.toFixed(2));
    }
    $('.qty-input').on('change', function () {
        var unitPrice = $(this).parents('tr').find('.unit-price').attr('data-unitprice');
        let totalprice = parseFloat(unitPrice) * $(this).val();
        if (totalprice > 0) {
            setGrandTotal();
            $(this).parents('tr').find('.total-price').text('USD ' + totalprice.toFixed(2));
            var key = $(this).parents('.item-container').attr('data-key')
            updateCart(key, $(this).val())
        } else {
            $(this).parents('tr').find('.total-price').text('USD ' + 0);
        }

    })
    $('.remove-btn').on('click', function (e) {
        e.preventDefault();
        var key = $(this).parents('.item-container').attr('data-key');
        var ele = $(this);
        $.ajax({
            url: "/buyer/remove-item",
            type: "post",
            data: {
                id: key
            }
        }).done(function (resp) {
            $('.item-count').text(resp);
            ele.parents('.item-container').remove();
        });

    })
    $('.criteria label').on('click', function (e) {
        e.stopImmediatePropagation();
    })

    $("#sameBilling").on("click",function () {
        if($(this).is(":checked")){
            $.ajax({
                url:"/account/address/shipping/get-billing",
                dataType:"json",
                type:"post",
                contentType:"application/json",
                data:JSON.stringify({}),
            }).done(function (response){
                for(key in response){
                    $('[name="'+key+'"]').val(response[key]);
                }
            })
        }else{
            $("#shipping-addr-form")[0].reset();
        }


    })
})