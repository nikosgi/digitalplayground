$(document).ready(function(){
		$flag=1;
    	$("#username").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                     $("#error_username").text("* You have to enter a username!");
            }
            else
            {
                $(this).css("border-color", "#2eb82e");
                $('#submit').attr('disabled',false);
                $("#error_username").text("");

            }
       });
        $("#name").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_name").text("* You have to enter your First name!");
            }
            else
            {
                $(this).css("border-color", "#2eb82e");
                $('#submit').attr('disabled',false);
                $("#error_name").text("");
            }
       });
        $("#surname").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_surname").text("* You have to enter your Last name!");
            }
            else
            {
                $(this).css("border-color", "#2eb82e");
                $('#submit').attr('disabled',false);
                $("#error_surname").text("");
            }
       });
        $("#dob").focusout(function(){
    		if($(this).val()==''){
        		$(this).css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			$("#error_dob").text("* You have to enter your Date of Birth!");
        	}
        	else
        	{
        		$(this).css("border-color", "#2eb82e");
        		$('#submit').attr('disabled',false);
        		$("#error_dob").text("");
        	}
       });
        $("#region").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                     $("#error_region").text("* You have to enter your Region!");
            }
            else
            {
                $(this).css("border-color", "#2eb82e");
                $('#submit').attr('disabled',false);
                $("#error_region").text("");

            }
       });
        $("#municipality").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                     $("#error_municipality").text("* You have to enter your Municipality!");
            }
            else
            {
                $(this).css("border-color", "#2eb82e");
                $('#submit').attr('disabled',false);
                $("#error_municipality").text("");

            }
       });
        $("#country").focusout(function(){
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                     $("#error_country").text("* You have to enter your Country!");
            }
            else
            {
                $(this).css("border-color", "#2eb82e");
                $('#submit').attr('disabled',false);
                $("#error_country").text("");

            }
       });
        $("#phone").focusout(function(){
            $pho =$("#phone").val();
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_phone").text("* You have to enter your Phone Number!");
            }
            else if ($pho.length!=10)
            {   
                    $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_phone").text("* Lenght of Phone Number Should Be Ten");
            }
            else if(!$.isNumeric($pho))
            {
                    $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_phone").text("* Phone Number Should Be Numeric");  
            }
            else{
                $(this).css({"border-color":"#2eb82e"});
                $('#submit').attr('disabled',false);
                $("#error_phone").text("");
            }

        });
        $("#cellphone").focusout(function(){
            $pho =$("#cellphone").val();
            if($(this).val()==''){
                $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_cellphone").text("* You have to enter your Cellphone Number!");
            }
            else if ($pho.length!=10)
            {   
                    $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_cellphone").text("* Lenght of Phone Number Should Be Ten");
            }
            else if(!$.isNumeric($pho))
            {
                    $(this).css("border-color", "#FF0000");
                    $('#submit').attr('disabled',true);
                    $("#error_cellphone").text("* Phone Number Should Be Numeric");  
            }
            else{
                $(this).css({"border-color":"#2eb82e"});
                $('#submit').attr('disabled',false);
                $("#error_cellphone").text("");
            }

        });

   		$( "#submit" ).click(function() {
   			if($("#myName" ).val()=='')
   			{
        		$("#myName").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_name").text("* You have to enter your first name!");
        	}
        	if($("#lastname" ).val()=='')
   			{
        		$("#lastname").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_lastname").text("* You have to enter your Last name!");
        	}
   			if($("#dob" ).val()=='')
   			{
        		$("#dob").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_dob").text("* You have to enter your Date of Birth!");
        	}
   			if($("#age" ).val()=='')
   			{
        		$("#age").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_age").text("* You have to enter your Age!");
        	}
        	if($("#phone" ).val()=='')
   			{
        		$("#phone").css("border-color", "#FF0000");
        			$('#submit').attr('disabled',true);
        			 $("#error_phone").text("* You have to enter your Phone Number!");
        	}
			});


    	
	});