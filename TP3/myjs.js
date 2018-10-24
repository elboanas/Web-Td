$( document ).ready(function() {
    $('#btn-toilets').on('click', () => {
        $('#table-json').show();
        const URL = 'http://odata.bordeaux.fr/v1/databordeaux/sigsanitaire/?format=json&callback=?';
        $.getJSON(URL, function(result){
           $('#table-json').append("<tr><th>Nom</th><th>Options</th><th>quartier</th><th>typologie</th><th>quartier</th> </tr>");
           
           for(i in result.d)
           {
            $('#table-json').append("<tr><td>"+result.d[i].nom+"</td>"+
            "<td>"+result.d[i].options+"</td>"+
            "<td>"+result.d[i].quartier+"</td>"+
            "<td>"+result.d[i].typologie+"</td>"+
            "<td>"+result.d[i].num_quartier+"</td></tr>");
           }
        });   
    });
    $('#btn-toilets').on('dblclick', () => {
        $('#table-json').remove();
    }); 
  });
