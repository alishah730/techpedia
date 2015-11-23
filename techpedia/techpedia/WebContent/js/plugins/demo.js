$( window ).load(function() {

    //Load main_navsar
    $.ajax({
        type: 'GET',
        async: false,
        //url: 'doc/main_navbar.html',
        success: function(response) {
            $("#nav_wrapper").html(response);
        },
        error:  function(response) {
            $("#nav_wrapper").html("<h1>Sorry but there was an error: " + response.status+' '+response.statusText + "</h1>");
        }
    });


    //Load table of contents
    $.ajax({
        type: 'GET',
        async: false,
        url: 'doc/contents.html',
        success: function(response) {
            $(".cpinput").spectrum("destroy");
            $("#contents").html(response);
        },
        error:  function(response) {
            $("#contents").html("<h1>Sorry but there was an error: " + response.status+' '+response.statusText + "</h1>");
        }
    });

    $(document).on('click', '.navbar .dropdown-menu', function(e) {e.stopPropagation();})

    $('.tooltips').tooltip();
    $('.popovers').popover();

    SetID();


    //Ajax content loading
    $(document).on('click', '.ajax', function(e) {
        //$('#main_navbar li').removeClass('active');
        $(this).parent().addClass('active').parent().parent().addClass('active');
        $.ajax({
            url: $(this).attr('href'),
            async: false,
            success: function(results) {
                $("#content").html(results);
                $("html, body").animate({scrollTop:220},"slow");
                $('pre code').each(function(i, block) {hljs.highlightBlock(block);});
                $(this).dropdown('toggle');
                SetID();
                if ($('#main_navbar').hasClass('rtl')) {
                    $('nav').addClass('rtl');
                }
            },
            error:  function(results) {
                $("#content").html("<h1>Sorry but there was an error: " + results.status+' '+results.statusText + "</h1>");
            }
        });
        e.preventDefault();
    });


    // Log all jQuery AJAX requests to Google Analytics
    (function ($) {
      $(document).ajaxSend(function(event, xhr, settings){
        ga('send','pageview',settings.url.pathname);
      });
    })(jQuery);

    //Fix navbar on scroll
    var navHeight = $('#main_navbar').offset().top;
    FixMN(navHeight);
    $(window).bind('scroll', function() {
        FixMN(navHeight);
    });


    $(document).on('click', '.toggle_fixing', function(e) {
        e.preventDefault();
        if ($('#main_navbar').hasClass('navbar-fixed-top')) {
            $('#main_navbar').toggleClass('navbar-fixed-bottom navbar-fixed-top');
            $(this).children('i').toggleClass('fa-chevron-down fa-chevron-up');
        } else {
            $('#main_navbar').toggleClass('navbar-fixed-bottom');
            $(this).children('i').toggleClass('fa-chevron-down fa-chevron-up');
                  if ($('#main_navbar').parent('div').hasClass('container')) $('#main_navbar').children('div').addClass('container').removeClass('container-fluid');
                  else if ($('#main_navbar').parent('div').hasClass('container-fluid')) $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');

            FixMN(navHeight);
        }

        if ($('#main_navbar').hasClass('navbar-fixed-top')) {
            $('body').css({'margin-top': $('#main_navbar').height()+'px', 'margin-bottom': ''});
        }
        else if ($('#main_navbar').hasClass('navbar-fixed-bottom')) {
            $('body').css({'margin-bottom': $('#main_navbar').height()+'px', 'margin-top': ''});
        }

        //
    })




    //Load content if url have hash
    if (window.location.hash.substring(1)!='') {
        console.log(window.location.hash.substring(1));
        $.ajax({
            type: 'GET',
            async: false,
            url: window.location.hash.substring(1),
            success: function(response) {
                $("#content").html(response);
                $('pre code').each(function(i, block) {hljs.highlightBlock(block);});
                $(this).dropdown('toggle');
                SetID();
            }
        });
    }

    //Radio change
    $('input[type=radio]').on('change', function(){
        $("input[type=radio]").each(function() {
            if($(this).is(":checked")) {
                $(this).next('i').addClass('fa-check-square-o').removeClass('fa-square-o');
            } else {
                $(this).next('i').addClass('fa-square-o').removeClass('fa-check-square-o');
            }
        });
    });


    //Sticky change
    $('input[name=sticky]').on('change', function(){
        FixMN(navHeight);
    });








});




