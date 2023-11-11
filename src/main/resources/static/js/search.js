$( document ).ready(function() {

  $('#search').click(function(){

      const idUser = $("#id").val();

      const validForm = validateForm(idUser);

      if (!validForm){
          return;
      }

      $('div.table').empty();

      $.ajax({
        url: '/users/' + idUser,
        type: 'GET',
        dataType: 'json'
      })
      .done(function(user) {
         $('div.table').append( '<h2>User Table</h2>' );
         $('div.table').append( '<table border="1">' );
         $('<tr>').append(
             $('<th>').text('Field Name'),
             $('<th>').text('Value')
         ).appendTo('div.table table');
         $('<tr>').append(
             $('<th>').text('First Name'),
             $('<td>').text(user.firstName)
         ).appendTo('div.table table');
         $('<tr>').append(
             $('<th>').text('Last Name'),
             $('<td>').text(user.lastName)
         ).appendTo('div.table table');
         $('<tr>').append(
             $('<th>').text('Username'),
             $('<td>').text(user.username)
         ).appendTo('div.table table');
         $('<tr>').append(
             $('<th>').text('Birth'),
             $('<td>').text(moment(user.birth).format('DD-MM-YYYY'))
         ).appendTo('div.table table');
         $('<tr>').append(
             $('<th>').text('Status'),
             $('<td>').text(user.firstName)
         ).appendTo('div.table table');
      })
      .fail(function(xhr) {

        if ( xhr.status === 200 ) {
          $('div.table').append( '<h2>User Table</h2>' );
          $('div.table').append( '<table border="1">' );
          $('<tr>').append(
             $('<th>').text('User Not Found'),
          ).appendTo('div.table table');
        }
        else{
          console.error(xhr.responseText);
          alert("Error while searching for User!");
        }
      });
  });

  function validateForm(idUser) {

      if ( idUser.trim() === "" ){

          alert("Please, type the User ID!");

          $("#id").focus();
          return false;
      }

      return true;
  }

});