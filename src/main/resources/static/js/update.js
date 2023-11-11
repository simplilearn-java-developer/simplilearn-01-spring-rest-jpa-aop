$( document ).ready(function() {

  const idUser = $("#idUser").val();

  $.ajax({
    url: '/users/' + idUser,
    type: 'GET',
    dataType: 'json'
  })
  .done(function( user ) {

    $("#firstName").val(user.firstName);
    $("#lastName").val(user.lastName);
    $("#username").val(user.username);
    $("#birth").val(user.birth);

  })
  .fail(function(xhr) {

    console.error(xhr.responseText);
    alert("Error while retrieving User!");
  });

  $('#update').click(function(){

      const idUser = $("#idUser").val();
      const firstName = $("#firstName").val();
      const lastName = $("#lastName").val();
      const username = $("#username").val();
      const birth = $("#birth").val();

      const validForm = validateForm(firstName, lastName, username, birth);

      if (!validForm){
          return;
      }

      const validUsername = validateUsername(idUser,username);

      if (!validUsername){
          return;
      }

      $.ajax({
        url: '/users',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
                'idUser': idUser,
                'firstName': firstName,
                'lastName': lastName,
                'username': username,
                'birth': birth
        })
      })
      .done(function() {
        $(location).attr("href","/list");
      })
      .fail(function(xhr) {
        console.error(xhr.responseText);
        alert("Error while updating User!");
      });
  });

  function validateUsername(idUser,username) {

      let found = false;

      $.ajax({
        url: '/users/' + idUser + '/' + username,
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

  function validateForm(firstName, lastName, username, birth) {

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

      if ( birth.trim() === "" ){

          alert("Please, type the Date of Birth!");

          $("#birth").focus();
          return false;
      }

      return true;
  }

});