function SetID() {
    //Set unique identifier for collapse
    $("a[data-toggle='collapse']").each(function() {
        if (!$(this).data("parent") && !$(this).hasClass('nochange')) {
            var $id=Math.random().toString(16).substring(2, 15) + Math.random().toString(16).substring(2, 15);
            $(this).attr('data-target', '#id_'+$id);
            $(this).next('ul.dropdown-menu').attr('id', 'id_'+$id);
        }
    });
}


function FixMN(navHeight) {
        //alert ($('input[name=sticky]').length);
        if ($('input[name=sticky]:checked').val()=='yes' || $('input[name=sticky]').length==0) {
            if (!$('#main_navbar').hasClass('navbar-fixed-bottom')) {
                if ($(window).scrollTop() > navHeight) {
                  $('#main_navbar').addClass('navbar-fixed-top')
                  $('body').css({'margin-top': $('#main_navbar').height()+'px'});

                  if ($('input[name=sticky]').length==0) {
                    if ($('#main_navbar').parent('div').hasClass('container')) $('#main_navbar').children('div').addClass('container').removeClass('container-fluid');
                    else if ($('#main_navbar').parent('div').hasClass('container-fluid')) $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');
                  }
                }
                else {
                  $('#main_navbar').removeClass('navbar-fixed-top');
                  if ($('input[name=sticky]').length==0) {
                    $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');
                  }
                  $('body').css({'margin-top': ''});
                }

            }
        }

        else {
            $('#main_navbar').removeClass('navbar-fixed-top');
            $('body').css({'margin-top': ''});
            if ($('input[name=sticky]').length==0) {
                $('#main_navbar').children('div').addClass('container-fluid').removeClass('container');
            }
        }
}

/*ANIMATION*/

