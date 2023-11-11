$( document ).ready(function() {

  $('#create').click(function(){

      const firstName = $("#firstName").val();
      const lastName = $("#lastName").val();
      const username = $("#username").val();
      const password = $("#password").val();
      const birth = $("#birth").val();

      const validForm = validateForm(firstName, lastName, username, password, birth);

      if (!validForm){
          return;
      }

      const validUsername = validateUsername(username);

      if (!validUsername){
          return;
      }

      $.ajax({
        url: '/users',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
                'firstName': firstName,
                'lastName': lastName,
                'username': username,
                'password': password,
                'birth': birth
        })
      })
      .done(function() {
         $(location).attr("href","/list");
      })
      .fail(function(xhr) {
        console.error(xhr.responseText);
        alert("Error while creating User!");
      });
  });

  function validateUsername(username) {

      let found = false;

      $.ajax({
        url: '/users/0/' + username,
        type: 'GET',
        async: false,
        dataType: 'json'
      })
      .done(function() {
        alert("Username already taken!, " + username);

        $("#username").focus();

        found = true;
      })
      .fail(function(xhr) {

        if ( xhr.status !== 200 ) {
          console.error(xhr.responseText);
          alert("Error while searching for User!");
        }
      });

      return !found;
  }

  function validateForm(firstName, lastName, username, password, birth) {

      if ( firstName.trim() === "" ){

          alert("Please, type the First Name!");

          $("#firstName").focus();
          return false;
      }

      if ( lastName.trim() === "" ){

          alert("Please, type the Last Name!");

          $("#lastName").focus();
          return false;
      }

      if ( username.trim() === "" ){

          alert("Please, type the Username!");

          $("#username").focus();
          return false;
      }

      if ( password.trim() === "" ){

          alert("Please, type the Password!");

          $("#password").focus();
          return false;
      }

      if ( birth.trim() === "" ){

          alert("Please, type the Date of Birth!");

          $("#birth").focus();
          return false;
      }

      return true;
  }



});