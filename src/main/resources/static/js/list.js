$( document ).ready(function() {

  $.ajax({
    url: '/users',
    type: 'GET',
    dataType: 'json'
  })
  .done(function( users ) {
    $.each(users, function( index, user ) {
      $('<tr>').append(
        $('<td>').text(user.idUser),
        $('<td>').text(user.firstName + ' ' + user.lastName),
        $('<td>').text(user.username.toUpperCase()),
        $('<td>').text(moment(user.birth).format('DD-MM-YYYY')),
        $('<td>').text(user.status),
        $('<td>').text('Update').wrapInner('<a href="#" class="update" data-id="'+ user.idUser + '"/>'),
        $('<td>').text('Delete').wrapInner('<a href="#" class="delete" data-id="'+ user.idUser + '"/>')
      ).appendTo('tbody');
    });
  })
  .fail(function(xhr) {
    console.error(xhr.responseText);
    alert("Error while retrieving Users!");
  });

  $('tbody').on('click', 'a.delete', function(){

    if (!confirm("Are you sure?")) {
        return;
    }

    $.ajax({
      url: '/users/' + + $(this).data("id"),
      type: 'DELETE'
    })
    .done(function() {
      $(location).attr("href","/list");
    })
    .fail(function(xhr) {
      console.error(xhr.responseText);
      alert("Error while deleting User!");
    });
  });

  $('tbody').on('click', 'a.update', function(){
    $(location).attr("href","/update/" + $(this).data("id"));
  });

});