var animation = ["SpeedStartToEndShort", "SpeedStartToEndMedium", "SpeedStartToEndLong", "SpeedEndToStartShort", "SpeedEndToStartMedium", "SpeedEndToStartLong", "SpeedRightToLeftShort", "SpeedRightToLeftMedium", "SpeedRightToLeftLong", "SpeedLeftToRightShort", "SpeedLeftToRightMedium", "SpeedLeftToRightLong",
    "HingeDownToUp", "HingeUpToDown", "HingeDownToUpInverse", "HingeUpToDownInverse", "HingeLeftToRight", "HingeLeftToRightInverse", "HingeRightToLeft", "HingeRightToLeftInverse", "HingeStartToEnd", "HingeStartToEndInverse", "HingeEndToStart", "HingeEndToStartInverse",
    "SlideTopToBottom", "SlideBottomToTop", "SlideLeftToRight", "SlideRightToLeft", "SlideLeftTopToRightBottom", "SlideRightBottomToLeftTop", "SlideRightTopToLeftBottom", "SlideLeftBottomToRightTop", "SlideStartToEnd", "SlideEndToStart", "SlideStartTopToEndBottom", "SlideEndBottomToStartTop", "SlideEndTopToStartBottom", "SlideStartBottomToEndTop",
    "Bounce", "flash", "pulse", "rubberBand", "shake", "swing", "tada", "wobble", "twisterInDown", "twisterInUp", "fadeIn",
    "Bounce", "BounceBottomToTop", "BounceTopToBottom", "BounceLeftToRight", "BounceRightToLeft", "BounceStartToEnd", "BounceEndToStart",
    "SpaceTopToBottom", "SpaceRightToLeft", "SpaceBottomToTop", "SpaceLeftToRight", "SpaceStartToEnd", "SpaceEndToStart",
    "SkewRightTopToBottom", "SkewRightBottomToTop", "SkewLeftTopToBottom", "SkewLeftBottomToTop", "SkewBottomLeftToRight", "SkewBottomRightToLeft", "SkewTopRightToLeft", "SkewTopLeftToRight", "SkewEndTopToBottom", "SkewEndBottomToTop", "SkewStartTopToBottom", "SkewStartBottomToTop", "SkewBottomStartToEnd", "SkewBottomEndToStart", "SkewTopStartToEnd", "SkewTopEndToStart",
    "ScaleBottomToTop", "ScaleTopToBottom", "ScaleLeftToRight", "ScaleRightToLeft", "ScaleLeftTopToRightBottom", "ScaleLeftBottomToRightTop", "ScaleRightTopToLeftBottom", "ScaleRightBottomToLeftTop", "ScaleStartToEnd", "ScaleEndToStart", "ScaleStartTopEndBottom", "ScaleStartBottomEndTop", "ScaleEndTopStartBottom", "ScaleEndBottomStartTop",
    "Zoom", "ZoomDown", "ZoomUp", "ZoomLeftToRight", "ZoomRightToLeft", "ZoomStartToEnd", "ZoomEndToStart",
    "RotateLeftTopFixedDown", "RotateLeftTopFixedUp", "RotateRightTopFixedDown", "RotateRightTopFixedUp", "RotateLeftBottomFixedDown", "RotateLeftBottomFixedUp", "RotateRightBottomFixedDown", "RotateRightBottomFixedUp", "RotateCenterFixedToRight", "RotateCenterFixedToLeft", "RotateStartTopFixedDown", "RotateStartTopFixedUp", "RotateStartBottomFixedDown", "RotateStartBottomFixedUp", "RotateEndTopFixedDown", "RotateEndTopFixedUp", "RotateEndBottomFixedDown", "RotateEndBottomFixedUp", "RotateCenterFixedToEnd", "RotateCenterFixedToStart",
    "FlipVertical", "FlipHorizontal", "FlipLeftToRightFrontShort", "FlipLeftToRightFrontMedium", "FlipLeftToRightFrontLong", "FlipLeftToRightBackShort", "FlipLeftToRightBackMedium", "FlipLeftToRightBackLong", "FlipRightToLeftFrontShort", "FlipRightToLeftFrontMedium", "FlipRightToLeftFrontLong", "FlipRightToLeftBackShort", "FlipRightToLeftBackMedium", "FlipRightToLeftBackLong", "FlipStartToEndFrontShort", "FlipStartToEndFrontMedium", "FlipStartToEndFrontLong", "FlipStartToEndBackShort", "FlipStartToEndBackMedium", "FlipStartToEndBackLong", "FlipEndToStartFrontShort", "FlipEndToStartFrontMedium", "FlipEndToStartFrontLong", "FlipEndToStartBackShort", "FlipEndToStartBackMedium", "FlipEndToStartBackLong"
];

