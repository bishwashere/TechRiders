$(function () {
    $(".accept-btn").on("click",function (e) {
        e.preventDefault();
        var id = $(this).parents("tr").data("id");
        $.ajax({
            url:"/administration/users/accept/"+id,
            type:"post",
            contentType:'application/json',
            dataType:"json",
            data:JSON.stringify([])
        }).done(function (resp) {
            console.log('resp',resp)
            if(resp == true){
                $('.user-list tr[data-id="'+id+'"]').find(".action").html('<span class="text-success">Verified <i class="fa fa-check"></i></span>');
            }
        })
    })
    $(".decline-btn").on("click",function (e) {
        e.preventDefault();
        var id = $(this).parents("tr").data("id");
        $.ajax({
            url:"/administration/users/decline/"+id,
            type:"post",
            contentType:'application/json',
            dataType:"json",
            data:JSON.stringify([])
        }).done(function (resp) {
            console.log('resp',resp)
            if(resp == true){
                $('.user-list tr[data-id="'+id+'"]').find(".action").html('<span class="text-danger">Declined <i class="fa fa-times"></i></span>');
            }
        })
    })
});