function removeAnimation() {
    $('.navbar').removeClass('SpeedStartToEndShort SpeedStartToEndMedium SpeedStartToEndLong SpeedEndToStartShort SpeedEndToStartMedium SpeedEndToStartLong SpeedRightToLeftShort SpeedRightToLeftMedium SpeedRightToLeftLong SpeedLeftToRightShort SpeedLeftToRightMedium SpeedLeftToRightLong');
    $('.navbar').removeClass('HingeDownToUp HingeUpToDown HingeDownToUpInverse HingeUpToDownInverse HingeLeftToRight HingeLeftToRightInverse HingeRightToLeft HingeRightToLeftInverse HingeStartToEnd HingeStartToEndInverse HingeEndToStart HingeEndToStartInverse');
    $('.navbar').removeClass('SlideTopToBottom SlideBottomToTop SlideLeftToRight SlideRightToLeft SlideLeftTopToRightBottom SlideRightBottomToLeftTop SlideRightTopToLeftBottom SlideLeftBottomToRightTop SlideStartToEnd SlideEndToStart SlideStartTopToEndBottom SlideEndBottomToStartTop SlideEndTopToStartBottom SlideStartBottomToEndTop');
    $('.navbar').removeClass('Bounce flash pulse rubberBand shake swing tada wobble twisterInDown twisterInUp fadeIn');
    $('.navbar').removeClass('Bounce BounceBottomToTop BounceTopToBottom BounceLeftToRight BounceRightToLeft BounceStartToEnd BounceEndToStart');
    $('.navbar').removeClass('SpaceTopToBottom SpaceRightToLeft SpaceBottomToTop SpaceLeftToRight SpaceStartToEnd SpaceEndToStart');
    $('.navbar').removeClass('SkewRightTopToBottom SkewRightBottomToTop SkewLeftTopToBottom SkewLeftBottomToTop SkewBottomLeftToRight SkewBottomRightToLeft SkewTopRightToLeft SkewTopLeftToRight SkewEndTopToBottom SkewEndBottomToTop SkewStartTopToBottom SkewStartBottomToTop SkewBottomStartToEnd SkewBottomEndToStart SkewTopStartToEnd SkewTopEndToStart');
    $('.navbar').removeClass('ScaleBottomToTop ScaleTopToBottom ScaleLeftToRight ScaleRightToLeft ScaleLeftTopToRightBottom ScaleLeftBottomToRightTop ScaleRightTopToLeftBottom ScaleRightBottomToLeftTop ScaleStartToEnd ScaleEndToStart ScaleStartTopEndBottom ScaleStartBottomEndTop ScaleEndTopStartBottom ScaleEndBottomStartTop');
    $('.navbar').removeClass('Zoom ZoomDown ZoomUp ZoomLeftToRight ZoomRightToLeft ZoomStartToEnd ZoomEndToStart');
    $('.navbar').removeClass('RotateLeftTopFixedDown RotateLeftTopFixedUp RotateRightTopFixedDown RotateRightTopFixedUp RotateLeftBottomFixedDown RotateLeftBottomFixedUp RotateRightBottomFixedDown RotateRightBottomFixedUp RotateCenterFixedToRight RotateCenterFixedToLeft RotateStartTopFixedDown RotateStartTopFixedUp RotateStartBottomFixedDown RotateStartBottomFixedUp RotateEndTopFixedDown RotateEndTopFixedUp RotateEndBottomFixedDown RotateEndBottomFixedUp RotateCenterFixedToEnd RotateCenterFixedToStart');
    $('.navbar').removeClass('FlipVertical FlipHorizontal FlipLeftToRightFrontShort FlipLeftToRightFrontMedium FlipLeftToRightFrontLong FlipLeftToRightBackShort FlipLeftToRightBackMedium FlipLeftToRightBackLong FlipRightToLeftFrontShort FlipRightToLeftFrontMedium FlipRightToLeftFrontLong FlipRightToLeftBackShort FlipRightToLeftBackMedium FlipRightToLeftBackLong FlipStartToEndFrontShort FlipStartToEndFrontMedium FlipStartToEndFrontLong FlipStartToEndBackShort FlipStartToEndBackMedium FlipStartToEndBackLong FlipEndToStartFrontShort FlipEndToStartFrontMedium FlipEndToStartFrontLong FlipEndToStartBackShort FlipEndToStartBackMedium FlipEndToStartBackLong');
    return;
}

function addAnimation() {


   if ($('input[name=animation]:checked').val()=='yes') {
        removeAnimation();
        $('.navbar').addClass(animation[Math.floor(Math.random() * animation.length)]);
   }
}
$( window ).load(function() {
    $('.navbar .navbar-nav>li>a').on('click', function(e) {addAnimation();});
});


/*SCROLL PAGE TO TOP*/
$(document).ready(function() {
    $("#toTop").css("display", "none");

    $(window).scroll(function(){
        if($(window).scrollTop() > 0){$("#toTop").fadeIn("slow");} else {$("#toTop").fadeOut("slow");}
    });

    $("#toTop").click(function(){
        event.preventDefault();
        $("html, body").animate({scrollTop:0},"slow");
    });
});


/*Get escaped source code of element*/
/*$('.getSource').on('click', function(){*/

$(window).load(function() {
/*    $('<div>').append($('#main_navbar').clone()).html();

    str=$('<div>').append($('#main_navbar').clone()).html();
var escapedHtml = str.replace(/\t/g, ' ').replace(/&/g, '&amp;').replace(/>/g, '&gt;').replace(/</g, '&lt;').replace(/"/g, '&quot;').replace(/'/g, '&apos;');

console.log(escapedHtml); */
});